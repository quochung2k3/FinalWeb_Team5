<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<body>
<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100" style="height: 70% !important;">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Admin update</p>

                                <form action="admin-update" class="mx-1 mx-md-4" method="post">
                                    <p style="margin-left: 50px; margin-bottom: 2px;">Fullname</p>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div style="border: 1px solid #ccc; border-radius: 10px" class="form-outline flex-fill mb-0">
                                            <input placeholder="fullname" value="${account.fullName}" name="fullname" type="text" class="form-control" required>
                                        </div>
                                    </div>
                                    <p style="margin-left: 50px; margin-bottom: 2px;">Username</p>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div style="border: 1px solid #ccc; border-radius: 10px" class="form-outline flex-fill mb-0">
                                            <input placeholder="username" value="${account.userName}" type="email" id="form3Example3c" class="form-control" required disabled>
                                            <input type="hidden" name="username" value="${account.userName}">
                                        </div>
                                    </div>
                                    <p style="margin-left: 50px; margin-bottom: 2px;">Password</p>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div style="border: 1px solid #ccc; border-radius: 10px" class="form-outline flex-fill mb-0">
                                            <input placeholder="password" value="${account.passWord}" name="password" type="text" id="form3Example4c" class="form-control" required>
                                        </div>
                                    </div>
                                    <p style="margin-left: 50px; margin-bottom: 2px;">RoleId</p>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i style="font-size: 20px" class="fa-solid fa-user-tie me-3 fa-fw"></i>
<%--                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>--%>
                                        <div style="border: 1px solid #ccc; border-radius: 10px" class="form-outline flex-fill mb-0">
                                            <input placeholder="roleid" value="${account.roleId}" name="roleid" type="text" id="form3Example5c" class="form-control" required>
                                        </div>
                                    </div>

                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">Update</button>
                                    </div>
                                </form>

                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                     class="img-fluid" alt="Sample image">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    if ("${note}" != "") {
        alert("${note}");
        ${node} = "";
    }
</script>
</body>