<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-4">
                        <h2>Revenue <b>Details</b></h2>
                    </div>
                </div>
            </div>
            <div class="table-filter">
                <div class="row">
                    <div style="width: 100%;" class="col-sm-12">
                        <form action="admin-ql-revenue" method="get">
                            <button type="submit" class="btn btn-primary">RESET</button>
                        </form>
                        <form id="searchForm" action="admin-revenue-search" method="get">
                            <button type="button" class="btn btn-primary" onclick="searchAndUpdateTable()"><i class="fa fa-search"></i></button>
                            <div class="filter-group">
                                <label>Chi nhánh</label>
                                <select name="maChiNhanh" class="form-control">
                                    <option>ALL</option>
                                    <option>CN01</option>
                                    <option>CN02</option>
                                    <option>CN03</option>
                                    <option>CN04</option>
                                    <option>CN05</option>
                                </select>
                                <c:set var="maChiNhanh" value="${param.maChiNhanh}" />
                            </div>
                            <div class="filter-group">
                                <label>Ngày bắt đầu</label>
                                <input style="width: 150px;" name="ngayIn" type="date" class="form-control">
                                <c:set var="ngayIn" value="${param.ngayIn}" />
                            </div>
                            <div class="filter-group">
                                <label>Ngày kết thúc</label>
                                <input style="width: 150px;" name="ngayIn" type="date" class="form-control">
                                <c:set var="ngayIn" value="${param.ngayIn}" />
                            </div>
                            <span class="filter-icon"><i class="fa fa-filter"></i></span>
                        </form>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Mã hóa đơn</th>
                    <th>Ngày in</th>
                    <th>Tổng tiền hóa đơn</th>
                </tr>
                </thead>
                <tbody id="tableBody">
                <c:forEach var = "item" items = "${listBill}">
                    <tr>
                        <td>${item.maHD}</td>
                            <%--                            <td><a href="#"><img src="/examples/images/avatar/1.jpg" class="avatar" alt="Avatar">${item.userName}</a></td>--%>
                        <td>${item.ngayIn}</td>
                        <td>${item.tongTien}</td>
                    </tr>
                    <c:set var="totalPrice" value="${(totalPrice ne null) ? totalPrice + item.tongTien : item.tongTien}" />
                </c:forEach>
                </tbody>
            </table>
            <div style="margin-top: 36px;" class="filter-group float-lg-right">
                <label style="color: red; font-weight: 700; font-size: 18px;">Tổng doanh thu:</label>
                <input value="${totalPrice}" style="width: 150px;" name="ngayIn" type="text" class="form-control" disabled>
            </div>
        </div>
    </div>
</div>
<div id="myModal" class="modal fade">
    <div class="modal-dialog modal-confirm">
        <div class="modal-content">
            <div class="modal-header justify-content-center">
                <div class="icon-box">
                    <i class="material-icons">&#xE5CD;</i>
                </div>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body text-center">
                <h4>Warning!</h4>
                <p>Are you sure about this action?</p>
                <button type="button" style="background-color: red" class="btn btn-success" data-dismiss="modal">Cancel</button>
                <button type="button" style="background-color: #5ede5e" class="btn btn-success" onclick="confirmAction(currentItemId)">Yes</button>
            </div>
        </div>
    </div>
</div>

<script>
    function openModal(event) {
        // Ngăn chặn hành động mặc định của thẻ <a>
        event.preventDefault();
        currentItemId = $(event.currentTarget).data('item-id');
        console.log(currentItemId);
        // Hiển thị modal
        $('#myModal').modal('show');
    }
    function confirmAction(itemId) {
        // Chuyển hướng đến URL mong muốn
        window.location.href = "admin-product-delete?maSP="+itemId;
    }
</script>
<script>
    if ("${note}" != "") {
        alert("${note}");
        ${node} = "";
    }
</script>
</body>