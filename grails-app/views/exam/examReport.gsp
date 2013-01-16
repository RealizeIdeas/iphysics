<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="kickstart"/>
  <title>Exam report</title>
</head>
<body>
 <section id="show-report" class="first">
   <h2>Всего баллов заработано: <g:formatNumber number="${exam?.getTotalPointsEarned()}"/></h2>
   <g:each in="${exam?.studentAnswers}" var="studentAnswer">
     <div>
       <h5>${studentAnswer?.question?.description}</h5>
       <div>Правильный ответ: ${studentAnswer?.question?.answers?.find{it.isCorrect}?.value}</div>
       <div>Данный ответ: ${studentAnswer?.answer?.value}</div>
     </div>
   </g:each>
 </section>
</body>
</html>