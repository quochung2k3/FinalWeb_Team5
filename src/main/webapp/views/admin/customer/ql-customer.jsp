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
                        <h2>Customer <b>Details</b></h2>
                    </div>
                    <div class="col-sm-8">
                        <a href="<c:url value="/admin-customer-add"/>" class="btn btn-primary"><span>Add Customer</span></a>
                        <a href="#" class="btn btn-secondary"><i class="material-icons">&#xE24D;</i> <span>Export to Excel</span></a>
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
                        <form action="admin-customer-search" method="get">
                            <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>
                            <div class="filter-group">
                                <label>Tên</label>
                                <input name="name" type="text" class="form-control">
                            </div>
                            <div class="filter-group">
                                <label>Tổng tiền đã mua</label>
                                <select name="total" class="form-control">
                                    <option>ALL</option>
                                    <option>Tăng dần</option>
                                    <option>Giảm dần</option>
                                </select>
                            </div>
                            <span class="filter-icon"><i class="fa fa-filter"></i></span>
                        </form>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Mã khách hàng</th>
                    <th>Tên</th>
                    <th>Ngày Sinh</th>
                    <th>SĐT</th>
                    <th>Tổng tiền đã mua</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var = "item" items = "${listCustomer}">
                    <tr>
                        <td>${item.maKh}</td>
                        <td>${item.ten}</td>
                        <td>${item.ngaySinh}</td>
                        <td>${item.sdt}</td>
                        <td>${item.tongTienDaMua}</td>
                        <td style="
                                            display: flex;
                                            justify-content: space-between;
                                            align-items: center;
                                        ">
                                <a href="admin-customer-update?maKh=${item.maKh}" class="settings" title="Settings" data-toggle="tooltip"><i class="material-icons">&#xE8B8;</i></a>
                                <a href="admin-bill-details?mahd=${item.maKh}" class="settings" title="Purchase History" data-toggle="tooltip"><i class="material-icons">&#xE86A;</i></a>
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
        window.location.href = "admin-customer-delete?maKh="+itemId;
    }
</script>
</body>