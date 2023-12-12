<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<head>
    <style>
        .icon-hover:hover i {
            color: #3b71ca !important;
        }
        .qty-btn {
            float: left;
            background: #fff;
            border: 1px solid #f3f4f4;
            cursor: pointer;
            font-weight: 600;
            font-size: 16px;
            outline: none;
            height: 40px;
            line-height: 40px;
            width: 40px;
            text-align: center;
            border-radius: 0;
            outline: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            -o-appearance: none;
            appearance: none;
        }
    </style>
</head>
<body>
<section class="py-5">
    <div class="container">
        <div class="row gx-5">
            <aside class="col-lg-6">
                <div class="border rounded-4 mb-3 d-flex justify-content-center">
                    <a data-fslightbox="mygalley" class="rounded-4" target="_blank" data-type="image" href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big.webp">
                        <img style="max-width: 100%; max-height: 100vh; margin: auto;" class="rounded-4 fit" src="${detail.getImage()}" />
                    </a>
                </div>
            </aside>
            <main class="col-lg-6">
                <h4 class="title text-dark" style = "font-size: 4rem">
                    ${detail.getTenSP()}
                </h4>
                <div class="mb-3">
                    <span class="h5" style = "font-size: 2.5rem; color: #17a2b8">${detail.getGia()}$ (Đã bao gồm VAT)</span>
                </div>
                <p style = "font-size: 1.5rem">
                    ${detail.getDescription()}
                </p>
                <div class="row">
                    <dt class="col-3" style = "font-size: 2rem">Mã sản phẩm:</dt>
                    <dd class="col-9" style = "font-size: 2rem">${detail.getMaSP()}</dd>

                    <dt class="col-3" style = "font-size: 2rem">Brand:</dt>
                    <dd class="col-9" style = "font-size: 2rem">${detail.getMaNcc()}</dd>

                    <dt class="col-3" style = "font-size: 2rem">Tình trạng:</dt>
                    <dd class="col-9" style = "font-size: 2rem">${detail.getTrangThai()}</dd>
                </div>

                <hr />

                <div class="row mb-4">
                    <div class="col-md-4 col-6 mb-3">
                        <label class="mb-4 d-block" style = "font-size: 2rem">Số lượng</label>
                        <div class="block-quantity quantity-selector" >
                            <input type="button" value="-" onclick="minusQuantity()" class="qty-btn" style="float: left; width: 40px; height: 30px; font-size: 1.5rem; background: #fff; border: 1px solid #f3f4f4;text-align: center;">
                            <input type="text" id="quantity-bottom" name="quantity" value="1" min="1" class="quantity-number" style="float: left;width: 60px; height: 30px; font-size: 1.5rem; text-align: center;background: #fff; border: 1px solid #f3f4f4;">
                            <input type="button" value="+" onclick="plusQuantity()" class = "qty-btn" style="float: left;width: 40px; height: 30px; font-size: 1.5rem;background: #fff; border: 1px solid #f3f4f4;text-align: center;">
                        </div>
                    </div>
                </div>
                <button href="#" class="btn btn-warning shadow-0" style = "font-size: 1.4rem"> Buy now </button>
                <button href="#" class="btn btn-primary shadow-0" style = "font-size: 1.4rem"> <i class="me-1 fa fa-shopping-basket"></i> Add to cart </button>
            </main>
        </div>
    </div>
</section>
<!-- content -->
<section class="bg-light border-top py-4">
    <div class="container">
        <div class="row gx-4">
            <div class="col-lg-4">
                <div class="px-0 border rounded-2 shadow-0">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title" style = "font-size: 2rem">Sản phẩm cùng loại</h5>
                            <c:forEach var = "o" items="${detail_same}">
                                <div class="d-flex mb-3">
                                    <a href="user-product?pid=${o.getMaSP()}" class="me-3">
                                        <img src="${o.getImage()}" style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                    </a>
                                    <div class="info" style = "font-size: 1.5rem; max-width: 280px">
                                        <a href="user-product?pid=${o.getMaSP()}" class="nav-link mb-1">
                                            ${o.getTenSP()}
                                        </a>
                                        <strong class="text-dark" style = "font-size: 1.3rem"> ${o.getGia()}$</strong>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="px-0 border rounded-2 shadow-0">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title" style = "font-size: 2rem">Sản phẩm cùng nhà cung cấp</h5>
                            <c:forEach var = "o" items="${detail_same_ncc}" >
                                <div class="d-flex mb-3">
                                    <a href="user-product?pid=${o.getMaSP()}" class="me-3">
                                        <img src="${o.getImage()}" style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                    </a>
                                    <div class="info" style = "font-size: 1.5rem; max-width: 280px">
                                        <a href="user-product?pid=${o.getMaSP()}" class="nav-link mb-1">
                                                ${o.getTenSP()}
                                        </a>
                                        <strong class="text-dark"  style = "font-size: 1.3rem">${o.getGia()}$</strong>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="px-0 border rounded-2 shadow-0">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title" style = "font-size: 2rem">Sản phẩm đã xem</h5>
                            <c:forEach var = "o" items="${detail_viewed}" >
                                <div class="d-flex mb-3">
                                    <a href="user-product?pid=${o.getMaSP()}" class="me-3">
                                        <img src="${o.getImage()}" style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                    </a>
                                    <div class="info" style = "font-size: 1.5rem; max-width: 280px">
                                        <a href="user-product?pid=${o.getMaSP()}" class="nav-link mb-1">
                                                ${o.getTenSP()}
                                        </a>
                                        <strong class="text-dark"  style = "font-size: 1.3rem">${o.getGia()}$</strong>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    function minusQuantity() {
        var quantityInput = document.getElementById('quantity-bottom');
        var currentQuantity = parseInt(quantityInput.value);

        if (currentQuantity > 1) {
            quantityInput.value = currentQuantity - 1;
        }
    }
    function plusQuantity(){
        var quantityInput = document.getElementById('quantity-bottom');
        var currentQuantity = parseInt(quantityInput.value);
        quantityInput.value = currentQuantity + 1;
    }
</script>
</body>
