<div id="body">  
  <table cellspacing="0" >
    <tr>
      <td width="150px" bgcolor="#440000" ><h2>${useritem.item.itemname}</h2></td>

      <td width="80px" bgcolor="#1C1C1C">${useritem.item.dmgmin}-${useritem.item.dmgmax}</td>
      <td width="80px" bgcolor="#1C1C1C">${useritem.item.item_type}</td>
      <td width="80px" bgcolor="#1C1C1C">${useritem.item.gold}</td>
      <td width="85px" bgcolor="#1C1C1C"><g:if test="${useritem.unit != null}">
${useritem.unit.name}
    </g:if>
    <g:else>
      <g:select name="user.id" from="${com.bgame.User.list()}" optionKey="id" value="${unitInstance?.user?.id}"  />
    </g:else></td>

    <td bgcolor="#1C1C1C"><g:link action="sellquestion" params="[usritemid:useritem.id]">Verkaufen</g:link></td>
    </tr>
  </table>
  </br>
</div>
