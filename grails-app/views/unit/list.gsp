
<%@ page import="com.bgame.Unit" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'unit.label', default: 'Unit')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'unit.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'unit.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="curhp" title="${message(code: 'unit.curhp.label', default: 'Curhp')}" />
                        
                            <g:sortableColumn property="curhppr" title="${message(code: 'unit.curhppr.label', default: 'Curhppr')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'unit.dateCreated.label', default: 'Date Created')}" />
                        
                            <g:sortableColumn property="exp" title="${message(code: 'unit.exp.label', default: 'Exp')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${unitInstanceList}" status="i" var="unitInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${unitInstance.id}">${fieldValue(bean: unitInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: unitInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: unitInstance, field: "curhp")}</td>
                        
                            <td>${fieldValue(bean: unitInstance, field: "curhppr")}</td>
                        
                            <td><g:formatDate date="${unitInstance.dateCreated}" /></td>
                        
                            <td>${fieldValue(bean: unitInstance, field: "exp")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${unitInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
