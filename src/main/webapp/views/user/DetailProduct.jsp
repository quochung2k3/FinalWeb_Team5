<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<head>
    <style>
        .icon-hover:hover {
            border-color: #3b71ca !important;
            background-color: white !important;
            color: #3b71ca !important;
        }
        .icon-hover:hover i {
            color: #3b71ca !important;
        }
    </style>
</head>
<section class="py-5">
    <div class="container">
        <div class="row gx-5">
            <aside class="col-lg-6">
                <div class="border rounded-4 mb-3 d-flex justify-content-center">
                    <a data-fslightbox="mygalley" class="rounded-4" target="_blank" data-type="image" href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big.webp">
                        <img style="max-width: 100%; max-height: 100vh; margin: auto;" class="rounded-4 fit" src="https://upanh123.com/wp-content/uploads/2020/11/hinh-anh-con-meo-cute9.jpg" />
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
                    <!-- col.// -->
                    <div class="col-md-4 col-6 mb-3">
                        <label class="mb-4 d-block" style = "font-size: 2rem">Quantity</label>
                        <div class="input-group" style="width: 200px">
                            <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon1" data-mdb-ripple-color="dark">
                                <i class="fas fa-minus"></i>
                            </button>
                            <input type="text" class="form-control text-center border border-secondary" placeholder="1" aria-label="Example text with button addon" aria-describedby="button-addon1" />
                            <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon2" data-mdb-ripple-color="dark">
                                <i class="fas fa-plus"></i>
                            </button>
                        </div>
                    </div>
                </div>
                <a href="#" class="btn btn-warning shadow-0" style = "font-size: 1.4rem"> Buy now </a>
                <a href="#" class="btn btn-primary shadow-0" style = "font-size: 1.4rem"> <i class="me-1 fa fa-shopping-basket"></i> Add to cart </a>
                <a href="#" class="btn btn-light border border-secondary py-2 icon-hover px-3" style = "font-size: 1.4rem"> <i class="me-1 fa fa-heart fa-lg"></i> Save </a>
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
                                        <img src="https://upanh123.com/wp-content/uploads/2020/11/hinh-anh-con-meo-cute9.jpg" style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                    </a>
                                    <div class="info" style = "font-size: 1.5rem">
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
                                        <img src="https://upanh123.com/wp-content/uploads/2020/11/hinh-anh-con-meo-cute9.jpg" style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                    </a>
                                    <div class="info" style = "font-size: 1.5rem">
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
                            <div class="d-flex mb-3">
                                <a href="#" class="me-3">
                                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/8.webp" style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                </a>
                                <div class="info">
                                    <a href="#" class="nav-link mb-1">
                                        Rucksack Backpack Large
                                        Line Mounts
                                    </a>
                                    <strong class="text-dark"> $38.90</strong>
                                </div>
                            </div>

                            <div class="d-flex mb-3">
                                <a href="#" class="me-3">
                                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/9.webp" style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                </a>
                                <div class="info">
                                    <a href="#" class="nav-link mb-1">
                                        Summer New Men's Denim
                                        Jeans Shorts
                                    </a>
                                    <strong class="text-dark"> $29.50</strong>
                                </div>
                            </div>

                            <div class="d-flex mb-3">
                                <a href="#" class="me-3">
                                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/10.webp" style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                </a>
                                <div class="info">
                                    <a href="#" class="nav-link mb-1"> T-shirts with multiple colors, for men and lady </a>
                                    <strong class="text-dark"> $120.00</strong>
                                </div>
                            </div>

                            <div class="d-flex">
                                <a href="#" class="me-3">
                                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/11.webp" style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                </a>
                                <div class="info">
                                    <a href="#" class="nav-link mb-1"> Blazer Suit Dress Jacket for Men, Blue color </a>
                                    <strong class="text-dark"> $339.90</strong>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
