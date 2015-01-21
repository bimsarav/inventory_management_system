$(document).ready(function() {
	$("body").off("click", "#btnAdd").on("click", "#btnAdd", doAdd);
	// $("#btnClear").click(doClearAll);
	$("body").off("click", "#btnClear").on("click", "#btnClear", doClearAll);
});

function InventoryAddParam(){
		this.inventoryId = "";
		this.name = "";
		this.price = "";
		this.hospital = "";
		this.userNote = "";
}

function populateObject(){
	var addParam = new InventoryAddParam();
	addParam.inventoryId = $("#inventoryId").val();
	addParam.name = $("#name").val();
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