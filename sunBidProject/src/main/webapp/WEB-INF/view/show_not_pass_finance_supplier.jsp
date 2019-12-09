<%--
  Created by IntelliJ IDEA.
  User: YQD
  Date: 2019/11/28
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>财务审核未通过的供应商</title>
    <link rel="icon" href="/images/tu_biao.ico" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap-3.7.7.min.css">
</head>
<body>
<div class="container-fluid">
    <table class="table table-bordered table-responsive">
        <tr>
            <th>序号</th>
            <th>供应商名称</th>
            <th>法人姓名</th>
            <th>供应商资金</th>
            <th>供应商地址</th>
            <th>审核状态</th>
        </tr>
        <c:forEach items="${suppliers}" var="v" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${v.supplierName}</td>
                <td>${v.supplierPeople}</td>
                <td>${v.supplierMoney}</td>
                <td>${v.supplierAddress}</td>
                <td>${v.supplierSign}</td>
                    <%--<td>--%>
                    <%--<button type="button" class="btn btn-primary">审核</button>--%>
                    <%--</td>--%>
            </tr>
        </c:forEach>
    </table>
    <%--************--%>
    <div style="text-align: center">
        <%--<c:forEach items="${pageInfo}" var="p">--%>
        <a href="<%=path%>/selectnotpassfinancesupplier?pageNum=1">首页</a>
        <a href="<%=path%>/selectnotpassfinancesupplier?pageNum=${pageInfo.prePage}">上一页</a>
        <a href="<%=path%>/selectnotpassfinancesupplier?pageNum=${pageInfo.nextPage}">下一页</a>
        <a href="<%=path%>/selectnotpassfinancesupplier?pageNum=${pageInfo.pages}">尾页</a>
        <%--</c:forEach>--%>
    </div>
    <%--************--%>
</div>
</body>
</html>
