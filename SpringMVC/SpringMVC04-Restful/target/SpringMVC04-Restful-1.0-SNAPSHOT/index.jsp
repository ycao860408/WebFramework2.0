<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%--get method--%>
<a href="${pageContext.request.contextPath}/books">查詢全部圖書</a><br/>
<a href="${pageContext.request.contextPath}/books/1/xiaoming">根據id查詢一個圖書</a><br/>
<%--post--%>
<form action="${pageContext.request.contextPath}/books" method="post">
    name <input type="text" name="name"/><br/>
    author<input type="text" name="author"/><br/>
    price <input type="text" name="price"/><br/>
    <input type="submit" value="提交"/>
</form>
<%--put--%>
<form action="${pageContext.request.contextPath}/books" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    name <input type="text" name="name"/><br/>
    author<input type="text" name="author"/><br/>
    price <input type="text" name="price"/><br/>
    <input type="submit" value="更新"/>
</form>
<%--Delete--%>
<form action="${pageContext.request.contextPath}/books" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    name <input type="text" name="name"/><br/>
    <input type="submit" value="刪除"/>
</form>
</body>
</html>