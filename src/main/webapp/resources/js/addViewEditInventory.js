$(document).ready(function() {
	$("body").off("click", "#btnAdd").on("click", "#btnAdd", doAdd);
	$("body").off("click", "#btnClear").on("click", "#btnClear", doClearAll);
	$("body").off("click", "#btnGoHome").on("click", "#btnGoHome", goHome);
	$("body").off("click", "#btnBack").on("click", "#btnBack", goBack);
});

function goHome() {
	window.location.replace("http://localhost:8080/GradleSpringMVC");
}

function goBack(){
	window.location.replace("http://localhost:8080/GradleSpringMVC/inventory/welcome");
}

function InventoryAddParam() {
	this.inventoryId = "";
	this.name = "";
	this.amount = "";
	this.price = "";
	this.hospital = "";
	this.userNote = "";
}

function populateObject() {
	var addParam = new InventoryAddParam();
	addParam.inventoryId = $("#inventoryId").val();
	addParam.name = $("#name").val();
	addParam.amount = 1;
	addParam.price = $("#price").val();
	addParam.hospital = $("#hospital").val();
	addParam.userNote = $("#userNote").val();
	return addParam;
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
		alert(data);
		// temGrid.addJSONData(data);
	}).fail(function(error) {
		alert(error);
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