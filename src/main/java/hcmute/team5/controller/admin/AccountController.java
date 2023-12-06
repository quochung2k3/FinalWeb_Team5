package hcmute.team5.controller.admin;

import hcmute.team5.model.AccountModel;
import hcmute.team5.service.IAccountService;
import hcmute.team5.service.impl.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
@WebServlet(urlPatterns = {"/admin-ql-account", "/admin-delete", "/admin-add", "/admin-update"})
public class AccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IAccountService service = new AccountService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        req.setAttribute("name", account.getUserName());
        if(url.contains("account")) {
            findAll(req, resp);
        }
        if(url.contains("admin-delete")) {
            deleteAccount(req, resp);
        }
        if(url.contains("add")) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/account/add-account.jsp");
            rd.forward(req, resp);
        }
        if(url.contains("update")) {
            findOneByUserName(req, resp);
        }
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
        String pass = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        int roleid = Integer.parseInt(req.getParameter("roleid"));
        if (service.findOneByUsername(username) == null) {
            String password = req.getParameter("password");
            AccountModel account = new AccountModel();
            account.setUserName(username);
            account.setPassWord(password);
            account.setRoleId(roleid);
            account.setStatus("Active");
            account.setFullName(fullname);
            service.insertAcc(account);
            req.setAttribute("note", "Thêm thành công");
            findAll(req, resp);

        } else {
            req.setAttribute("note", "Tên tài khoản đã tồn tại!!");
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/account/add-account.jsp");
            rd.forward(req, resp);
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AccountModel> list = service.findAll();
        req.setAttribute("listAccount", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/account/ql-account.jsp");
        rd.forward(req, resp);
    }
}
