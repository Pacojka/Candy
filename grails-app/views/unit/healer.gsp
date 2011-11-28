<html>
  <head>
    <title>Welcome to Xiconis da Game CheckCheck</title>
    <meta name="layout" content="main" />

  </head>
  <body>
    <div id="body1">





    <g:if test="${userunits.size() > 0}">
       <table cellspacing="0">
        <tr>
          <td width="150px"><h2>Einheit</h2></td>
          <td width="300px">HP</td>
          <td width="10px">Kosten</td>


        </tr>
      </table>
        <g:render template="healunits" collection="${userunits}" var="unit"/>
    </g:if>
    <g:else>
      <h2>deinen Einheiten geht es gut!</h2>
    </g:else>
  
      </br>
      </br>
      </br>
      </br>
      </br>
    </div>

  </body>
</html>
