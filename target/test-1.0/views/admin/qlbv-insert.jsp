<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2023
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="admin-insert" method="post">
            <label>Nhap ten bai viet: </label>
            <input type="text" name="newsName">

            <label>Nhap mo ta ngan: </label>
            <input type="text" name="shortDescription">

            <label>Nhap noi dung: </label>
            <input type="text" name="content">

            <label>Nhap loai bai viet: </label>
            <input type="text" name="categoryId">

            <button type="submit">Insert News</button>
    </form>
</body>
</html>
