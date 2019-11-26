<%@ page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%--分页后的集合遍历--%>
<c:forEach items="${books}" var="book">
    ${book.id}--${book.bookname}--${book.bookauthor}--${book.bookbz}<br>*******
</c:forEach>
<c:forEach items="${cities}" var="city">
    ${city.id}--${city.cityname}<br>*******
</c:forEach>
<%--使用后台传过来的页面信息的对象PageInfi获取里面的属性值--%>
<a href="/ssm2019_11_21pm/testpage?page=1">首页</a>
<a href="/ssm2019_11_21pm/testpage?page=${pageInfo.prePage}">上一页</a>
<a href="/ssm2019_11_21pm/testpage?page=${pageInfo.nextPage}">下一步</a>
<a href="/ssm2019_11_21pm/testpage?page=${pageInfo.lastPage}">尾页</a><br><br>
<%--遍历页面信息中的页面--%>
<c:forEach items="${pageInfo.navigatepageNums}" var="num">
    <a href="/ssm2019_11_21pm/testpage?page=${num}">${num}</a>
</c:forEach>
</body>
</html>
