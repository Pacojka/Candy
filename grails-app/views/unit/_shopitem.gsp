<div id="table">  
  <table>
    <tr>
      <td width="80px" bgcolor="#440000"><h2>${item.itemname}</h2></td>
      <td>Schaden: ${item.dmgmin}-${item.dmgmax}<br>Waffen Typ: ${item.item_type}</td>
      <td>Equipted by Unit: </td>
      <td><g:link action="shopbuy" params="[itemid:item.id]">kaufen für ${item.gold} Gold.</g:link></td>
    </tr>
  </table>

</div>

