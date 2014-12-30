<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>

<h1>Inventory Management System</h1>
<h2>Hello User</h2>

<body>

<form action="inventory/add">

	<br>
	Inventory ID:
	<input type="text" name="inventoryId">
	<br>
	Inventory Name:
	<input type="text" name="Name">
	<br>
	Inventory Price:
	<input type="text" name="Price">
	<br>
	Hospital name:
	<input type="text" name="hospital">
	<br>
	Location:
	<input type="text" name="userNote">
	<br>
	
	<input type="submit" value="Submit">

</form>

</body>

</body>
</html>