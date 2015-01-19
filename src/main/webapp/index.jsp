<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<script src="<c:url value="/resources/core/jquery.min.js" />"></script>
<link href="<c:url value="/resources/core/main.css" />" rel="stylesheet">

</head>
<title>IMS</title>
<h1>Inventory Management System</h1>
<h2>Hello User</h2>

<body>

<form role="form" action="/GradleSpringMVC/inventory/welcome" method="GET">
	<input type="submit" name="inventory" value="Add Inventory">
</form>

<button type="button"
onclick="document.getElementById('demo').innerHTML = Date()">
Date and Time.</button>

<p id="demo"></p>

</body>

</body>
</html>