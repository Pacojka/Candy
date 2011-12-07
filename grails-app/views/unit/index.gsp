<html>
  <head>
    <title>Welcome to Xiconis da Game CheckCheck</title>
    <meta name="layout" content="main" />

  </head>
  <body>
    
    <div id="body1">
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:render template="actions" collection="${useractions}" var="action"/>
      <table cellspacing="0">
        <tr>
          <td width="150px"><h2>Einheit</h2></td>
          <td width="80px"><h2>HP</h2></td>


        </tr>
      </table>
      <g:render template="units" collection="${userunits}" var="unit"/>      
      </br>
      </br>
      </br>
      </br>
      </br>
    </div>

  </body>
</html>
