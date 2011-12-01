<html>
  <head>
    <title>Welcome to Xiconis da Game CheckCheck</title>
    <meta name="layout" content="main" />
  </head>
  <body>
  <g:javascript src="wz_tooltip.js" />
  <div id="body1">
    <table>  
      <tr>
        <td>
      <g:if test="${rangenow<=5}">
        <g:link action="map" params="[newx:xnow,newy:ynow,newrange:rangenow+1]"><h4>-</h4></g:link>
      </g:if>
      </td>
      <td><g:link action="map" params="[newx:xnow,newy:ynow-1,newrange:rangenow]"><h4><img src="/bgame/images/map/mapup.png"/></h4></g:link></td>
      <td></td>
      </tr>
      <tr width="380px">
        <td id="maptd"><g:link action="map" params="[newx:xnow-1,newy:ynow,newrange:rangenow]"><h4><img src="/bgame/images/map/mapleft.png"/></h4></g:link></td>
      <td width="380px">
        <table id="maptable" cellspacing="1" >
          <tr>
          <g:render template="map" collection="${fields}" var="field"/>
          </tr>
        </table>
      </td>
      <td id="maptd"><g:link  action="map" params="[newx:xnow+1,newy:ynow,newrange:rangenow]"><h4><img src="/bgame/images/map/mapright.png"/></h4></g:link></td>
      </tr>
      <tr>
        <td></td>
        <td><g:link action="map" params="[newx:xnow,newy:ynow+1,newrange:rangenow]"><h4><img src="/bgame/images/map/mapdown.png"/></h4></g:link></td>
      <td>
      <g:if test="${rangenow>=4}">
        <g:link action="map" params="[newx:xnow,newy:ynow,newrange:rangenow-1]"><h4>+</h4></g:link>
      </g:if>
      </td>
      </tr>
    </table>
    </br>
    </br>
    </br>
    </br>
    </br>
    </br>
  </div>
</div>
</body>
</html>
