<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/8/2
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope</title>
</head>
<body>
data from request field: ${requestScope.name} &nbsp; ${requestScope.age}<br/>
data from session field: ${sessionScope.name} &nbsp; ${sessionScope.age}<br/>
data from applicationContext field: ${applicationScope.name} &nbsp; ${applicationScope.age}<br/>
data from map to request field: ${requestScope.name} &nbsp; ${requestScope.age}<br/>
data from model to request field: ${requestScope.name} &nbsp; ${requestScope.age} <br/>
data from modelMap to request field: ${requestScope.name} &nbsp; ${requestScope.age} <br/>
data from three hidden object: ${requestScope.name} &nbsp; ${requestScope.age} &nbsp; ${requestScope.gender} <br/>
data from the ModelAndView: ${requestScope.name} &nbsp; ${requestScope.age} &nbsp; ${requestScope.gender}<br/>
data synchronized to session field: ${sessionScope.name} &nbsp; ${sessionScope.age} <br/>
</body>
</html>
