<%--
  Created by IntelliJ IDEA.
  User: YQD
  Date: 2019/12/8
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>All招标类型</title>
    <%--link导入css文件的时候，必须制定三个属性，rel="stylesheet" type="text/css" href=
否则无法在正常访问样式
--%>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap-3.7.7.min.css">
</head>
<body>
<div class="container-fluid">
    <table class="table table-bordered table-responsive table-condensed">
        <tr>
            <th>序号</th>
            <th>招标类型名称</th>
        </tr>
        <c:forEach items="${tenderingtypes}" var="t" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${t.tenderingtypename}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
