<div id="table">  
  <table>
    <tr>
      <td width="80px" bgcolor="#440000"><h2>${useritem.item.id} ${useritem.item.itemname}</h2></td>
      <td>Schaden: ${useritem.item.dmgmin}-${useritem.item.dmgmax}<br>Waffen Typ: ${useritem.item.item_type}<br>Goldwert: ${useritem.item.gold}</td>
      <td>Equipted by Unit: 
    <g:if test="${useritem.unit != null}">
${useritem.unit.name}
    </g:if>
    <g:else>
      keine
    </g:else></td>
    <td><g:link action="sellquestion" params="[usritemid:useritem.id]">Verkaufen für ${useritem.item.gold} Gold.</g:link></td>
    </tr>
  </table>

</div>

