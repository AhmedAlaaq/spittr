<%-- 
    Document   : page
    Created on : 22-Sep-2017, 17:07:32
    Author     : Egelantier
--%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/style.css" />" >
  </head>
  <body>
    <div id="header">
      <t:insertAttribute name="header" />	
    </div>
    <div id="content">
      <t:insertAttribute name="body" />	
    </div>
    <div id="footer">
      <t:insertAttribute name="footer" />	
    </div>
  </body>
</html>

<!--#1: Insert the header
#2: Insert the body
#3: Insert the footer>
