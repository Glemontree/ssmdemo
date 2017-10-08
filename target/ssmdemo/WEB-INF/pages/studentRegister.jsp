<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/7
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="studentRegisterSuccess" method="post">
        username: <input type="text" name="name"/>
        <br>
        password: <input type="password" name="password"/>
        <br>
        sex: <input type="text" name="sex"/>
        <br>
        student_id: <input type="text" name="studentId"/>
        <br>
        className: <input type="text" name="clazz.name"/>
        <br>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>
