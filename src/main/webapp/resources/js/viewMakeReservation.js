$(document).ready(
		function() {
			viewAllInventory();
			$("body").off("click", "#btnClear").on("click", "#btnClear",doClearAll);
			$("body").off("click", "#btnSearch").on("click", "#btnSearch",doSearch);
			$("body").off("click", "#btnViewAll").on("click", "#btnViewAll",viewAllInventory);
			$("body").off("click", "#btnGoHome").on("click", "#btnGoHome",goHome);
			$("body").off("click", "#btnReserve").on("click", "#btnReserve",viewBuyInventory);
		});

function goHome() {
	window.location.replace("http://54.165.74.52:8080/GradleSpringMVC");
}

function Inventory(){
	this.inventoryId="";
	this.name="";
	this.availableAmount="";
	this.soldAmount="";
	this.restAmount="";
	this.pricePerUnit="";
	this.location="";
	this.description="";
	this.createdDate="";
}

function getInventoryData(inventoryId){
	var inventory = new Inventory();
	$.ajax({
		url : "/GradleSpringMVC/reservation/makeReservation/load",
		type : 'POST',
		dataType : 'json',
		data : inventoryId,
		contentType : 'application/json',
		mimeType : 'application/json'
	}).done(function(data) {
		inventory = data;
		// temGrid.addJSONData(data);
	}).fail(function(error) {
		// parseToPageAlerts(error.responseText);
	}).always(function() {
		// hideLoading()
	});
	return inventory;
}

function createMakeReservationToBuy(data){
	var inventoryId = data.toElement.attributes.data.value;
	var Inventory = getInventoryData(inventoryId);
	$('#enterInfo').empty();
	if (data != null) {
		var trHTML = '<tr><td><b>Inventory ID</b></td><td><b>Inventory Name</b></td><td><b>Required Amount</b></td><td><b>Total Price</b></td>'
				+ '<td><b>Full Name</b></td><td><b>Contact Number</b></td><td><b>Continue</b></td></tr>';
		trHTML += '<tr><td>'
				+ Inventory.inventoryId
				+ '</td><td>'
				+ Inventory.name
				+ '</td><td> <input id="requiredAmount"></td><td>'
				+ Inventory.pricePerUnit
				* ("#requiredAmount").val
				+ '</td><td><input id="fullName"></td><td>'
				+ '</td><td><input id="contactNumber"></td><td> <button class="continuePurchasing" type="button" id="continuePurchasing" data='
				+ Inventory.inventoryId + 'value=' + Inventory.inventoryId + '> Delete </button></td></tr>';
		$('#enterInfo').append(trHTML);
	} else {
		alert("No Data Found");
	}
}

function viewBuyInventory(data){
	createMakeReservationToBuy(data);
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

function viewAllInventoty(){
	$.ajax({
		url : "/GradleSpringMVC/inventory/viewAll",
		type : 'POST',
		dataType : 'json',
		data : JSON.stringify(viewAllParam()),
		contentType : 'application/json',
		mimeType : 'application/json'
	}).done(function(response) {
		if (response != null && response != "") {
			viewInventoryTable(response);
		} else {
			alert("Search Result Not Found");
		}
	}).fail(function(error) {
		// parseToPageAlerts(error.responseText);
	}).always(function() {
		// hideLoading()
	});
}

function viewInventoryTable(data) {
	$('#makeReservations').empty();
	if (data != null) {
		var trHTML = '<tr><td><b>Inventory ID</b></td><td><b>Inventory Name</b></td><td><b>Available Amount</b></td><td><b>Sold Amount</b></td><td><b>Inventory Unit Price</b></td>'
				+ '<td><b>Location</b></td><td><b>Description</b></td><td><b>Reserve</b></td></tr>';
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
									+ item.pricePerUnit
									+ '</td><td>'
									+ item.location
									+ '</td><td>'
									+ item.description
									+ '</td><td> <button type="button" id="btnReserve" data='
									+ item.inventoryId
									+ ' 					value='
									+ item.inventoryId
									+ '> Buy </button></td></tr>';
						});
		$('#makeReservations').append(trHTML);
	} else {
		alert("No Data Found");
	}
}

function viewAllParam(){
	var tenant = Tenant();
	tenant.tenantId = "SRI";
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
		viewInventoryTable(response);
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
	$("#name").val("");
	$("#price").val("");
	$("#hospital").val("");
	$("#userNote").val("");
}
