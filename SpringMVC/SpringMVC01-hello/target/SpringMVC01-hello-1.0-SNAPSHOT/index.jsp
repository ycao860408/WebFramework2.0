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
<a href="${pageContext.request.contextPath}/hello">springmvc's hello request</a><br/>
<a href="${pageContext.request.contextPath}/sss">This is a array path!</a>
<form action="${pageContext.request.getContextPath()}/param7" method="post">
    id:<input type="text" name="id"/><br/>
    username: <input type="text" name="name"/> <br/>
    phone: <input type="text" name="phone"/> <br/>
    age: <input type="text" name="age"/> <br/>
    carName: <input type="text" name="car.type"/><br/>
    carNo: <input type="text" name="car.carNo"/> <br/>

    <input type="submit" value="提交"/>
</form>
</body>
</html>