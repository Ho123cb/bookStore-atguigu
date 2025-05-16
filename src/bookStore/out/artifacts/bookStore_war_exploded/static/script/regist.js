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