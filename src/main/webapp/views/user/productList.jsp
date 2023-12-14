<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<head>
    <style>
        body {
            background-color: #eee
        }
        .category_block li:hover {
            background-color: #007bff;
        }
        .category_block li:hover a {
            color: #ffffff;
        }
        .category_block li a {
            color: #343a40;
        }
        .about span {
            color: #5629c0;
            font-size: 16px
        }
        .cart-button button {
            font-size: 12px;
            color: #fff;
            background-color: #5629c0;
            height: 38px
        }

        .cart-button button:focus,
        button:active {
            font-size: 12px;
            color: #fff;
            background-color: #5629c0;
            box-shadow: none
        }

        .product_fav i {
            line-height: 40px;
            color: #5629c0;
            font-size: 15px
        }

        .product_fav:hover i {
            background: #5629c0
        }

        .product_fav:hover i {
            color: #fff
        }

        .about {
            margin-top: 12px
        }
        a .active{
            color: white;
        }
    </style>
</head>
<body>
<br>
<div class="container">
    <div class="row g-2">
        <div class="col-md-3" style="width: 200px">
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase" style="font-size: 1.7rem; text-align: center">
                    <i class="fa fa-list"></i> Categories
                </div>
                <ul class="list-group category_block text-uppercase" style="font-size: 1.5rem">
                    <c:forEach items="${listc}" var="o">
                        <li class="list-group-item text-white ${tag == o.getMaLoaiSP()? "active":""}">
                            <a href="user-category?cid=${o.getMaLoaiSP()}">${o.getTenLoaiSP()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <br>
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase" style="font-size: 1.7rem; text-align: center">
                    <i class="fa fa-list"></i> suppliers
                </div>
                <ul class="list-group category_block text-uppercase" style="font-size: 1.5rem">
                    <c:forEach items="${listsup}" var="o">
                        <li class="list-group-item text-white ${tag == o.getMaNcc()? "active":""}">
                            <a href="user-supplier?sid=${o.getMaNcc()}">${o.getTenNcc()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-md-9">
            <div class="row g-2">
                <c:forEach var="p" items="${listpro}">
                    <div class="col-md-4" type="button" onclick="productdetail(${p.getMaSP()})">
                        <div class="card">
                            <div class="text-center"><img src=${p.getImage()}></div>
                            <div class="about text-center">
                                <h5>${p.getTenSP()}</h5>
                                <span>${p.getGia()}$</span>
                            </div>
                            <div class="cart-button mt-3 px-2 d-flex justify-content-between align-items-center"
                                 style="align-self: center">
                                <button class="btn btn-primary text-uppercase">Add to cart</button>
                            </div>
                        </div>
                        <br>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<script>
    function productdetail(productId){
        window.location.href = "user-product?pid="+productId;
    }
</script>
</body>

