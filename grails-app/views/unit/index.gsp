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
      <table cellspacing="0">
        <tr>
          <td width="150px"><h2>Einheit</h2></td>
          <td width="80px">HP</td>


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
