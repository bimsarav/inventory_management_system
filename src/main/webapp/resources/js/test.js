$(document).ready(function() {
	$("#btnAdd").click(sendDataTest());
	$("#btnClear").click(doClearAll);

});

function createAddParam() {
	var inventoryAddParam = {
		"inventoryId" : "ABC123",
		"name" : "ECG Machine",
		"price" : "100",
		"hospital" : "Kandy",
		"userNote" : "User Note"
	};
	return inventoryAddParam;
}

function InventoryAddParam(){
		this.inventoryId = "";
		this.name = "";
		this.price = "";
		this.hospital = "";
		this.userNote = "";
}

function doAdd(addParam) {
	$.ajax({
		type : "GET",
		url : "/GradleSpringMVC/inventory/add",
		data : addParam,
		success : function(response) {
			alert('Succes msg: ' + response);
		},
		error : function(e) {
			alert('Error msg: ' + e);
		}
	});
}

function populateTestObject(){
	
	var addParam = new InventoryAddParam();
	addParam.inventoryId = "INV001";
	addParam.name = "ECG MACHINE";
	addParam.price = "1000";
	addParam.hospital = "Colombo";
	addParam.userNote = "User Note";
	
	
	return addParam;
}

function sendDataTest() {
	
	$.ajax({
		url : "/GradleSpringMVC/inventory/add",
		type : 'GET',
		dataType : 'json',
		data : JSON.stringify(populateTestObject()),
		contentType : 'application/json',
		mimeType : 'application/json'
	}).done(function(data) {
		// temGrid.addJSONData(data);
	}).fail(function(error) {
		// parseToPageAlerts(error.responseText);
	}).always(function() {
		// hideLoading()
	});
}

function doClearAll() {
	$("#inventoryId").val("Done");
	$("#name").val("ERP");
}