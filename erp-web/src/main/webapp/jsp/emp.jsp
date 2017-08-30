<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理页面</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form.js"></script>
</head>
<body>
<%--表头--%>
<div id="toolbar_1">
    <a id="a_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'增加'"></a>
    <a id="a_cut" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cut',plain:true,text:'剪切'"></a>
</div>
<%--动态生成数据表格--%>
<table id="table_emp"></table>
<%--添加操作使用的窗口,默认关闭状态--%>
<div id="w_add" class="easyui-window" title="操作窗口" style="width:450px;height:350px;" align="center"
     data-options="modal:true,closed:true" top="100px">
    <form id="form_add_update">
        <div>
            <input id="uuid" type="hidden" name="uuid" />
        </div>
        <div>
            <label for="username">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
            <input id="username" class="easyui-textbox" type="text" name="username"
                   data-options="required:true" style="width: 200px;height: 30px;"/>
        </div>
        <div>
            <label for="pwd">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
            <input id="pwd" class="easyui-textbox" type="password" name="pwd"
                   data-options="required:true" style="width: 200px;height: 30px;"/>
        </div>
        <div>
            <label for="name">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;字:</label>
            <input id="name" class="easyui-textbox" type="text" name="name"
                   data-options="required:true" style="width: 200px;height: 30px;"/>
        </div>
        <div>
            <label for="gender">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
            <input id="gender" class="easyui-combobox" type="text" name="gender"
                   data-options="required:true,valueField:'num',textField:'g',data:[{num:'0',g:'女'},{num:'1',g:'男'}]"
                   style="width: 200px;height: 30px;" />
        </div>
        <div>
            <label for="email">电子邮箱:</label>
            <input id="email" class="easyui-textbox" type="text" name="email"
                   data-options="validType:'email'" style="width: 200px;height: 30px;"/>
        </div>
        <div>
            <label for="address">家庭地址:</label>
            <input id="address" class="easyui-textbox" type="text" name="address"
                   data-options="required:true" style="width: 200px;height: 30px;"/>
        </div>
        <div>
            <label for="deptname">部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门:</label>
            <input id="deptname" class="easyui-combobox" type="text" name="deptname"
                   data-options="required:true" style="width: 200px;height: 30px;"/>
        </div>
        <div>
            <label for="birthday">生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日:</label>
            <input id="birthday" class="easyui-datebox" type="text" name="birthday"
                   data-options="" style="width: 200px;height: 30px;"/>
        </div>
        <br/>
        <div>
            <a id="btn_sub" class="easyui-linkbutton" type="button" data-options="iconCls:'icon-save'">提交</a>
        </div>
    </form>
</div>

<%--修改操作使用的窗口,默认关闭状态--%>
<div id="w_update" class="easyui-window" title="操作窗口" style="width:450px;height:350px;" align="center"
     data-options="modal:true,closed:true" top="100px">
    <form id="form_update">
        <div>
            <input id="uid" type="hidden" name="empl.uuid" value=""/>
        </div>
        <div>
            <label for="uname">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
            <input id="uname" class="easyui-textbox" type="text" name="empl.username" value=""
                   data-options="required:true" style="width: 200px;height: 30px;"/>
        </div>
        <div>
            <label for="pd">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
            <input id="pd" class="easyui-textbox" type="password" name="empl.pwd" value=""
                   data-options="required:true" style="width: 200px;height: 30px;"/>
        </div>
        <div>
            <label for="n">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;字:</label>
            <input id="n" class="easyui-textbox" type="text" name="empl.name" value=""
                   data-options="required:true" style="width: 200px;height: 30px;"/>
        </div>
        <div>
            <label for="g">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
            <input id="g" class="easyui-combobox" type="text" name="empl.gender" value=""
                   data-options="required:true,valueField:'num',textField:'g',data:[{num:'0',g:'女'},{num:'1',g:'男'}]"
                   style="width: 200px;height: 30px;" />
        </div>
        <div>
            <label for="e">电子邮箱:</label>
            <input id="e" class="easyui-textbox" type="text" name="empl.email" value=""
                   data-options="validType:'email'" style="width: 200px;height: 30px;"/>
        </div>
        <div>
            <label for="a">家庭地址:</label>
            <input id="a" class="easyui-textbox" type="text" name="empl.address" value=""
                   data-options="required:true" style="width: 200px;height: 30px;"/>
        </div>
        <div>
            <label for="dname">部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门:</label>
            <input id="dname" class="easyui-combobox" type="text" name="dep.deptname" value=""
                   data-options="required:true,disabled:true" style="width: 200px;height: 30px;"/>
        </div>
        <div>
            <label for="birth">生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日:</label>
            <input id="birth" class="easyui-datebox" type="text" name="empl.birthday" value=""
                   data-options="formatter:dtformatter,parser:dtparser" style="width: 200px;height: 30px;"/>
        </div>
        <br/>
        <div>
            <a id="btn_save" class="easyui-linkbutton" type="button" data-options="iconCls:'icon-save'">保存</a>
        </div>
    </form>
</div>
</body>
<script>
$(function () {
    $('#table_emp').datagrid({
        url:path+'/user/page',
        pagination:true,
        fit:true,
        fitColumns:true,
        singleSelect:true,
        pageNumber:1,
        pageSize:10,
        showHeader:true,
        sortName:'uuid',
        sortOrder:'desc',
        columns:[[
            {field:'uuid',title:'员工编号',width:100,height:100,align:'center'},
            {field:'username',title:'员工账号',width:100,align:'center'},
            {field:'name',title:'员工姓名',width:100,align:'center'},
            {field:'email',title:'电子邮箱',width:100,align:'center'},
            {field:'birthday',title:'员工生日',width:120,align:'center',formatter:dateFormatter},
            {field:'gender',title:'员工性别',width:50,align:'center',formatter:sexFormatter},
            {field:'depuuid',title:'所属部门',width:50,align:'center'},
            {field:'address',title:'家庭住址',width:100,align:'center'},
            {field:'description',title:'可用操作',width:100,align:'center',formatter:operFormatter}
        ]],
        toolbar: "#toolbar_1"
    });

    $("#table_emp").datagrid("getPager").pagination({//点击分页条的页码的时候可以进行手动控制
        layout:['manual','sep','first','prev','sep','links','sep','next','last','sep','refresh'],
        beforePageText:'第',afterPageText:'页----共{pages}页',displayMsg:'当前显示从第{from}条到第{to}条数据,共{total}条'
    });

    $('#deptname').combobox({//部门的下拉框数据来自这里
        url:path+'/dep/listAllDep',
        valueField:'uuid',
        textField:'deptname',
    });

});
</script>
<script>
function dateFormatter(value,row) {
    return new Date(value).toLocaleDateString();
}
function sexFormatter(value,row) {
    if(value==0){return"女";}else if(value==1){return"男";}
}
function operFormatter(value,row) {
   return '<a href="#" onclick="modifyRow('+row.uuid+')"  class="icon-edit" style="padding-left: 20px;"/></a>-'+
     '<a href="#" onclick="delRow('+row.uuid+')"  class="icon-cut" style="padding-left: 20px;"></a>';
}

$("#a_add").click(function () {//打开窗口
   $("#w_add").window("open");
});
$("#btn_sub").click(function () {//插入一条数据
    var formData=getFormData("form_add_update");
    $.ajax({
        url:path+'/user/addUser',
        data:formData,
        dataType:'json',
        type:'post',
        success:function (data) {
            if(data.status==200){
                $("#w_add").window("close");
                $("#w_add").window("clear");
                $("#table_emp").datagrid("reload");
            }else if(data.status==400) {
                $("#w_add").window("close");
                $.messager.alert("员工添加失败");
            }
        }
    })
});

function modifyRow(uuid) {
    $('#form_update').form("clear");
    $("#w_update").window("open");
    $('#form_update').form('load',path+"/user/selectRow?uuid="+uuid);
//    $.ajax({
//        url:path+"/user/selectRow?uuid="+uuid,
//        dataType:'json',
//        method:'post',
//        success:function (result) {
//            $.each(result,function (i, n) {
//                if(i=="empl"){
//                    $.each(n,function (x, m) {
//                        alert("empl:"+x+":"+m);
//
//                    })
//                }else if(i=="dep"){
//                    $.each(n,function (x, m) {
//                        alert("dep:"+x+":"+m);
//
//                    })
//                }
//            })
//        }
//    });
}
$("#btn_save").click(function () {//saveRow,将修改之后的数据保存
    var formData=getFormData("form_update");
    $.ajax({
        url:path+'/user/saveRow',
        data:formData,
        dataType:'json',
        type:'post',
        success:function (data) {
            if(data.status==200){
                $('#form_update').form("clear");
                $("#w_update").window("close");
                $("#table_emp").datagrid("reload");
            }else if(data.status==400) {
                $('#form_update').form("clear");
                $("#w_update").window("close");
                $.messager.alert("提示","更新失败!");
            }
        }
    });
});
function delRow(uuid) {
    $.messager.confirm('提示','确定要删除此记录吗？',function(r){
        if(r){
            $.ajax({
                url:path+'/user/del?uuid='+uuid,
                dataType:'json',
                type:'post',
                success:function(data){
                    if(data.status=="200"){
                        $("#table_emp").datagrid("reload");
                    }else{
                        $.messager.alert('提示',"删除失败!");
                    }
                }
            });
        }
    });
}
</script>
<script type="text/javascript">
    function dtformatter(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return (d<10?('0'+d):d)+'-'+(m<10?(m+'月'):m+'月')+'-'+y;
    }
    function dtparser(s){
        if (!s) return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0],10);
        var m = parseInt(ss[1],10);
        var d = parseInt(ss[2],10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
            return new Date(y,m-1,d);
        } else {
            return new Date();
        }
    }
</script>
</html>
