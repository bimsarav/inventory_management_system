$(document).ready(function() {

	$('form').submit(function(e){
    		e.preventDefault();
	});
	
	$("body").off("click", "#btnAdd").on("click", "#btnAdd", doAdd);
	$("body").off("click", "#btnClear").on("click", "#btnClear", doClearAll);
	$("body").off("click", "#btnSearch").on("click", "#btnSearch", doSearch);
	$("body").off("click", "#btnDelete").on("click", "#btnDelete", deleteRow);
	$("body").off("click", "#btnViewAll").on("click", "#btnViewAll", viewAllInventory);
	$("body").off("click", "#btnGoHome").on("click", "#btnGoHome", goHome);
});

function goHome(){
	window.location.replace("http://localhost:8080/GradleSpringMVC");
}

function createInventoryTable(data){
	$('#inventoryTable').empty();
	var trHTML = '<tr><td><b>Inventory ID</b></td><td><b>Inventory Name</b></td><td><b>Inventory Price</b></td>'
		+'<td><b>Hospital name</b></td><td><b>User Note</b></td><td><b>Created Date</b></td></tr>';
	$.each(data, function(i, item) {
		trHTML += '<tr><td>' + item.inventoryId + '</td><td>'
				+ item.name + '</td><td>' + item.price
				+ '</td><td>' + item.hospital + '</td><td>'
				+ item.userNote + '</td><td>' + item.createdDate
				+ '</td><td> <button id="btnDelete" data='+ item.inventoryId+' value='+item.inventoryId+'> Delete </button></td></tr>';
	});
	$('#inventoryTable').append(trHTML);
}

function deleteRow(data){
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
	viewAllInventory();
}

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
	}).done(function(response) {
				createInventoryTable(response);
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
		createInventoryTable(response);
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
		// temGrid.addJSONData(data);
	}).fail(function(error) {
		// parseToPageAlerts(error.responseText);
	}).always(function() {
		// hideLoading()
	});
	viewAllInventory();
}

function doClearAll() {
	$("#inventoryId").val("");
	$("#name").val("");
	$("#price").val("");
	$("#hospital").val("");
	$("#userNote").val("");
}