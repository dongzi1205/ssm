<%--
  Created by IntelliJ IDEA.
  User: YQD
  Date: 2019/11/27
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>用户登录</title>
    <link rel="icon" href="/images/tu_biao.ico" type="image/x-icon"/>
    <script type="text/javascript">
        function flushUserVerification(tis) {
            /*
            因为图片在内存中存在缓存，所以在这里提供，不同的参数，要求每次的请求都不同才会刷新缓存中的图片。
             */
            tis.src = "<%=path%>/userverification?" + new Date().getTime();
        }
    </script>
</head>
<body>

<fieldset>
    <legend>用户登录</legend>
    ${message}
    <form action="<%=path%>/userlogin" method="post">
        <table border="1" cellspacing="0">
            <tr>
                <td>用户名</td>
                <td><input name="userName" value="" type="text"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input name="userPassWord" value="" type="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input name="userVerification" value="" type="password" style="width: 60px"><img
                        onclick="flushUserVerification(this)" src="<%=path%>/userverification" alt="验证码"
                        title="点击刷新，验证码"></td>
            </tr>
            <tr style="margin-left: 20px">
                <td colspan="2"><input value="登录" type="submit"></td>
            </tr>
        </table>
    </form>

</fieldset>

</body>
</html>
