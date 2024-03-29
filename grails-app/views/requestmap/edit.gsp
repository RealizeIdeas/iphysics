<%@ page import="net.realizeideas.iphysics.Requestmap" %>
<!doctype html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <g:set var="entityName" value="${message(code: 'requestmap.label', default: 'Requestmap')}"/>
  <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>

<section id="edit-requestmap" class="first">

  <g:hasErrors bean="${requestmap}">
    <div class="alert alert-error">
      <g:renderErrors bean="${requestmap}" as="list"/>
    </div>
  </g:hasErrors>

  <g:form method="post" class="form-horizontal">
    <g:hiddenField name="id" value="${requestmap?.id}"/>
    <g:hiddenField name="version" value="${requestmap?.version}"/>
    <fieldset class="form">
      <f:with bean="requestmap">
        <f:field property="url"/>
        <f:field property="configAttribute"/>
      </f:with>
    </fieldset>

    <div class="form-actions">
      <g:actionSubmit class="btn btn-primary" action="update"
                      value="${message(code: 'default.button.update.label', default: 'Update')}"/>
      <g:actionSubmit class="btn btn-danger" action="delete"
                      value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                      onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
      <button class="btn" type="reset">Cancel</button>
    </div>
  </g:form>

</section>

</body>

</html>
