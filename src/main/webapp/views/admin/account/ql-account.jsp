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
                        <div class="col-sm-8">
                            <a href="<c:url value="/admin-add"/>" class="btn btn-primary"><span>Add Account</span></a>
<%--                            <a href="#" class="btn btn-secondary"><i class="material-icons">&#xE24D;</i> <span>Export to Excel</span></a>--%>
                        </div>
                    </div>
                </div>
                <div class="table-filter">
                    <div class="row">
                        <div class="col-sm-3"></div>
                            <div class="col-sm-9">
                                <form action="admin-ql-account" method="get">
                                    <button type="submit" class="btn btn-primary">RESET</button>
                                </form>
                                <form id="searchForm" action="admin-account-search" method="get">
                                    <button type="button" class="btn btn-primary" onclick="searchAndUpdateTable()"><i class="fa fa-search"></i></button>
                                <div class="filter-group">
                                    <label>Name</label>
                                    <input name="username" type="text" class="form-control">
                                    <c:set var="username" value="${param.username}" />
                                </div>
                                <div class="filter-group">
                                    <label>Role name</label>
                                    <select name="roleName" class="form-control">
                                        <option>All</option>
                                        <option>Admin</option>
                                        <option>Customer</option>
                                    </select>
                                    <c:set var="roleName" value="${param.roleName}" />
                                </div>
                                <div class="filter-group">
                                    <label>Status</label>
                                    <select name="status" class="form-control">
                                        <option>All</option>
                                        <option>Active</option>
                                        <option>Disable</option>
                                    </select>
                                    <c:set var="status" value="${param.status}" />
                                </div>
                                <span class="filter-icon"><i class="fa fa-filter"></i></span>
                                </form>
                            </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Role</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody id="tableBody">
                        <c:forEach var = "item" items = "${listAccount}">
                            <tr>
                                <td>${item.id}</td>
    <%--                            <td><a href="#"><img src="/examples/images/avatar/1.jpg" class="avatar" alt="Avatar">${item.userName}</a></td>--%>
                                <td>${item.userName}</td>
                                <td>${item.passWord}</td>
                                <td>${item.roleId}</td>
                                <td><span class="status text-success">&bull;</span>${item.status}</td>
                                <td style="
                                                display: flex;
                                                justify-content: space-between;
                                                align-items: center;
                                            ">
                                    <a href="admin-update?username=${item.userName}" class="settings" title="Settings" data-toggle="tooltip"><i class="material-icons">&#xE8B8;</i></a>
                                    <a href="admin-delete?id=${item.id}" class="delete trigger-btn" title="Delete" data-item-id="${item.id}" onclick="openModal(event)"><i class="material-icons">&#xE5C9;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix" id="partialReloadDiv">
                    <div class="hint-text">Showing <b>${num2}</b> out of <b>${numOfAccount}</b> entries</div>
                    <ul class="pagination">
                        <c:choose>
                            <c:when test="${not empty username or not empty roleName or not empty status}">
                                <li class="page-item"><a class="page-link" href="admin-account-search?index=1&username=${param.username}&roleName=${param.roleName}&status=${param.status}" ${index==1 ? "style=\"color: red;\"" : ""}>1</a></li>
                                <c:forEach begin = "2" end = "${numpage}" var = "i">
                                    <li class="page-item"><a class="page-link" href="admin-account-search?index=${i}&username=${param.username}&roleName=${param.roleName}&status=${param.status}" ${index==i ? "style=\"color: red;\"" : ""}>${i}</a></li>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link" href="admin-ql-account?index=1" ${index==1 ? "style=\"color: red;\"" : ""}>1</a></li>
                                <c:forEach begin = "2" end = "${numpage}" var = "i">
                                    <li class="page-item"><a class="page-link" href="admin-ql-account?index=${i}" ${index==i ? "style=\"color: red;\"" : ""}>${i}</a></li>
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

    <script>
        function updateTableContent() {
            $.ajax({
                url: 'admin-account-search', // Specify the URL of your controller
                type: 'GET',
                dataType: 'html',
                success: function (data) {
                    $('#tableBody').html($(data).find('#tableBody').html());
                    $('#partialReloadDiv').html($(data).find('#partialReloadDiv').html());
                },
            });
        }

        // Call updateTableContent function when the page loads or when needed
        $(document).ready(function () {
            updateTableContent();
        });
    </script>

    <script>
        function searchAndUpdateTable() {
            $.ajax({
                url: $('#searchForm').attr('action'), // Use the form action URL
                type: 'GET',
                data: $('#searchForm').serialize(), // Serialize the form data
                dataType: 'html',
                success: function (data) {
                    // Update the content of the table and pagination
                    $('#tableBody').html($(data).find('#tableBody').html());
                    $('#partialReloadDiv').html($(data).find('#partialReloadDiv').html());
                },
            });
        }
    </script>

</body>