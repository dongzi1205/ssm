<%--
  Created by IntelliJ IDEA.
  User: YQD
  Date: 2019/11/27
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>待采购员审核的供应商</title>
    <%--link导入css文件的时候，必须制定三个属性，rel="stylesheet" type="text/css" href=
    否则无法在正常访问样式
    --%>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap-3.7.7.min.css">
    <script>
        //采购员审核：1
        function verfiySign(id) {
            window.location.href = "<%=path%>/verfiysuppliersignjustregister?id="+id;
        }
    </script>
</head>
<body>
<div class="container-fluid">
    <table class="table table-bordered table-responsive table-condensed">
        <tr>
            <th>序号</th>
            <th>供应商名称</th>
            <th>法人姓名</th>
            <th>供应商资金</th>
            <th>供应商地址</th>
            <th>审核状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${suppliers}" var="v" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${v.supplierName}</td>
                <td>${v.supplierPeople}</td>
                <td>${v.supplierMoney}</td>
                <td>${v.supplierAddress}</td>
                <td>${v.supplierSign}</td>
                <td>
                    <button type="button" class="btn btn-primary" onclick="verfiySign(${v.id})">审核</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%--************--%>
    <div style="text-align: center">
        <%--<c:forEach items="${pageInfo}" var="p">--%>
        <a href="<%=path%>/selectsupplierjustregisternoverify?pageNum=1">首页</a>
        <a href="<%=path%>/selectsupplierjustregisternoverify?pageNum=${pageInfo.prePage}">上一页</a>
        <a href="<%=path%>/selectsupplierjustregisternoverify?pageNum=${pageInfo.nextPage}">下一页</a>
        <a href="<%=path%>/selectsupplierjustregisternoverify?pageNum=${pageInfo.pages}">尾页</a>
        <%--</c:forEach>--%>
    </div>
    <%--************--%>
</div>
</body>
</html>
