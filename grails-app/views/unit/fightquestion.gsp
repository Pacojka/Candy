<html>
  <head>
    <title>Welcome to Xiconis da Game</title>
    <meta name="layout" content="main" />
  </head>
  <body>
    <div id="body1">

      Hey ${user.username}, willst du wirklich ${enemy.username} auf den Sack geben?<br>
      er ist ${distance}sec entfernt. also ${(int)(distance/60)}min

      <g:form name="form" action="travel">
        <g:render template="fightunits" collection="${units}" var="unit"/>
        <g:hiddenField name="enemyid" value="${enemy.id}" />
        <g:submitButton name="travel" class="test" value="Abreisen" style="cursor: pointer; font-weight: bold; width: 90px; background-color: #000000; color: #606060; border: 1px solid #606060; "/>
      </g:form>
    </div>
  </body>
</html>
