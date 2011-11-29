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
        <div class="equipbutton">
        <g:submitButton name="unequipt" class="test" value="-" />
        </div>
      </g:form>

    </g:if>
    <g:else>
<g:set var="unittype" value="${useritem.item.item_type.getKey()}" />
<g:set var="avunits" value="${useritem.user.getitemunits(unittype)}" />
      <g:form action="equipt">
        <g:hiddenField name="useritemid" value="${useritem.id}" />
        <g:select name="unitid" noSelection="${['null':'auswählen...']}" from="${avunits}" optionKey="id" />
      <div class="equipbutton">
        <span class="style"><g:submitButton name="equipt" class="test" value="+" /></span>
      </div>
      </g:form>



    </g:else>
 <td bgcolor="#1C1C1C">
    <g:form action="sellquestion">
        <g:hiddenField name="useritemid" value="${useritem.id}" />
         <div class="buttons">
        <span class="jizzton"><g:submitButton name="sellquestion" class="test" value="verkaufen" /></span>
         </div>
      </g:form>
</td>
    </tr>
  </table>
  </br>
</div>

