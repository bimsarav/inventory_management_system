
function.ready{
	$("body").off("click", "#btnAdd").on("click", "#btnAdd", doAdd);
}

var doAdd(){
	var addParam = createAddParam();
	sendData(addParam);
}

var createAddParam(){
	
	{"inventoryAddParam":[
	                      {"inventoryId":"John", "name":"Doe"},
	                      {"price":100, "hospital":"Smith"},
	                      {"userNote":"Peter"}
	                  ]}
	
}

var sendData(postdata) {
    $.ajax({
        url: "/GradleSpringMVC/inventory/add",
        type: 'GET',
        dataType: 'json',
        data: JSON.stringify($.extend(reqData,postdata)),
        contentType: 'application/json',
        mimeType: 'application/json'
    })
        .done(function(data) {
          //  temGrid.addJSONData(data);
        })
        .fail(function(error) {
         //   parseToPageAlerts(error.responseText);
        })
        .always(function(){
            //hideLoading()
        });
}
