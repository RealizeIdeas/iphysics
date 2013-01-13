
<%@ page import="net.realizeideas.iphysics.question.Question" %>
<!doctype html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}"/>
  <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>

<section id="show-question" class="first">

  <table class="table">
    <tbody>
    
    <tr class="prop">
      <td valign="top" class="name"><g:message code="question.type.label"
                                               default="Type"/></td>
      
      <td valign="top" class="value">${fieldValue(bean: question, field: "type")}</td>
      
    </tr>
    
    <tr class="prop">
      <td valign="top" class="name"><g:message code="question.description.label"
                                               default="Description"/></td>
      
      <td valign="top" class="value">${fieldValue(bean: question, field: "description")}</td>
      
    </tr>
    
    <tr class="prop">
      <td valign="top" class="name"><g:message code="question.asnwers.label"
                                               default="Asnwers"/></td>
      
      <td valign="top" style="text-align: left;" class="value">
        <ul>
          <g:each in="${question.asnwers}" var="a">
            <li><g:link controller="answer" action="show"
                        id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
          </g:each>
        </ul>
      </td>
      
    </tr>
    
    <tr class="prop">
      <td valign="top" class="name"><g:message code="question.category.label"
                                               default="Category"/></td>
      
      <td valign="top" class="value"><g:link controller="category" action="show"
                                             id="${question?.category?.id}">${question?.category?.encodeAsHTML()}</g:link></td>
      
    </tr>
    
    <tr class="prop">
      <td valign="top" class="name"><g:message code="question.maxPointsToEarn.label"
                                               default="Max Points To Earn"/></td>
      
      <td valign="top" class="value">${fieldValue(bean: question, field: "maxPointsToEarn")}</td>
      
    </tr>
    
    <tr class="prop">
      <td valign="top" class="name"><g:message code="question.title.label"
                                               default="Title"/></td>
      
      <td valign="top" class="value">${fieldValue(bean: question, field: "title")}</td>
      
    </tr>
    
    </tbody>
  </table>
</section>

</body>

</html>
