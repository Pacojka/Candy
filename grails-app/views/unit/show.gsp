
<%@ page import="com.bgame.Unit" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'unit.label', default: 'Unit')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.name.label" default="Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "name")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.curhp.label" default="Curhp" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "curhp")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.curhppr.label" default="Curhppr" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "curhppr")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.dateCreated.label" default="Date Created" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${unitInstance?.dateCreated}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.exp.label" default="Exp" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "exp")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.ferToNext.label" default="Fer To Next" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "ferToNext")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.ferexp.label" default="Ferexp" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "ferexp")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.ferlvl.label" default="Ferlvl" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "ferlvl")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.ges.label" default="Ges" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "ges")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.gesToNext.label" default="Ges To Next" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "gesToNext")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.inz.label" default="Inz" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "inz")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.inzToNext.label" default="Inz To Next" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "inzToNext")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.magToNext.label" default="Mag To Next" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "magToNext")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.magexp.label" default="Magexp" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "magexp")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.maglvl.label" default="Maglvl" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "maglvl")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.main.label" default="Main" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${unitInstance?.main}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.maxhp.label" default="Maxhp" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "maxhp")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.nahToNext.label" default="Nah To Next" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "nahToNext")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.nahexp.label" default="Nahexp" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "nahexp")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.nahlvl.label" default="Nahlvl" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "nahlvl")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.str.label" default="Str" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "str")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.strToNext.label" default="Str To Next" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: unitInstance, field: "strToNext")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.user.label" default="User" /></td>
                            
                            <td valign="top" class="value"><g:link controller="user" action="show" id="${unitInstance?.user?.id}">${unitInstance?.user?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.useritems.label" default="Useritems" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${unitInstance.useritems}" var="u">
                                    <li><g:link controller="usritm" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="unit.wtyp.label" default="Wtyp" /></td>
                            
                            <td valign="top" class="value">${unitInstance?.wtyp?.encodeAsHTML()}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${unitInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
