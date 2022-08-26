<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>FileUpload</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/files/uploading" method="post" enctype="multipart/form-data">
    username: <input type="text" name="username"/><br/>
    photo: <input type="file" name="photo"/><br/>
    <input type="submit" value="upload"/>
</form>
</body>
</html>