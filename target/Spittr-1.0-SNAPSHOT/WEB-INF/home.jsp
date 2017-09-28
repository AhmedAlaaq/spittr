<%-- 
    Document   : home
    Created on : 19-Sep-2017, 16:51:48
    Author     : Egelantier
--%>


<%@ page session="false" %>
<html>
    <head>
        <title>Spittr</title>
        <link rel="stylesheet" type="text/css" 
              href="<c:url value="/>resources/style.css" />" >
    </head>
    <body>
        <h1><s:message code="spittr.welcome" /></h1>
        <a href="<c:url value="/spittles" />">Spittles</a> | 
        <a href="<c:url value="/spitter/register" />">Register</a>
    </body>
</html>

