<%@ page import="net.realizeideas.iphysics.User" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="kickstart">
  <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
  <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<section id="list-user" class="first">

  <table class="table table-bordered">
    <thead>
    <tr>

      <g:sortableColumn property="username" title="${message(code: 'user.username.label', default: 'Username')}"/>
      <g:sortableColumn property="firstName" title="${message(code: 'user.firstName.label', default: 'FirstName')}"/>
      <g:sortableColumn property="lastName" title="${message(code: 'user.lastName.label', default: 'LastName')}"/>
      <g:sortableColumn property="email" title="${message(code: 'user.email.label', default: 'Email')}"/>
      <g:sortableColumn property="dateCreated"
                        title="${message(code: 'user.dateCreated.label', default: 'Date Created')}"/>
    </tr>
    </thead>
    <tbody>
    <g:each in="${userInstanceList}" status="i" var="userInstance">
      <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

        <td><g:link action="edit"
                    id="${userInstance.id}">${fieldValue(bean: userInstance, field: "username")}</g:link></td>
        <td>${fieldValue(bean: userInstance, field: "firstName")}</td>
        <td>${fieldValue(bean: userInstance, field: "lastName")}</td>
        <td>${fieldValue(bean: userInstance, field: "email")}</td>
        <td><g:formatDate date="${userInstance.dateCreated}" format="yyyy-MM-dd"/></td>
      </tr>
    </g:each>
    </tbody>
  </table>

  <div class="pagination">
    <g:paginate total="${userInstanceTotal}"/>
  </div>
</section>
</body>
</html>
