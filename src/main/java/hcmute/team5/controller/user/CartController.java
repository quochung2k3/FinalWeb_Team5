package hcmute.team5.controller.user;

import hcmute.team5.model.AccountModel;
import hcmute.team5.model.CartModel;
import hcmute.team5.service.ICartService;
import hcmute.team5.service.impl.CartService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/user-cart"})
public class CartController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ICartService service = new CartService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        if(url.contains("user-cart")) {
            findAll(req, resp);
        }
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

    }
}