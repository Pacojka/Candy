<html>
  <head>
    <title>Welcome to Xiconis da Game</title>
    <meta name="layout" content="main" />
  </head>
  <body>
    <div id="body1">


      <table cellspacing="0">
        <tr>
          <td width="150px"><h2>${unit.name} der Zerstöhrer</h2></td>
          
          
          
        </tr>
      </table>
     
        </br>
      <div id="hpbalken">
        <div style="background-color:#440000; z-index:1; width:${unit.curhppr}%;face="Arial">&nbsp</font> </div>
      </div>

      <div id="hp">
${unit.curhp}/${unit.maxhp}
      </div>

      <div id="table" >
        <table cellspacing="0">

          <tr>
            <td bgcolor="#1C1C1C">St&auml;rke
              <div id="balken">
                <div style="background-color:#440000; width:${unit.strToNext}%;face="Arial"> ${unit.str}</font></div> </div>
            </td>


            <td bgcolor="#1C1C1C">Geschick
              <div id="balken">
                <div style="background-color:#440000; width:${unit.gesToNext}%;face="Arial">${unit.ges}</font></div> </div>
            </td>


            <td bgcolor="#1C1C1C">Intelligenz
              <div id="balken">
                <div style="background-color:#440000; width:${unit.inzToNext}%;face="Arial">  ${unit.inz}</font></div> </div>
            </td>

          </tr>

          <tr>
            <td bgcolor="#1C1C1C">Nahkampf

              <div id="balken">
                <div style="background-color:#440000; width:${unit.nahToNext}%;face="Arial"> ${unit.nahlvl}</font></div> </div>

            </td>
            <td bgcolor="#1C1C1C">Fernkampf

              <div id="balken">
                <div style="background-color:#440000; width:${unit.ferToNext}%;face="Arial">${unit.ferlvl}</font></div> </div>
            </td>
            <td bgcolor="#1C1C1C">Magie
              <div id="balken">
                <div style="background-color:#440000; width:${unit.magToNext}%;face="Arial">${unit.maglvl}</font></div> </div>

            </td>
          </tr>
        </table>
      </div>
      
      
      
      </br>
      <table cellspacing="0">
        <tr>
          <td width="150px"><h2>Item</h2></td>
          <td width="80px">Schaden</td>
          <td width="80px">Waffen Typ</td>
          <td width="80px">Goldwert</td>
          
        </tr>
      </table> 
      </br>
     
      <g:render template="unititem" collection="${items}" var="useritem"/>
      <br>

<g:if test="${unit.away() == false}">
      Ausrüsten:
      <g:set var="uneqitems" value="${unit.notequipteditemtypes()}" />
        <g:form action="uvequipt">
        <g:hiddenField name="unitid" value="${unit.id}" />
        <g:select name="useritemid" noSelection="${['null':'auswählen...']}" from="${uneqitems}" optionKey="id" style="width: 90px; background-color: #440000; color: black; border: 1px solid #606060; " />
       <g:submitButton name="equipt" class="test" value="+" style="cursor: pointer; font-weight: bold; width: 20px; background-color: #000000; color: #606060; border: 1px solid #606060; " />
      </g:form>
</g:if>

    </div>
  </body>
</html>
