package hcmute.team5.controller.admin;

import hcmute.team5.model.AccountModel;
import hcmute.team5.model.CustomerModel;
import hcmute.team5.service.IAccountService;
import hcmute.team5.service.ICustomerService;
import hcmute.team5.service.impl.AccountService;
import hcmute.team5.service.impl.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
@WebServlet(urlPatterns = {"/admin-ql-customer", "/admin-update"})
public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ICustomerService service = new CustomerService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("customer")) {
            findAll(req, resp);
        }
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maKh = req.getParameter("makh");
        String ten = req.getParameter("ten");
        String ngaySinh = req.getParameter("ngaysinh");
        String sdt = req.getParameter("sdt");
        int tongTienDaMua = Integer.parseInt(req.getParameter("tongtiendamua"));
        CustomerModel customer = new CustomerModel();
        customer.setMaKh(maKh);
        customer.setTen(ten);
        customer.setNgaySinh(ngaySinh);
        customer.setSdt(sdt);
        customer.setTongTienDaMua(tongTienDaMua);
        service.update(customer);
        req.setAttribute("note", "Cập nhật thành công");
        findAll(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CustomerModel> list = service.findAll();
        req.setAttribute("listCustomer", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/ql-customer.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
