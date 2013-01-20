<div class="control-group fieldcontain ${invalid ? 'error' : ''} ${required ? 'required' : ''}">
  <label for="${property}" class="control-label">
    ${label}<g:if test="${required}"><span class="required-indicator">*</span></g:if>
  </label>

  <div class="controls">
    ${widget}
    <span class="help-inline">${invalid ? 'error' : ''}</span>
  </div>
</div>