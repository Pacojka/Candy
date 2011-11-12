<html>
  <head>
    <title>Welcome to Xiconis da Game</title>
    <meta name="layout" content="main" />

  </head>
  <body>
    <div id="body1">
      sicher, dass du ${useritem.item.itemname} für ${useritem.item.gold} verkaufen möchtest?
      <g:link action="sell" params="[usritemid:useritem.id]">für ${useritem.item.gold} Gold verkaufen.</g:link>
      <br>
    </div>
  </body>
</html>
