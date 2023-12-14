<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<section class="h-100 h-custom" style="background-color: #eee;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card">
                    <div class="card-body p-4">
                        <div class="row">
                            <div style="font-size: 16px" class="col-lg-7">
                                <h5 class="mb-3"><a href="<c:url value="/user-home"/>" class="text-body"><i
                                        class="fas fa-long-arrow-alt-left me-2"></i>Continue shopping</a></h5>
                                <hr>

                                <div class="d-flex justify-content-between align-items-center mb-4">
                                    <div>
                                        <p class="mb-1">Shopping cart</p>
                                        <p class="mb-0">You have ${listCart.size()} items in your cart</p>
                                    </div>
                                    <div>
                                        <p class="mb-0"><span class="text-muted">Sort by:</span>
                                            <a href="#!" class="text-body">price
                                                <i class="fas fa-angle-down mt-1"></i>
                                            </a>
                                        </p>
                                    </div>
                                </div>
                                <c:forEach var="item" items="${listCart}">
                                    <div class="card mb-3">
                                        <div class="card-body">
                                            <div class="d-flex justify-content-between">
                                                <div class="d-flex flex-row align-items-center">
                                                    <div>
                                                        <img
                                                                src="${item.getImage()}"
                                                                style="width: 100px;">
                                                    </div>
                                                    <div class="ms-3" style="width: 400px;">
                                                        <h5>${item.tenSP}</h5>
                                                        <p class="small mb-0" style="font-size: 1rem;text-align: justify;">${item.description}</p>
                                                    </div>
                                                </div>
                                                <div class="d-flex flex-row align-items-center">
                                                    <div style="width: 50px;">
                                                        <h5 class="fw-normal mb-0">${item.soLuong}</h5>
                                                    </div>
                                                    <div style="width: 80px;">
                                                        <h5 class="mb-0">${item.soLuong*item.gia}$</h5>
                                                        <c:set var="totalPrice"
                                                               value="${(totalPrice ne null) ? totalPrice + item.soLuong*item.gia : item.soLuong*item.gia}"/>
                                                    </div>
                                                    <a type="button"
                                                       style="color: #cecece;" onclick="confirmDelete(${item.getMaSanPham()})"><i class="fas fa-trash-alt"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="col-lg-5">

                                <div style="font-size: 14px" class="card bg-primary text-white rounded-3">
                                    <div style="height: 640px" class="card-body">
                                        <div class="d-flex justify-content-between align-items-center mb-4">
                                            <h5 class="mb-0">Card details</h5>
                                            <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp"
                                                 class="img-fluid rounded-3" style="width: 45px;" alt="Avatar">
                                        </div>

                                        <p class="small mb-2">Card type</p>
                                        <a href="#!" type="submit" class="text-white"><i
                                                class="fab fa-cc-mastercard fa-2x me-2"></i></a>
                                        <a href="#!" type="submit" class="text-white"><i
                                                class="fab fa-cc-visa fa-2x me-2"></i></a>
                                        <a href="#!" type="submit" class="text-white"><i
                                                class="fab fa-cc-amex fa-2x me-2"></i></a>
                                        <a href="#!" type="submit" class="text-white"><i
                                                class="fab fa-cc-paypal fa-2x"></i></a>
                                        <form action="user-check-voucher" class="mt-4" method="get">
                                            <div class="form-outline form-white mb-4">
                                                <span style="padding-left: 5px;">Cardholder's Name</span>
                                                <input type="text" id="typeName" class="form-control form-control-lg"
                                                       siez="17"
                                                       placeholder="Cardholder's Name"
                                                       style="border-radius: 10px;border: 1px solid #ccc;font-size: 14px;height: 40px;"/>
                                                <%--<label class="form-label" for="typeName">Cardholder's Name</label>--%>
                                            </div>

                                            <div class="form-outline form-white mb-4">
                                                <span style="padding-left: 5px;">Card Number</span>
                                                <input type="text" id="" class="form-control form-control-lg" siez="17"
                                                       placeholder="1234 5678 9012 3457" minlength="19" maxlength="19"
                                                       style="border-radius: 10px;border: 1px solid #ccc;font-size: 14px;height: 40px;"/>
                                                <%-- <label class="form-label" for="typeText">Card Number</label>--%>
                                            </div>

                                            <div class="row mb-4">
                                                <div class="col-md-6">
                                                    <div class="form-outline form-white">
                                                        <span style="padding-left: 5px;">Expiration</span>
                                                        <input type="text"
                                                               class="form-control form-control-lg"
                                                               placeholder="MM/YYYY" size="7" minlength="7"
                                                               maxlength="7"
                                                               style="border-radius: 10px;border: 1px solid #ccc;font-size: 14px;height: 40px;"/>
                                                        <%-- <label class="form-label" for="typeExp">Expiration</label>--%>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-outline form-white">
                                                        <span style="padding-left: 5px;">Cvv</span>
                                                        <input type="password"
                                                               class="form-control form-control-lg"
                                                               placeholder="&#9679;&#9679;&#9679;" size="1"
                                                               minlength="3" maxlength="3"
                                                               style="border-radius: 10px;border: 1px solid #ccc;font-size: 14px;height: 40px;"/>
                                                        <%--                                                        <label class="form-label" for="typeText">Cvv</label>--%>
                                                    </div>
                                                </div>
                                                <div style="display: flex; align-items: center;">
                                                        <div style="margin-top: 10px;" class="col-md-6">
                                                            <div class="form-outline form-white">
                                                                <span style="padding-left: 5px;">Voucher Code</span>
                                                                <input value="${maVCController}" name="maVC" type="text"
                                                                       class="form-control form-control-lg"
                                                                       style="border-radius: 10px;border: 1px solid #ccc;font-size: 14px;height: 40px;"/>
                                                                <c:set var="maVC" value="${maVCController}"/>
                                                            </div>
                                                        </div>
                                                        <button type="submit" style="margin-top: 30px;margin-left: 10px;height: 40px;" class="header__search-btn">
                                                            <i class="header__search-btn-icon fa-solid fa-check"></i>
                                                        </button>
                                                            <p>${note}</p>
                                                </div>
                                            </div>

                                        </form>
                                        <form action="user-solve-pay" method="post" id="myForm">
                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between">
                                                <p class="mb-2">Subtotal</p>
                                                <p class="mb-2">${totalPrice}$</p>
                                            </div>

                                            <div class="d-flex justify-content-between">
                                                <p class="mb-2">Discount</p>
                                                <c:set var="discount" value="${totalPrice * discountController / 100}"/>
                                                <p class="mb-2">${fn:substringBefore(discount, '.')}$</p>
                                            </div>

                                            <div class="d-flex justify-content-between mb-4">
                                                <p class="mb-2">Total(Incl. taxes)</p>
                                                <c:set var="total" value="${totalPrice - discount}"/>
                                                <p class="mb-2">${fn:substringBefore(total, '.')}$</p>
                                            </div>

                                            <button style="padding: 0px 32px;font-size: 14px;height: 50px;" type="button" onclick="confirmPay()"
                                                    class="btn btn-info btn-block btn-lg">
                                                <div class="d-flex justify-content-between">
                                                    <span>${total}</span>
                                                    <input type="hidden" name="totalController" value="${total}">
                                                    <input type="hidden" name="maVCController" value="${maVC}">
                                                    <span>Checkout <i class="fas fa-long-arrow-alt-right ms-2"></i></span>
                                                </div>
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    function confirmDelete(productId) {
        // Sử dụng hàm confirm() để hiển thị hộp thoại đồng ý/hủy bỏ
        var result = confirm("Bạn có chắc muốn xóa không?");

        // Nếu người dùng nhấn "OK" (đồng ý), thực hiện xóa
        if (result) {
            window.location.href= "user-delete-cart?pid="+productId;
            alert("Đã xóa!");
        } else {
            alert("Đã hủy bỏ xóa.");
        }
    }
</script>

<script>
    function confirmPay() {
        // Sử dụng hàm confirm() để hiển thị hộp thoại đồng ý/hủy bỏ
        var result = confirm("Đồng ý thanh toán?");
        // Nếu người dùng nhấn "OK" (đồng ý), thực hiện xóa
        if (result) {
            document.getElementById('myForm').submit();
            alert("Thanh toán thành công!");
        } else {
            alert("Đã hủy bỏ thanh toán.");
        }
    }
</script>