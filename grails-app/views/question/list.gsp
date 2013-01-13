
<%@ page import="net.realizeideas.iphysics.question.Question" %>
<!doctype html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}"/>
  <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<section id="list-question" class="first">

  <table class="table table-bordered">
    <thead>
    <tr>
      
      <g:sortableColumn property="type"
                        title="${message(code: 'question.type.label', default: 'Type')}"/>
      
      <g:sortableColumn property="description"
                        title="${message(code: 'question.description.label', default: 'Description')}"/>
      
      <th><g:message code="question.category.label" default="Category"/></th>
      
      <g:sortableColumn property="maxPointsToEarn"
                        title="${message(code: 'question.maxPointsToEarn.label', default: 'Max Points To Earn')}"/>
      
      <g:sortableColumn property="title"
                        title="${message(code: 'question.title.label', default: 'Title')}"/>
      
    </tr>
    </thead>
    <tbody>
    <g:each in="${questionList}" status="i" var="question">
      <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
        
        <td><g:link action="show"
                    id="${question.id}">${fieldValue(bean: question, field: "type")}</g:link></td>
        
        <td>${fieldValue(bean: question, field: "description")}</td>
        
        <td>${fieldValue(bean: question, field: "category")}</td>
        
        <td>${fieldValue(bean: question, field: "maxPointsToEarn")}</td>
        
        <td>${fieldValue(bean: question, field: "title")}</td>
        
      </tr>
    </g:each>
    </tbody>
  </table>

  <div class="pagination">
    <bs:paginate total="${questionTotal}"/>
  </div>
</section>

</body>

</html>
