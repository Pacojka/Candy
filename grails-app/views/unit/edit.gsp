

<%@ page import="com.bgame.Unit" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'unit.label', default: 'Unit')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${unitInstance}">
            <div class="errors">
                <g:renderErrors bean="${unitInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${unitInstance?.id}" />
                <g:hiddenField name="version" value="${unitInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="unit.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${unitInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="curhp"><g:message code="unit.curhp.label" default="Curhp" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'curhp', 'errors')}">
                                    <g:textField name="curhp" value="${fieldValue(bean: unitInstance, field: 'curhp')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="curhppr"><g:message code="unit.curhppr.label" default="Curhppr" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'curhppr', 'errors')}">
                                    <g:textField name="curhppr" value="${fieldValue(bean: unitInstance, field: 'curhppr')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="exp"><g:message code="unit.exp.label" default="Exp" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'exp', 'errors')}">
                                    <g:textField name="exp" value="${fieldValue(bean: unitInstance, field: 'exp')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="ferToNext"><g:message code="unit.ferToNext.label" default="Fer To Next" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'ferToNext', 'errors')}">
                                    <g:textField name="ferToNext" value="${fieldValue(bean: unitInstance, field: 'ferToNext')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="ferexp"><g:message code="unit.ferexp.label" default="Ferexp" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'ferexp', 'errors')}">
                                    <g:textField name="ferexp" value="${fieldValue(bean: unitInstance, field: 'ferexp')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="ferlvl"><g:message code="unit.ferlvl.label" default="Ferlvl" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'ferlvl', 'errors')}">
                                    <g:textField name="ferlvl" value="${fieldValue(bean: unitInstance, field: 'ferlvl')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="ges"><g:message code="unit.ges.label" default="Ges" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'ges', 'errors')}">
                                    <g:textField name="ges" value="${fieldValue(bean: unitInstance, field: 'ges')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="gesToNext"><g:message code="unit.gesToNext.label" default="Ges To Next" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'gesToNext', 'errors')}">
                                    <g:textField name="gesToNext" value="${fieldValue(bean: unitInstance, field: 'gesToNext')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="inz"><g:message code="unit.inz.label" default="Inz" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'inz', 'errors')}">
                                    <g:textField name="inz" value="${fieldValue(bean: unitInstance, field: 'inz')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="inzToNext"><g:message code="unit.inzToNext.label" default="Inz To Next" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'inzToNext', 'errors')}">
                                    <g:textField name="inzToNext" value="${fieldValue(bean: unitInstance, field: 'inzToNext')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="magToNext"><g:message code="unit.magToNext.label" default="Mag To Next" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'magToNext', 'errors')}">
                                    <g:textField name="magToNext" value="${fieldValue(bean: unitInstance, field: 'magToNext')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="magexp"><g:message code="unit.magexp.label" default="Magexp" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'magexp', 'errors')}">
                                    <g:textField name="magexp" value="${fieldValue(bean: unitInstance, field: 'magexp')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="maglvl"><g:message code="unit.maglvl.label" default="Maglvl" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'maglvl', 'errors')}">
                                    <g:textField name="maglvl" value="${fieldValue(bean: unitInstance, field: 'maglvl')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="main"><g:message code="unit.main.label" default="Main" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'main', 'errors')}">
                                    <g:checkBox name="main" value="${unitInstance?.main}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="maxhp"><g:message code="unit.maxhp.label" default="Maxhp" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'maxhp', 'errors')}">
                                    <g:textField name="maxhp" value="${fieldValue(bean: unitInstance, field: 'maxhp')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="nahToNext"><g:message code="unit.nahToNext.label" default="Nah To Next" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'nahToNext', 'errors')}">
                                    <g:textField name="nahToNext" value="${fieldValue(bean: unitInstance, field: 'nahToNext')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="nahexp"><g:message code="unit.nahexp.label" default="Nahexp" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'nahexp', 'errors')}">
                                    <g:textField name="nahexp" value="${fieldValue(bean: unitInstance, field: 'nahexp')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="nahlvl"><g:message code="unit.nahlvl.label" default="Nahlvl" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'nahlvl', 'errors')}">
                                    <g:textField name="nahlvl" value="${fieldValue(bean: unitInstance, field: 'nahlvl')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="str"><g:message code="unit.str.label" default="Str" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'str', 'errors')}">
                                    <g:textField name="str" value="${fieldValue(bean: unitInstance, field: 'str')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="strToNext"><g:message code="unit.strToNext.label" default="Str To Next" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'strToNext', 'errors')}">
                                    <g:textField name="strToNext" value="${fieldValue(bean: unitInstance, field: 'strToNext')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="user"><g:message code="unit.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.bgame.User.list()}" optionKey="id" value="${unitInstance?.user?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="useritems"><g:message code="unit.useritems.label" default="Useritems" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'useritems', 'errors')}">
                                    
<ul>
<g:each in="${unitInstance?.useritems?}" var="u">
    <li><g:link controller="usritm" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="usritm" action="create" params="['unit.id': unitInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'usritm.label', default: 'Usritm')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="wtyp"><g:message code="unit.wtyp.label" default="Wtyp" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: unitInstance, field: 'wtyp', 'errors')}">
                                    <g:select name="wtyp" from="${com.bgame.Unit$MyEnum?.values()}" keys="${com.bgame.Unit$MyEnum?.values()*.name()}" value="${unitInstance?.wtyp?.name()}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
