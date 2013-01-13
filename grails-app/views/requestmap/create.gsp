<%@ page import="net.realizeideas.iphysics.Requestmap" %>
<!doctype html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <g:set var="entityName" value="${message(code: 'requestmap.label', default: 'Requestmap')}"/>
  <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>

<section id="create-requestmap" class="first">

  <g:hasErrors bean="${requestmap}">
    <div class="alert alert-error">
      <g:renderErrors bean="${requestmap}" as="list"/>
    </div>
  </g:hasErrors>

  <g:form action="save" class="form-horizontal" >
  <fieldset class="form">
    <f:with bean="requestmap">
      <f:field property="url"/>
      <f:field property="configAttribute"/>
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
