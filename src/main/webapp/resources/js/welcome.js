
$(document).ready(function() {
	$("body").off("click", "#btnShowInventorys").on("click", "#btnShowInventorys", showInventories);
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

function Tenant() {
	this.tenantId = "";
}

function createSendData(){
	var tenant = new Tenant();
	tenant.tenantId = "SRI";
	return tenant;
}









