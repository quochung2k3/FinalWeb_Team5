<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="app">
    <header class="header">
        <div class="grid">
            <form action="logout" method="get">
                <div class="header__navbar">
                    <ul class="header__navbar-list">
                        <li class="header__navbar-items header__navbar-items--has-qr header__navbar-items--separate">
                            Vào cửa hàng trên ứng dụng ViVu Shop
                            <div style="z-index: 99" class="header__QR">
                                <img src="<c:url value='/template/user/img/QR.png'/>" alt="qr_code" class="header__QR-img">
                                <div class="header__QR-apps">
                                    <a href="" class="header__QR-link">
                                        <img src="<c:url value='/template/user/img/appStore.png'/>" alt="" class="header__QR-download-img">
                                    </a>
                                    <a href="" class="header__QR-link">
                                        <img src="<c:url value='/template/user/img/ggPlay.png'/>" alt="" class="header__QR-download-img">
                                    </a>

                                </div>
                            </div>
                        </li>
                        <li class="header__navbar-items">
                                    <span class="header__navbar-title--no-poiter">
                                        Kết nối
                                    </span>
                            <a href="https://www.facebook.com/maivy.140103/" class="header__navbar-icon-link">
                                <i class="header__navbar-icon fa-brands fa-facebook"></i>
                            </a>
                            <a href="https://www.instagram.com/vivu.14__/" class="header__navbar-icon-link">
                                <i class="header__navbar-icon fa-brands fa-instagram"></i>
                            </a>
                        </li>
                    </ul>

                    <ul class="header__navbar-list">
                        <li class="header__navbar-items header__navbar-items-open-notify">
                            <a href="" class="header__items-link">
                                <i class="header__navbar-icon fa-solid fa-bell"></i>
                                Thông báo
                            </a>
                            <div class="header__notify">
                                <header class="header__notify-title">
                                    <h3>Thông báo mới nhận</h3>
                                </header>
                                <ul class="header__notify-list">
                                    <li class="header__notify-items header__notify-items--viewed">
                                        <a href="" class="header__notify-link">
                                            <img src="<c:url value='/template/user/img/myPham.webp'/>" alt="" class="header__notify-img">
                                            <div class="header__notify-info">
                                                <span class="header__notify-name">Mỹ phẩm Ohui chính hãng</span>
                                                <span class="header__notify-description">Mô tả mỹ phẩm</span>
                                            </div>
                                        </a>
                                    </li>

                                    <li class="header__notify-items header__notify-items--viewed">
                                        <a href="" class="header__notify-link">
                                            <img src="<c:url value='/template/user/img/myPham.webp'/>" alt="" class="header__notify-img">
                                            <div class="header__notify-info">
                                                <span class="header__notify-name">Mỹ phẩm Ohui chính hãng</span>
                                                <span class="header__notify-description">Mô tả mỹ phẩm</span>
                                            </div>
                                        </a>
                                    </li>

                                    <li class="header__notify-items header__notify-items--viewed">
                                        <a href="" class="header__notify-link">
                                            <img src="<c:url value='/template/user/img/myPham.webp'/>" alt="" class="header__notify-img">
                                            <div class="header__notify-info">
                                                <span class="header__notify-name">Mỹ phẩm Ohui chính hãng</span>
                                                <span class="header__notify-description">Mô tả mỹ phẩm</span>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                                <footer class="header__notify-footer">
                                    <a href="" class="header__notify-footer-btn">Xem tất cả</a>
                                </footer>
                            </div>
                        </li>
                        <li class="header__navbar-items">
                            <a href="" class="header__items-link">
                                <i class="header__navbar-icon fa-solid fa-question"></i>
                                Trợ giúp
                            </a>
                        </li>
                        <li class="header__navbar-items header__navbar-items--strong header__navbar-items--separate js-modal__register">${name}</li>
                        <button style="background-color: #569cdd; border: none" type="submit" class="header__navbar-items header__navbar-items--strong js-modal__login">Đăng xuất</button>
                    </ul>
                </div>
            </form>

            <!-- Header with search -->
            <div class="header-with-search">
                <div class="header__logo">
                    <img src="<c:url value='/template/user/img/iconShop.png'/>" alt="" class="header__logo-img">
                </div>

                <div class="header__search">
                    <div class="header__search-input-wrap">
                        <input type="text" class="header__search-input" placeholder="Nhập để tìm kiếm sản phẩm">
                        <!-- Search History -->
                        <div style="z-index: 99;" class="header__search-history">
                            <h3 class="header__search-history-heading">Lịch sử tìm kiếm</h3>
                            <ul class="header__search-history-list">
                                <li class="header__search-history-items">
                                    <a href="" class="header__search-history-link">Kem dưỡng da</a>
                                </li>
                                <li class="header__search-history-items">
                                    <a href="" class="header__search-history-link">Kem trị mụn</a>
                                </li>
                                <li class="header__search-history-items">
                                    <a href="" class="header__search-history-link">Gel  tẩy lông</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="header__search-selection">
                        <span class="header__search-selection-label">Trong shop</span>
                        <i class="header__search-selection-icon fa-solid fa-chevron-down"></i>
                        <ul class="header__search-option">
                            <li class="header__search-option-items header__search-option-items--active">
                                <span>Trong shop</span>
                                <i class="fa-solid fa-check"></i>
                            </li>
                            <li class="header__search-option-items">
                                <span>Ngoài shop</span>
                                <i class="fa-solid fa-check"></i>
                            </li>
                        </ul>
                    </div>
                    <button class="header__search-btn">
                        <i class="header__search-btn-icon fa-solid fa-magnifying-glass"></i>
                    </button>
                </div>

                <div class="header__cart">
                    <a href="<c:url value="/user-cart"/>">
                        <div class="header__cart-wrap">
                            <i class="header__cart-icon fa-solid fa-cart-shopping"></i>
                            <span class="header__cart-notice">3</span>
                            <!-- No cart: header__cart-list--no-cart -->
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </header>
</div>