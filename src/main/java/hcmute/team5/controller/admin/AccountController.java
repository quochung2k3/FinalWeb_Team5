package hcmute.team5.controller.admin;

import hcmute.team5.model.AccountModel;
import hcmute.team5.model.CustomerModel;
import hcmute.team5.service.IAccountService;
import hcmute.team5.service.impl.AccountService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = {"/admin-ql-account", "/admin-delete", "/admin-add", "/admin-update", "/admin-account-search", "/admin-reset-account", "/admin-account-pagination"})
public class AccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IAccountService service = new AccountService();
    int pageSize = 5;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        req.setAttribute("name", account.getUserName());
        if(url.contains("ql-account")) {
            findAll(req, resp);
        }
        if(url.contains("admin-delete")) {
            deleteAccount(req, resp);
        }
        if(url.contains("add")) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/account/add-account.jsp");
            rd.forward(req, resp);
        }
        if(url.contains("admin-update")) {
            findOneByUserName(req, resp);
        }
        if(url.contains("account-search")) {
            findAllByProperties(req, resp);
        }
        if(url.contains("account-pagination")) {
            findAllPagination(req, resp);
        }
    }

    private void findAllPagination(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fetchValue = Integer.parseInt(req.getParameter("fetch"));
        List<AccountModel> list = service.findAll(fetchValue, 0);
        req.setAttribute("listAccount", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/account/ql-account.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/logout")){
            RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
            rd.forward(req, resp);
        }
        if(url.contains("add")) {
            postRegister(req, resp);
        }
        if(url.contains("update")) {
            update(req, resp);
        }
    }

    private void findAllByProperties(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = 0;
        int num2 = 0;
        int numpage = 0;
        String text = req.getParameter("index");
        String rolename = req.getParameter("roleName");
        String status = req.getParameter("status");
        String username = req.getParameter("username");
        List<AccountModel> listNum = service.findAllByProperties(rolename, status, username, 999999999, 0);
        int numOfAccount = listNum.size();
        req.setAttribute("numOfAccount", numOfAccount);
        if(numOfAccount % pageSize == 0) {
            numpage = numOfAccount/pageSize;
        }
        else {
            numpage = numOfAccount/pageSize + 1;
        }
        req.setAttribute("numpage", numpage);
        if(text == null || text.equals("1")) {
            index = 0;
            num2 = pageSize;
        }
        else if (text.equals(String.valueOf(numpage))) {
            int temp = Integer.parseInt(req.getParameter("index"));
            index = (temp-1)*pageSize;
            num2 = numOfAccount;
        }
        else {
            int temp = Integer.parseInt(req.getParameter("index"));
            num2 = temp*pageSize;
            index = (temp-1)*pageSize;
        }
        if(pageSize >= numOfAccount) {
            num2 = numOfAccount;
        }
        req.setAttribute("num2", num2);
        List<AccountModel> list = service.findAllByProperties(rolename, status, username, pageSize, index);
        req.setAttribute("listAccount", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/account/ql-account.jsp");
        rd.forward(req, resp);
    }

    private void findOneByUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        AccountModel account = service.findOneByUsername(username);
        req.setAttribute("account", account);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/account/update-account.jsp");
        rd.forward(req, resp);
    }

    private void deleteAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        AccountModel account = new AccountModel();
        account.setId(id);
        service.deleteAccount(account);
        findAll(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int roleid = Integer.parseInt(req.getParameter("roleid"));
        AccountModel account = new AccountModel();
        account.setFullName(fullname);
        account.setUserName(username);
        account.setPassWord(password);
        account.setRoleId(roleid);
        service.update(account);
        req.setAttribute("note", "Cập nhật thành công");
        findAll(req, resp);
    }

    private void postRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String fullname = req.getParameter("fullname");
        String sdt = req.getParameter("sdt");
        int roleid = Integer.parseInt(req.getParameter("roleid"));
        if (service.findOneByUsername(username) == null) {
            String password = req.getParameter("password");
            AccountModel account = new AccountModel();
            account.setUserName(username);
            account.setPassWord(password);
            account.setRoleId(roleid);
            account.setStatus("Active");
            account.setFullName(fullname);
            account.setSdt(sdt);
            service.insertAcc(account);
            if(roleid == 2) {
                CustomerModel customer = new CustomerModel();
                customer.setUsername(username);
                customer.setSdt(sdt);
                service.insertCus(customer);
            }
            req.setAttribute("note", "Thêm thành công");
            findAll(req, resp);

        } else {
            req.setAttribute("note", "Tên tài khoản đã tồn tại!!");
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/account/add-account.jsp");
            rd.forward(req, resp);
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("index");
        int index;
        int numOfAccount = service.getNumOfAccount();
        req.setAttribute("numOfAccount", numOfAccount);
        int numpage = 0;
        int num2 = 0;
        if(numOfAccount % pageSize == 0) {
            numpage = numOfAccount/pageSize;
        }
        else {
            numpage = numOfAccount/pageSize + 1;
        }
        req.setAttribute("numpage", numpage);
        if(text == null || text.equals("1")) {
            index = 0;
            num2 = pageSize;
        }
        else if (text.equals(String.valueOf(numpage))) {
            int temp = Integer.parseInt(req.getParameter("index"));
            index = (temp-1)*pageSize;
            num2 = numOfAccount;
        }
        else {
            int temp = Integer.parseInt(req.getParameter("index"));
            num2 = temp*pageSize;
            index = (temp-1)*pageSize;
        }
        if(pageSize >= numOfAccount) {
            num2 = numOfAccount;
        }
        req.setAttribute("num2", num2);
        List<AccountModel> list = service.findAll(pageSize, index);
        req.setAttribute("listAccount", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/account/ql-account.jsp");
        rd.forward(req, resp);
    }
}