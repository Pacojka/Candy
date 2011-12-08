<div id="clock${action.id}">[${action.id}]</div>
<div>${action}</div>
<script language="javascript">
var clock${action.id} = new StartCountDown("clock${action.id}","${action.timeleft()}");
</script>
<br>