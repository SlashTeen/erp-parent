<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门页面</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/date.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'center',border:false">
    <table id="tt" style="width:100%;height:auto"
           title="部门明细表" iconCls="icon-edit" singleSelect="true" pagination="true" fit="true"
           idField="itemid" url="/erp/dep/selectAllDep">
        <thead>
        <tr>
            <th field="uuid" width="20%" align="center">部门编号</th>
            <th field="deptname" width="15%" align="center">部门名称</th>
            <th field="tele" width="15%" align="center">部门电话</th>
            <th field="attr1" width="20%" align="center" editor="{type:'validatebox',options:{precision:1}}">部门属性</th>
            <th field="attr2" width="15%" align="center" editor="{type:'validatebox',options:{precision:1}}">部门属性</th>
            <th field="attr3" width="15%" align="center" editor="validatebox">部门属性</th>
        </tr>
        </thead>
    </table>
</div>
<%--<div data-options="region:'south',border:false" style="height:30px;padding-left: 500px">--%>
    <%--<a id="btn_save" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" height="50px" onclick="saveRows()">提交订单</a>--%>
<%--</div>--%>
<script type="text/javascript">
    var lastIndex;
    $(function () {
        $('#tt').datagrid({
            onClickRow:function(rowIndex){
                if (lastIndex != rowIndex){
                    $('#tt').datagrid('endEdit', lastIndex);
                    $('#tt').datagrid('beginEdit', rowIndex);
                    setEditing(rowIndex);
                }
                lastIndex = rowIndex;
            }
        });

        $("#tt").datagrid("getPager").pagination({//点击分页条的页码的时候可以进行手动控制
            layout:['manual','sep','first','prev','sep','links','sep','next','last','sep','refresh'],
            beforePageText:'第',afterPageText:'页----共{pages}页',displayMsg:'当前显示从第{from}条到第{to}条数据,共{total}条'
        });
    });


    function setEditing(rowIndex){//validatebox才好使
//debugger;
        var editors = $('#tt').datagrid('getEditors', rowIndex);
        var priceEditor = editors[0];
        var amountEditor = editors[1];
        var costEditor = editors[2];
        priceEditor.target.bind('keyup', function(){
            calculate();
        });
        amountEditor.target.bind('keyup', function(){
            calculate();
        });
        function calculate(){
            var cost = priceEditor.target.val() * amountEditor.target.val();
            $(costEditor.target).val(cost);
        }
    }

</script>
</body>
</html>
