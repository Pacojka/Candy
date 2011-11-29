
<div id="table">  
  <table cellspacing="0">
    <tr>
      <td width="150px" bgcolor="#440000">
        <h2><g:link action="unitview" params="[unitid:unit.id]">${unit.name}</g:link></h2>
      </td>
      
      <td width="340px" bgcolor="#1C1C1C">

        <div id="hpbalken">
          <div style="background-color:#440000; z-index:1; width:${unit.curhppr}%;face="Arial">&nbsp</font> </div>
        </div>

        <div id="hp">
${unit.curhp}/${unit.maxhp}
        </div>
      </td>
      <td width="40px" bgcolor="#1C1C1C">${unit.healcost()}</td>
      <td width="30px" bgcolor="#1C1C1C">

    <g:if test="${(unit.curhp > 0) &&(unit.healcost() <= gold)}">
      <g:form name="form" action="healunit">
        <g:hiddenField name="unitid" value="${unit.id}" />
        <g:submitButton name="healunit" class="test" value="heilen" style="cursor: pointer; font-weight: bold; width: 90px; background-color: #000000; color: #606060; border: 1px solid #606060; "/>
      </g:form>
    </g:if>
        <g:if test="${(unit.curhp > 0) &&(unit.healcost() > gold)}">
       <g:submitButton name="healunit" class="test" value="heilen" disabled="true" style="cursor: pointer; font-weight: bold; width: 90px; background-color: #000000; color: #606060; border: 1px solid #606060; "/>
    </g:if>





    <g:if test="${(unit.curhp == 0) &&(unit.healcost() <= gold)}">
      <g:form name="form" action="healunit">
        <g:hiddenField name="unitid" value="${unit.id}" />
        <g:submitButton name="healunit" class="test" value="beleben" style="cursor: pointer; font-weight: bold; width: 90px; background-color: #000000; color: #606060; border: 1px solid #606060; "/>
      </g:form>
    </g:if>
        <g:if test="${(unit.curhp == 0) &&(unit.healcost() > gold)}">
        <g:submitButton name="healunit" class="test" value="beleben" disabled="true" style="cursor: pointer; font-weight: bold; width: 90px; background-color: #000000; color: #606060; border: 1px solid #606060; "/>
    </g:if>
    </td>
    </tr>
  </table>

</div>







