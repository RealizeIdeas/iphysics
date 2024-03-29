<%@ page import="net.realizeideas.iphysics.question.Category" %>
<!doctype html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}"/>
  <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>

<section id="create-category" class="first">

  <g:hasErrors bean="${category}">
    <div class="alert alert-error">
      <g:renderErrors bean="${category}" as="list"/>
    </div>
  </g:hasErrors>

  <g:form action="save" class="form-horizontal">
    <fieldset class="form">
      <f:with bean="category">

        <f:field property="title"/>
        <f:field property="description"/>

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
