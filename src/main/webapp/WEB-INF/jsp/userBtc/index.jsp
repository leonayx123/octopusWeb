<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/23
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap-3.3.0-dist/dist/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-3.3.0-dist/dist/js/bootstrap.js"></script>
    <style>
        td{
            padding: 5px;
        }
    </style>
</head>
<body class="container">
<table class="table table-hover">
    <thead>
    <tr>
        <th>investBtc</th>
        <th>initBtc</th>
        <th>currBtc</th>
        <th>addRatio</th>
        <th>updateDate</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="item">
        <tr onclick="location.href='${pageContext.request.contextPath}/record/index.do?userId=${item.userId}'">
            <td class="col-md-3"><span>${item.investBtc}</span></td>
            <td class="col-md-3"><span>${item.initBtc}</span></td>
            <td class="col-md-3"><span>${item.currBtc}</span></td>
            <td class="col-md-3">${item.ratio}%</td>
            <td class="col-md-3">${item.updateDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
