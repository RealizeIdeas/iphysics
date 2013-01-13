<%@ page import="net.realizeideas.iphysics.question.Category" %>



<div class="control-group fieldcontain ${hasErrors(bean: category, field: 'createdBy', 'error')} ">
  <label for="createdBy" class="control-label"><g:message code="category.createdBy.label" default="Created By"/></label>

  <div class="controls">
    <g:textField name="createdBy" value="${category?.createdBy}"/>
    <span class="help-inline">${hasErrors(bean: category, field: 'createdBy', 'error')}</span>
  </div>
</div>

<div class="control-group fieldcontain ${hasErrors(bean: category, field: 'description', 'error')} ">
  <label for="description" class="control-label"><g:message code="category.description.label"
                                                            default="Description"/></label>

  <div class="controls">
    <g:textField name="description" value="${category?.description}"/>
    <span class="help-inline">${hasErrors(bean: category, field: 'description', 'error')}</span>
  </div>
</div>

<div class="control-group fieldcontain ${hasErrors(bean: category, field: 'tasks', 'error')} ">
  <label for="tasks" class="control-label"><g:message code="category.tasks.label" default="Tasks"/></label>

  <div class="controls">

    <ul class="one-to-many">
      <g:each in="${category?.tasks ?}" var="t">
        <li><g:link controller="question" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
      </g:each>
      <li class="add">
        <g:link controller="question" action="create"
                params="['category.id': category?.id]">${message(code: 'default.add.label', args: [message(code: 'question.label', default: 'Question')])}</g:link>
      </li>
    </ul>

    <span class="help-inline">${hasErrors(bean: category, field: 'tasks', 'error')}</span>
  </div>
</div>

<div class="control-group fieldcontain ${hasErrors(bean: category, field: 'title', 'error')} ">
  <label for="title" class="control-label"><g:message code="category.title.label" default="Title"/></label>

  <div class="controls">
    <g:textField name="title" value="${category?.title}"/>
    <span class="help-inline">${hasErrors(bean: category, field: 'title', 'error')}</span>
  </div>
</div>

