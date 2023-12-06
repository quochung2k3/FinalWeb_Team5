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
import java.util.List;
@WebServlet(urlPatterns = {"/admin-ql-customer"})
public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ICustomerService service = new CustomerService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("customer")) {
            findAll(req, resp);
        }
        if(url.contains("admin-delete")) {
            deleteAccount(req, resp);
        }
        if(url.contains("add")) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/add-account.jsp");
            rd.forward(req, resp);
        }
        if(url.contains("update")) {
            findOneByTen(req, resp);
        }
    }
    private void findOneByTen(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten = req.getParameter("ten");
        AccountModel account = service.findOneByTen(ten);
        req.setAttribute("ten", ten);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/update-customer.jsp");
        rd.forward(req, resp);
    }
    private void deleteAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        AccountModel account = new AccountModel();
        account.setId(id);
        service.deleteAccount(account);
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
