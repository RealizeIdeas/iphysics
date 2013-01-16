<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <title>Question</title>
</head>

<body>
<section id="show-question" class="first">
  <h3>${question?.description}</h3>

  <g:form action="nextQuestion" method="post">
    <g:select from="${question?.answers}" name="answerValue" noSelection="['': '-----']"/>
    <div class="form-actions">
      <g:actionSubmit class="btn btn-primary" action="nextQuestion"
                      value="Next Question"/>
    </div>
  </g:form>
</section>
</body>
</html>