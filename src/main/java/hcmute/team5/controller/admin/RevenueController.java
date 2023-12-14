package hcmute.team5.controller.admin;

import hcmute.team5.mapper.BillMapper;
import hcmute.team5.model.BillModel;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.RevenueModel;
import hcmute.team5.service.IBillService;
import hcmute.team5.service.IRevenueService;
import hcmute.team5.service.impl.BillService;
import hcmute.team5.service.impl.RevenueService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-ql-revenue", "/admin-revenue-search"})
public class RevenueController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IRevenueService service = new RevenueService();
    IBillService sv = new BillService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("ql-revenue")) {
            findAll(req, resp);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
    }
    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RevenueModel> list = service.findAll();
        req.setAttribute("listBill", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/revenue/ql-revenue.jsp");
        rd.forward(req, resp);
    }

}
