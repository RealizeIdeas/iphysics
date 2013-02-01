<g:javascript>
    var answersQuantity = ${question?.answers ? question?.answers?.size() : 1};

    jQuery(function () {
      jQuery('.minus_btn').live('click', function () {
        if (answersQuantity > 1) {
          jQuery(this).parent().parent().remove();
          answersQuantity--;
        }
      });

      jQuery('.plus_btn').live('click', function () {
        answersQuantity++;
        jQuery(".answersHolder > div:eq(0)").clone().appendTo('.answersHolder');
      });
    });

</g:javascript>
<div class="control-group fieldcontain required ${hasErrors(bean: question, field: 'answers', 'error')}">
  <label for="answers" class="control-label">
    <g:message code="question.answers.label"/> <span class="required-indicator">*</span>
  </label>

  <div class="controls">

    <div class="form">
      <div class="formSx answersHolder">
        <g:if test="${question?.answers}">
          <g:each in="${question?.answers}" var="answer">
            <div>
              <div class="container_left">
                <g:textField name="answers" value="${answer.value}"/>
                <g:radio name="isCorrect" value="true" checked="${answer.isCorrect}"/>
              </div>

              <div class="additionalInfoActions">
                <input type="button" class="btn minus_btn" value="Delete"/>
                <input type="button" class="btn plus_btn" value="Add"/>
              </div>
            </div>
          </g:each>
        </g:if>
        <g:else>
          <div>
            <div class="container_left">
              <g:textField name="answers"/>
              <g:radio name="isCorrect" value="true"/>
            </div>

            <div class="additionalInfoActions">
              <input type="button" class="btn minus_btn" value="Delete"/>
              <input type="button" class="btn plus_btn" value="Add"/>
            </div>
          </div>
        </g:else>
      </div>
    </div>

    <span class="help-inline">${hasErrors(bean: question, field: 'answers', 'error')}</span>
  </div>
</div>