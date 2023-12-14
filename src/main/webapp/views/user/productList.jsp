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
            <div id="loadlist" class="row g-2">
                <c:forEach var="p" items="${listpro}">
                    <div class="product col-md-4" type="button" onclick="productdetail(${p.getMaSp()})" >
                        <div class="card" style= "height: 350px">
                            <div class="text-center"><img style= "width: 250px" src=${p.getImage()} ></div>
                            <div class="about text-center" >
                                <h5 >${p.getTenSP()}</h5>
                                <span><i class="me-1 fa fa-shopping-basket"></i> ${p.getGia()}$</span>
                            </div>
                        </div>
                        <br>
                    </div>
                </c:forEach>
            </div>
                <button id="myButton" onclick="loadMore()" class="btn btn--primary" style="float:right;">Load More</button>
        </div>
    </div>
</div>
<script>
    function productdetail(productId){
        window.location.href = "user-product?pid=" + productId;
    }
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    function loadMore() {
        var amount = document.getElementsByClassName("product").length;
        $.ajax({
            url: "/test_war_exploded/load",
            type: "get",
            data:{
                exits : amount
            },
            success: function (data) {
                var row = document.getElementById("loadlist");
                row.innerHTML += data;
            },
            error: function (xhr) {

            }
        });
    }
</script>
<script>
    // Kiểm tra nếu URL chứa "user-home"
    var isUserHome = window.location.href.indexOf("user-home") !== -1;

    // Lấy thẻ button bằng id
    var myButton = document.getElementById("myButton");

    // Kiểm tra và thay đổi trạng thái của button
    if (isUserHome) {
        // Nếu ở URL "user-home", cho phép button
        myButton.style.display = "block";
    } else {
        // Nếu không ở URL "user-home", ẩn button
        myButton.style.display = "none";
    }
</script>
</body>

