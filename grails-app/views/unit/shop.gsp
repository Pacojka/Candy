<html>
  <head>
    <title>Welcome to Xiconis da Game</title>
    <meta name="layout" content="main" />
  </head>
  <body>
    <div id="body1">
      <table cellspacing="0">
        <tr>
          <td width="150px"><h2>Item</h2></td>
          <td width="80px">Schaden</td>
          <td width="80px">Waffen Typ</td>
          <td width="80px">Goldwert</td>
          
        </tr>
      </table> 
      </br>
      <g:render template="shopitem" collection="${items}" var="item"/>
    </div>
  </body>
</html>








