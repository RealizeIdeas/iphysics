<%@ page import="net.realizeideas.iphysics.question.Question" %>

<!doctype html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}"/>
  <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>

<section id="create-question" class="first">

  <g:hasErrors bean="${question}">
    <div class="alert alert-error">
      <g:renderErrors bean="${question}" as="list"/>
    </div>
  </g:hasErrors>

  <g:form action="save" class="form-horizontal">
    <fieldset class="form">
      <f:with bean="question">
        <f:field property="title"/>
        <f:field property="description"/>
        <f:field property="category"/>
        <f:field property="type"/>
        <f:field property="maxPointsToEarn"/>
        <f:field property="asnwers"/>
      </f:with>

    </fieldset>

    <div class="form-actions">
      <g:submitButton name="create" class="btn btn-primary"
                      value="${message(code: 'default.button.create.label', default: 'Create')}"/>
      <button class="btn" type="reset">Cancel</button>
    </div>
  </g:form>

</section>

</body>

</html>
