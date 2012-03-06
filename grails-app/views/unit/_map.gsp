<g:if test="${field.hasUser()}">
  <td id="maptd" onmouseover="Tip('<img src=&quot;/images/user/${field.user.username}.jpg&quot; width=&quot;48&quot;></br>${field.user.username}')" onmouseout="UnTip()">
</g:if>   
<g:else>
  <td id="maptd" onmouseover="Tip('${field.fieldtype}</br>${field.xaxis}/${field.yaxis}</br>Monsterexp: ${field.monsterexp}</br>Staerkemult.: ${field.staerkefaktor}')" onmouseout="UnTip()">
</g:else>
<g:set var="img" value="${field.fieldtype.getKey()}${rangenow}.png" />
<g:if test="${field.hasUser()}">
  <g:link action="fightquestion" params="[x:field.xaxis,y:field.yaxis]"><img title="${field.user.username}Fehler" src="${resource(dir:'images/map',file:img)}"/></g:link>
</g:if>
<g:else>
  <g:link action="fightquestion" params="[x:field.xaxis,y:field.yaxis]"><img title="${field.fieldtype} Fehler" src="${resource(dir:'images/map',file:img)}"/></g:link>
</g:else>
</td>
<g:if test="${field.xaxis == range}">
</tr>
<tr>
</g:if>








