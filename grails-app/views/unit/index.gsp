<html>
  <head>
    <title>Welcome to Xiconis da Game CheckCheck</title>
    <meta name="layout" content="main" />

  </head>
  <body>
<script language="JavaScript">

  /*
  	Author:		Robert Hashemian (http://www.hashemian.com/)
  	Modified by:	Munsifali Rashid (http://www.munit.co.uk/)
  	Modified by:	Tilesh Khatri
	Modified by:	Patrick Sojka
  */

  function StartCountDown(myDiv,daseconds)
  {
    var isec	= daseconds
    CountBack(myDiv,isec);
  }

  function Calcage(secs, num1, num2)
  {
    s = ((Math.floor(secs/num1))%num2).toString();
    if (s.length < 2)
    {
      s = "0" + s;
    }
    return (s);
  }

  function CountBack(myDiv, secs)
  {
    var DisplayStr;
    var DisplayFormat

	if (secs >=21600)
  {
    DisplayFormat = "%%D%% Tage, %%H%% Std., %%M%% Min., %%S%% Sek.";

	DisplayStr = DisplayFormat.replace(/%%D%%/g,	Calcage(secs,86400,100000));
    DisplayStr = DisplayStr.replace(/%%H%%/g,		Calcage(secs,3600,24));
    DisplayStr = DisplayStr.replace(/%%M%%/g,		Calcage(secs,60,60));
    DisplayStr = DisplayStr.replace(/%%S%%/g,		Calcage(secs,1,60));
  }
  else if (secs <= 21599 && secs >= 3600)
  {
        DisplayFormat = "%%H%% Std., %%M%% Min., %%S%% Sek.";

    DisplayStr = DisplayFormat.replace(/%%H%%/g,		Calcage(secs,3600,24));
    DisplayStr = DisplayStr.replace(/%%M%%/g,		Calcage(secs,60,60));
    DisplayStr = DisplayStr.replace(/%%S%%/g,		Calcage(secs,1,60));
  }
    else if (secs <= 3599 && secs >= 60)
  {
    DisplayFormat = "%%M%% Min., %%S%% Sek.";

    DisplayStr = DisplayFormat.replace(/%%M%%/g,		Calcage(secs,60,60));
    DisplayStr = DisplayStr.replace(/%%S%%/g,		Calcage(secs,1,60));
  }
    else
  {
    DisplayFormat = "%%S%% Sek.";
    DisplayStr = DisplayFormat.replace(/%%S%%/g,		Calcage(secs,1,60));
    }


	if(secs > 0)
    {
      document.getElementById(myDiv).innerHTML = DisplayStr;
      setTimeout("CountBack('" + myDiv + "'," + (secs-1) + ");", 990);
    }
    else
    {
      document.getElementById(myDiv).innerHTML = "-";
    }
  }

</script>


    
    
    <div id="body1">
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:render template="actions" collection="${useractions}" var="action"/>
      <table cellspacing="0">
        <tr>
          <td width="150px"><h2>Einheit</h2></td>
          <td width="80px"><h2>HP</h2></td>


        </tr>
      </table>
      <g:render template="units" collection="${userunits}" var="unit"/>      
      </br>
      </br>
      </br>
      </br>
      </br>
    </div>

  </body>
</html>
