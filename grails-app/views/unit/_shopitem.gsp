

<div id="body">  
  <table cellspacing="0" >
    <tr>
      <td width="150px" bgcolor="#440000" ><h2>${item.itemname}</h2></td>
      <td width="80px" bgcolor="#1C1C1C">${item.dmgmin}-${item.dmgmax}</td>
      <td width="80px" bgcolor="#1C1C1C">${item.item_type}</td>
      <td width="80px" bgcolor="#1C1C1C">${item.gold}</td>
 
  
    <td width="60px" bgcolor="#1C1C1C">

    <g:if test="${gold >= item.gold}">
          <g:form action="shopbuy">
        <g:hiddenField name="itemid" value="${item.id}" />
        <span class="button"><g:submitButton name="shopbuy" class="test" value="kaufen" /></span>
      </g:form>
 </g:if>
    <g:else>
      -
    </g:else>




    
    </td>
    </tr>
  </table>
  </br>
</div>
