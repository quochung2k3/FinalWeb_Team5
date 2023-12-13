<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<section class="container-fluid p-4">
    <div class="row ">
        <div class="col-lg-12 col-md-12 col-12">
            <!-- Page header -->
            <div class="border-bottom pb-3 mb-3 ">
                <div class="mb-2 mb-lg-0">
                    <h1 class="mb-0 h2 fw-bold">Order History </h1>
                </div>
            </div>
        </div>
    </div>
    <!-- row -->
    <div class="row">
        <div class="col-xxl-8 col-12">
            <!-- card -->
            <div class="card">
                <!-- card body-->
                <div class="card-body">
                    <div class="mb-6">
                        <h4 class="mb-0">Your Order</h4>
                        <p>Check the status of recent orders, manage returns, and discover similar products.</p>
                    </div>
                    <c:forEach var = "item" items = "${listBill}">
                        <div class="mb-8">
                            <!-- text -->
                            <div class="border-bottom mb-3 pb-3 d-lg-flex align-items-center justify-content-between ">
                                <div class="d-flex align-items-center justify-content-between">
                                    <h5 class="mb-0">Order #${item.maHD}</h5>
                                </div>
                                <div class="d-flex align-items-center justify-content-between">
                                    <!-- link -->
                                    <a href="" class="ms-6 ">Date: ${item.ngayIn}</a>
                                </div>
                                <div class="d-flex align-items-center justify-content-between">
                                    <!-- link -->
                                    <a href="admin-bill-details?mahd=${item.maHD}" class="ms-6 ">View Invoice</a>
                                </div>
                            </div>
                            <hr class="my-3">
                            <!-- row -->
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>