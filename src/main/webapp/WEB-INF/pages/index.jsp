<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<script src="<c:url value="/resources/core/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/test.js" />"></script>
<link href="<c:url value="/resources/core/main.css" />" rel="stylesheet">

</head>
<title>IMS</title>
<h1>Inventory Management System</h1>
<h2>Hello User</h2>

<body>
<form role="form">
<table style="width:50%">
	<tr>
	<td>
	Inventory ID:
	</td>
	<td>
	<input id="inventoryId">
	</td>
	</tr>
	<tr>
	<td>
	Inventory Name:
	</td>
	<td>
	<input id="name">
	</td>
	</tr>
	<tr>
	<td>
	Inventory Price:
	</td>
	<td>
	<input id="price">
	</td>
	</tr>
	<tr>
	<td>
	Hospital name: </td>
	<td>
	<input id="hospital">
	</td>
	</tr>
	<tr>
	<td>
	User Note:</td> <td>
	<input id="userNote">
	</td>
	</tr>
	<tr>
	<td>
	<button id="btnAdd">Add Inventory</button>
	</td>
	</tr>
<table>
</form>

<button type="button"
onclick="document.getElementById('demo').innerHTML = Date()">
Date and Time.</button>

<button id="btnClear"> Clear</button>

<p id="demo"></p>

</body>

</body>
</html>