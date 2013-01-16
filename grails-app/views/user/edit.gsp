<%@ page import="net.realizeideas.iphysics.User" %>
<!doctype html>
<html>
<head>
  <meta name="layout" content="kickstart">
  <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
  <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<section id="edit-user" class="first">

  <g:hasErrors bean="${userInstance}">
    <div class="alert alert-error">
      <g:renderErrors bean="${userInstance}" as="list"/>
    </div>
  </g:hasErrors>

  <g:form method="post" class="form-horizontal">
    <g:hiddenField name="id" value="${userInstance?.id}"/>
    <g:hiddenField name="version" value="${userInstance?.version}"/>
      <fieldset class="form">
      <f:with bean="userInstance">
        <f:field property="username"/>
        <f:field property="password" input-type="password"/>
        <f:field property="firstName"/>
        <f:field property="lastName"/>
        <f:field property="enabled"/>
      </f:with>
    </fieldset>
    <div class="form-actions">
      <g:actionSubmit class="btn btn-primary" action="update"
                      value="${message(code: 'default.button.update.label', default: 'Update')}"/>
      <g:actionSubmit class="btn btn-danger" action="delete"
                      value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate=""
                      onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
    </div>
  </g:form>
</section>
</body>
</html>
