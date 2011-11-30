<td id="maptd">
  <g:set var="img" value="${field.fieldtype.getKey()}.png" />
<g:if test="${field.hasUser()}">
<g:link action="fightquestion" params="[enemyid:field.user.id]"><img title="${field.user.username}" src="${resource(dir:'images/map',file:img)}"/></g:link>

</g:if>
<g:else>
  <img src="${resource(dir:'images/map',file:img)}"/>
</g:else>


</td>
<g:if test="${field.xaxis == range}">
</tr>
<tr>
</g:if>








