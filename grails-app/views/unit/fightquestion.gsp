<html>
  <head>
    <title>Welcome to Xiconis da Game</title>
    <meta name="layout" content="main" />
  </head>
  <body>
    <div id="body1">

      Hey ${user.username},
<g:if test="${user.hasAvailableUnits() == 0}">
 du hast keine verfuegbaren Einheiten!<br>
</g:if>      
<g:elseif test="${field.hasUser()}">
 willst du wirklich ${field.user.username} auf den Sack geben?<br>
      Die Reise dauert ${distance}Sec. also ${(int)(distance/60)}min
      <g:form name="form" action="travel">
        <g:render template="fightunits" collection="${units}" var="unit"/>
        <g:hiddenField name="x" value="${field.xaxis}" />
        <g:hiddenField name="y" value="${field.yaxis}" />
        <g:submitButton name="travel" class="test" value="Abreisen" style="cursor: pointer; font-weight: bold; width: 90px; background-color: #000000; color: #606060; border: 1px solid #606060; "/>
      </g:form>
</g:elseif>
<g:else>
 willst du wirklich zum ${field.fieldtype} reisen um Monster auf zu mischen?<br>
      Die Reise dauert ${distance}Sec. also ${(int)(distance/60)}min
      <g:form name="form" action="travel">
        <g:render template="fightunits" collection="${units}" var="unit"/>
        <g:hiddenField name="x" value="${field.xaxis}" />
        <g:hiddenField name="y" value="${field.yaxis}" />
        <g:submitButton name="travel" class="test" value="Abreisen" style="cursor: pointer; font-weight: bold; width: 90px; background-color: #000000; color: #606060; border: 1px solid #606060; "/>
      </g:form>
</g:else>


    </div>
  </body>
</html>
