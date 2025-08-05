#!/usr/bin/env python
# encoding: UTF-8
# from bs4 import BeautifulSoup
import requests
import json
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from time import sleep
import os
import pandas as pd
import cx_Oracle
import numpy
from datetime import datetime as dt
from pandas import DataFrame
import smtplib
import mimetypes
from email.mime.multipart import MIMEMultipart
from email import encoders
from email.mime.audio import MIMEAudio
from email.mime.base import MIMEBase
from email.mime.image import MIMEImage
from email.mime.text import MIMEText

import sys, traceback


class DB:
    conn = None
    cur = None

    def __init__(self):
        self.conn = cx_Oracle.connect(
            "USER/PASS@HOST/DB", encoding="UTF-8", nencoding="UTF-8"
        )
        self.cur = self.conn.cursor()

    def query_sel(self, arr):
        # self.cur = self.conn.cursor()
        self.cur.execute(arr[0], arr[1])
        return self.cur.fetchall()

    def exist_id(self, id):
        self.cur = self.conn.cursor()
        self.cur.execute(
            """SELECT COUNT(*) FROM TABLE WHERE adt =:id_value""", id_value=id
        )
        return self.cur.fetchone()

    def query_ins(self, str):
        self.cur = self.conn.cursor()
        self.cur.execute("SELECT * FROM table")

    def query_bulk(self, arr):
        print(arr[1])
        self.cur = self.conn.cursor()
        self.cur.executemany(arr[0], arr[1], batcherrors=True)
        self.conn.commit()
        for error in self.cur.getbatcherrors():
            print("Error", error.message, "at row offset", error.offset)

    def call_proc(self, st):
        cur_var = self.cur.var(cx_Oracle.CURSOR)
        self.cur.callproc(st, [cur_var])
        return cur_var

    def close(self):
        self.cur.close()
        self.conn.close()


class Correo:
    server = None
    msg = None

    def __init__(self):
        self.server = smtplib.SMTP("HOST")
        self.server.set_debuglevel(1)
        # self.server.ehlo(name='HOST')
        # self.server.ehlo(name='HOST')
        # self.server.ehlo_or_helo_if_needed()
        self.msg = MIMEMultipart()

    def adjuntar_archivo(self, filename, path):
        attachment = open(path, "rb")
        # p = MIMEBase('application', 'octet-stream')
        p = MIMEBase("application", "csv")
        p.set_payload((attachment).read())
        encoders.encode_base64(p)
        p.add_header("Content-Disposition", "attachment; filename= %s" % filename)
        self.msg.attach(p)

    def enviar(self, emailfrom, emailto, emailcc, subject, body):
        # msg = MIMEMultipart()
        self.msg["From"] = emailfrom
        self.msg["To"] = emailto
        self.msg["Subject"] = subject
        self.msg["CC"] = emailcc

        Body = body
        body = MIMEText(body)
        self.msg.attach(body)

        self.msg.preamble = subject
        to_addrs = emailto
        if emailcc is not None and emailcc != "":
            to_addrs += "," + emailcc
        print(to_addrs.split(","))
        print(self.msg.as_string())
        self.server.sendmail(emailfrom, to_addrs.split(","), self.msg.as_string())

        self.server.quit()


def run_script():
    try:

        di = dt.now()
        print("init :%s" % di)
        db = DB()
        a = 1

        prefs = {"download.default_directory": "/home/oracle/apps/run/downloads"}
        options = webdriver.ChromeOptions()
        options.add_argument(
            "download.default_directory=/home/oracle/apps/run/downloads"
        )
        options.add_argument("--headless")
        options.add_argument("--no-sandbox")
        options.add_experimental_option("prefs", prefs)

        if a == 0:
            driver = webdriver.Chrome(
                "C:\\\\Users\\carriagadad\\chromedriver", options=options
            )
        else:
            driver = webdriver.Chrome(
                "/home/oracle/apps/run/chromedriver", chrome_options=options
            )

        driver.implicitly_wait(1024)  # seconds
        # driver.set_page_load_timeout(0.5)

        driver.get("https://HOST/servlet/mstrWeb")
        # print(r.text)
        user = driver.find_element_by_xpath('//*[@id="Uid"]')
        passwd = driver.find_element_by_xpath('//*[@id="Pwd"]')

        user.send_keys("USER")
        passwd.send_keys("PASS")

        send = driver.find_element_by_xpath('//*[@id="2341"]')
        send.click()

        menu = driver.find_element_by_xpath(
            '//*[@id="12341"]/table/tbody/tr/td[1]/div/a'
        )
        menu.click()

        licencia = driver.find_element_by_xpath('//*[@id="234"]')
        licencia.click()

        misinfor = driver.find_element_by_xpath(
            '//*[@id="YTW"]/div[2]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/div[1]/a'
        )
        misinfor.click()

        suscript = driver.find_element_by_xpath(
            '//*[@id="ASQ"]/tbody/tr[12]/td[2]/table/tbody/tr/td[2]/div[1]/span/a'
        )
        suscript.click()

        # Dia vencido
        driver.get("https://HOST/servlet/mstrWeb?evt=400")

        # sleep(150)

        ejecutarinfo = driver.find_element_by_xpath('//*[@id="ID"]')
        ejecutarinfo.click()

        # ejecutarinfo2 = driver.find_element_by_xpath('//*[@id="id_mstr201"]')
        # Dia vencido
        ejecutarinfo2 = driver.find_element_by_xpath('//*[@id="ID"]')

        ejecutarinfo2.click()

        try:
            excel = WebDriverWait(driver, 5).until(
                # EC.staleness_of((By.ID, "tbExport"))
                EC.presence_of_element_located((By.ID, "tbExport"))
                # EC.visibility_of_element_located((By.ID, "tbExport"))
            )
            sleep(6)
            excel.click()
        except:
            print("No encuentra 'tbExport'")

        main_window = driver.current_window_handle
        windows = driver.window_handles
        driver.switch_to.window(windows[1])

        xlson = driver.find_element_by_xpath('//*[@id="34223"]')
        xlson.click()

        export = driver.find_element_by_xpath('//*[@id="45644"]')
        export.click()

        # TIEMPO DE DESCARGA DE ARCHIVO CSV
        sleep(300)

        # CIERRA TODAS LAS PESTANAS ABIERTAS
        for handle in driver.window_handles:
            driver.switch_to.window(handle)
            driver.close()

        # SE BUSCA ARCHIVO DESCARGADO
        if a == 0:
            search_dir = "C:\\Users\\carriagadad\\Downloads"
        else:
            search_dir = "/home/oracle/apps/run/downloads"

        os.chdir(search_dir)
        files = filter(os.path.isfile, os.listdir(search_dir))
        files = [os.path.join(search_dir, f) for f in files]
        files.sort(key=lambda x: os.path.getmtime(x))

        print(files[-1])
        if a == 0:
            os.chdir("C:\\Users\\carriagadad\\Desktop")
        else:
            os.chdir("/home/oracle/apps/run")

        df = pd.read_csv(files[-1], engine="python", encoding="cp1252")

        # DESCARTAR REGISTROS EXISTENTES EN BASE A CAMPO adt

        dataToInsert = []
        for i in df.index:
            v = []
            for j in range(0, len(df.columns)):
                if j == 3:
                    m = ["ENE", "FEB", ...]
                    dd = df[df.columns[j]][i].split("-")
                    v.append(
                        pd.to_datetime(
                            "%s/%02d/%s" % (dd[0], m.index(dd[1]) + 1, dd[2]),
                            format="%d/%m/%Y",
                        )
                    )
                else:
                    if (
                        type(df[df.columns[j]][i]) == numpy.int64
                        or type(df[df.columns[j]][i]) == numpy.float64
                    ):
                        v.append(df[df.columns[j]][i].astype(str).strip())
                    else:
                        v.append(df[df.columns[j]][i].strip())
            if db.exist_id(df[df.columns[24]][i].astype(str))[0] == 0:
                dataToInsert.append(v)
                print("registro nuevo: %s" % (df[df.columns[24]][i].astype(str),))
            else:
                print("registro existe: %s" % (df[df.columns[24]][i].astype(str),))

        print("len insert %s" % (len(dataToInsert),))

        db.query_bulk(
            [
                """INSERT INTO TABLE VALUES (:1,:2,:3,:4,:5,:6,:7,:8,:9,:10,:11,:12,:13,:14,:15,:16,:17,:18,:19,:20,:21,:22,:23,:24,:25,:26,:27,:28,:29,:30,:31,:32,:33,:34,:35,:36,:37,:38,:39,:40,:41,:42,:43,:44,:45,:46,:47,:48,:49,:50,:51)""",
                dataToInsert,
            ]
        )

        # Se obtiene los registros para el archivo de salida
        res = db.call_proc("""SCHEME.SP_CONSOLIDA""")

        df = DataFrame(res.getvalue().fetchall())

        cols = ["COL1", "COL2"]
        df.to_csv("./FILE.csv", sep=";", encoding="utf-8", index=False, header=cols)
        #
        correo = Correo()
        # Se prepara envio de archivo a traves de correo
        correo.adjuntar_archivo("FILE.csv", "FILE.csv")
        correo.enviar(
            "EMAIL",
            "EMAIL",
            "",
            "Reporte",
            "Estimado\n\nAdjunto se encuentra el reporte\n\nGenerado el %s"
            % (di.strftime("%d/%m/%Y %H:%M:%S")),
        )

        db.close()
        print("====")
        print(df.index)
        print("====")
        df = dt.now()
        print("fin :%s" % df)
        print("diff: %s seconds" % (df - di).seconds)
        fh = open("log", "a")
        fh.write("---------------\n")
        fh.write("finaliza ok : %s\n" % (df,))
        fh.write("segundos : %s\n" % ((df - di).seconds,))
        fh.write("---------------\n")
        fh.close()
    except:
        typ, val, tb = sys.exc_info()
        fh = open("error", "a")
        fh.write("---------------\n")
        fh.write("finaliza nok : %s\n" % (di,))
        fh.write("".join(traceback.format_exception(typ, val, tb)))
        fh.write("---------------\n")
        fh.close()


if __name__ == "__main__":
    run_script()
