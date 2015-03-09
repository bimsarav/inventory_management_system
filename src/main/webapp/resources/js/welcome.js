
$(document).ready(function() {
	$("body").off("click", "#btnShowInventorys").on("click", "#btnShowInventorys", viewInventory);
	$("body").off("click", "#btnMakeReservation").on("click", "#btnMakeReservation", viewMakeReservation);
});

function showInventories(){
	$.ajax({
		url : "/GradleSpringMVC/inventory/inv",
		type : 'POST',
		dataType : 'json',
		data : JSON.stringify(createSendData()),
		contentType : 'application/json',
		mimeType : 'application/json'
	}).done(function(response) {
		
	}).fail(function(error) {
		// parseToPageAlerts(error.responseText);
	}).always(function() {
		// hideLoading()
	});
}

function viewInventory() {
    window.location.replace("http://54.165.74.52:8080/GradleSpringMVC/inventory/welcome");
}

function viewMakeReservation() {
    window.location.replace("http://54.165.74.52:8080/GradleSpringMVC/reservation/makeReservation/welcome");
}

function Tenant() {
	this.tenantId = "";
}

function createSendData(){
	var tenant = new Tenant();
	tenant.tenantId = "SRI";
	return tenant;
}