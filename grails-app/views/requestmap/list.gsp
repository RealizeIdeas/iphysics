
<%@ page import="net.realizeideas.iphysics.Requestmap" %>
<!doctype html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <g:set var="entityName" value="${message(code: 'requestmap.label', default: 'Requestmap')}"/>
  <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<section id="list-requestmap" class="first">

  <table class="table table-bordered">
    <thead>
    <tr>
      
      <g:sortableColumn property="url"
                        title="${message(code: 'requestmap.url.label', default: 'Url')}"/>
      
      <g:sortableColumn property="configAttribute"
                        title="${message(code: 'requestmap.configAttribute.label', default: 'Config Attribute')}"/>
      
    </tr>
    </thead>
    <tbody>
    <g:each in="${requestmapList}" status="i" var="requestmap">
      <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
        
        <td><g:link action="show"
                    id="${requestmap.id}">${fieldValue(bean: requestmap, field: "url")}</g:link></td>
        
        <td>${fieldValue(bean: requestmap, field: "configAttribute")}</td>
        
      </tr>
    </g:each>
    </tbody>
  </table>

  <div class="pagination">
    <bs:paginate total="${requestmapTotal}"/>
  </div>
</section>

</body>

</html>
