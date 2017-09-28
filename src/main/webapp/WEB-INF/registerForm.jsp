<%-- 
    Document   : registerForm
    Created on : 20-Sep-2017, 13:46:40
    Author     : Egelantier
--%>

<s:url href="/spitter/register" var="registerUrl" scope="request" /> </s:url>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<sf:form method="POST" commandName="spitter">

<sf:label path="firstName"
          cssErrorClass="error">First Name</sf:label>:
<sf:input path="firstName" cssErrorClass="error" /><br/>
Last Name: <sf:input path="lastName" />  <br/>
Email: <sf:input path="email" />  <br/>
Username: <sf:input path="username" />  <br/>
Password: <sf:password path="password" />  <br/>
<input type="submit" value="Register" />

</sf:form>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spitter registeration</title>
    </head>  
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />" >

          <body>
        <h1>Register</h1>
        <form id="spitter" action="/spittr/spitter/register" method="POST">
            <label for="firstName" class="error">First Name</label>
            First Name: <input id="firstName" type="text" name="firstName" value="J" />
            <span id="firstName.errors"> size must be between 2 and 30 </span> <br/>
            Last Name: <input id="lastName" type="text" name="lastName" value="B" /><br/>
            Email:<input id="email" type="text" name="email" value="jack" /><br/>
            Username: <input id="username" type="text" name="username" value="jack"/><br/>
            Password: <input id="password" type="password" name="password" value=" "/><br/>
            <input type="submit" value="Register" />
        </form>
    </body>
</html>
