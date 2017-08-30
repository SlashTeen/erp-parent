
function paramsToJson(paramsAndValues) {
    var jsonObj = {};
    var param = paramsAndValues.split("&");  
    for ( var i = 0; param != null && i < param.length; i++) {  
        var para = param[i].split("=");  
        jsonObj[para[0]] = para[1];  
    }  
    return jsonObj;
}  

function getFormData(form) {  
    var formValues = $("#" + form).serialize();
    formValues = formValues.replace(/\+/g,"");//关于jquery的serialize方法转换空格为+号的解决方法,g表示对整个字符串中符合条件的都进行替换
    var temp =  decodeURIComponent(JSON.stringify(paramsToJson(formValues)));
    var queryParam = JSON.parse(temp);
    return queryParam;
}

//noinspection JSUnusedGlobalSymbols
function queryFormData(formId) {
    var param = {};
    $("#"+formId+" input").each(function (i, n) {
        param[n.name] = n.value;
    })
    alert(param.user);
    var paramStr=JSON.stringify(param);
    return paramStr;
}