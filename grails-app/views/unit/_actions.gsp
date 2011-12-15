

<div id="body">
  <table cellspacing="0" >
    <tr>
      <td width="150px" bgcolor="#440000" ><h2>${action}
          


        </h2></td>

      <td width="80px" bgcolor="#1C1C1C">
        <div id="clock${action.id}">[${action.id}]</div>
      </td>

      <td width="120px" bgcolor="#1C1C1C">

        <g:render template="actionunits" collection="${action.units()}" var="unit"/>
    </td>
    <script language="javascript">
var clock${action.id} = new StartCountDown("clock${action.id}","${action.timeleft()}");
</script>
    </tr>
  </table>
  </br>
</div>

