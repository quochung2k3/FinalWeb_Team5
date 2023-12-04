package hcmute.team5.controller.admin;

import hcmute.team5.model.AccountModel;
import hcmute.team5.service.IAccountService;
import hcmute.team5.service.impl.AccountService;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin-home", "/admin-ql-account"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IAccountService service = new AccountService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
		req.setAttribute("name", account.getUserName());
		if(url.contains("home")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/home.jsp");
			rd.forward(req, resp);
		}
		if(url.contains("account")) {
			findAll(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		if(url.contains("/logout")){
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AccountModel> list = service.findAll();
		req.setAttribute("listAccount", list);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/ql-account.jsp");
		rd.forward(req, resp);
	}
}
