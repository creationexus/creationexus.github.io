
# Generate report from web site (with login)

Se automatiza la extraccion de reporte en formato csv, generando un resultado consolidado que se envia por correo. 

Para generar el reporte es necesario interactuar con una interface web, la cual se trabaja con selenium, cuando finalmente llega el csv se procesa con pandas, se llama a un SP y con el resultado finalmente se envia un correo.

#########

The extraction of the report in CSV format is automated, generating a consolidated result that is sent by email.

To generate the report, it is necessary to interact with a web interface using Selenium. Once the CSV is retrieved, it is processed with pandas, a stored procedure (SP) is called, and with the resulting output, an email is finally sent.