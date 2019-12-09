<%--
  Created by IntelliJ IDEA.
  User: YQD
  Date: 2019/12/8
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%><html>
<head>
    <title>All招标项目</title>
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
            <th>招标类型</th>
            <th>项目发布人</th>
            <th>标题</th>
            <th>内容</th>
            <th>发布时间</th>
            <th>截止时间</th>
            <th>开标时间</th>
            <th>中标单位</th>
            <th>招标状态</th>
        </tr>
        <c:forEach items="${tenderingprjs}" var="t" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${t.tenderingtypeid}</td>
                <td>${t.userid}</td>
                <td>${t.tenderingprjtitle}</td>
                <td>${t.tenderingprjbody}</td>
                <td>${t.releasetime}</td>
                <td>${t.supplierendtime}</td>
                <td>${t.opentime}</td>
                <td>${t.supplierid}</td>
                <td>${t.sign}</td>
            </tr>
        </c:forEach>
    </table>
    <%--************--%>
    <div style="text-align: center">
        <%--<c:forEach items="${pageInfo}" var="p">--%>
        <a href="<%=path%>/selecttenderingprojs?pageNum=1">首页</a>
        <a href="<%=path%>/selecttenderingprojs?pageNum=${pageInfo.prePage}">上一页</a>
        <a href="<%=path%>/selecttenderingprojs?pageNum=${pageInfo.nextPage}">下一页</a>
        <a href="<%=path%>/selecttenderingprojs?pageNum=${pageInfo.pages}">尾页</a>
        <%--</c:forEach>--%>
    </div>
    <%--************--%>
</div>
</body>
</html>
