<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品页面</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/datagrid-detailview.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:50px;">
    <div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="">删除</a>
    </div>
</div>
<div data-options="region:'center'" style="padding:5px;background:#eee;">
    <table id="dg" class="easyui-datagrid"
           url="/erp/goods/listGoods" pagination="true" fit="true">
        <thead>
        <tr>
            <th field="uuid" width="25%" align="center">商品类型</th>
            <th field="name" width="25%" align="center">类型名称</th>
            <th field="u" width="25%" align="center">商品产地</th>
            <th field="n" width="25%" align="center">商品描述</th>
        </tr>
        </thead>
    </table>
    <table id="dg"></table>
    <%--<form method="post" >--%>
        <%--<table class="dv-table" style="width:100%;background:#fafafa;padding:5px;margin-top:5px;">--%>
            <%--<tr>--%>
                <%--<td>商品编号</td>--%>
                <%--<td><input name="uuid" class="easyui-validatebox"></td>--%>
                <%--<td>商品名称</td>--%>
                <%--<td><input name="name" class="easyui-validatebox"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>产地</td>--%>
                <%--<td><input name="origin"></td>--%>
                <%--<td>厂商</td>--%>
                <%--<td><input name="producer" class="easyui-validatebox"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>计价单位</td>--%>
                <%--<td><input name="unit" class="easyui-validatebox"></td>--%>
                <%--<td>进价</td>--%>
                <%--<td><input name="inprice" class="easyui-validatebox"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>出价</td>--%>
                <%--<td><input name="outprice"></td>--%>
                <%--<td>商品类型</td>--%>
                <%--<td><input name="goodstypeuuid" class="easyui-validatebox"></td>--%>
            <%--</tr>--%>
        <%--</table>--%>
        <%--<div style="padding:5px 0;text-align:right;padding-right:30px">--%>
            <%--<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="">Save</a>--%>
            <%--<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="">Cancel</a>--%>
        <%--</div>--%>
    <%--</form>--%>
</div>
</body>
<script>
    $(function () {
        $('#dg').datagrid({
//            url:path+'/goods/listGoods',
            view: detailview,
//            pagination:true,
//            fitColumns:true,
//            fit:true,
//            columns:[[
//                {field:'uuid',title:'商品类型',width:'25%',align:'center'},
//                {field:'name',title:'类型名称',width:'25%',align:'center'},
//                {field:'u',title:'商品产地',width:'25%',align:'center'},
//                {field:'n',title:'商品描述',width:'25%',align:'center'}
//            ]],
            detailFormatter:function(index,row){
                return '<div style="padding:2px"><table id="ddv-'+index+'"></table></div>';
            },
            onExpandRow: function(index,row){
                $("#ddv-"+index).datagrid({//商品类型表的UUID就是商品表的goodstypeuuid
                    url:path+'/goods/goodsdetail?uuid='+row.uuid,
                    fitColumns:true,
                    singleSelect:true,
                    pagination:true,
                    height:'auto',
                    columns:[[
                        {field:'uuid',title:'商品编号',width:200,align:'center'},
                        {field:'name',title:'商品名称',width:200,align:'center',editor:{type:'validatebox'}},
                        {field:'origin',title:'产地',width:200,align:'center',editor:{type:'validatebox'}},
                        {field:'producer',title:'厂商',width:200,align:'center',editor:{type:'validatebox'}},
                        {field:'unit',title:'计价单位',width:200,align:'center',editor:{type:'validatebox'}},
                        {field:'inprice',title:'进价',width:200,align:'center',editor:{type:'validatebox'}},
                        {field:'outprice',title:'出价',width:200,align:'center',editor:{type:'validatebox'}},
                        {field:'goodstypeuuid',title:'商品类型',width:200,align:'center',heditor:{type:'validatebox'}},
                        {field:'operation',title:'可用操作',width:100,align:'center',formatter:operFormatter}
                    ]],
                    onResize:function(){
                        $('#dg').datagrid('fixDetailRowHeight',index);
                    },
                    onLoadSuccess:function(){
                        setTimeout(function(){$('#dg').datagrid('fixDetailRowHeight',index);},0);
                    }
                });
                $('#dg').datagrid('fixDetailRowHeight',index);
            }
        });

        $("#dg").datagrid("getPager").pagination({//点击分页条的页码的时候可以进行手动控制
            layout:['manual','sep','first','prev','sep','links','sep','next','last','sep','refresh'],
            beforePageText:'第',afterPageText:'页----共{pages}页',displayMsg:'当前显示从第{from}条到第{to}条数据,共{total}条'
        });

    });

    function operFormatter(value,row) {
        return '<a href="#" onclick="modifyRow('+row.uuid+')"  class="icon-edit" style="padding-left: 20px;"/></a>';
    }
    function modifyRow(uuid) {
        alert(uuid);
    }




    function saveItem(index){
        var row = $('#dg').datagrid('getRows')[index];
        var url = row.isNewRecord ? 'save_user.php' : 'update_user.php?id='+row.id;
        $('#dg').datagrid('getRowDetail',index).find('form').form('submit',{
            url: url,
            onSubmit: function(){
                return $(this).form('validate');
            },
            success: function(data){
                data = eval('('+data+')');
                data.isNewRecord = false;
                $('#dg').datagrid('collapseRow',index);
                $('#dg').datagrid('updateRow',{
                    index: index,
                    row: data
                });
            }
        });
    }

    function cancelItem(index){
        var row = $('#dg').datagrid('getRows')[index];
        if (row.isNewRecord){
            $('#dg').datagrid('deleteRow',index);
        } else {
            $('#dg').datagrid('collapseRow',index);
        }
    }
</script>
</html>
