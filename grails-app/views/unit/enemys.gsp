<html>
  <head>
    <title>Welcome to Xiconis da Game</title>
    <meta name="layout" content="main" />
  </head>
  <body>
    <div id="body1">
      
      
         <table cellspacing="0">
        <tr>
          <td width="150px"><h2>Gegner</h2></td>
          <td width="80px">Einheiten</td>
        </tr>
      </table>
      <g:render template="enemy" collection="${userenemys}" var="enemy"/> 
    </div>
  </body>
</html>
