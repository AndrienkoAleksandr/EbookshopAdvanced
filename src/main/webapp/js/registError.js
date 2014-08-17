/**
 * Created by USER on 14.08.2014.
 */
//function registrationError() {
//    url = document.URL;
//    myvar = GetURLParameter('error', url);
//    if (myvar != null && myvar != "") {
//        document.getElementById('error').innerHTML = myvar;
//    }
//}
//function GetURLParameter(sParam, url) {
//    var begin = url.indexOf('?');
//    var sPageURL = url.substring(begin + 1, url.length);
//    var sURLVariables = sPageURL.split('&');
//    for (var i = 0; i < sURLVariables.length; i++) {
//        var sParameterName = sURLVariables[i].split('=');
//        if (sParameterName[0] == sParam) {
//            return sParameterName[1];
//        }
//    }
//}
//
//urlParam = function(name){
//    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
//    if (results==null){
//        return null;
//    }
//    else{
//        return results[1] || 0;
//    }
//}

function sendData() {
    var user = new Object();
    user.id = null;
    user.name = $("#user").val();
    user.email = $("#email").val();
    user.phone = $("#phone").val();
    user.permission = null;
    user.password = $("#password").val();

    $.ajax({
        url: "regist",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(user),
        contentType: 'application/json',
        mimeType: 'application/json',

        success: function (data) {
            if (data.message == 'success!') {
                console.log('success' + data + 'ffff'+data.message);
            }
            document.getElementById('error').innerHTML = data.message;
        },
        error: function (data, status, er) {
            alert("error: ");
        }
    });
}

//// example.com?param1=name&amp;param2=&amp;id=6
//$.urlParam('param1'); // name
//$.urlParam('id');        // 6
//$.urlParam('param2');   // null
//
////example params with spaces
//http://www.jquery4u.com?city=Gold Coast
//    console.log($.urlParam('city'));
////output: Gold%20Coast
//
//console.log(decodeURIComponent($.urlParam('city')));
////output: Gold Coast




