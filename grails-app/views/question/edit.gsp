<%@ page import="net.realizeideas.iphysics.question.Question" %>

<!doctype html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <link rel="stylesheet" href="${resource(dir: 'css', file: 'question.css')}" type="text/css">
  <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}"/>
  <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>

<section id="edit-question" class="first">

  <g:hasErrors bean="${question}">
    <div class="alert alert-error">
      <g:renderErrors bean="${question}" as="list"/>
    </div>
  </g:hasErrors>

  <g:form method="post" class="form-horizontal">
    <g:hiddenField name="id" value="${question?.id}"/>
    <g:hiddenField name="version" value="${question?.version}"/>
    <fieldset class="form">
      <f:with bean="question">
        <f:field property="title"/>
        <f:field property="description"/>
        <f:field property="category"/>
        <f:field property="type"/>
        <f:field property="maxPointsToEarn"/>
        <g:render template="answers" model="[question:question]"/>
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
