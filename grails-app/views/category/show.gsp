<%@ page import="net.realizeideas.iphysics.question.Category" %>
<!doctype html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}"/>
  <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>

<section id="show-category" class="first">

  <table class="table">
    <tbody>

    <tr class="prop">
      <td valign="top" class="name"><g:message code="category.createdBy.label" default="Created By"/></td>

      <td valign="top" class="value">${fieldValue(bean: category, field: "createdBy")}</td>

    </tr>

    <tr class="prop">
      <td valign="top" class="name"><g:message code="category.dateCreated.label" default="Date Created"/></td>

      <td valign="top" class="value"><g:formatDate date="${category?.dateCreated}"/></td>

    </tr>

    <tr class="prop">
      <td valign="top" class="name"><g:message code="category.lastUpdated.label" default="Last Updated"/></td>

      <td valign="top" class="value"><g:formatDate date="${category?.lastUpdated}"/></td>

    </tr>

    <tr class="prop">
      <td valign="top" class="name"><g:message code="category.description.label" default="Description"/></td>

      <td valign="top" class="value">${fieldValue(bean: category, field: "description")}</td>

    </tr>

    <tr class="prop">
      <td valign="top" class="name"><g:message code="category.tasks.label" default="Tasks"/></td>

      <td valign="top" style="text-align: left;" class="value">
        <ul>
          <g:each in="${category.tasks}" var="t">
            <li><g:link controller="question" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
          </g:each>
        </ul>
      </td>

    </tr>

    <tr class="prop">
      <td valign="top" class="name"><g:message code="category.title.label" default="Title"/></td>

      <td valign="top" class="value">${fieldValue(bean: category, field: "title")}</td>

    </tr>

    </tbody>
  </table>
</section>

</body>

</html>
