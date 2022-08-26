<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/8/5
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>ajax</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.7.2.js"></script>
    <script>
        $(function(){
            $("#sendOne").click(function() {
                var person = {"id" : 1, "name" : "Peter"};
                $.ajax(
                    {
                        url: "${pageContext.request.contextPath}/persons/4",
                        data: JSON.stringify(person),
                        type: "POST",
                        success: function(obj){
                            console.log(obj);
                        },
                        dataType: "JSON",
                        contentType: "application/json"
                    }
                )
            })

            $("#sendMany").click(function() {
                var persons = [{"id" : 1, "name" : "Peter"}, {"id":2, "name" : "Stevens"}, {"id" : 3, "name": "John"}]
                $.ajax({
                    url: "${pageContext.request.contextPath}/persons/5",
                    data: JSON.stringify(persons),
                    type: "POST",
                    success: function(obj) {
                        console.log(obj)
                    },
                    dataType: "JSON",
                    contentType: "application/json"
                })
            })
        })
    </script>
</head>
<body>
<a href="#" id="sendOne">send a person data</a> <br/>
<a href="#" id="sendMany">send many persons data</a> <br/>
</body>
</html>
