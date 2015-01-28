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
	<br>
	<br>
	<div>
		<table class="inputTable">
			<tr>
				<td><p>Inventory ID:</p></td>
				<td><input id="inventoryId"></td>

				<td><p>Inventory Name:</p></td>
				<td><input id="name"></td>
			</tr>
			<tr>
				<td><p>Inventory Price:</p></td>
				<td><input id="price"></td>

				<td><p>Hospital name:</p></td>
				<td><input id="hospital"></td>
			</tr>
			<tr>
				<td><p>User Note:</p></td>
				<td><input id="userNote"></td>
			</tr>
		</table>
		<br> <br>
		<table class="table1">
			<tr>
				<td><button class="normalButton" type="button" id="btnClear">Clear</button>
					<button class="normalButton" type="button" id="btnAdd">Add</button>
				</td>
				<td><button class="normalButton" type="button" id="btnBack">Back</button>
					<button class="normalButton" type="button" id="btnGoHome">Home</button></td>
			</tr>
		</table>
	</div>

	<p id="demo"></p>

	<script src="<c:url value="/resources/core/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/addViewEditInventory.js" />"></script>
	<link href="<c:url value="/resources/core/main.css" />"
		rel="stylesheet">
</body>
</html>