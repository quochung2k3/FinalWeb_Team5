package hcmute.team5.controller.user;

import hcmute.team5.model.AccountModel;
import hcmute.team5.model.CartModel;
import hcmute.team5.model.ProductModel;
import hcmute.team5.service.ICartService;
import hcmute.team5.service.IProductService;
import hcmute.team5.service.impl.CartService;
import hcmute.team5.service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/user-home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICartService service = new CartService();
	IProductService service_p= new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
		if(url.contains("user-home")) {
//			List<ProductModel> list_p =service_p.findAll();
			List<CartModel> list = service.findAll(account.getUserName());
			int length = list.size();
			req.setAttribute("length", length);
			req.setAttribute("name", account.getUserName());
//			req.setAttribute("listpro",list_p);
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/productList.jsp");
			rd.forward(req, resp);
		}

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
