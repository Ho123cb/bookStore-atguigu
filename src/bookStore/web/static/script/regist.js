function $(id) {
    return document.getElementById(id);
}

function judgmentConditions() {
    var unameReg = /[0-9a-zA-Z]{6,16}/;
    var uname = $("tUname").value;

    var tnameText = $("tUnameText");
    if(!unameReg.test(uname)) {
        //使其显示
        tnameText.style.visibility = "visible";
        return false;
    }
    else {
        tnameText.style.visibility = "hidden";
    }

    var pwdReg = /[\w]{8,}/; // /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,}$/;
    var pwd = $("tPwd").value;
    var pwdContext = $("tPwdContext");

    if(!pwdReg.test(pwd)) {
        pwdContext.style.visibility = "visible";
        return false;
    }
    else {
        pwdContext.style.visibility = "hidden";
    }

    var pwd2 = $("tPwd2").value;
    var pwd2Context = $("tPwd2Context");
    if(pwd2!=pwd) {
        pwd2Context.style.visibility = "visible";
        alert('两次输出的密码不一致');
        return false;
    }
    else {
        pwd2Context.style.visibility = "hidden";
    }

    var emailReg = /^[a-zA-Z0-9_\.-]+@([a-zA-Z0-9-]+[\.]{1})+[a-zA-Z]+$/;
    var email = $("tEmailId").value;
    var emailContext = $("tEmailIdContext");
    if(!emailReg.test(email)) {
        emailContext.style.visibility = "visible";
        return false;
    }
    else {
        emailContext.style.visibility = "hidden";
    }

    return true;
}

var xmlHttpRequest ;

function createXMLHttpRequest(){
    if(window.XMLHttpRequest){
        //符合DOM2标准的浏览器 ，xmlHttpRequest的创建方式
        xmlHttpRequest = new XMLHttpRequest() ;
    }else if(window.ActiveXObject){//IE浏览器
        try{
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP")
        }
    }
}

function checkDB(uname) {
    createXMLHttpRequest();
    var url = "user.do?operate=ckUname&uname="+uname;
    xmlHttpRequest.open("GET",url,true);
    xmlHttpRequest.onreadystatechange = checkName;
    xmlHttpRequest.send();
}

function checkName() {
    if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
        var responseText = xmlHttpRequest.responseText;
        if(responseText == "{'uname':'1'}") {
            alert("用户名已经被注册2");
            var t = $('tUname');
            t.value = '';
        }
        else {
            // alert("用户名可以注册");
        }
    }
}
