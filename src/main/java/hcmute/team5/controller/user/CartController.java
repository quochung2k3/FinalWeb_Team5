package hcmute.team5.controller.user;

import hcmute.team5.model.*;
import hcmute.team5.service.*;
import hcmute.team5.service.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/user-cart", "/user-check-voucher", "/user-solve-pay","/user-delete-cart"})
public class CartController extends HomeController {
    private static final long serialVersionUID = 1L;
    ICartService service = new CartService();
    IVoucherService voucherService = new VoucherService();
    ICustomerService customerService = new CustomerService();
    IBillService billService = new BillService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("user-cart")) {
            findAll(req, resp);
        }
        if (url.contains("user-delete-cart")){
            deleteCardById(req,resp);
        }
        if(url.contains("user-check-voucher")) {
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
            List<CartModel> list = service.findAll(account.getUserName());
            int length = list.size();
            req.setAttribute("length", length);
            req.setAttribute("listCart", list);
            req.setAttribute("note", "Voucher không hợp lệ");
            RequestDispatcher rd = req.getRequestDispatcher("/views/user/cart.jsp");
            rd.forward(req, resp);
        }
        else {
            AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
            req.setAttribute("name", account.getUserName());
            List<CartModel> list = service.findAll(account.getUserName());
            int length = list.size();
            req.setAttribute("length", length);
            req.setAttribute("listCart", list);
            req.setAttribute("note", "OK");
            req.setAttribute("discountController", voucher.getPhanTramGiam());
            req.setAttribute("maVCController", maVC);
            RequestDispatcher rd = req.getRequestDispatcher("/views/user/cart.jsp");
            rd.forward(req, resp);
        }
    }

    private void deleteCardById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        String masp = req.getParameter("pid");
        String username = account.getUserName();
        service.deleteCartById(masp,username);
        findAll(req,resp);
    }
    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        req.setAttribute("name", account.getUserName());
        List<CartModel> list = service.findAll(account.getUserName());
        int length = list.size();
        req.setAttribute("length", length);
        req.setAttribute("listCart", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/user/cart.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("user-solve-pay")) {
            AddBill(req, resp);
            AddBillDetails(req, resp);
            AddPay(req, resp);
            DeleteCart(req, resp);
            loadData(req, resp);
        }
    }

    private void DeleteCart(HttpServletRequest req, HttpServletResponse resp) {
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        billService.DeleteCart(account.getUserName());
    }


    private void AddPay(HttpServletRequest req, HttpServletResponse resp) {
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        int maKH = customerService.findId(account.getUserName());
        int maVC = 0;
        int mahd = billService.findCodeBill(maKH);
        if(!req.getParameter("maVCController").isEmpty()) {
            maVC = Integer.parseInt(req.getParameter("maVCController"));
        }
        billService.AddPay(maKH, maVC, mahd);
    }

    private void AddBillDetails(HttpServletRequest req, HttpServletResponse resp) {
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        req.setAttribute("name", account.getUserName());
        List<CartModel> list = service.findAll(account.getUserName());
        int maKH = customerService.findId(account.getUserName());
        int mahd = billService.findCodeBill(maKH);
        for(CartModel cart:list ) {
            billService.AddBillDetails(mahd, cart.getMaSp(), cart.getSoLuong());
        }
    }

    private void AddBill(HttpServletRequest req, HttpServletResponse resp) {
        String date = String.valueOf(java.time.LocalDate.now());
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        int maKH = customerService.findId(account.getUserName());
        String tongTien = req.getParameter("totalController");
        billService.addBill(date, maKH, 1, tongTien);
    }
}