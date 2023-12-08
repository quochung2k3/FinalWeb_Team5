package hcmute.team5.controller.admin;

import hcmute.team5.model.AccountModel;
import hcmute.team5.model.CustomerModel;
import hcmute.team5.service.IAccountService;
import hcmute.team5.service.ICustomerService;
import hcmute.team5.service.impl.AccountService;
import hcmute.team5.service.impl.CustomerService;

import javax.naming.Name;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
@WebServlet(urlPatterns = {"/admin-ql-customer", "/admin-customer-update", "/admin-customer-delete", "/admin-customer-add"})
public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ICustomerService service = new CustomerService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        CustomerModel customer = (CustomerModel) req.getSession(false).getAttribute("customer");
        if (url.contains("ql-customer")) {
            findAll(req, resp);
        }
        if(url.contains("customer-update")) {
            findOneByCustomer(req, resp);
        }
        if(url.contains("customer-delete")) {
            deleteCustomer(req, resp);
        }
        if(url.contains("add")) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/add-customer.jsp");
            rd.forward(req, resp);
        }

    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maKh = req.getParameter("makh");
        String ten = req.getParameter("ten");
        String ngaySinh = req.getParameter("ngaysinh");
        String sdt = req.getParameter("sdt");
        CustomerModel customer = new CustomerModel();
        customer.setMaKh(maKh);
        customer.setTen(ten);
        customer.setNgaySinh(ngaySinh);
        customer.setSdt(sdt);
        service.updateCustomer(customer);
        req.setAttribute("note", "Cập nhật thành công");
        findAll(req, resp);
    }
    private void findOneByCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maKh = req.getParameter("maKh");
        CustomerModel customer = service.findOneByCustomer(maKh);
        req.setAttribute("customer", customer);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/update-customer.jsp");
        rd.forward(req, resp);
    }
    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maKh = req.getParameter("maKh");
        System.out.println(maKh);
        CustomerModel customer = new CustomerModel();
        customer.setMaKh(maKh);
        service.deleteCustomer(customer);
        findAll(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CustomerModel> list = service.findAll();
        req.setAttribute("listCustomer", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/ql-customer.jsp");
        rd.forward(req, resp);
    }
    private void postCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String makh = req.getParameter("makh");
        String ten = req.getParameter("ten");
        String ngaysinh = req.getParameter("ngaysinh");
        String sdt =req.getParameter("sdt");
        if (service.findOneByCustomer(makh) == null) {
            CustomerModel customer = new CustomerModel();
            customer.setMaKh(makh);
            customer.setTen(ten);
            customer.setNgaySinh(ngaysinh);
            customer.setSdt(sdt);
            service.insertCus(customer);
            req.setAttribute("note", "Thêm thành công");
            findAll(req, resp);

        } else {
            req.setAttribute("note", "Khách hàng đã tồn tại!!");
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/add-customer.jsp");
            rd.forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("delete")){
            deleteCustomer(req, resp);
        }
        if(url.contains("update")) {
            update(req, resp);
        }
        if(url.contains("add")) {
            postCustomer(req, resp);
        }
    }
}
