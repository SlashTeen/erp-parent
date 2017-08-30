<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--pageScope只能取在同一个页面之中的属性值,即限定为同一个页面,包含进来的不算--%>
<%--<c:set var="ctx" value="${pageContext.request.contextPath}" scope="page"></c:set>--%>
<html>
<head>
    <title>测试http协议请求参数封装和获取</title>
    <jsp:include page="common.jsp"></jsp:include>
    <%
//        pageContext.setAttribute("ctx","page_");
    %>
</head>
<body>
<div id="d1">
    <%--1el的applicationScope可以获取其他域之中存放的属性值--%>
    <%--2requestScope只能取request域之中的属性值,即限定为一次请求,新打开一个网页本次请求结束--%>
        <%--3sessionScope只能取session域之中的属性值,即限定为一次会话,浏览器关闭会话结束--%>
    <%--<form action="${requestScope.ctx}/json/map1Params" method="post" id="f1">--%>
    <form action="<c:out value="${ctx}"/>/json/map4Params" method="post" id="f1">
        姓名1:<input type="text" name="name">
        年龄1:<input type="text" name="age">
        <input type="submit" value="提交">
    </form>
</div>
<div id="d2">
    <form action="${ctx}/json/map4Params" method="get" id="f2">
        姓名2:<input type="text" name="name">
        年龄2:<input type="text" name="age">
        <input type="submit" value="提交">
    </form>
</div>
<%
//    out.print("pageContext-get:"+pageContext.getAttribute("ctx")+"<br/>");
//    out.print("pageContext-find:"+pageContext.findAttribute("ctx")+"<br/>");
//    out.print("request:"+request.getAttribute("ctx")+"<br/>");
//    out.print("session:"+session.getAttribute("ctx")+"<br/>");
//    out.print("application:"+application.getAttribute("ctx")+"<br/>");
    //1application可以获取所有域中的存放的属性值,request,session域对象只能获取各自域中的属性值,
    //pageContext有个全域查找方法findAttribute
    //pageContext只能获取page域之中存放的属性值,且必须存,取在同一个页面
    //session域之中存放的属性值如果移除,只有在浏览器窗口关闭才会生效,即会话结束才会生效
    //request域之中的属性值如果发生改变(包括修改和删除),重发一次请求就会看到效果
%>
${ctx}
</body>
<script>
    window.onload=function send() {
        var data={"name":"tom","age":22};
        $.ajax({
            url:"${pageContext.request.contextPath}/json/map4Params",
            dataType:"json",
//            method:"post",
            method:"get",
//            contentType:"application/json;charset=utf-8",
//            data:data,
            data:JSON.stringify(data),
            success:function (result) {
                alert("ok");
            }
        });
    }
</script>
</html>
