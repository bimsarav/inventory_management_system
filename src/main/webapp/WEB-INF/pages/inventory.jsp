<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

</head>
<title>IMS</title>
<h1>Inventory Management System</h1>
<h2>Hello User</h2>
<hr></hr>
<body>
	<form role="form">
		<table class="inputTable">
			<tr>
				<td><p>Inventory ID:</p></td>
				<td><input id="inventoryId"></td>

				<td><p>Inventory Name:</p></td>
				<td><input id="inventoryName"></td>
			</tr>
			<tr>
				<td><p>Unit Price:</p></td>
				<td><input id="pricePerUnit"></td>
			
				<td><p>Location :</p></td>
				<td><input id="location"></td>
			</tr>
			<tr>
			</tr>
		</table>
		<table>
			<tr>
				<td>
					<button class="normalButton" type="button" id="btnClear">Clear</button>
				</td>
				<td>
					<button class="normalButton" type="button" id="btnSearch">Search</button>
				</td>
				<td>
					<button class="normalButton" type="button" id="btnViewAll">View All</button>
				</td>
			</tr>
		</table>
	</form>

	<div class="inventoryTable">
		<table id="inventoryTable">
		</table>
	</div>
	<br>
	<table class="table">
	<tr>
		<td>
			<button class="normalButton" type="button" id="btnGoHome">Home</button>
		</td>
		<td>
			<button class="normalButton" type="button" id="btnViewAddInventory">Add Inventory</button>
		</td>
	<tr>
	</table>
	<p id="demo"></p>

	<script src="<c:url value="/resources/core/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/inventory.js" />"></script>
	<link href="<c:url value="/resources/core/main.css" />"
		rel="stylesheet">

</body>
</html>