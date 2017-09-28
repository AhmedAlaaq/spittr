<%-- 
    Document   : profile
    Created on : 20-Sep-2017, 17:21:08
    Author     : Egelantier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>profile</title>
    </head>
    <body>
        <h1>Your Profile</h1>
    <c:out value="${spitter.username}" /><br/>
    <c:out value="${spitter.firstName}" />
    <c:out value="${spitter.lastName}" />
</body>
</html>
