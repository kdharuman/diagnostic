<?php
include("../common/common.php");

if (isset($_REQUEST["user_id"])) { $user_id = $_REQUEST["user_id"]; } else { echo "user_id is required, exiting"; exit; }
if (isset($_REQUEST["curr_ym"])) { $curr_ym = $_REQUEST["curr_ym"];} else { $curr_ym=date("Ym");}
if (isset($_REQUEST["account_id"])) { $account_id = $_REQUEST["account_id"]; } else { $account_id=""; }
//if (isset($_REQUEST["payor_id"])) { $payor_id = $_REQUEST["payor_id"]; } else { $payor_id=""; }
if (isset($_REQUEST["tax_id"])) { $tax_id = $_REQUEST["tax_id"]; } else { $tax_id=""; }
if (isset($_REQUEST["group_npi"])) { $group_npi = $_REQUEST["group_npi"]; } else { $group_npi=""; }
if (isset($_REQUEST["legacy_id"])) { $legacy_id = $_REQUEST["legacy_id"]; } else { $legacy_id=""; }
if (isset($_REQUEST["deny"])) { $deny = $_REQUEST["deny"]; } else { $deny=""; }
if (isset($_REQUEST["command"])) { $command = $_REQUEST["command"]; } else { $command=""; }
$marge = connect_marge_e835v2();
$cowboy=connect_cowboy_primary();
$c1=oci_pexec($cowboy,"select ops_group from internal_users where user_id='$user_id'");
if (oci_fetch($c1)) { $ops_group = oci_result($c1,1);} else { echo "invalid user_id, $user_id"; exit; }
?>
<html><head>
<script>
function display_tax_id(value) {
	document.display_extra_info.tax_id.value=value;
	document.display_extra_info.submit();
}
function lookup(obj) {
	document.display_extra_info.key.value=obj;
	f=document.getElementById(obj);
	document.display_extra_info.clg_payor_id.value=f.clg_payor_id.value;
	document.display_extra_info.verify_account_id.value=f.account_id.value;
	if (f.tax_id) document.display_extra_info.tax_id.value=f.tax_id.value;
	if (f.group_npi) document.display_extra_info.group_npi.value=f.group_npi.value;
	if (f.legacy_id) document.display_extra_info.legacy_id.value=f.legacy_id.value;
	document.display_extra_info.submit();
}
function verifyform(obj) {
	if (obj.account_id.value.length != 10) {
		alert("account_id needs to be 10 long");
		return false;
/*	} else if (obj.group_npi && obj.group_npi.value.length != 10) {
		alert("group npi needs to be 10 long");
		return false;
	} else if (obj.tax_id && obj.tax_id.value.length != 9) {
		alert("tax id needs to be 9 long");
		return false;
	} else if (obj.legacy_id && obj.legacy_id.value.length == 0) {
		alert("legacy id can't be empty");
		return false;
	} else if (obj.group_npi && obj.group_npi.value.length == 10 && obj.tax_id && obj.tax_id.value.length == 9) {
		alert("group npi link can only be used when tax_id is blank");
		return false;*/
	} else {
		<?php if ($ops_group != "ops" && $ops_group != "all") { ?>
		val="";
		if (obj.tax_id) val += obj.tax_id.value + " ";
		if (obj.group_npi) val += obj.group_npi.value + " ";
		if (obj.legacy_id) val += obj.legacy_id.value + " ";
		return confirm ("are you sure you want to link " + val + "to " + obj.account_id.value + "?");
		<?php } ?>
		return true;
	}
}
</script>
</head>
<body>
<form name=display_extra_info action=display_extra_info.php target=right>
<input type=hidden name=clg_payor_id>
<input type=hidden name=tax_id>
<input type=hidden name=legacy_id>
<input type=hidden name=group_npi>
<input type=hidden name=key>
<input type=hidden name=callpage value=verify>
<input type=hidden name=verify_account_id>
<?php
echo "<input type=hidden name=curr_ym value=$curr_ym>";
echo "</form>";
echo "<table><tr><td>";
echo "<form name=new>";
echo "<input type=hidden name=user_id value=$user_id>";
echo "<select name=curr_ym onchange=submit()>";
$c1=oci_pexec($marge,"select unique substr(submit_date,1,6) ym from marge.e835_files_v2 order by ym desc");
while (oci_fetch($c1)) {
	$result=oci_result($c1,1);
	if ($result == $curr_ym) $selected = "selected"; else $selected="";
	echo "<option value='$result' $selected >$result";
}
echo "</select>";
echo "<input type=submit name=command value=display>";
echo "</form>";

echo "</td><td>";
echo "<form name=rematch action=exec_e835_func.php target=right>";
echo "<input type=hidden name=func value=fill_act_id_from_lookup>";
echo "<input type=hidden name=arg1 value=$curr_ym>";
echo "<input type=hidden name=arg2 value=all>";
echo "<input type=submit name=rematch value=rematch>";
echo "</td></tr></table>";
echo "</form>";

//display current account/payor combo
echo "<table border=1 rules=both>";
$c1=oci_pexec($cowboy,"select v.*,rowidtochar(rowid) rid from e835_act_lookup_v2 v where verified is null or verified = 'n'");
echo "<tr>";
for ($i = 1; $i < oci_num_fields($c1); $i++) {
	echo "<th>".strtolower(oci_field_name($c1,$i))."</th>";
}
echo "<th colspan=2>&nbsp;</th>";
echo "</tr>";
while (oci_fetch($c1)) {
	echo "<tr>";
	$rowid=oci_result($c1,oci_num_fields($c1));
	echo "<form name=$rowid id=$rowid onsubmit=\"return verifyform(this);\" action=save_account_link.php target=action>";
	for ($i = 1; $i < oci_num_fields($c1); $i++) {
		switch (oci_field_name($c1,$i)) {
			case "TAX_ID" :
			case "ACCOUNT_ID" :
			case "GROUP_NPI" :
			case "LEGACY_ID" :
				echo "<td><input readonly size=10 type=text name=".strtolower(oci_field_name($c1,$i))." value='".oci_result($c1,$i)."' ></td>";
				break;
			case "PAYOR_ID" :
				echo "<td><input readonly size=10 type=text name=clg_payor_id value='".oci_result($c1,$i)."' ></td>";
				break;
			case "DENY" :
				echo "<td><input readonly size=1 type=text name=".strtolower(oci_field_name($c1,$i))." value='".oci_result($c1,$i)."' ></td>";
				break;
			case "LINK_TSTAMP" :
				echo "<td>".date("Y/m/d H:i",oci_result($c1,$i))."</td>";
				break;
			case "LINK_ID" :
				$link_id=oci_result($c1,$i);
				echo "<td>".oci_result($c1,$i)."</td>";
				break;
			default :
				echo "<td>".oci_result($c1,$i)."</td>";
				break;
		}
	}
	echo "<input type=hidden name=user_id value='$user_id'>";
	echo "<input type=hidden name=ym value='$curr_ym'>";
	echo "<input type=hidden name=rowid value='$rowid'>";
	echo "<td><input type=button name=lookup_button value=lookup onclick=\"lookup('$rowid')\"></td>";
	if ($link_id == $user_id) echo "<td>&nbsp;</td>";
	else echo "<td><input type=submit name=command value=verify></td>";
	echo "</form>";
	echo "</tr>";
}
echo "</table>";
?>

</body>
</html>
