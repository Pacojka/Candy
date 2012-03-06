<html>
  <head>
    <title>Welcome to Grails</title
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <meta name="layout" content="main" />

  </head>
  <body>

    <div id="body1">
      <h1></h1>
         <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    </div>

  </body>
</html>
