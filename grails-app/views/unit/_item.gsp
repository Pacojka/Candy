<div id="body">  
  <table cellspacing="0" >
    <tr>
      <td width="150px" bgcolor="#440000" ><h2>${useritem.item.itemname}</h2></td>

      <td width="80px" bgcolor="#1C1C1C">${useritem.item.dmgmin}-${useritem.item.dmgmax}</td>
      <td width="80px" bgcolor="#1C1C1C">${useritem.item.item_type}</td>
      <td width="60px" bgcolor="#1C1C1C">${useritem.item.gold}</td>
      <td width="120px" bgcolor="#1C1C1C">


    <g:if test="${useritem.unit != null}">
      <g:form action="unequipt">
        <g:hiddenField name="usritemid" value="${useritem.id}" />
${useritem.unit.name}
        <span class="button"><g:submitButton name="unequipt" class="test" value="-" /></span>
      </g:form>
    </g:if>
    <g:else>
      <g:set var="nowpnunits" value="${useritem.user.nowpnunis()}" />
      <g:form action="equipt">        
        <g:hiddenField name="useritemid" value="${useritem.id}" />
        <g:select name="unit.id" noSelection="${['null':'Select One...']}" from="${nowpnunits}" optionKey="id" />
        <span class="button"><g:submitButton name="equipt" class="test" value="+" /></span>
      </g:form>




    </g:else></td>            



    <td bgcolor="#1C1C1C"><g:link action="sellquestion" params="[usritemid:useritem.id]">Verkaufen</g:link></td>
    </tr>
  </table>
  </br>
</div>

