<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询订单详情</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/date.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="width: 100%;height: 35px">
    <input class="easyui-textbox" name="goodsuuid" data-options="iconCls:'icon-search'" style="width:200px">&nbsp;&nbsp;&nbsp;&nbsp;商品编号&nbsp;&nbsp;&nbsp;&nbsp;
    <input class="easyui-textbox" name="goodsname" data-options="iconCls:'icon-search'" style="width:200px">&nbsp;&nbsp;&nbsp;&nbsp;商品名称&nbsp;&nbsp;&nbsp;&nbsp;
    <input class="easyui-textbox" name="state" data-options="iconCls:'icon-search'" style="width:200px">&nbsp;&nbsp;&nbsp;&nbsp;商品状态&nbsp;&nbsp;&nbsp;&nbsp;
    <a id="btn_search" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">检索</a>
</div>
<div data-options="region:'center',border:false">
    <table id="tab_order_detail"></table>
</div>
</body>
<script>
$(function () {
    $("#tab_order_detail").datagrid({
        url:path+"/order/search",
        pagination:true,
        fit:true,
        fitColumns:true,
        singleSelect:true,
        pageNumber:1,
        pageSize:10,
        showHeader:true,
        columns:[[
            {field:'uuid',title:'主键',width:200,align:'center',hidden:true,editor:{type:'textbox'}},
            {field:'endtime',title:'审核日期',width:200,align:'center',hidden:true,editor:{type:'textbox'}},
            {field:'ender',title:'审核人',width:200,align:'center',hidden:true,editor:{type:'textbox'}},
            {field:'storeuuid',title:'仓库编号',width:200,align:'center',hidden:true,editor:{type:'textbox'}},
            {field:'goodsuuid',title:'商品编号',width:200,align:'center',editor:{type:'textbox'}},
            {field:'goodsname',title:'商品名称',width:200,align:'center',editor:{type:'combobox'}},
            {field:'price',title:'价格',width:100,align:'center',editor:{type:'numberbox',options:{precision:2}}},
            {field:'num',title:'数量',width:100,align:'center',editor:{type:'numberbox',options:{precision:2}}},
            {field:'money',title:'金额',width:100,align:'center',editor:{type:'numberbox',options:{precision:2}}},
            {field:'state',title:'状态',width:100,align:'center',editor:{type:'numberbox'}},
            {field:'ordersuuid',title:'所属订单',align:'center',width:200,editor:{type:'combobox'}}
        ]]
    });

    $("#tab_order_detail").datagrid("getPager").pagination({//点击分页条的页码的时候可以进行手动控制
        layout:['manual','sep','first','prev','sep','links','sep','next','last','sep','refresh'],
        beforePageText:'第',afterPageText:'页----共{pages}页',displayMsg:'当前显示从第{from}条到第{to}条数据,共{total}条'
    });

    $("#btn_search").bind('click',function () {
        var data={};
        $(".easyui-textbox").each(function (i, n) {//这里为什么使用的是textboxname而不是name:因为easyUI已经将该属性改变了
            data[$(this).attr("textboxname")]=$(this).val();
        });
//        alert(data.goodsuuid+":"+data.goodsname+":"+data.state);
//        data["page"]=1;
//        data["rows"]=10;
//        $.ajax({
//            dataType:'application/json;charset=utf8',
//            data:JSON.stringify(data),
//            method:'post',
//            url:path+'/order/search',
//            success:function (result) {
//                $("#tab_order_detail").datagrid("reload");
//            }
//        });

//        $.ajax({
//            method:'get',
//            url:path+"/order/search?page="+data["page"]+"&rows="+data["rows"]+"&goodsuuid="+data["goodsuuid"]+"&goodsname="+data["goodsname"]+"&state="+data["state"],
//            success:function (result) {
//                $("#tab_order_detail").datagrid("load");
//            }
//        });
        $("#tab_order_detail").datagrid("load",{
            goodsuuid:data["goodsuuid"],
            goodsname:data["goodsname"],
            state:data["state"]
        });
    });

});
</script>
</html>
