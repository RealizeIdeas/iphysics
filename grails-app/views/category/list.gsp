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

      <g:sortableColumn property="createdBy"
                        title="${message(code: 'category.createdBy.label', default: 'Created By')}"/>

      <g:sortableColumn property="dateCreated"
                        title="${message(code: 'category.dateCreated.label', default: 'Date Created')}"/>

      <g:sortableColumn property="lastUpdated"
                        title="${message(code: 'category.lastUpdated.label', default: 'Last Updated')}"/>

      <g:sortableColumn property="description"
                        title="${message(code: 'category.description.label', default: 'Description')}"/>

      <g:sortableColumn property="title" title="${message(code: 'category.title.label', default: 'Title')}"/>

    </tr>
    </thead>
    <tbody>
    <g:each in="${categoryList}" status="i" var="category">
      <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

        <td><g:link action="show" id="${category.id}">${fieldValue(bean: category, field: "createdBy")}</g:link></td>

        <td><g:formatDate date="${category.dateCreated}"/></td>

        <td><g:formatDate date="${category.lastUpdated}"/></td>

        <td>${fieldValue(bean: category, field: "description")}</td>

        <td>${fieldValue(bean: category, field: "title")}</td>

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
