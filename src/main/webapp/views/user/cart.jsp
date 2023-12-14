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
                                                                src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img1.webp"
                                                                class="img-fluid rounded-3" alt="Shopping item"
                                                                style="width: 65px;">
                                                    </div>
                                                    <div class="ms-3">
                                                        <h5>${item.tenSP}</h5>
                                                        <p class="small mb-0">${item.description}</p>
                                                    </div>
                                                </div>
                                                <div class="d-flex flex-row align-items-center">
                                                    <div style="width: 50px;">
                                                        <h5 class="fw-normal mb-0">${item.soLuong}</h5>
                                                    </div>
                                                    <div style="width: 80px;">
                                                        <h5 class="mb-0">${item.soLuong*item.gia}</h5>
                                                        <c:set var="totalPrice"
                                                               value="${(totalPrice ne null) ? totalPrice + item.soLuong*item.gia : item.soLuong*item.gia}"/>
                                                    </div>
                                                    <a href="user-delete-cart?maSP=${item.tenSP}"
                                                       style="color: #cecece;"><i class="fas fa-trash-alt"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="col-lg-5">

                                <div style="font-size: 14px" class="card bg-primary text-white rounded-3">
                                    <div style="height: 560px" class="card-body">
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

                                        <form class="mt-4">
                                            <div class="form-outline form-white mb-4">
                                                <span style="padding-left: 5px;">Cardholder's Name</span>
                                                <input type="text" id="typeName" class="form-control form-control-lg"
                                                       siez="17"
                                                       placeholder="Cardholder's Name"
                                                       style="border-radius: 10px;border: 1px solid #ccc;font-size: 14px;height: 40px;"/>
                                                <%--                                                <label class="form-label" for="typeName">Cardholder's Name</label>--%>
                                            </div>

                                            <div class="form-outline form-white mb-4">
                                                <span style="padding-left: 5px;">Card Number</span>
                                                <input type="text" id="" class="form-control form-control-lg" siez="17"
                                                       placeholder="1234 5678 9012 3457" minlength="19" maxlength="19"
                                                       style="border-radius: 10px;border: 1px solid #ccc;font-size: 14px;height: 40px;"/>
                                                <%--                                                <label class="form-label" for="typeText">Card Number</label>--%>
                                            </div>

                                            <div class="row mb-4">
                                                <div class="col-md-6">
                                                    <div class="form-outline form-white">
                                                        <span style="padding-left: 5px;">Expiration</span>
                                                        <input type="text" id="typeExp"
                                                               class="form-control form-control-lg"
                                                               placeholder="MM/YYYY" size="7" id="exp" minlength="7"
                                                               maxlength="7"
                                                               style="border-radius: 10px;border: 1px solid #ccc;font-size: 14px;height: 40px;"/>
                                                        <%--                                                        <label class="form-label" for="typeExp">Expiration</label>--%>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-outline form-white">
                                                        <span style="padding-left: 5px;">Cvv</span>
                                                        <input type="password" id="typeText"
                                                               class="form-control form-control-lg"
                                                               placeholder="&#9679;&#9679;&#9679;" size="1"
                                                               minlength="3" maxlength="3"
                                                               style="border-radius: 10px;border: 1px solid #ccc;font-size: 14px;height: 40px;"/>
                                                        <%--                                                        <label class="form-label" for="typeText">Cvv</label>--%>
                                                    </div>
                                                </div>
                                            </div>

                                        </form>

                                        <hr class="my-4">

                                        <div class="d-flex justify-content-between">
                                            <p class="mb-2">Subtotal</p>
                                            <p class="mb-2">${totalPrice}$</p>
                                        </div>

                                        <div class="d-flex justify-content-between">
                                            <p class="mb-2">Discount</p>
                                            <c:set var="discount" value="${totalPrice * 0.1}"/>
                                            <p class="mb-2">${fn:substringBefore(discount, '.')}$</p>
                                        </div>

                                        <div class="d-flex justify-content-between mb-4">
                                            <p class="mb-2">Total(Incl. taxes)</p>
                                            <c:set var="total" value="${totalPrice - discount}"/>
                                            <p class="mb-2">${fn:substringBefore(total, '.')}$</p>
                                        </div>

                                        <button style="padding: 0px 32px;font-size: 14px;height: 50px;" type="button"
                                                class="btn btn-info btn-block btn-lg">
                                            <div class="d-flex justify-content-between">
                                                <span>$4818.00</span>
                                                <span>Checkout <i class="fas fa-long-arrow-alt-right ms-2"></i></span>
                                            </div>
                                        </button>
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