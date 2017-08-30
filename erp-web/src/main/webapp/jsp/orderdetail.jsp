<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情页面</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/date.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'center',border:false">
    <table id="tab_order_detail"></table>
</div>
<div data-options="region:'south',border:false" style="height:30px;padding-left: 500px">
    <a id="btn_save" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" height="50px" onclick="saveRows()">提交订单</a>
</div>
</body>
<script>
var isEditingRowIndex;//当前编辑行的索引
$(function () {
    $("#tab_order_detail").datagrid({
        columns:[[
            {field:'uuid',title:'主键',width:200,align:'center',hidden:true,editor:{type:'textbox'}},
            {field:'endtime',title:'审核日期',width:200,align:'center',hidden:true,editor:{type:'textbox'}},
            {field:'ender',title:'审核人',width:200,align:'center',hidden:true,editor:{type:'textbox'}},
            {field:'storeuuid',title:'仓库编号',width:200,align:'center',hidden:true,editor:{type:'textbox'}},
            {field:'goodsuuid',title:'商品编号',width:200,align:'center',editor:{type:'textbox'}},
            {field:'goodsname',title:'商品名称',width:200,align:'center',editor:{type:'combobox',options:{
                url:'',
                valueField:'goodsname',
                textField:'goodsname',
                onSelect:function (index, row) {//index是行号,row是该行结束编辑的时候的状态,该事件被选中触发

                }
            }}},
            {field:'price',title:'价格',width:100,align:'center',editor:{type:'validatebox',options:{precision:2}}},
            {field:'num',title:'数量',width:100,align:'center',editor:{type:'validatebox',options:{precision:2}}},
            {field:'money',title:'金额',width:100,align:'center',editor:{type:'validatebox'}},
            {field:'state',title:'状态',width:100,align:'center',editor:{type:'numberbox'}},
            {field:'ordersuuid',title:'所属订单',align:'center',width:200,editor:{type:'combobox'}},
            {field:'-',title:'操作',width:200,align:'center',formatter:function (index,row) {
                return '<a href="#" onclick="delRow()" class="icon-cut" style="padding-left: 20px;"></a>';
            }}
        ]],
        singleSelect:true,
        fitColumns:true,
        toolbar: [{
            iconCls: 'icon-add',
            text:'增加',
            handler: function(){
                $("#tab_order_detail").datagrid('appendRow',{'price':0,'num':0});//该方法必须有options{}
                $("#tab_order_detail").datagrid('endEdit',isEditingRowIndex);//结束上次编辑的行
                isEditingRowIndex=$("#tab_order_detail").datagrid('getRows').length-1;//将行号置为当前最大
                $("#tab_order_detail").datagrid('beginEdit',isEditingRowIndex);//开启编辑行,第二个参数是行号
//                setEditing();//增加行时绑定事件
                cellEvent();
            }
        }],
        onDblClickRow:function (index,row) {//index,row的位置是不能颠倒的easyUI会把第一个值当成行号
            $("#tab_order_detail").datagrid('endEdit',isEditingRowIndex);//结束上次行的编辑状态,行号在isEditingRowIndex中
            isEditingRowIndex=index;//将行号索引刷新
            $("#tab_order_detail").datagrid('beginEdit',isEditingRowIndex);//当点击某一行的时候开启该行的编辑状态
//            setEditing();//增加行时绑定事件
            cellEvent();
        },
        onClickRow:function (index, row) {//某一行被单击的时候结束当前编辑行的编辑状态,这种体验度是最好的
            $("#tab_order_detail").datagrid('endEdit',isEditingRowIndex);
        }
    });

});

function setEditing(){
    var editors = $('#tab_order_detail').datagrid('getEditors', isEditingRowIndex);
    var _price = editors[6];
    var _num = editors[7];
    var _money = editors[8];
    var price=_price.target;
    price.bind('keyup', function(){
        calculate();
    });
    var num=_num.target;
    num.bind('keyup', function(){
        calculate();
    });
    function calculate(){
        var cost = price.val() * num.val();
        $(_money.target).val(cost);
    }
}

function cellEvent() {
    var _price=$('#tab_order_detail').datagrid('getEditor', {index:isEditingRowIndex,field:'price'});
    $(_price.target).bind('keyup',function () {
        cal();
    });
    var _num = $('#tab_order_detail').datagrid('getEditor', {index:isEditingRowIndex,field:'num'});
    $(_num.target).bind('keyup',function () {
        cal();
    });
}

function cal() {
    var _price = $('#tab_order_detail').datagrid('getEditor', {index:isEditingRowIndex,field:'price'});
    var price=$(_price.target).val();
    var _num = $('#tab_order_detail').datagrid('getEditor', {index:isEditingRowIndex,field:'num'});
    var num=$(_num.target).val();
    var money=(price*num).toFixed(2);
    var _money = $('#tab_order_detail').datagrid('getEditor', {index:isEditingRowIndex,field:'money'});
    $(_money.target).val(money);
}

function delRow() {//删除一行,EasyUI的删除的方法和想象的不太一样
    $("#tab_order_detail").datagrid('endEdit',isEditingRowIndex);
    var row=$("#tab_order_detail").datagrid('getSelected');//1获取选中的行
    if(row){
        var rowIndex = $('#tab_order_detail').datagrid('getRowIndex', row);//2得到被选中行的行号
        $('#tab_order_detail').datagrid('deleteRow', rowIndex);//3删除该行
        $('#tab_order_detail').datagrid('reload');//4重新加载表格数据
    }
}

function saveRows() {
    var _rows=$("#tab_order_detail").datagrid('getRows');
    var data=[];
    for (var i=0;i<=_rows.length-1;i++){//0,1,2
        var temp={
            uuid:_rows[i].uuid,
            goodsuuid:_rows[i].goodsuuid,
            goodsname:_rows[i].goodsname,
            price:_rows[i].price,
            num:_rows[i].num,
            money:_rows[i].money,
            state:_rows[i].state,
            ordersuuid:_rows[i].ordersuuid,
            ender:_rows[i].ender,
            endtime:_rows[i].endtime,
            storeuuid:_rows[i].storeuuid,
        };
        data.push(temp);
    }

    $.ajax({
        url:path+'/order/insert',
        dataType:'json',
        method:'post',
        data:{"data":JSON.stringify(data)},
        success:function (result) {
            if(result.status=="200"){
                $.messager.alert("提示信息","信息提交成功")
            }else{
                $.messager.alert("提示信息","信息提交失败")
            }
        }
    });
}
</script>
</html>
