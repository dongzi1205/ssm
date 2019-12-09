<%--
  Created by IntelliJ IDEA.
  User: YQD
  Date: 2019/12/8
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%
    String path = request.getContextPath();//动态获取项目路径名称
%>
<html>
<head>
    <title>增加招标类型</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap-3.7.7.min.css">
    <script src="<%=path%>/js/jquery-1.4.4.min.js"></script>
</head>
<body>

<div class="container-fluid">
    <form action="<%=path%>/inserttenderingtype" method="post">
        <table class="table table-bordered">
            <tr>
                <td>招标类型名称</td>
                <td><input name="tenderingtypename"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
