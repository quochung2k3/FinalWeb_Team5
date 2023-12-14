package hcmute.team5.controller.user;

import hcmute.team5.model.*;
import hcmute.team5.service.ICartService;
import hcmute.team5.service.IProductDetailService;
import hcmute.team5.service.impl.CartService;
import hcmute.team5.service.impl.ProductDetailService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/user-home","/user-category","/user-supplier"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICartService service = new CartService();
	IProductDetailService service_p= new ProductDetailService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		loadData(req, resp);
	}

	public void loadData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
		List<SupplierModel> list_sup = service_p.getAllSuppliers();
		List<ProductTypeModel> list_c = service_p.getAllProductType();
		List<CartModel> list = service.findAll(account.getUserName());
		int length = list.size();
		req.setAttribute("length", length);
		req.setAttribute("name", account.getUserName());
		req.setAttribute("listc",list_c);
		req.setAttribute("listsup",list_sup);
		if(url.contains("user-home") || url.contains("user-solve-pay")) {
			getTop3(req, resp);
		}
		if(url.contains("user-category")) {
			getProductByProductType(req, resp);
		}
		if(url.contains("user-supplier")) {
			getProductByNCC(req, resp);
		}

		RequestDispatcher rd = req.getRequestDispatcher("/views/user/productList.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	private void getTop3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> list_p = service_p.getTop3();
		req.setAttribute("listpro",list_p);
	}
	private void getProductByNCC(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mancc = req.getParameter("sid");
		List<ProductModel> list_p = service_p.getAllProductByNCC(mancc);
		req.setAttribute("listpro",list_p);
	}
	private void getProductByProductType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maloai = req.getParameter("cid");
		List<ProductModel> list_p = service_p.getAllProDuctByProductType(maloai);
		req.setAttribute("listpro",list_p);
	}
}
