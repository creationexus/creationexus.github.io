# Login new PRM OpenId PKCE programmatically

import requests
import base64
import hashlib
import os
import re
import json

env = "prod"

session = requests.Session()

# Autenticacion
state = "1111"
__RequestVerificationToken = "1111"

code_verifier = base64.urlsafe_b64encode(os.urandom(40)).decode("utf-8")
code_verifier = re.sub("[^a-zA-Z0-9]+", "", code_verifier)

code_challenge = hashlib.sha256(code_verifier.encode("utf-8")).digest()
code_challenge = base64.urlsafe_b64encode(code_challenge).decode("utf-8")
code_challenge = code_challenge.replace("=", "")


payload = {
    "ReturnUrl": "/connect/authorize/callback?client_id=backofficenew&redirect_uri=https%3A%2F%2Fbackoffice.new."
    + env
    + ".creationexus.procloudhub.com%2F%23%2Fsignin-oidc&response_type=code&scope=openid%20profile%20api&state="
    + state
    + "&code_challenge="
    + code_challenge
    + "&code_challenge_method=S256&response_mode=query",
    "Username": "root",
    "Password": "open",
    "button": "login",
    "__RequestVerificationToken": __RequestVerificationToken,
    "RememberLogin": False,
}

headers = {}

response = session.post(
    "https://login."
    + env
    + ".creationexus.procloudhub.com/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dbackofficenew%26redirect_uri%3Dhttps%253A%252F%252Fbackoffice.new."
    + env
    + ".creationexus.procloudhub.com%252F%2523%252Fsignin-oidc%26response_type%3Dcode%26scope%3Dopenid%2520profile%2520api%26state%3D"
    + state
    + "%26code_challenge%3D"
    + code_challenge
    + "%26code_challenge_method%3DS256%26response_mode%3Dquery&Username=gestionagenda&Password=gestionagenda.2020&button=login&__RequestVerificationToken="
    + __RequestVerificationToken
    + "&RememberLogin=false",
    headers=headers,
    data=payload,
)
print(response)
# print(response.text)


if response.history:
    print("Request was redirected")
    for resp in response.history:
        print(resp.status_code, resp.url)
    print("Final destination:")
    print(response.status_code, response.url)
else:
    print("Request was not redirected")

cookies = response.cookies

print(cookies)

varss = response.url.split("?")[1]
varss = varss.split("&")
code = varss[0].split("=")[1]

print(code)
# GET TOKEN
headers = {}
payload = {
    "client_id": "backofficenew",
    "code": code,
    "redirect_uri": "https://backoffice.new."
    + env
    + ".creationexus.procloudhub.com/#/signin-oidc",
    "code_verifier": code_verifier,
    "grant_type": "authorization_code",
}

response = session.post(
    "https://login." + env + ".creationexus.procloudhub.com/connect/token",
    headers=headers,
    data=payload,
)
# print(response)
# print(response.text)
access_token = response.json()["access_token"]
print(access_token)

# Listar los centros
headers = {"authorization": "Bearer %s" % (access_token,)}
payload = {
    "searchPhrase": "",
    "includeAvailabilities": False,
    "onlyAssignedToUser": False,
    "resourceId": None,
    "serviceId": None,
    "areaId": None,
    "exclusionList": [],
    "count": True,
}
response = requests.post(
    "https://proxy.%s.creationexus.procloudhub.com/v2/masterdata/odata/Search/GetLocation"
    % env,
    headers=headers,
    json=payload,
)
print("--Listar los centros")
print(response)
# print(response.json())
regiones = response.json()["value"]
for region in regiones:
    for centro in region["Locations"]:
        print(
            "%s:%s"
            % (
                region["RegionName"],
                centro.get("Name"),
            )
        )
print("--Listar los centros")
