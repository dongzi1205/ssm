<%--
  Created by IntelliJ IDEA.
  User: YQD
  Date: 2019/11/26
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
String path=request.getContextPath();//动态获取项目路径名称
%>
<html>
<head>
    <title>主页面</title>
    <link rel="icon" href="/images/tu_biao.ico" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/aftermain.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.ztree.core-3.5.min.js"></script>

</head>
<SCRIPT type="text/javascript">
    <!--
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onClick: onClick
        }

    };
    // //isParent:true
    // var zNodes =[
    //     { id:1, pId:0, name:"父节点1 - 展aaaa开", open:true},
    //     { id:2, pId:1, name:"父节点11 - 折叠",url:"","target":"af"},
    //     { id:3, pId:3, name:"叶子节点222"},
    //     { id:4, pId:3, name:"叶子节点1111"},
    //     { id:5, pId:5, name:"叶子节点112"},
    //     { id:6, pId:5, name:"叶子节点113"}
    // ];
    var zNodes=${userMenuJsonString}

    $(document).ready(function(){
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    });


    function onClick(e,treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.expandNode(treeNode, null, null, null, true);

    }

    //-->
</SCRIPT>

<style type="text/css">
    #treeDemo {
        background-color: #DDE4EE;
    }
    .ztree li span.button.switch {
        width: 18px;
        height: 18px;
        display:none;
    }

    .ztree li a {
        padding: 0px 3px 0 0;
        border: 1px #fff solid;
    }
    .ztree li a.curSelectedNode {
        padding-top: 0px;
        background: #EBEDF2 url(../../images/tree/button.png) repeat-x 0 0;
        color: black;
        border: 1px #A9ACB5 solid;
        opacity: 0.8;
    }

    #treeDemo a {
        height: 21px;
        line-height: 19px;
        vertical-align: middle;
    }

    #treeDemo a span {
        font-size: 13px;
        vertical-align: middle;
    }
</style>
<body>
<div class="maintop">
    <ul class="commonul menuul">
        <li class="commonli m1"><a href="<%=path%>/userlogin.jsp"><font color="white"> 首页</font></a></li>
        <li class="commonli m1">系统</li>
        <li class="commonli m1">用户</li>
        <li class="commonli m1">任务</li>
    </ul>

</div>
<div class="mainleft">
    <%--树形菜单--%>
        <div class="zTreeDemoBackground left">
            <ul id="treeDemo" class="ztree"></ul>
        </div>

</div>
<div class="mainright">

    <iframe name="mainiframe" src="" width="100%" height="99%" frameborder="0px" style="background: #FFFFFF;"></iframe>
</div>

</body>
</html>
