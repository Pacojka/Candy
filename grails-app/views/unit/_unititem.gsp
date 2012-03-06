

<div id="body">  
  <table cellspacing="0" >
    <tr>
      <td width="150px" bgcolor="#440000" ><h2>${useritem.item.itemname}</h2></td>

      <td width="80px" bgcolor="#1C1C1C">${useritem.item.dmgmin}-${useritem.item.dmgmax}</td>
      <td width="80px" bgcolor="#1C1C1C">${useritem.item.item_type}</td>
      <td width="80px" bgcolor="#1C1C1C">${useritem.item.gold}</td>
      <td bgcolor="#1C1C1C">
  <g:if test="${unit.away() == false}"> 
    <g:form action="unequiptuv">
      <g:hiddenField name="usritemid" value="${useritem.id}" />
      <g:hiddenField name="unitid" value="${useritem.unit.id}" />
      <g:submitButton name="unequiptuv" class="test" value="-" style="cursor: pointer; font-weight: bold; width: 20px; background-color: #000000; color: #606060; border: 1px solid #606060; " />
    </g:form>
  </g:if>
  </td>

    </tr>
  </table>
  </br>
</div>

