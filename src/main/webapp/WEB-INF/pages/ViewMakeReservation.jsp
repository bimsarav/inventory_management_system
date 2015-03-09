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

<div class="makeReservations">
	<table id="makeReservations">
	</table>
</div>

			<button class="normalButton" type="button" id="btnGoHome">Home</button>

<div class="enterInfo">
	<table id="enterInfo">
	</table>
</div>

	<script src="<c:url value="/resources/core/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/viewMakeReservation.js" />"></script>
	<link href="<c:url value="/resources/core/makeReservation.css" />"
		rel="stylesheet">
</body>
</html>