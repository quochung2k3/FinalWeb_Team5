package hcmute.team5.controller;

import hcmute.team5.model.UserModel;
import hcmute.team5.service.IUserService;
import hcmute.team5.service.impl.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.Serial;

@WebServlet(urlPatterns = {"/login", "/register", "/waiting", "/logout"})
public class LoginController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    IUserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        if (path.contains("/login")) {
            getLogin(req, resp);
        } else if (path.contains("/register")) {
            req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
        } else if (path.contains("/waiting")) {
            getWaiting(req, resp);
        } else if (path.contains("/logout")) {
            getLogout(req, resp);
        }
    }

    private void getLogout(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().removeAttribute("account");

        // remove cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
        }
        try {
            resp.sendRedirect(req.getContextPath() +"/waiting");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getWaiting(HttpServletRequest req, HttpServletResponse resp) {
        // do authorization and redirect
        UserModel account = (UserModel) req.getSession(false).getAttribute("account");
        if (account != null) {
            if (account.getRoleId() == 1) {
                try {
                    resp.sendRedirect(req.getContextPath() +"/admin-home");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    resp.sendRedirect(req.getContextPath() +"/trang-chu");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                resp.sendRedirect(req.getContextPath() +"/trang-chu");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void getLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getSession().getAttribute("account") != null) {
            resp.sendRedirect(req.getContextPath() + "/waiting");
            return;
        }
        // check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    HttpSession session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/waiting");
                    return;
                }
            }
        }
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        System.out.println(path);
        if (path.contains("/login")) {
            postLogin(req, resp);
        } else if (path.contains("/register")) {
            postRegister(req, resp);
        }
    }

    private void postRegister(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        if (service.findOneByUsername(username) == null) {
            String password = req.getParameter("password");
            UserModel account = new UserModel();
            account.setUserName(username);
            account.setPassWord(password);
            account.setRoleId(2);
            service.insert(account);
            try {
                resp.sendRedirect(req.getContextPath() +"/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                resp.sendRedirect(req.getContextPath() +"/register");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void postLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        UserModel account = service.login(username, password);
        if (account != null) {
            // if remember is checked, set cookie
            if (remember != null) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60 *  30);
                resp.addCookie(cookie);
            }

            req.getSession().setAttribute("account", account);
            try {
                resp.sendRedirect(req.getContextPath() +"/waiting");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}