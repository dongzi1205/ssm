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
    <title>增加招标项目</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap-3.7.7.min.css">
    <script src="<%=path%>/js/jquery-1.4.4.min.js"></script>
    <script src="<%=path%>/js/ajaxfileupload.js"></script>
    <script>
        //页面加载完毕，ajax方式加载下拉列表里面的内容
        $(function () {
            $.get("<%=path%>/selectalltenderingname", function (data) {
                // alert(data);  //ok
                for (var i = 0; i < data.length; i++) {
                    $("#tenderingtypeid").append(" <option value='" + data[i].id + "'>" + data[i].tenderingtypename + "</option>")
                }
            });
        });

        //ajax多个附件上传
        function ajaxFileUpload() {
            $.ajaxFileUpload({
                type: "POST",  //文件的提交方式
                url: '<%=path%>/uploadtenderingfiles', //用于文件上传的服务器端请求地址
                secureuri: false, //是否需要安全协议，一般设置为false
                fileElementId: 'uploadfiles', //文件上传域的ID，这里对应的是下面input标签的id
                async: false,   //是否同步
                dataType: "json",  //返回数据的类型
                success: function (data) //服务器成功响应处理函数
                {//成功接收到数据
                    // alert(data.filepath+"*****");
                    $("#trfile").after("<tr><td></td><td><input readonly='readonly' style='border: 0px' name='upfilespath' value='"+data.filepath+"'></input><button onclick='del(this)'>删除</button><br></td></tr>")

                },
                error: function (data, status, e)//服务器响应失败处理函数
                {
                    alert("错误:" + e + data);
                }
            });
            return false;  //组织表单提交，不提交
        }

        //删除不想要的附件
        function del(th) {
            var dt = $(th);
            dt.prev("input").parent("td").parent("tr").remove();  //删除同级的上一个标签
            dt.remove(); //删除当前的标签
        }


    </script>
</head>
<body>

<div class="container-fluid">
    <form action="<%=path%>/inserttenderingproj" method="post">
        <table class="table table-bordered">
            <tr>
                <td>招标类型</td>
                <td><select id="tenderingtypeid" name="tenderingtypeid"></select></td>
            </tr>
            <tr>
                <td>招标标题</td>
                <td><input name="tenderingprjtitle"></td>
            </tr>
            <tr>
                <td>招标内容</td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td><textarea name="tenderingprjbody" style="width: 150px;height: 100px"></textarea></td>
            </tr>
            <tr>
                <td>截止时间</td>
                <td><input type="date" name="supplierendtime"></td>
            </tr>
            <tr>
                <td>开标时间</td>
                <td><input type="date" name="opentime"></td>
            </tr>
            <tr id="trfile">
                <td>招标附件</td>
                <%--id="uploadfiles",通过id注册onchange事件--%>
                <td><input type="file" id="uploadfiles" name="uploadfiles" onchange="ajaxFileUpload()">
                </td>
                <div id="filediv"></div>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
