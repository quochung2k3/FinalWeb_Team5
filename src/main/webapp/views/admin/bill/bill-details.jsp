<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<style>
    th {
        width: 33.33%;
    }
</style>
<body>
<div class="card">
    <div class="card-header bg-black"></div>
    <div class="card-body">

        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <i class="far fa-building text-danger fa-6x float-start"></i>
                </div>
            </div>


            <div class="row">
                <div class="col-xl-12">

                    <ul class="list-unstyled float-end">
                        <li style="font-size: 30px; color: red;">Company</li>
                        <li>123, Elm Street</li>
                        <li>123-456-789</li>
                        <li>mail@mail.com</li>
                    </ul>
                </div>
            </div>

            <div class="row text-center">
                <h3 class="text-uppercase text-center mt-3" style="font-size: 40px;">Invoice</h3>
                <p>${MaHD}</p>
            </div>
            <div class="row mx-3">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Product Code</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Cost</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var = "item" items = "${listBillDetails}">
                    <tr>
                        <td>${item.maSP}</td>
                        <td>${item.tenSP}</td>
                        <td><i class="fas fa-dollar-sign"></i>${item.gia}</td>
                    </tr>
                        <c:set var="totalPrice" value="${(totalPrice ne null) ? totalPrice + item.gia : item.gia}" />
                        <c:set var="percentDecrease" value="${item.phanTramGiam}" />
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <c:set var="discount" value="${totalPrice*percentDecrease/100}" />
            <c:set var="total" value="${totalPrice-discount}" />
            <div class="row">
                <div class="col-xl-8">
                    <ul class="list-unstyled float-end me-0">
                        <li><span class="me-3 float-start">Total Amount:</span><i class="fas fa-dollar-sign"></i>${totalPrice}</li>
                        <li> <span class="me-5">Discount:</span><i class="fas fa-dollar-sign"></i>${discount}</li>
<%--                        <li><span class="float-start" style="margin-right: 35px;">Shippment: </span><i--%>
<%--                                class="fas fa-dollar-sign"></i> 500,00</li>--%>
                    </ul>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-xl-8" style="margin-left:60px">
                    <p class="float-end"
                       style="font-size: 30px; color: red; font-weight: 400;font-family: Arial, Helvetica, sans-serif;">
                        Total:
                        <span><i class="fas fa-dollar-sign"></i>${total}</span></p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>