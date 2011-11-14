
<div id="table">  
  <table cellspacing="0">
    <tr>
      <td width="150px" bgcolor="#440000"><h2><g:link action="unitview" params="[unitid:unit.id]">${unit.name}</g:link></h2></td>
      <td width="340px" bgcolor="#1C1C1C"> 
        <div id="hpbalken">
          <div style="background-color:#440000; z-index:1; width:${unit.curhppr}%;face="Arial">&nbsp</font> </div>
        </div>

        <div id="hp">
          ${unit.curhp}/${unit.maxhp}
        </div>
      </td>
    </tr>
  </table>

</div>







