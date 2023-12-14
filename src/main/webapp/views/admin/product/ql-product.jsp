<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
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
                        <h2>Product <b>Details</b></h2>
                    </div>
                    <div class="col-sm-8">
                        <a href="<c:url value="/admin-product-add"/>"
                           class="btn btn-primary"><span>Add Product</span></a>
                        <a href="#" class="btn btn-secondary"><i class="material-icons">&#xE24D;</i> <span>Export to Excel</span></a>
                    </div>
                </div>
            </div>
            <div class="table-filter">
                <div class="row">
                    <div style="width: 100%;" class="col-sm-12">
                        <form action="admin-ql-product" method="get">
                            <button type="submit" class="btn btn-primary">RESET</button>
                        </form>
                        <form id="searchForm" action="admin-product-search" method="get">
                            <button type="button" class="btn btn-primary" onclick="searchAndUpdateTable()"><i
                                    class="fa fa-search"></i></button>
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
                                <c:set var="maChiNhanh" value="${param.maChiNhanh}"/>
                            </div>
                            <div class="filter-group">
                                <label>Trạng thái</label>
                                <select name="status" class="form-control">
                                    <option>ALL</option>
                                    <option>Còn hàng</option>
                                    <option>Hết hàng</option>
                                </select>
                                <c:set var="status" value="${param.status}"/>
                            </div>
                            <div class="filter-group">
                                <label>Mã sản phẩm</label>
                                <input style="width: 150px;" name="maSP" type="text" class="form-control">
                                <c:set var="maSP" value="${param.maSP}"/>
                            </div>
                            <div class="filter-group">
                                <label>Mã loại phẩm</label>
                                <input style="width: 150px;" name="maLoaiSP" type="text" class="form-control">
                                <c:set var="maLoaiSP" value="${param.maLoaiSP}"/>
                            </div>
                            <span class="filter-icon"><i class="fa fa-filter"></i></span>
                        </form>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Mã sản phẩm</th>
                    <th>Tên sản phẩm</th>
                    <th>Mã loại sản phẩm</th>
                    <th>Giá</th>
                    <th>Mã chi nhánh</th>
                    <th>Trạng thái</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody id="tableBody">
                <c:forEach var="item" items="${listProduct}">
                    <tr>
                        <td>${item.maSp}</td>
                            <%--                            <td><a href="#"><img src="/examples/images/avatar/1.jpg" class="avatar" alt="Avatar">${item.userName}</a></td>--%>
                        <td>${item.tenSP}</td>
                        <td>${item.maLoaiSP}</td>
                        <td>${item.gia}</td>
                        <td>${item.maChiNhanh}</td>
                        <td>${item.trangThai}</td>
                        <td style="
                                            display: flex;
                                            justify-content: space-between;
                                            align-items: center;
                                        ">
                            <a href="admin-product-update?maSP=${item.maSp}" class="settings" title="Settings"
                               data-toggle="tooltip"><i class="material-icons">&#xE8B8;</i></a>
                            <a href="admin-product-delete?maSP=${item.maSp}" class="delete trigger-btn" title="Delete"
                               data-item-id="${item.maSp}" onclick="openModal(event)"><i
                                    class="material-icons">&#xE5C9;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="clearfix" id="partialReloadDiv">
                <div class="hint-text">Showing <b>${num2}</b> out of <b>${numOfAccount}</b> entries</div>
                <ul class="pagination">
                    <c:choose>
                        <c:when test="${not empty maChiNhanh or not empty status or not empty maSP or not empty maLoaiSP}">
                            <li class="page-item"><a id="linkPagging${1}" class="page-link active"
                                                     onclick="searchAndUpdateTableByPaging(event, 1)"
                                                     href="admin-product-search?index=1&maChiNhanh=${param.maChiNhanh}&status=${param.status}&maSP=${param.maSP}&maLoaiSP=${param.maLoaiSP}" ${index==1 ? "style=\"color: red;\"" : ""}>1</a>
                            </li>
                            <c:forEach begin="2" end="${numpage}" var="i">
                                <li class="page-item"><a id="linkPagging${i}" class="page-link"
                                                         onclick="searchAndUpdateTableByPaging(event, ${i})"
                                                         href="admin-product-search?index=${i}&maChiNhanh=${param.maChiNhanh}&status=${param.status}&maSP=${param.maSP}&maLoaiSP=${param.maLoaiSP}" ${index==i ? "style=\"color: red;\"" : ""}>${i}</a>
                                </li>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a id="linkPagging${1}" class="page-link active"
                                                     onclick="searchAndUpdateTableByPaging(event, 1)"
                                                     href="admin-ql-product?index=1">1</a></li>
                            <c:forEach begin="2" end="${numpage}" var="i">
                                <li class="page-item"><a id="linkPagging${i}" class="page-link"
                                                         onclick="searchAndUpdateTableByPaging(event, ${i})"
                                                         href="admin-ql-product?index=${i}">${i}</a></li>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
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
                <button type="button" style="background-color: red" class="btn btn-success" data-dismiss="modal">
                    Cancel
                </button>
                <button type="button" style="background-color: #5ede5e" class="btn btn-success"
                        onclick="confirmAction(currentItemId)">Yes
                </button>
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
        window.location.href = "admin-product-delete?maSP=" + itemId;
    }
</script>
<script>
    if ("${note}" != "") {
        alert("${note}");
        ${node}
        = "";
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
        var url = "#linkPagging" + i.toString();
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