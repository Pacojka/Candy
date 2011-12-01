<html>
  <head>
    <title>Welcome to Xiconis da Game</title>
    <meta name="layout" content="main" />

  </head>
  <body>
    <div id="body1">
      sicher, dass du ${useritem.item.itemname} für ${useritem.item.gold} verkaufen möchtest?

      <g:form action="sell">
        <g:hiddenField name="useritemid" value="${useritem.id}" />
        <g:hiddenField name="gold" value="${useritem.item.gold}" />
        <span class="button"><g:submitButton name="sellquestion" class="notest" value="verkaufen" /></span>
      </g:form>
      <br>
    </div>
  </body>
</html>
