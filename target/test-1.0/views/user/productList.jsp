<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<head>
    <style>
        body {
            background-color: #eee
        }

        .t-products {
            background-image: linear-gradient(to right top, #5629c0, #5625cb, #5620d5, #551ae0, #5412eb);
            color: #fff;
            border-radius: 3px
        }

        .processor {
            background-color: #fff;
            margin-top: 5px;
            border-bottom: 1px solid #eee
        }

        .brand {
            background-color: #fff;
            border-bottom: 1px solid #eee
        }

        .type {
            background-color: #fff
        }

        .product {
            padding: 10px;
            background-color: #fff;
            border-radius: 5px;
            position: relative
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

        .product_fav {
            display: inline-block;
            width: 36px;
            height: 39px;
            background: #FFFFFF;
            box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
            border-radius: 11%;
            text-align: center;
            cursor: pointer;
            margin-left: 3px;
            -webkit-transition: all 200ms ease;
            -moz-transition: all 200ms ease;
            -ms-transition: all 200ms ease;
            -o-transition: all 200ms ease;
            transition: all 200ms ease
        }

        .product_fav:hover {
            background: #5629c0
        }

        .product_fav:hover i {
            color: #fff
        }

        .about {
            margin-top: 12px
        }

        .off {
            position: absolute;
            left: 65%;
            top: 6%;
            width: 80px;
            text-align: center;
            height: 30px;
            line-height: 8px;
            border-radius: 5px;
            font-size: 13px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #fff
        }
    </style>
</head>
<div class="container-fluid mt-5 mb-5">
    <div class="col-md-9">
        <div class="row g-2">
            <c:forEach var="p" items="${list_p}">
            <div class="col-md-4">
                <div class="product py-4">
                    <div class="text-center"><img src=${p.getImage()} width="200"></div>
                    <div class="about text-center"><h5>XRD Active Shoes</h5> <span>$1,999.99</span></div>
                    <div class="cart-button mt-3 px-2 d-flex justify-content-between align-items-center">
                        <button class="btn btn-primary text-uppercase">Buy now</button>
                        <button class="btn btn-primary text-uppercase">Add to cart</button>
                    </div>
                </div>
            </div>
            </c:forEach>
            <div class="col-md-4">
                <div class="product py-4">
                    <div class="text-center"><img src="https://i.imgur.com/nOFet9u.jpg" width="200"></div>
                    <div class="about text-center"><h5>XRD Active Shoes</h5> <span>$1,999.99</span></div>
                    <div class="cart-button mt-3 px-2 d-flex justify-content-between align-items-center">
                        <button class="btn btn-primary text-uppercase">Buy now</button>
                        <button class="btn btn-primary text-uppercase" style="float: left" ">Add to cart</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>