<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>图书列表</title>
		<%
			String basePath = request.getScheme() 
								+ "://"
								+ request.getServerName()
								+ ":"
								+ request.getServerPort()
								+ request.getContextPath()
								+ "/";
		%>
		<base href="<%=basePath %>" />
		<style type="text/css">
			table {
				border: 1px blue solid;
				width: 700px;
				border-collapse: collapse;
			}
			td,th{
				border: 1px green solid;
			}
			div.menu {
				width: 700px;
				text-align: right;
			}
		</style>

		<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			$(function() {
				$("a.deleteBook").click(function(){
					var parent = $(this).parent().parent().find("td:first");
					var name = parent.text()
					if (confirm("你確定要刪除【" + name + "】麽？")) {
						$(this).prev("form").submit()
					}
					return false;
				})
			})
		</script>
	</head>
	<body>
		<center>
			<h2>图书列表管理页面</h2>
			<div class="menu"><a href="book/bookEdit.jsp">添加图书</a></div>
			<table>
				<tr bgcolor="#FF8888">
					<th>书名</th>
					<th>作者</th>
					<th>价格</th>
					<th>销量</th>
					<th>库存</th>
					<th>操作</th>
				</tr>

				<c:forEach items="${requestScope.books}" var="book">
					<tr>
						<td>${book.name}</td>
						<td>${book.author}</td>
						<td>${book.price}</td>
						<td>${book.sales}</td>
						<td>${book.stock}</td>
						<td>
							<form action="books/${book.id}" method="post" class="haha">
								<input type="hidden" name="_method" value="DELETE"/>
							</form>
							<a href="" class ="deleteBook">删除</a>、
							<a href="books/${book.id}">修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</body>
</html>