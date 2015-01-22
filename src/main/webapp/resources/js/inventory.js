$(document).ready(function() {
	$("body").off("click", "#btnAdd").on("click", "#btnAdd", doAdd);
	// $("#btnClear").click(doClearAll);
	$("body").off("click", "#btnClear").on("click", "#btnClear", doClearAll);
	$("body").off("click", "#btnSearch").on("click", "#btnSearch", doSearch);
	viewAllInventory();
});

function InventoryAddParam() {
	this.inventoryId = "";
	this.name = "";
	this.price = "";
	this.hospital = "";
	this.userNote = "";
}

function Tenant() {
	this.tenantId = "";
}

function InventorySearchCriteria(){
	this.inventoryId="";
	this.inventoryName="";
	this.hospital="";
	this.price="";
	this.createdDate="";
}

function collectSearchParam(){
	var searchParam = new InventorySearchCriteria();
	searchParam.inventoryId = $("#inventoryId").val();
	searchParam.inventoryName = $("#name").val();
	searchParam.hospital = $("#hospital").val();
	searchParam.price = $("#price").val();
	searchParam.createdDate = "";
	return searchParam;
}

function populateViewAllParam() {
	var viewAll = new Tenant();
	viewAll.tenantId = "SRI";
	return viewAll;
}

function populateObject() {
	var addParam = new InventoryAddParam();
	addParam.inventoryId = $("#inventoryId").val();
	addParam.name = $("#name").val();
	addParam.price = $("#price").val();
	addParam.hospital = $("#hospital").val();
	addParam.userNote = $("#userNote").val();
	return addParam;
}

function viewAllInventory() {
	$.ajax({
		url : "/GradleSpringMVC/inventory/viewAll",
		type : 'POST',
		dataType : 'json',
		data : JSON.stringify(populateViewAllParam()),
		contentType : 'application/json',
		mimeType : 'application/json'
	}).done(
			function(response) {
				var trHTML = '';
				$.each(response, function(i, item) {
					trHTML += '<tr><td>' + item.inventoryId + '</td><td>'
							+ item.name + '</td><td>' + item.price
							+ '</td><td>' + item.hospital + '</td><td>'
							+ item.userNote + '</td><td>' + item.createdDate
							+ '</td></tr>';
				});
				$('#inventoryTable').append(trHTML);
			}).fail(function(error) {
		// parseToPageAlerts(error.responseText);
	}).always(function() {
		// hideLoading()
	});
}

function doSearch(){
	
	$.ajax({
		url : "/GradleSpringMVC/inventory/search",
		type : 'POST',
		dataType : 'json',
		data : JSON.stringify(collectSearchParam()),
		contentType : 'application/json',
		mimeType : 'application/json'
	}).done(function(response) {
		var trHTML = '';
		$.each(response, function(i, item) {
			trHTML += '<tr><td>' + item.inventoryId + '</td><td>'
					+ item.name + '</td><td>' + item.price
					+ '</td><td>' + item.hospital + '</td><td>'
					+ item.userNote + '</td><td>' + item.createdDate
					+ '</td></tr>';
		});
		$('#inventoryTable').append(trHTML);
	}).fail(function(error) {
		// parseToPageAlerts(error.responseText);
	}).always(function() {
		// hideLoading()
	});
}

function doAdd() {
	$.ajax({
		url : "/GradleSpringMVC/inventory/add",
		type : 'POST',
		dataType : 'json',
		data : JSON.stringify(populateObject()),
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

function doClearAll() {
	$("#inventoryId").val("");
	$("#name").val("");
	$("#price").val("");
	$("#hospital").val("");
	$("#userNote").val("");
}