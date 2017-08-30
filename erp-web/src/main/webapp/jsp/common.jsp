<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入c标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--引入项目路径--%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"></c:set>
<%
String path=request.getContextPath();
//pageContext.setAttribute("ctx",path);
//    request.setAttribute("ctx",path);
//    session.setAttribute("ctx",path);
//    application.setAttribute("ctx",path);

//    pageContext.setAttribute("ctx","page_");
//    request.setAttribute("ctx","request_");
//    session.setAttribute("ctx","session_");
//    application.setAttribute("ctx","application_");
%>
<script>var path='${ctx}';</script>
<%--引入JQuery和easyUI--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/material/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/color.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>