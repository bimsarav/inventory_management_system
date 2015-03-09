$(document).ready(
		function() {
			$("body").off("click", "#btnViewAddInventory").on("click","#btnViewAddInventory", viewAddInventory);
			$("body").off("click", "#btnClear").on("click", "#btnClear",doClearAll);
			$("body").off("click", "#btnSearch").on("click", "#btnSearch",doSearch);
			$("body").off("click", "#btnDelete").on("click", "#btnDelete",deleteRow);
			$("body").off("click", "#btnViewAll").on("click", "#btnViewAll",viewAllInventory);
			$("body").off("click", "#btnGoHome").on("click", "#btnGoHome",goHome);
		});

function goHome() {
	window.location.replace("http://54.165.74.52:8080/GradleSpringMVC");
}

function viewAddInventory() {
	window.location.replace("http://54.165.74.52:8080/GradleSpringMVC/inventory/add_edit_view");
}

function createInventoryTable(data) {
	$('#inventoryTable').empty();
	if (data != null) {
		var trHTML = '<tr><td><b>Inventory ID</b></td><td><b>Inventory Name</b></td><td><b>Available Amount</b></td><td><b>Sold Amount</b></td><td><b>Rest Amount Amount</b></td><td><b>Inventory Unit Price</b></td>'
				+ '<td><b>Location</b></td><td><b>Description</b></td><td><b>Created Date</b></td><td><b>Delete</b></td><td><b>Edit</b></td></tr>';
		$
				.each(
						data,
						function(i, item) {
							trHTML += '<tr><td>'
									+ item.inventoryId
									+ '</td><td>'
									+ item.name
									+ '</td><td>'
									+ item.availableAmount
									+ '</td><td>'
									+ item.soldAmount
									+ '</td><td>'
									+ item.restAmount
									+ '</td><td>'
									+ item.pricePerUnit
									+ '</td><td>'
									+ item.location
									+ '</td><td>'
									+ item.description
									+ '</td><td>'
									+ item.createdDate
									+ '</td><td> <button class="deleteButton" id="btnDelete" data='
									+ item.inventoryId
									+ ' 					value='
									+ item.inventoryId
									+ '> Delete </button></td><td> <button class="deleteButton" id="btnEdit" data='
									+ item.inventoryId + ' value='
									+ item.inventoryId
									+ '> Edit </button></td></tr>';
						});
		$('#inventoryTable').append(trHTML);
	} else {
		alert("No Data Found");
	}
}

function deleteRow(data) {
	var inventoryId = data.toElement.attributes.data.value;
	$.ajax({
		url : "/GradleSpringMVC/inventory/delete",
		type : 'POST',
		dataType : 'json',
		data : inventoryId,
		contentType : 'application/json',
		mimeType : 'application/json'
	}).done(function(data) {
		viewAllInventory();
		// temGrid.addJSONData(data);
	}).fail(function(error) {
		// parseToPageAlerts(error.responseText);
	}).always(function() {
		// hideLoading()
	});
}

function Tenant() {
	this.tenantId = "";
}

function InventorySearchCriteria() {
	this.inventoryId = "";
	this.inventoryName = "";
	this.location = "";
	this.pricePerUnit = "";
	this.createdDate = "";
}

function collectSearchParam() {
	var searchParam = new InventorySearchCriteria();
	searchParam.inventoryId = $("#inventoryId").val();
	searchParam.inventoryName = $("#inventoryName").val();
	searchParam.location = $("#location").val();
	searchParam.pricePerUnit = $("#pricePerUnit").val();
	searchParam.createdDate = "";
	return searchParam;
}

function populateViewAllParam() {
	var viewAll = new Tenant();
	viewAll.tenantId = "SRI";
	return viewAll;
}

function viewAllInventory() {
	$.ajax({
		url : "/GradleSpringMVC/inventory/viewAll",
		type : 'POST',
		dataType : 'json',
		data : JSON.stringify(populateViewAllParam()),
		contentType : 'application/json',
		mimeType : 'application/json'
	}).done(function(response) {
		createInventoryTable(response);
	}).fail(function(error) {
		// parseToPageAlerts(error.responseText);
	}).always(function() {
		// hideLoading()
	});
}

function doSearch() {

	$.ajax({
		url : "/GradleSpringMVC/inventory/search",
		type : 'POST',
		dataType : 'json',
		data : JSON.stringify(collectSearchParam()),
		contentType : 'application/json',
		mimeType : 'application/json'
	}).done(function(response) {
		if (response != null && response != "") {
			createInventoryTable(response);
		} else {
			alert("Search Result Not Found");
		}
	}).fail(function(error) {
		// parseToPageAlerts(error.responseText);
	}).always(function() {
		// hideLoading()
	});
}

function doClearAll() {
	$("#inventoryId").val("");
	$("#inventoryName").val("");
	$("#location").val("");
	$("#pricePerUnit").val("");
}
