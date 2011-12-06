
<div id="table">  
  <table cellspacing="0">
    <tr>
      <td width="150px" bgcolor="#440000">
        <h2>
          startzeit:<br>${action.starttime}
        </h2>
      </td>
      <td width="150px" bgcolor="#440000">
        <h2> 
          ankunftszeit:<br>${action.endtime}
        </h2>
      </td>
    </tr>
    <tr>
      <td width="150px" bgcolor="#440000">
        <h2>
          <g:render template="actionunits" collection="${action.units()}" var="unit"/>
        </h2>
      </td>
    </tr>
  </table>

</div>







