<%@ page import="net.realizeideas.iphysics.question.Category" %>
<!doctype html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}"/>
  <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<section id="list-category" class="first">

  <table class="table table-bordered">
    <thead>
    <tr>

      <g:sortableColumn property="title" title="${message(code: 'category.title.label', default: 'Title')}"/>
       <g:sortableColumn property="description"
                        title="${message(code: 'category.description.label', default: 'Description')}"/>

    </tr>
    </thead>
    <tbody>
    <g:each in="${categoryList}" status="i" var="category">
      <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
        <td><g:link action="show" id="${category.id}">${fieldValue(bean: category, field: "title")}</g:link></td>

        <td>${fieldValue(bean: category, field: "description")}</td>

      </tr>
    </g:each>
    </tbody>
  </table>

  <div class="pagination">
    <bs:paginate total="${categoryTotal}"/>
  </div>
</section>

</body>

</html>
