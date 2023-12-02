<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shop Homepage - Start Bootstrap Template</title>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href=<c:url value="/template/web/font/fontawesome-free-6.4.2-web/css/all.css" />  rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
    <link href=<c:url value="/template/web/css/footer.css" />  rel="stylesheet" />
    <link href=<c:url value="/template/web/css/main.css" />  rel="stylesheet" />
    <link href=<c:url value="/template/web/css/base.css" />  rel="stylesheet" />
    <link href=<c:url value="/template/web/css/styles.css"/> rel="stylesheet" />
</head>
<body>
<!-- Header-->
    <%@ include file="/common/web/header.jsp"%>

    <div>
        <dec:body/>
    </div>

    <!-- Footer-->
    <%@ include file="/common/web/footer.jsp"%>

<!-- Core theme JS-->
<script src="<c:url value='/template/web/js/openModal.js'/>"></script>
</body>
</html>