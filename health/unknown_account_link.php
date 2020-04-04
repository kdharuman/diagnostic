<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../common/css/jquery-ui-CL_custom/jquery-ui.css' />
		<link rel="stylesheet" type="text/css" href="../common/js/datatables_jq2.2.3_dt-1.10.12/datatables.min.css" />
		<link rel='stylesheet' type='text/css' href='style/ual.css' />	
		<script type='text/javascript' src='../common/js/jquery-2.1.3.min.js'></script>
		<script type='text/javascript' src='../common/js/underscore.js'></script>
		<script type='text/javascript' src='../common/js/jquery-ui.min.js'></script>
		<script type='text/javascript' src='../common/js/datatables_jq2.2.3_dt-1.10.12/DataTables-1.10.12/datatables.min.js'></script>
		<script type='text/javascript' src='../common/js/clhelper.js'></script>
		<script type='text/javascript' src='js/unknown.js'></script>
		<title>Unknown Account Link</title>
	</head>
	<body>
		<table id='headerTable'>
			<tr>
				<td>
					<!-- EAM SELECTOR -->
					<select id='advocateSelect'></select>
					<script id='addDefaultUser' type='text/template'>
						<option value=''>ChooseEAM</option>
					</script>
					<script id='addUsers' type='text/template'>
						<option value='<%- ADVOCATE %>'>
							<%- ADVOCATE %>
						</option>
					</script>
					</select>
					<!-- ACT SELECTOR -->
					<!-- US: 194478 [OE] Update Unknowns: Add conflict as an option under the drop-down choose EAM -->
					<select id='accountSelect'></select>
					<script id='addDefaultAct' type='text/template'>
						<option value=''>ChooseAct</option>
						<option value='CONFLICT'>CONFLICT</option>
					</script>
					<script id='addActs' type='text/template'>
						<option value='<%- ACCOUNT_ID %>'>
							<%- ACCOUNT_ID %>
						</option>
					</script>
					</select>
					<!-- PID SELECTOR -->
					<select id='payorIdSelect'></select>
					<script id='addDefaultPid' type='text/template'>
						<option value=''>ChoosePID</option>
					</script>
					<script id='addPid' type='text/template'>
						<option value='<%- PAYOR_ID %>'>
							<%- PAYOR_ID %>
						</option>
					</script>
					</select>
					<!-- the rest -->
					<input type=checkbox id='taxCheckbox' checked>Tax ID
					<input type=checkbox id='gnpiCheckbox'>Group NPI
					<input type=checkbox id='legacyCheckbox'>Legacy ID
				</td>
			</tr>
		</table>
		<h3></h3>
		<table id='mainTable' cellspacing='0'>
			<thead id='mainThead'>
			</thead>
			<tbody id='mainTbody'>
			</tbody>
		</table>
		<div id='dialogBox'></div>
		<div id='confirmBoxMain'></div>
		<div id='confirmBoxSub'></div>
		<div id='loadingModal'></div>
	</body>
</html>
