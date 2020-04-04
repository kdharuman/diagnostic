<html>
	<head>
<title>Reports</title>
	</head>
<body>
	<fieldset>
		<legend>
			<b>Reports</b>
		</legend>
		<table>
		<tr>
		<input type="checkbox" name="todays_report" value="Today's Report"/> Today's Report
		<input type="checkbox" name="weekly_report" value="Weekly Report" /> Weekly Report
		<input type="checkbox" name="monthly_report" value="Monthly Report" /> Monthly Report
		
		<input type="date" name="date_control" /> Select the Date
		
		<input name="datetime" id="time" type="text" data-template="HH : mm" data-format="HH:mm">
				<script>
					$(function() {
						$('#time').combodate({
							firstItem : 'name',
							minuteStep : 1
						});
					});
				</script>


			</tr>
		</table>
    </fieldset>
    
    <script>
    var now = new Date()
    var month = now.getMonth()
    var ar = new Array(12)
    ar[0] = "January"
    ar[1] = "February"
    ar[2] = "March"
    ar[3] = "April"
    ar[4] = "May"
    ar[5] = "June"
    ar[6] = "July"
    ar[7] = "August"
    ar[8] = "September"
    ar[9] = "October"
    ar[10] = "November"
    ar[11] = "December"
    var message = "It is now " + ar[month] + ", my favorite.<BR>"
    document.write(message)
    </script>
		
</body>
</html>
