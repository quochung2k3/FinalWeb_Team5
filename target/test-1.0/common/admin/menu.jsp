<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<c:url value="/admin-home"/>">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Super Admin</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">


    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
           aria-expanded="true" aria-controls="collapseTwo">
            <i style="font-size: 20px;" class="fa-solid fa-shop"></i>
            <span>Quản lý sản phẩm</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Loại sản phẩm</h6>
                <a class="collapse-item" href="<c:url value="/admin-qlbv"/>">Mỹ phẩm</a>
                <a class="collapse-item" href="cards.html">Nước hoa</a>
                <a class="collapse-item" href="#">Mặt nạ</a>
                <a class="collapse-item" href="#">ALL</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
           aria-expanded="true" aria-controls="collapseUtilities">
            <i style="font-size: 20px;" class="fa-solid fa-hand-holding-dollar"></i>
            <span>Quản lý doanh thu</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
             data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <a class="collapse-item" href="utilities-color.html">Chi nhánh Q1</a>
                <a class="collapse-item" href="utilities-border.html">Chi nhánh Q9</a>
            </div>
        </div>
    </li>

<%--    Quản lý khách hàng--%>
    <li class="nav-item">
        <a class="nav-link collapsed" href="<c:url value="/admin-ql-customer"/>">
            <i style="font-size: 20px;" class="fa-solid fa-person"></i>
            <span>Quản lý khách hàng</span>
        </a>
    </li>

    <%--    Quản lý hóa đơn--%>
    <li class="nav-item">
        <a class="nav-link collapsed">
            <i style="font-size: 20px;" class="fa-solid fa-file-invoice-dollar"></i>
            <span>Quản lý hóa đơn</span>
        </a>
    </li>

    <%--    Quản lý tài khoản--%>
    <li class="nav-item">
        <a class="nav-link collapsed" href="<c:url value="/admin-ql-account"/>">
            <i style="font-size: 20px;" class="fa-solid fa-users"></i>
            <span>Quản lý tài khoản</span>
        </a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">


    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>
</ul>
<!-- End of Sidebar -->