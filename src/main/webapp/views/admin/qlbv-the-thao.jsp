<%--@elvariable id="loop" type="com.google.protobuf.RepeatedFieldBuilderV3"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/23/2023
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a style="margin-left: 110px; margin-bottom: 20px" href= "admin-insert" class="btn btn-outline-success">Thêm bài viết</a>

    <table class="table">
        <thead>
            <th scope="col">Id</th>
            <th scope="col">Title</th>
            <th scope="col">Content</th>
            <th scope="col">shortDescription</th>
            <th scope="col">Action</th>
        </thead>
        <tbody>
        <c:forEach var = "item" items = "${listNews}">
            <tr>
                <td>${item.id}</td>
                <td>${item.titile}</td>
                <td>${item.content}</td>
                <td>${item.shortDescription}</td>
                <td>
                    <a href="admin-update?id=${item.id}">Update</a>
                    <span style="margin: 0 5px 0 5px">|</span>
                    <a href="admin-delete?id=${item.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <p>Total items: ${fn:length(listNews)}</p>
    </table>
</body>
</html>
