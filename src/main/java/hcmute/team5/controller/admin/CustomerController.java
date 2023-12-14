package hcmute.team5.controller.admin;

import hcmute.team5.model.AccountModel;
import hcmute.team5.model.BillModel;
import hcmute.team5.model.CustomerModel;
import hcmute.team5.service.IAccountService;
import hcmute.team5.service.IBillService;
import hcmute.team5.service.ICustomerService;
import hcmute.team5.service.impl.AccountService;
import hcmute.team5.service.impl.BillService;
import hcmute.team5.service.impl.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-ql-customer", "/admin-customer-update", "/admin-customer-delete", "/admin-customer-add", "/admin-customer-search", "/admin-customer-history"})
public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ICustomerService service = new CustomerService();
    IBillService billService = new BillService();
    IAccountService accountService = new AccountService();
    int pageSize = 5;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        req.setAttribute("name", account.getUserName());
        if (url.contains("ql-customer")) {
            findAll(req, resp);
        }
        if (url.contains("customer-update")) {
            findOneByCustomer(req, resp);
        }
        if (url.contains("customer-delete")) {
            deleteCustomer(req, resp);
        }
        if (url.contains("add")) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/add-customer.jsp");
            rd.forward(req, resp);
        }
        if (url.contains("customer-search")) {
            findAllByProperties(req, resp);
        }
        if (url.contains("history")) {
            findAllByMaKH(req, resp);
        }

    }

    private void findAllByMaKH(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maKH = Integer.parseInt(req.getParameter("maKh"));
        List<BillModel> listBill = billService.findAllBillByMaKH(maKH);

        req.setAttribute("listBill", listBill);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/history-purchase.jsp");
        rd.forward(req, resp);
    }

    private void findAllByProperties(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = 0;
        int num2 = 0;
        int numpage = 0;
        String text = req.getParameter("index");
        String name = req.getParameter("name");
        String total = req.getParameter("total");
        List<CustomerModel> listNum = service.findAllByProperties(name, total, 999999999, 0);
        int numOfCustomer = listNum.size();
        req.setAttribute("numOfAccount", numOfCustomer);
        if (numOfCustomer % pageSize == 0) {
            numpage = numOfCustomer / pageSize;
        } else {
            numpage = numOfCustomer / pageSize + 1;
        }
        req.setAttribute("numpage", numpage);
        if (text == null || text.equals("1")) {
            index = 0;
            num2 = pageSize;
        } else if (text.equals(String.valueOf(numpage))) {
            int temp = Integer.parseInt(req.getParameter("index"));
            index = (temp - 1) * pageSize;
            num2 = numOfCustomer;
        } else {
            int temp = Integer.parseInt(req.getParameter("index"));
            num2 = temp * pageSize;
            index = (temp - 1) * pageSize;
        }
        if (pageSize >= numOfCustomer) {
            num2 = numOfCustomer;
        }
        req.setAttribute("num2", num2);
        List<CustomerModel> list = service.findAllByProperties(name, total, pageSize, index);
        req.setAttribute("listCustomer", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/ql-customer.jsp");
        rd.forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maKh = Integer.parseInt(req.getParameter("makh"));
        String ten = req.getParameter("ten");
        String ngaySinh = req.getParameter("ngaysinh");
        String sdt = req.getParameter("sdt");
        CustomerModel customerByUserName = service.findOneByCustomer(maKh);
        CustomerModel customer = new CustomerModel();
        customer.setMaKh(maKh);
        customer.setTen(ten);
        customer.setNgaySinh(ngaySinh);
        customer.setSdt(sdt);
        customer.setUsername(customerByUserName.getUsername());
        service.updateCustomer(customer);
        req.setAttribute("note", "Cập nhật thành công");
        findAll(req, resp);
    }

    private void findOneByCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maKh = Integer.parseInt(req.getParameter("maKh"));
        CustomerModel customer = service.findOneByCustomer(maKh);
        req.setAttribute("customer", customer);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/update-customer.jsp");
        rd.forward(req, resp);
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maKh = Integer.parseInt(req.getParameter("maKh"));
        System.out.println(maKh);
        CustomerModel customer = new CustomerModel();
        customer.setMaKh(maKh);
        service.deleteCustomer(customer);
        findAll(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("index");
        int index;
        int numOfAccount = service.getNumOfCustomer();
        req.setAttribute("numOfAccount", numOfAccount);
        int numpage = 0;
        int num2 = 0;
        if (numOfAccount % pageSize == 0) {
            numpage = numOfAccount / pageSize;
        } else {
            numpage = numOfAccount / pageSize + 1;
        }
        req.setAttribute("numpage", numpage);
        if (text == null || text.equals("1")) {
            index = 0;
            num2 = pageSize;
        } else if (text.equals(String.valueOf(numpage))) {
            int temp = Integer.parseInt(req.getParameter("index"));
            index = (temp - 1) * pageSize;
            num2 = numOfAccount;
        } else {
            int temp = Integer.parseInt(req.getParameter("index"));
            num2 = temp * pageSize;
            index = (temp - 1) * pageSize;
        }
        if (pageSize >= numOfAccount) {
            num2 = numOfAccount;
        }
        req.setAttribute("num2", num2);
        List<CustomerModel> list = service.findAll(pageSize, index);
        req.setAttribute("listCustomer", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/ql-customer.jsp");
        rd.forward(req, resp);
    }

    private void postCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        if (accountService.findOneByUsername(username) == null) {
            String password = req.getParameter("pass");
            String fullname = req.getParameter("fullname");
            String sdt = req.getParameter("sdt");
            AccountModel account = new AccountModel();
            account.setUserName(username);
            account.setFullName(fullname);
            account.setPassWord(password);
            account.setRoleId(2);
            account.setStatus("Active");
            account.setSdt(sdt);
            accountService.insert(account);
            CustomerModel customer = new CustomerModel();
            customer.setUsername(username);
            customer.setSdt(sdt);
            accountService.insertCus(customer);
            req.setAttribute("note", "Thêm thành công");
            findAll(req, resp);

        } else {
            req.setAttribute("note", "Tên tài khoản đã tồn tại!!");
            try {
                req.getRequestDispatcher("/views/admin/customer/add-customer.jsp").forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }

        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("delete")) {
            deleteCustomer(req, resp);
        }
        if (url.contains("update")) {
            update(req, resp);
        }
        if (url.contains("add")) {
            postCustomer(req, resp);
        }
    }
}
