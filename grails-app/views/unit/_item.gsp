<div id="body">
	<table cellspacing="0">
		<tr>
			<td width="150px" bgcolor="#440000"><h2>
					${useritem.item.itemname}
				</h2></td>

			<td width="80px" bgcolor="#1C1C1C">
				${useritem.item.dmgmin}-${useritem.item.dmgmax}
			</td>
			<td width="80px" bgcolor="#1C1C1C">
				${useritem.item.item_type}
			</td>
			<td width="60px" bgcolor="#1C1C1C">
				${useritem.item.gold}
			</td>
			<td width="120px" bgcolor="#1C1C1C"><g:if
					test="${useritem.unit == null}">
					<g:set var="unittype" value="${useritem.item.item_type.getKey()}" />
					<g:set var="avunits"
						value="${useritem.user.getitemunits(unittype)}" />
					<g:form action="equipt">
						<g:hiddenField name="useritemid" value="${useritem.id}" />
						<g:select name="unitid" noSelection="${['null':'auswählen...']}"
							from="${avunits}" optionKey="id"
							style="width: 90px; background-color: #440000; color: black; border: 1px solid #606060; " />



						<g:submitButton name="equipt" class="test" value="+"
							style="cursor: pointer; font-weight: bold; width: 20px; background-color: #000000; color: #606060; border: 1px solid #606060; " />

					</g:form>
			<td bgcolor="#1C1C1C"><g:form action="sellquestion">
					<g:hiddenField name="useritemid" value="${useritem.id}" />

					<g:submitButton name="sellquestion" class="test" value="verkaufen"
						style="cursor: pointer; font-weight: bold; width: 70px; background-color: #000000; color: #606060; border: 1px solid #606060; " />

				</g:form></td>
				</g:if> <g:elseif test="${useritem.unit.away == true}">
				
						<p>
							<g:hiddenField name="usritemid" value="${useritem.id}"
								style="position:static;" />


							<g:submitButton disabled="true" name="sellquestion" class="test"
								value="${useritem.unit.name}"
								style="width: 90px; cursor: default; font-weight: bold;  background-color: #000000; color: #606060; border: 1px solid #606060; " />


							<g:submitButton disabled="true" name="unequipt" class="test" value="-"
								style="cursor: pointer; font-weight: bold; width: 20px; background-color: #000000; color: #606060; border: 1px solid #606060; " />
						</p>
					
								<td bgcolor="#1C1C1C"><g:form action="sellquestion">
					<g:hiddenField name="useritemid" value="${useritem.id}" />

					<g:submitButton disabled="true" name="sellquestion" class="test" value="verkaufen"
						style="cursor: pointer; font-weight: bold; width: 70px; background-color: #000000; color: #606060; border: 1px solid #606060; " />

				</g:form></td>
				</g:elseif> <g:else>
					<g:form action="unequipt">
						<p>
							<g:hiddenField name="usritemid" value="${useritem.id}"
								style="position:static;" />


							<g:submitButton disabled="true" name="sellquestion" class="test"
								value="${useritem.unit.name}"
								style="width: 90px; cursor: default; font-weight: bold;  background-color: #000000; color: #606060; border: 1px solid #606060; " />


							<g:submitButton name="unequipt" class="test" value="-"
								style="cursor: pointer; font-weight: bold; width: 20px; background-color: #000000; color: #606060; border: 1px solid #606060; " />
						</p>
					</g:form>




			<td bgcolor="#1C1C1C"><g:form action="sellquestion">
					<g:hiddenField name="useritemid" value="${useritem.id}" />

					<g:submitButton name="sellquestion" class="test" value="verkaufen"
						style="cursor: pointer; font-weight: bold; width: 70px; background-color: #000000; color: #606060; border: 1px solid #606060; " />

				</g:form></td>
				</g:else>
		</tr>
	</table>
	</br>
</div>

