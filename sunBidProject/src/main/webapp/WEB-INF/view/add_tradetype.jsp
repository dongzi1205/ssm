<%--
  Created by IntelliJ IDEA.
  User: YQD
  Date: 2019/11/29
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%
    String path = request.getContextPath();//动态获取项目路径名称
%>
<html>
<head>
    <title>增加行业类别信息</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap-3.7.7.min.css">
    <script src="<%=path%>/js/jquery-1.4.4.min.js"></script>
    <script src="<%=path%>/js/ajaxfileupload.js"></script>
    <script>
        //添加行业信息的行
        function addtr() {
            $("#addtable_tr").append("<tr><td>行业名称:</td><td><input name='tradetypename'></td><td><button onclick='delTr(this)'>删除记录</button></td></tr>")
        }

        //删除对应行
        function delTr(t) {
            $(t).parent("td").parent("tr").remove();
            $(t).remove();
        }
    </script>
</head>
<body>

<div class="container-fluid">
    <span>如果你想要添加行业信息，请点击</span>
    <button onclick="addtr()">添加行</button>

    <form action="<%=path%>/insertbatchtradetypes" method="post">
        <table id="addtable_tr" class="table table-bordered">
            <%--js动态插入--%>
        </table>
        <input type="submit" value="提交">
    </form>
</div>

</body>
</html>
