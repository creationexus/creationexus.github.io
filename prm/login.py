# Login PRM programmatically

import requests
import json

session = requests.Session()
payload = {"username": "u123", "password": "1234"}
response = session.post(
    "https://proxy.tst.domain.com/AWAUsers/Login", headers=headers, data=payload
)
cookies = session.cookies.get_dict()

# print (cookies['XSRF-TOKEN'])

headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36",
    "Origin": "https://web.tst.domain.com",
    "Host": "proxy.tst.domain.com",
    "Referer": "https://web.tst.domain.com/",
    "X-AppTimezone": "-240",
    "X-XSRF-TOKEN": cookies["XSRF-TOKEN"],
}

cookies = response.cookies
response = session.get(
    "https://proxy.tst.domain.com/AWAUsers/DecryptCookie",
    cookies=cookies,
    headers=headers,
)
print(response.text)

headers = {
    "Authorization": response.text,
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36",
}

response = requests.get(
    "https://proxy.tst.domain.com/AWAUsers/RuleTables", headers=headers
)
parsed = json.loads(response.text)
print(json.dumps(parsed, indent=4, sort_keys=True))
