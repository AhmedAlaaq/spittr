<%-- 
    Document   : spittles
    Created on : 19-Sep-2017, 17:47:30
    Author     : Egelantier
--%>

<s:url value="/spittles" htmlEscape="true">
  <s:param name="max" value="60" />
  <s:param name="count" value="20" />
</s:url>
<s:url href="/spitter/{username}" var="spitterUrl">
  <s:param name="username" value="jbauer" />
</s:url>

<s:url value="/spittles" var="spittlesJSUrl" javaScriptEscape="true">
  <s:param name="max" value="60" />
  <s:param name="count" value="20" />
</s:url>
<script>
  var spittlesUrl = "${spittlesJSUrl}"
</script>

<c:forEach items="${spittleList}" var="spittle" >
  <li id="spittle_<c:out value="spittle.id"/>">
    <div class="spittleMessage">
      <c:out value="${spittle.message}" />
    </div>
    <div>
      <span class="spittleTime"><c:out value="${spittle.time}" /></span>
      <span class="spittleLocation">
          (<c:out value="${spittle.latitude}" />,
          <c:out value="${spittle.longitude}" />)</span>
    </div>
  </li>
  
</c:forEach>