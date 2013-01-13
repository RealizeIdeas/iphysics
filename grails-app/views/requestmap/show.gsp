
<%@ page import="net.realizeideas.iphysics.Requestmap" %>
<!doctype html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <g:set var="entityName" value="${message(code: 'requestmap.label', default: 'Requestmap')}"/>
  <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>

<section id="show-requestmap" class="first">

  <table class="table">
    <tbody>
    
    <tr class="prop">
      <td valign="top" class="name"><g:message code="requestmap.url.label"
                                               default="Url"/></td>
      
      <td valign="top" class="value">${fieldValue(bean: requestmap, field: "url")}</td>
      
    </tr>
    
    <tr class="prop">
      <td valign="top" class="name"><g:message code="requestmap.configAttribute.label"
                                               default="Config Attribute"/></td>
      
      <td valign="top" class="value">${fieldValue(bean: requestmap, field: "configAttribute")}</td>
      
    </tr>
    
    </tbody>
  </table>
</section>

</body>

</html>
