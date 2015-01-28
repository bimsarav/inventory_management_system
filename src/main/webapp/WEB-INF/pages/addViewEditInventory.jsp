<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<title>IMS</title>
<h1>Inventory Management System</h1>
<h2>Hello User</h2>
<hr></hr>
<body>
	<div>
		<table style="width: 50%">
			<tr>
				<td>Inventory ID:</td>
				<td><input id="inventoryId"></td>

				<td>Inventory Name:</td>
				<td><input id="name"></td>

				<td>Inventory Price:</td>
				<td><input id="price"></td>
			</tr>
			<tr>
				<td>Hospital name:</td>
				<td><input id="hospital"></td>

				<td>User Note:</td>
				<td><input id="userNote"></td>
			</tr>
			<tr>
				<td><button id="btnAdd">Add</button></td><td><button id="goHome">Home</button></td>
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