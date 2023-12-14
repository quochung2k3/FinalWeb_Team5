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
                                <label>Ngày kết thúc</label>
                                <input style="width: 150px;" name="ngayKetThuc" type="date" class="form-control">
                                <c:set var="ngayKetThuc" value="${param.ngayKetThuc}" />
                            </div>
                            <div class="filter-group">
                                <label>Ngày bắt đầu</label>
                                <input style="width: 150px;" name="ngayBatDau" type="date" class="form-control">
                                <c:set var="ngayBatDau" value="${param.ngayBatDau}" />
                            </div>
                            <span class="filter-icon"><i class="fa fa-filter"></i></span>
                        </form>
                    </div>
                </div>
            </div>
            <div class="scroll-bar">
                <div class="table-responsive" style="overflow-x: scroll; height: 480px;">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>Mã hóa đơn</th>
                            <th>Ngày in</th>
                            <th>Mã khách hàng</th>
                            <th>Mã chi nhánh</th>
                            <th>Tổng tiền hóa đơn</th>
                        </tr>
                        </thead>
                        <tbody id="tableBody">
                        <c:forEach var = "item" items = "${listBill}">
                            <tr>
                                <td>${item.maHD}</td>
                                    <%--                            <td><a href="#"><img src="/examples/images/avatar/1.jpg" class="avatar" alt="Avatar">${item.userName}</a></td>--%>
                                <td>${item.ngayIn}</td>
                                <td>${item.maKH}</td>
                                <td>${item.maChiNhanh}</td>
                                <td>${item.tongTien}</td>
                            </tr>
                            <c:set var="totalPrice" value="${(totalPrice ne null) ? totalPrice + item.tongTien : item.tongTien}" />
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
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
<script>
    function searchAndUpdateTable() {
        $.ajax({
            url: $('#searchForm').attr('action'), // Use the form action URL
            type: 'GET',
            data: $('#searchForm').serialize(), // Serialize the form data
            dataType: 'html',
            success: function (data) {
                $('#tableBody').html($(data).find('#tableBody').html());
                $('#partialReloadDiv').html($(data).find('#partialReloadDiv').html());
            },
        });
    }
</script>

<script>
    function searchAndUpdateTableByPaging(event, i) {
        var url = "#linkPagging"+i.toString();
        $('a.page-link').removeClass('active');
        // Thêm lớp 'active' vào thẻ a được click
        $(url).addClass('active');
        event.preventDefault();
        $.ajax({
            url: $(url).attr('href'), // Use the form action URL
            type: 'GET',
            dataType: 'html',
            success: function (data) {
                $('#tableBody').html($(data).find('#tableBody').html());
                $('.hint-text').html($(data).find('.hint-text').html());
            },
        });
    }
</script>
</body>