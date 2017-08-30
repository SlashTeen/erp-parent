<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户页面</title>
    <jsp:include page="common.jsp"></jsp:include>
</head>
<body class="easyui-layout" fit="true">
<div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
<div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>
<div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>
<div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>
</body>
<script>
    var _menus;//菜单数据
    $(function(){
        $.ajax({
            url:"",
            dataType:"json",
            success:function(value){
                _menus=value;
                initLeftMenu();
            }
        });
    });

    function initLeftMenu() {
        var menuList="";
        $.each(_menus.menus,function (i, n) {
            menuList+="<ul>";
            $.each(n.menus,function (j, o) {
                menuList+="<div><li><a href='#' rel='"+o.url+"'>"+o.menuname+"</a></li></div>";
            });
            menuList+="</ul>";
        });
        $('#west').accordion('add', {
            title: n.menuname,
            content: menuList,
            selected: false
        });
    }
</script>
</body>
</html>
