<g:if test="${session.layout == null || session.layout == 'grid'}">
  <g:set var="menutype" value="nav nav-tabs"/>
</g:if>
<g:elseif test="${session.layout == 'fluid'}">
  <g:set var="menutype" value="nav nav-tabs"/>
</g:elseif>

<!-- position of menu: LTR (left-to-right, European) or RTL (right-to-left, Oriental) -->
<g:if test="${session.menuposition == 'right' && session.layout == 'grid'}">
  <g:set var="menuposition" value="pull-right"/>
</g:if>
<g:elseif test="${session.menuposition == 'right' && session.layout == 'fluid'}">
  <g:set var="menuposition" value="tabbable tabs-right"/> <!-- pull-right -->
</g:elseif>
<g:elseif test="${session.layout == 'fluid'}">
  <g:set var="menuposition" value="tabbable tabs-left"/> <!-- pull-left -->
</g:elseif>
<g:else>
  <g:set var="menuposition" value=""/>
</g:else>


<div class="${menuposition}">
  <ul class="${menutype}" data-role="listview" data-split-icon="gear" data-filter="true">

    <li class="controller${params.controller == 'home' ? " active" : ""}">
      <g:link controller="home" action="index">
        <g:message code="home.label" default="Home"/>
      </g:link>
    </li>
    <sec:ifAllGranted roles="ROLE_ADMIN">
      <li class="controller${params.controller == 'category' ? " active" : ""}">
        <g:link controller="category" action="index">
          <g:message code="category.label" default="Category"/>
        </g:link>
      </li>
    </sec:ifAllGranted>
    <sec:ifAllGranted roles="ROLE_ADMIN">
      <li class="controller${params.controller == 'question' ? " active" : ""}">
        <g:link controller="question" action="index">
          <g:message code="question.label" default="Question"/>
        </g:link>
      </li>
    </sec:ifAllGranted>
    <sec:ifAllGranted roles="ROLE_ADMIN">
      <li class="controller${params.controller == 'user' ? " active" : ""}">
        <g:link controller="user" action="index">
          <g:message code="user.label" default="User"/>
        </g:link>
      </li>
    </sec:ifAllGranted>
    <sec:ifAllGranted roles="ROLE_ADMIN">
      <li class="controller${params.controller == 'requestmap' ? " active" : ""}">
        <g:link controller="requestmap" action="index">
          <g:message code="requestmap.label" default="Requestmap"/>
        </g:link>
      </li>
    </sec:ifAllGranted>

  </ul>
</div>
