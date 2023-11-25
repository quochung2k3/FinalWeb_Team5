<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/23/2023
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="admin-update" method="post">
        <c:forEach var = "item" items = "${news}">
            <label>Nhap ten bai viet: </label>
            <input type="text" name="newsName" value="${item.titile}">

            <label>Nhap mo ta ngan: </label>
            <input type="text" name="shortDescription" value="${item.shortDescription}">

            <label>Nhap noi dung: </label>
            <input type="text" name="content" value="${item.content}">

            <label>choose</label>
            <input type="file" name="content" value="${item.cover_image}">

            <button type="submit">Update News</button>

        </c:forEach>
    </form>
</body>
</html>
