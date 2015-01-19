
this.ready = function(){
	
	$("body").off("click", "#btnAdd").on("click", "#btnAdd", doAdd);
	
};

function createGrid(){

    var reqData = null;
    collectAddCriteria = function(){
        reqData = new InvnetoryAddParam();
        reqData.serviceCode = $("#service").val();
        reqData.packageCode = $("#package").val();
        reqData.flightNumber = $("#flightNumber").val();
        reqData.startDate = $("#startDate").val();
        reqData.endDate = $("#endDate").val();
        reqData.confirmed = $("#stateConfirmed").is(':checked');
        reqData.onHold = $("#stateOnHold").is(':checked');
        reqData.passengerFirstName = $("#paxFirstName").val();
        reqData.passengerLastName = $("#paxLastName").val();
        reqData.passengerPassportNumber = $("#paxPassportNumber").val();
        reqData.contactNumber = $("#contactMobileNumber").val();
        setSessionParam(getFrmDataCookieName(SEARCH_PARAM_COOKIE_SUFFIX), reqData);
    }


    var temGrid = $("#jqReservation").fooGrid({
        datatype: function(postdata) {
            $.ajax({
                beforeSend: hidePageAlerts(),
                url: "/GradleSpringMVC/inventory/add",
                type: 'POST',
                dataType: 'json',
                beforeSend:collectSearchCriteria(),
                data: JSON.stringify($.extend(reqData,postdata)),
                contentType: 'application/json',
                mimeType: 'application/json'
            })
                .done(function(data) {
                    temGrid.addJSONData(data);
                })
                .fail(function(error) {
                    parseToPageAlerts(error.responseText);
                })
                .always(function(){
                    //hideLoading()
                });
        },
        height: "auto",
        rowNum: 10,
        colNames:[ 'Inventoy ID', 'Name','Price', 'Hospital', 'User Note','Date', "View"],
        colModel:[
            {name:'inventoryId',index:'inventoryId', align:"left"},
            {name:'name',index:'name',  hideon:"phone"},
            {name:'price',index:'price', align:"center"},
            {name:'hospital',align:"center"},
            {name:'userNote',index:'userNote',  align:"center"}
        ],
        pager: "#jqReservationPager",
        viewrecords: true,
        hidegrid:false,
        autowidth: true,
        shrinkToFit: true
    });

}
