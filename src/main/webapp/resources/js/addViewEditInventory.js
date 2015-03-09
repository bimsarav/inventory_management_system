$(document).ready(function() {
	$("body").off("click", "#btnAdd").on("click", "#btnAdd", doAdd);
	$("body").off("click", "#btnClear").on("click", "#btnClear", doClearAll);
	$("body").off("click", "#btnGoHome").on("click", "#btnGoHome", goHome);
	$("body").off("click", "#btnBack").on("click", "#btnBack", goBack);
});

	$("#inventoryId").click(function() {
		$("#inventoryId").css('color', 'black');
		if ($("#inventoryId").val() == "Inventory Id can not be empty") {
			$("#inventoryId").val("");
		}
	});

	$("#name").click(function() {
		$("#name").css('color', 'black');
		if ($("#name").val() == "Inventory Name can not be empty") {
			$("#name").val("");
		}
	});
	
	$("#pricePerUnit").click(function() {
		$("#pricePerUnit").css('color', 'black');
		if ($("#pricePerUnit").val() == "Please Enter valied price") {
			$("#pricePerUnit").val("");
		}
	});
	
	$("#availableAmount").click(function() {
		$("#availableAmount").css('color', 'black');
		if ($("#availableAmount").val() == "Please Enter valied Amount") {
			$("#availableAmount").val("");
		}
	});

function goHome() {
	window.location.replace("http://54.165.74.52:8080/GradleSpringMVC");
}

function goBack() {
	window.location.replace("http://54.165.74.52:8080/GradleSpringMVC/inventory/welcome");
}

function InventoryAddParam() {
	this.inventoryId = "";
	this.name = "";
	this.availableAmount = "";
	this.pricePerUnit = "";
	this.location = "";
	this.description = "";
}

function populateObject() {
	var addParam = new InventoryAddParam();
	addParam.inventoryId = $("#inventoryId").val();
	addParam.name = $("#name").val();
	addParam.availableAmount = $("#availableAmount").val();;
	addParam.pricePerUnit = $("#pricePerUnit").val();
	addParam.location = $("#location").val();
	addParam.description = $("#description").val();
	return addParam;
}

function validateAdd(data){
	
	if(data.inventoryId == null || data.inventoryId =="" || data.inventoryId.length==0 || data.inventoryId=="Inventory Id can not be empty"){
		$("#inventoryId").val("Inventory Id can not be empty");
		$("#inventoryId").css('color', 'red');
		return false;
	}
	
	if(data.name == null || data.name =="" || data.name.length==0 || data.name=="Inventory Name can not be empty"){
		$("#name").val("Inventory Name can not be empty");
		$("#name").css('color', 'red');
		return false;
	}
	
	if(!($.isNumeric(data.availableAmount))){
		$("#availableAmount").val("Please Enter valied Amount");
		$("#availableAmount").css('color', 'red');
		return false;
	}
	
	if (!($.isNumeric(data.pricePerUnit))){
		$("#pricePerUnit").val("Please Enter valied price");
		$("#pricePerUnit").css('color', 'red');
		return false;
	}
	return true;
}

function doAdd() {
	var addParam = populateObject();
	if(validateAdd(addParam) == true)
	{
		$.ajax({
			url : "/GradleSpringMVC/inventory/add",
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(addParam),
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
}

function doClearAll() {
	$("#inventoryId").val("");
	$("#name").val("");
	$("#availableAmount").val("");
	$("#pricePerUnit").val("");
	$("#location").val("");
	$("#description").val("");
}