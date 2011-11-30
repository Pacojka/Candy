<html>
  <head>
    <title>Welcome to Xiconis da Game CheckCheck</title>
    <meta name="layout" content="main" />

  </head>
  <body>
    <div id="body1">
      <table id="maptable">
        <tr>

        <g:render template="map" collection="${fields}" var="field"/>
        </tr>

      </table>
      <h4>midde ist (${xnow}/${ynow})</h4>
      </br>
      <g:link action="map" params="[newx:xnow,newy:ynow-1]"><h4>oben</h4></g:link>
      <g:link action="map" params="[newx:xnow-1,newy:ynow]"><h4>links</h4></g:link>
      <g:link action="map" params="[newx:xnow,newy:ynow+1]"><h4>unten</h4></g:link>
      <g:link action="map" params="[newx:xnow+1,newy:ynow]"><h4>rechts</h4></g:link>
      </br>
      </br>
      </br>
      </br>
      </br>
    </div>
  </div>
</body>
</html>
