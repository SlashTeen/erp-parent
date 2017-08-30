<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页-商务管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css"/>
    <jsp:include page="common.jsp"></jsp:include>
</head>
<body class="easyui-layout" style="overflow-y: hidden" fit="true" scroll="no">
<noscript>
    <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
        <img src="../images/noscript.gif" alt='抱歉,请开启脚本支持'/>
    </div>
</noscript>
<div id="loading-mask" style="position:absolute;top:0px; left:0px; width:100%; height:100%; background:#D2E0F2; z-index:20000">
    <div id="pageloading" style="position:absolute; top:50%; left:50%; margin:-120px 0px 0px -120px; text-align:center;  border:2px solid #8DB2E3; width:200px; height:40px;  font-size:14px;padding:10px; font-weight:bold; background:#fff; color:#15428B;">
        <img src="../images/loading.gif" align="absmiddle"/> 正在加载中,请稍候...
    </div>
</div>
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;background: url(../images/banner.jpg) #7f99be repeat-x center 50%;line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
    <span style="float:right; padding-right:20px;" class="head">
        <span id="username">${user.username}</span>&nbsp;&nbsp;欢迎你!
        <a href="#" id="editpass" style="text-decoration: none">修改密码</a>
        <a href="#" onclick="logOut()" id="logOut" style="text-decoration: none">安全退出</a>
    </span>
    <span style="padding-left:10px; font-size: 16px; "><img src="../images/blocks.gif" width="20" height="20" align="absmiddle"/>ERP管理系统</span>
</div>
<div region="south" split="true" style="height: 30px;background:#D2E0F2;">
    <div class="footer"></div>
</div>
<!--导航内容 -->
<div region="west" split="true"  title="导航菜单" style="width:180px;" id="west">
    <div id="nav">

    </div>
</div>
<div id="mainPanel" region="center" style="background: #eee; overflow-y:hidden">
    <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
        <div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; " >
            <h1 style="font-size:24px;"></h1>
            <h1 style="font-size:24px;"></h1>
            <h1 style="font-size:24px;"></h1>
            <h1 style="font-size:24px;"></h1>
        </div>
    </div>
</div>
<!--修改密码窗口-->
<div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
     maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;background: #fafafa;">
    <div class="easyui-layout" fit="true">
        <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
            <table cellpadding=3>
                <tr>
                    <td>原密码：</td>
                    <td><input id="txtOldPass" type="password" class="txt01" /></td>
                </tr>
                <tr>
                    <td>新密码：</td>
                    <td><input id="txtNewPass" type="password" class="txt01" /></td>
                </tr>
                <tr>
                    <td>确认密码：</td>
                    <td><input id="txtRePass" type="password" class="txt01" /></td>
                </tr>
            </table>
        </div>
        <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
            <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">确定</a>
            <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
        </div>
    </div>
</div>
<div id="mm" class="easyui-menu" style="width:150px;">
    <div id="tabupdate">刷新</div>
    <div class="menu-sep"></div>
    <div id="close">关闭</div>
    <div id="closeall">全部关闭</div>
    <div id="closeother">除此之外全部关闭</div>
    <div class="menu-sep"></div>
    <div id="closeright">当前页右侧全部关闭</div>
    <div id="closeleft">当前页左侧全部关闭</div>
    <div class="menu-sep"></div>
    <div id="exit">退出</div>
</div>
<script>
function logOut(){//退出登录
    $.ajax({
        url:path+"/user/logOut",
        dataType:"json",
        success:function(value){
            if(value.status=="200"){
                window.location.href=path+"/login.jsp"
            }
        }
    });
}
</script>
<script>
window.onload = function(){
    $("#loading-mask").fadeOut();
};

var _menus;//菜单数据
var onlyOpenTitle="欢迎使用";
$(function(){
    $.ajax({
        url:path+"/index/init",
        dataType:"json",
        success:function(value){
            _menus=value;
            initLeftMenu();
        }
    });
//    tabClose();
//    tabCloseEven();
});

function initLeftMenu() {//初始化左侧导航菜单
    $("#nav").accordion({animate:false,fit:true,border:false});
    var panelNameSelected = "";
    $.each(_menus.menus,function (i,n) {
        var menuList="";
        menuList+="<ul class='navlist'>";
        $.each(n.menus,function (j,o) {
           menuList+="<li>" +
               "<div>" +
               "<a rel='"+o.url+"' ref='"+o.menuid+"' href='#'>" +
               "<span class='icon "+o.icon+"'>&nbsp;</span>" +
               "<span class='nav'>"+o.menuname+"</span>" +
               "</a>" +
               "</div>" +
               "</li>";
        });
        menuList+="</ul>";

        $("#nav").accordion("add",{
            title: n.menuname,
            content: menuList,
            border:false,
            iconCls: "icon"+n.icon
        });
        if(i==0){
            panelNameSelected=n.menuname;
        }
    });
    $("#nav").accordion('select',panelNameSelected);

    $(".navlist li a").click(function() {
        var tabTitle = $(this).children(".nav").text();
        var url = $(this).attr("rel");
        var menuid = $(this).attr("ref");
        var icon = $(this).find(".icon").attr("class");
//      alert(tabTitle+""+url+""+menuid+""+icon);
        var third = findByMenuid(menuid);//通过当前菜单的id查询该菜单对象
        if (third && third.child && third.child.length > 0) {
            $(".third_ul").slideUp();
            var ul = $(this).parent().next();
            if (ul.is(":hidden")) {
                ul.slideDown();
            } else {
                ul.slideUp();
            }
        } else {//添加一个tab标签
            addTab(tabTitle, url, icon);
            $('.navlist li div').removeClass("selected");
            $(this).parent().addClass("selected");
        }
    }).hover(function () {//鼠标进入
        $(this).parent().addClass("hover");
    },function () {//鼠标移除
        $(this).parent().removeClass("hover");
    });
}

function findByMenuid(menuid) {//通过菜单的id查询该
    var thisMenu;
    $.each(_menus.menus,function (i, n) {
        $.each(n.menus,function (j, o) {
            if(o.menuid==menuid){
                thisMenu=o;
            }
        })
    })
}

function addTab(subtitle,url,icon){
    if(!$('#tabs').tabs('exists',subtitle)){//判断名字是subtitle的选项卡是否存在,若不存在添加一个叫subtitle的选项卡
        $('#tabs').tabs('add',{
            title:subtitle,
            content:createFrame(url),//调用方法
            closable:true,
            icon:icon
        });
    }else{
        $('#tabs').tabs('select',subtitle);//选中一个叫名字是subtitle的选项卡
        $('#mm-tabupdate').click();
    }
//    tabClose();
}

function createFrame(url) {//iframe可以重新嵌套一个页面,URL来自数据库,是相对路径
    var s = '<iframe scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%"></iframe>';
    return s;
}



function tabClose() {
    $(".tabs-inner").dblclick(function(){//双击关闭TAB选项卡
        var subtitle = $(this).children(".tabs-closable").text();
        $("#tabs").tabs("close",subtitle);
    });
    $(".tabs-inner").bind("contextmenu",function(e){//为选项卡绑定右键
        $("#mm").menu("show", {
            left: e.pageX,
            top: e.pageY
        });
        var subtitle =$(this).children(".tabs-closable").text();
        $("#mm").data("currtab",subtitle);
        $("#tabs").tabs("select",subtitle);
        return false;
    });
}

function tabCloseEven() {
    $('#mm').menu({
        onClick: function (item) {
            closeTab(item.id);
        }
    });
    return false;
}

function closeTab(action) {
    var alltabs = $('#tabs').tabs('tabs');
    var currentTab =$('#tabs').tabs('getSelected');
    var allTabtitle = [];
    $.each(alltabs,function(i,n){
        allTabtitle.push($(n).panel('options').title);
    });

    switch (action) {
        case "refresh":
            var iframe = $(currentTab.panel('options').content);
            var src = iframe.attr('src');
            $('#tabs').tabs('update', {
                tab: currentTab,
                options: {content: createFrame(src)}
            });
            break;
        case "close":
            var currtab_title = currentTab.panel('options').title;
            $('#tabs').tabs('close', currtab_title);
            break;
        case "closeall":
            $.each(allTabtitle, function (i, n) {
                if (n != onlyOpenTitle){
                    $('#tabs').tabs('close', n);
                }
            });
            break;
        case "closeother":
            var currtab_title = currentTab.panel('options').title;
            $.each(allTabtitle, function (i, n) {
                if (n != currtab_title && n != onlyOpenTitle)
                {
                    $('#tabs').tabs('close', n);
                }
            });
            break;
        case "closeright":
            var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);
            if (tabIndex == alltabs.length - 1){
                alert('亲，后边没有啦 ^@^!!');
                return false;
            }
            $.each(allTabtitle, function (i, n) {
                if (i > tabIndex) {
                    if (n != onlyOpenTitle){
                        $('#tabs').tabs('close', n);
                    }
                }
            });
            break;
        case "closeleft":
            var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);
            if (tabIndex == 1) {
                alert('亲，前边那个上头有人，咱惹不起哦。 ^@^!!');
                return false;
            }
            $.each(allTabtitle, function (i, n) {
                if (i < tabIndex) {
                    if (n != onlyOpenTitle){
                        $('#tabs').tabs('close', n);
                    }
                }
            });
            break;
        case "exit":
            $('#closeMenu').menu('hide');
            break;
    }
}


function msgShow(title, msgString, msgType) {//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
    $.messager.alert(title, msgString, msgType);
}

function openPwd() {//设置密码窗口,默认关闭状态
    $("#w").window({title:"修改密码",width: 300,modal: true,shadow: true,closed: true,height: 260,resizable:false});
}

function closePwd() {//关闭密码修改窗口
    $("#w").window("close");
}
function serverLogin(){//修改密码
    var $oldpass = $("#txtOldPass");
    var $newpass = $("#txtNewPass");
    var $rePass = $("#txtRePass");

    if ($oldpass.val() == '') {
        msgShow('系统提示','请输入原密码','warning');
        return false;
    }
    if ($newpass.val() == '') {
        msgShow('系统提示','请输入新密码','warning');
        return false;
    }
    if ($rePass.val() == '') {
        msgShow('系统提示','请在一次输入新密码','warning');
        return false;
    }
    if ($newpass.val() != $rePass.val()) {
        msgShow('系统提示','两次密码不一至请重新输入','warning');
        return false;
    }

    $.ajax({
        url:path+"/user/modifyPwd",
        type:"post",
        dataType:"json",
        data:{"oldPwd":$oldpass.val(),"newPwd":$newpass.val()},
        success:function(value){
            if(value.status=="200"){
                $("#w").window("close");
                $oldpass.val("");
                $newpass.val("");
                $rePass.val("");
                window.location.href=path+"/login.jsp";
            }else{
                $.messager.alert("提示",value.message);
            }
        }
    });
}

$(function() {
    openPwd();//该窗口默认是关闭状态的
    $("#editpass").click(function(){$("#w").window("open");});
    $("#btnEp").click(function() {serverLogin();});
    $("#btnCancel").click(function(){closePwd();});
});
</script>
</body>
</html>
