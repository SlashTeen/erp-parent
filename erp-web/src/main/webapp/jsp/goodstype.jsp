<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品类型页面</title>
    <jsp:include page="common.jsp"></jsp:include>
    <style>
        .p-search{
            background:#fafafa;
            padding:5px;
            border:1px solid #ccc;
            border-bottom:0;
            overflow:hidden;
        }
        .p-search input{
            width:300px;
            border:1px solid #ccc;
            background: #fff url('../images/search.png') no-repeat right top;
        }
        .p-right{
            text-align:center;
            border:1px solid #ccc;
            border-left:0;
            width:150px;
            background:#fafafa;
            padding-top:10px;
        }
    </style>
</head>
<body style="background:#fafafa;">
<div class="easyui-panel" title="webchat room" iconCls="icon-search" collapsible="true" style="padding:5px;width:1000px;height:500px;">
    <div class="easyui-layout" fit="true">
        <div region="north" border="false" class="p-search">

        </div>
        <div region="center" border="false">
            <div class="easyui-layout" fit="true">
                <div region="east" border="false" class="p-right">

                </div>
                <div region="center" border="false" style="border:1px solid #ccc;">
                    <div class="easyui-layout" fit="true">
                        <div region="south" split="true" border="false" style="height:60px;">
                            <textarea style="border:0;width:100%;height:100%;resize:none">Hi,I am easyui.</textarea>
                        </div>
                        <div region="center" border="false">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
