<%=packageName%>
<% import grails.persistence.Event %>
<!doctype html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}"/>
  <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>

<section id="edit-${domainClass.propertyName}" class="first">

  <g:hasErrors bean="\${${propertyName}}">
    <div class="alert alert-error">
      <g:renderErrors bean="\${${propertyName}}" as="list"/>
    </div>
  </g:hasErrors>

  <g:form method="post" class="form-horizontal" <%=multiPart ? ' enctype="multipart/form-data"' : '' %>>
  <g:hiddenField name="id" value="\${${propertyName}?.id}"/>
  <g:hiddenField name="version" value="\${${propertyName}?.version}"/>
  <fieldset class="form">
    <f:with bean="${domainClass.propertyName}">
      <% excludedProps = Event.allEvents.toList() << 'id' << 'version' << 'dateCreated' << 'lastUpdated' << 'createdBy'
      allowedNames = domainClass.persistentProperties*.name
      props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) }
      Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
      props.each { p -> %>
      <f:field property="${p.name}"/>
      <% } %>
    </f:with>
  </fieldset>

  <div class="form-actions">
    <g:actionSubmit class="btn btn-primary" action="update"
                    value="\${message(code: 'default.button.update.label', default: 'Update')}"/>
    <g:actionSubmit class="btn btn-danger" action="delete"
                    value="\${message(code: 'default.button.delete.label', default: 'Delete')}"
                    onclick="return confirm('\${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
    <button class="btn" type="reset">Cancel</button>
  </div>
  </g:form>

</section>

</body>

</html>
