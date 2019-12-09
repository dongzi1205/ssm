<%--
  Created by IntelliJ IDEA.
  User: YQD
  Date: 2019/12/8
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>All行业类别信息</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap-3.7.7.min.css">

</head>
<body>
<div class="container-fluid">
    <table class="table table-bordered table-responsive table-condensed">
        <tr>
            <th>序号</th>
            <th>行业类别名称</th>
        </tr>
        <c:forEach items="${tradetypes}" var="t" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${t.tradetypename}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
