<td width="40" height="40">
${field}

<g:if test="${field.hasUser()}">
<g:link action="fightquestion" params="[enemyid:field.user.id]"><h4>${field.user.username}</h4></g:link>

</g:if>


</td>
<g:if test="${field.xaxis == range}">
</tr>
<tr>
</g:if>








