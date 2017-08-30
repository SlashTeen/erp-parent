<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商务管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
    <jsp:include page="/jsp/common.jsp"></jsp:include>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form.js"></script>
</head>
<body>
<div class='signup_container'>
    <div class="w-load"><div class="spin"></div></div>
    <h1 class='signup_title'>商务管理系统</h1>
    <div id="userInfo">
        <span style="float:left; margin-left:40px; height:200px; border:0px solid red"><img src="${pageContext.request.contextPath}/images/erp.jpg" id='admin'/></span>
        <span style="float:left; margin-left:40px; height:200px; border:0px solid red">
        <div id="signup_forms" class="signup_forms clearfix">
            <form class="signup_form_form" id="loginform" method="post">
                <div class="form_row first_row">
                    <label for="signup_name">请输入用户名</label>
                    <input type="text" name="username" placeholder="请输入用户名" id="signup_name" >
                    <span id="span_name"></span>
                </div>
                <div class="form_row">
                    <label for="signup_password">请输入密码</label>
                    <input type="password" name="pwd" placeholder="请输入密码" id="signup_password" >
                    <span id="span_password"></span>
                </div>
           </form>
        </div>
        <div id="foo">
            <span id="span_info"></span>
        </div><br/>
        </span>
    </div>
    <div class="login-btn-set"><div class='rem'>记住我</div><a href="#" class='login-btn' onclick="login()"></a></div>
</div>
<script>
function login() {
    var isOk=checkLogin();//登录时非空校验
    if(isOk==false){
        return false;
    }
    var formData=getFormData("loginform");
    $.ajax({
        url:"${pageContext.request.contextPath}/user/login",
        data:formData,
        dataType:"json",
        success:function (result) {
            if(result.status=="200"){//登录成功跳转到首页
                window.location.href="${pageContext.request.contextPath}/jsp/index.jsp";
            }else if(result.status=="400"){//登录失败给出提示信息
                $("#span_info").html("<font color='red'><b>"+result.message+"</b></font>");//b标签添加之后乱码解决了,不知原因
            }
        }
    });
}
function checkLogin() {
    if($("#signup_name").val()==""){//非空校验
        $("#signup_name").focus().css({
            border: "1px solid red"
        });
        $("#span_name").html("<font color='red'><b>用户名不能为空</b></font>");
        return false;
    }else{//如果有值,将上一次的红色警告线移除
        $("#signup_name").css({
            border: "none"
        });
        $("#span_name").html("");
    }
    if($("#signup_password").val()==""){
        $("#signup_password").focus().css({
            border: "1px solid red"
        });
        $("#span_password").html("<font color='red'><b>密码不能为空</b></font>");
        return false;
    }else{//如果有值,将上一次的红色警告线移除
        $("#signup_password").css({
            border: "none"
        });
        $("#span_password").html("");
    }
}
</script>
</body>
</html>
