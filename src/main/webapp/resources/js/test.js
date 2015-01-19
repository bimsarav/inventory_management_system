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

function sendDataTest() {
	var addParam = createAddParam();
	$.ajax({
		url : "/GradleSpringMVC/inventory/add",
		type : 'GET',
		dataType : 'json',
		data : JSON.stringify($.extend(addParam)),
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