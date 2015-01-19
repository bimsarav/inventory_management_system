
function UI_RESERVATION(){
    var flNumber = [], services = [], packages = [],servicePkg = null, searchParam = {};
    var SEARCH_PARAM_COOKIE_SUFFIX = "searchparam";
    var DATE_FORMAT = 'DD-MM-YYYY HH:mm';
    this.ready = function(){
        $('#startDate, #endDate')
            .datetimepicker({
                collapse: false,
                sideBySide: false,
                pick12HourFormat: false,
                language: 'en',
                format: DATE_FORMAT});
        $("#flightNumber,#service,#package").selectpicker();
        $('body').off('change',"#service").on('change',"#service", function(){
            var serviceCode = $("#service").val();
            onServiceChange(serviceCode)
        });
        loadFLightList();
        //jqGrid responsive

        $("body").off("click", "#btnClose").on("click", "#btnClose", goBack);
        $("body").off("click", "#btnSearch").on("click", "#btnSearch", doSearch);
        $("body").off("click", "#btnReset").on("click", "#btnReset", doResetForm);
        $("body").off("focusout","#startDate").on("focusout","#startDate",setDefaultEndDate);
    };

    function setDefaultEndDate(){
        var stDate = moment($("#startDate").val(),DATE_FORMAT,true);
        stDate.hours(23).minutes(59);
        if(stDate.isValid){
            $("#endDate").datetimepicker().data().DateTimePicker.setValue(stDate);
        }
    }

    function doResetForm(){
        setSessionParam(getFrmDataCookieName(SEARCH_PARAM_COOKIE_SUFFIX),null);
        setSearchParams();
    }

    function setSearchParams(){
        var sesParams = getSessionParam(getFrmDataCookieName(SEARCH_PARAM_COOKIE_SUFFIX));
        if (sesParams==null){
            sesParams = new ReservationSearchParam();
        }
        $("#service").val(sesParams.serviceCode).selectpicker('refresh');
        $("#package").val(sesParams.packageCode).selectpicker('refresh');
        $("#flightNumber").val(sesParams.flightNumber).selectpicker('refresh');

        var d = new Date();
        var month = d.getMonth();
        var day = d.getDate();
        var year = d.getFullYear();
        var output = (day<10 ? '0' : '') + day + '-' +
            (month<10 ? '0' : '') + month + '-' + d.getFullYear();


        if (sesParams.startDate==""){
            $('#startDate').val(output + " 00:00");
        }else{
            $("#startDate").val(sesParams.startDate);
        }
        if (sesParams.endDate==""){
            $('#endDate').val(output + " 23:59");
        }else{
            $("#endDate").val(sesParams.endDate);
        }
        if (sesParams.confirmed==""){
            $("#stateConfirmed").prop('checked', true);
        }else{
            $("#stateConfirmed").prop('checked', sesParams.confirmed);
        }
        $("#stateOnHold").prop('checked', sesParams.onHold);
        $("#paxFirstName").val(sesParams.passengerFirstName);
        $("#paxLastName").val(sesParams.passengerLastName);
        $("#paxPassportNumber").val(sesParams.passengerPassportNumber);
        $("#contactMobileNumber").val(sesParams.contactNumber);
    }

    function doSearch(){
        $("#jqReservation").trigger("reloadGrid");
    }

    function goBack(){
        window.location.hash = "#";
    }

    function onServiceChange(serviceCode){
        var indPackages = (serviceCode=="")?objectCollectToArray(servicePkg):servicePkg[serviceCode];
        $("#package").empty().fillDropDown({dataArray:indPackages, keyIndex:'packageCode', valueIndex:'packageTitle', firstEmpty:true});
        $("#package").selectpicker('refresh');
    }

    function objectCollectToArray(obj){
        var temp =[]
        for (key in obj){
            if  (obj.hasOwnProperty(key)){
                for (var i=0;i<obj[key].length;i++){
                    temp[temp.length] = obj[key][i];
                }
            }
        }
        return temp;
    }

    function loadFLightList(){
        hidePageAlerts();
        if (flNumber.length==0){
            var tenantParam = new TenantParam();
            $.ajax({
                //beforeSend: showLoading(),
                url: "controller/reservation/backoffice/searchparams/all",
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(tenantParam),
                contentType: 'application/json',
                mimeType: 'application/json'
            })
                .done(function(data) {
                    flNumber = data.flightNumbers;
                    services = data.airportServiceGrouping.availableServices;
                    servicePkg = data.airportServiceGrouping.serviceContainedPackages
                    packages = objectCollectToArray(servicePkg);
                    $("#flightNumber").fillDropDown({dataArray:flNumber, keyIndex:0, valueIndex:0, firstEmpty:true, oneArray:true});
                    $("#flightNumber").selectpicker('refresh');
                    $("#service").fillDropDown({dataArray:services, keyIndex:"serviceCode", valueIndex:"serviceName", firstEmpty:true});
                    $("#service").selectpicker('refresh');
                    $("#package").fillDropDown({dataArray:packages, keyIndex:'packageCode', valueIndex:'packageTitle', firstEmpty:true});
                    $("#package").selectpicker('refresh');
                    $("#lPage").fadeIn();
                    setSearchParams();
                    createGrid();
                })
                .fail(function(error) {
                    parseToPageAlerts(error.responseText);
                })
                .always(function(){

                });
        }else{
            $("#flightNumber").fillDropDown({dataArray:flNumber, keyIndex:0, valueIndex:0, firstEmpty:true, oneArray:true});
            $("#flightNumber").selectpicker('refresh');
            $("#service").fillDropDown({dataArray:services, keyIndex:"serviceCode", valueIndex:"serviceName", firstEmpty:true});
            $("#service").selectpicker('refresh');
            $("#package").fillDropDown({dataArray:packages, keyIndex:'packageCode', valueIndex:'packageTitle', firstEmpty:true});
            $("#package").selectpicker('refresh');
        }
    }

    function createGrid(){
        //custom formatter for view reservation
        var viewRec = function(cellVal, options, rowObject){
            var cls = (rowObject.notes.length > 0)? "resWithNotesIcon"  : "";
            return "<a href='#viewReservationDetails&d="+rowObject.consumptionDate+"&ref="+rowObject.referenceNumber+"'><span class='glyphicons eye_open "+cls+"'></span></a>";
        };

        var formatFlightNo = function(cellVal, options, rowObject){
            return "<span style='text-transform: uppercase'>"+rowObject.flightNumber+"</span>";
        };


        var reqData = null;
        collectSearchCriteria = function(){
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
                    url: "controller/reservation/backoffice/search",
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
                {name:'userNote',index:'userNote',  align:"center"},
                {name:'date',index:'date',  align:"center"},
                {name:'view', align:"center", width:60, formatter:viewRec}
            ],
            pager: "#jqReservationPager",
            viewrecords: true,
            hidegrid:false,
            autowidth: true,
            shrinkToFit: true
        });

    }
}
var ui_reservation = new UI_RESERVATION();
ui_reservation.ready();

