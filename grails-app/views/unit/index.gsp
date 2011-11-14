<html>
  <head>
    <title>Welcome to Xiconis da Game CheckCheck</title>
    <meta name="layout" content="main" />

  </head>
  <body>
    <div id="body1">
      <g:render template="units" collection="${userunits}" var="unit"/>
      <g:link controller='unit' action='createUnit'>Neue Einheit</g:link>
      </br>
      <g:link controller='unit' action='heal'>Einheiten heilen</g:link>
   </br>
    </br>
    </br>
    </br>
    </div>
    
  </body>
</html>
