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
                        <h2>Order <b>Details</b></h2>
                    </div>
                </div>
            </div>
            <div class="table-filter">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="show-entries">
                            <span>Show</span>
                            <select class="form-control">
                                <option>5</option>
                                <option>10</option>
                                <option>15</option>
                                <option>20</option>
                            </select>
                            <span>entries</span>
                        </div>
                    </div>
                    <div class="col-sm-9">
                        <button type="button" class="btn btn-primary"><i class="fa fa-search"></i></button>
                        <div class="filter-group">
                            <label>Bill Code</label>
                            <input type="text" class="form-control">
                        </div>
                        <div class="filter-group">
                            <label>Branch</label>
                            <select class="form-control">
                                <option>All</option>
                                <option>CN01</option>
                                <option>CN02</option>
                                <option>CN03</option>
                            </select>
                        </div>
<%--                        <div class="filter-group">--%>
<%--                            <label>Date</label>--%>
<%--                            <select class="form-control">--%>
<%--                                <option>All</option>--%>
<%--                                <option>Active</option>--%>
<%--                                <option>Disable</option>--%>
<%--                            </select>--%>
<%--                        </div>--%>
                        <span class="filter-icon"><i class="fa fa-filter"></i></span>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Mã hóa đơn</th>
                    <th>Ngày in</th>
                    <th>Mã khách hàng</th>
                    <th>Tổng tiền</th>
                    <th>Tiền đã nhận</th>
                    <th>Tiền thừa</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var = "item" items = "${listBill}">
                    <tr>
                        <td>${item.maHD}</td>
                            <%--                            <td><a href="#"><img src="/examples/images/avatar/1.jpg" class="avatar" alt="Avatar">${item.userName}</a></td>--%>
                        <td>${item.ngayIn}</td>
                        <td>${item.maKH}</td>
                        <td>${item.tongTien}</td>
                        <td>${item.tienDaNhan}</td>
                        <td>${item.tienThoi}</td>
                        <td style="
                                            display: flex;
                                            justify-content: space-between;
                                            align-items: center;
                                        ">
                            <a href="admin-bill-details?mahd=${item.maHD}" class="settings" data-toggle="tooltip">Xem chi tiết</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="clearfix">
                <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                    <li class="page-item active"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                    <li class="page-item"><a href="#" class="page-link">6</a></li>
                    <li class="page-item"><a href="#" class="page-link">7</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
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
        window.location.href = "admin-delete?id="+itemId;
    }
</script>
<script>
    if ("${note}" != "") {
        alert("${note}");
    }
</script>
</body>