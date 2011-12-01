<g:if test="${field.hasUser()}">
  <td id="maptd" onmouseover="Tip('<img src=&quot;/bgame/images/user/${field.user.username}.jpg&quot; width=&quot;48&quot;></br>${field.user.username}')" onmouseout="UnTip()">
</g:if>
<g:else>
  <td id="maptd" onmouseover="Tip('${field.fieldtype}</br>${field.xaxis}/${field.yaxis}')" onmouseout="UnTip()">
</g:else>
<g:set var="img" value="${field.fieldtype.getKey()}${rangenow}.png" />
<g:if test="${field.hasUser()}">
  <g:link action="fightquestion" params="[enemyid:field.user.id]"><img title="${field.user.username}Fehler" src="${resource(dir:'images/map',file:img)}"/></g:link>
</g:if>
<g:else>
  <img src="${resource(dir:'images/map',file:img)}"/>
</g:else>
</td>
<g:if test="${field.xaxis == range}">
</tr>
<tr>
</g:if>








