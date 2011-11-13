<div id="table">  
  <table>
    <tr>
      <td width="80px" bgcolor="#440000"><h2>${useritem.item.id} ${useritem.item.itemname}</h2></td>
      <td>Schaden: ${useritem.item.dmgmin}-${useritem.item.dmgmax}<br>Waffen Typ: ${useritem.item.item_type}<br>Goldwert: ${useritem.item.gold}</td>

    <td><g:link action="unequipt" params="[usritemid:useritem.id]">Item ablegen.</g:link></td>
    </tr>
  </table>

</div>

