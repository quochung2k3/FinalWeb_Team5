package hcmute.team5.controller.user;

import hcmute.team5.model.*;
import hcmute.team5.service.ICartService;
import hcmute.team5.service.IProductDetailService;
import hcmute.team5.service.IVoucherService;
import hcmute.team5.service.impl.CartService;
import hcmute.team5.service.impl.ProductDetailService;
import hcmute.team5.service.impl.VoucherService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/user-product", "/user-buy-now", "/user-buynow-voucher"})
public class DetailProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IProductDetailService service = new ProductDetailService();
    ICartService service_cart = new CartService();
    IVoucherService voucherService = new VoucherService();
    String masp = "";
    int soluong = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        req.setAttribute("name", account.getUserName());
        if (url.contains("product")) {
            getDetailProduct(req, resp, account);
        }
        if(url.contains("user-buynow-voucher")) {
            findVoucher(req, resp);
        }
    }

    private void findVoucher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maVC = 0;
        if(!req.getParameter("maVC").isEmpty()) {
            maVC = Integer.parseInt(req.getParameter("maVC"));
        }
        VoucherModel voucher = voucherService.findVoucher(maVC);
        if(voucher == null) {
            AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
            req.setAttribute("name", account.getUserName());
            List<CartModel> list = service_cart.findOne(masp, soluong);
            int length = list.size();
            req.setAttribute("length", length);
            req.setAttribute("listCart", list);
            req.setAttribute("note", "Voucher không hợp lệ");
            RequestDispatcher rd = req.getRequestDispatcher("/views/user/cartBuyNow.jsp");
            rd.forward(req, resp);
        }
        else {
            AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
            req.setAttribute("name", account.getUserName());
            List<CartModel> list = service_cart.findOne(masp, soluong);
            int length = list.size();
            req.setAttribute("length", length);
            req.setAttribute("listCart", list);
            req.setAttribute("note", "OK");
            req.setAttribute("discountController", voucher.getPhanTramGiam());
            req.setAttribute("maVCController", maVC);
            RequestDispatcher rd = req.getRequestDispatcher("/views/user/cartBuyNow.jsp");
            rd.forward(req, resp);
        }
    }

    private void findOne(HttpServletRequest req, HttpServletResponse resp, String masp, int soluong) throws ServletException, IOException {
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        req.setAttribute("name", account.getUserName());
        List<CartModel> list = service_cart.findOne(masp,soluong);
        int length = list.size();
        req.setAttribute("length", length);
        req.setAttribute("listCart", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/user/cartBuyNow.jsp");
        rd.forward(req, resp);
    }
    private void getDetailProduct(HttpServletRequest req, HttpServletResponse resp, AccountModel account) throws ServletException, IOException {
        String maSP = req.getParameter("pid");
        SupplierModel p = service.getDetailProduct(maSP);
        req.setAttribute("detail", p);

        List<CartModel> list = service_cart.findAll(account.getUserName());
        int length = list.size();
        req.setAttribute("length", length);

        String maLoaiSP = p.getMaLoaiSP();
        List<ProductModel> p_similar = service.getListProDuctByProductType(maLoaiSP, maSP);
        req.setAttribute("detail_same", p_similar);

        String mancc = p.getMaNcc();
        List<ProductModel> p_similarncc = service.getListProductByNCC(mancc, maSP);
        req.setAttribute("detail_same_ncc", p_similarncc);


        String username = account.getUserName();
        List<ProductModel> p_viewed = service.getListProDuctViewed(maSP, username);
        req.setAttribute("detail_viewed", p_viewed);

        service.insertviewed(username, maSP);

        RequestDispatcher rd = req.getRequestDispatcher("/views/user/DetailProduct.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("user-buy-now")){
            masp = req.getParameter("pid");
            soluong = Integer.parseInt(req.getParameter("quantity"));
            findOne(req,resp, masp, soluong);
        }
        else{
            inserttoCart(req, resp);
            doGet(req, resp);
        }
    }

    private void inserttoCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        String username = account.getUserName();
        String maSP = req.getParameter("pid");
        int Soluong = Integer.parseInt(req.getParameter("quantity"));
        service.inserttoCart(username, maSP, Soluong);
    }
}
