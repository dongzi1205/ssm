<%--
  Created by IntelliJ IDEA.
  User: YQD
  Date: 2019/12/8
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%><html>
<head>
    <title>财务审核</title>
</head>
<body>
<form action="<%=path%>/updatefinanceverfiysignbyId" method="post">
    <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
    财务审核意见：<input name="explains"><br>
    sign:<br>
    <label><input type="radio" name="supplierSign" value="3">通过</label>
    <label><input type="radio" name="supplierSign" value="4">不通过</label>
    <label><input type="radio" name="supplierSign" value="5">黑名单</label><br>
    <input type="submit" value="开始审核">
</form>
</body>
</html>
