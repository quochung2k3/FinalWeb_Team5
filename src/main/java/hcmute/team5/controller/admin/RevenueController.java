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
        if(url.contains("revenue-search")) {
            findAllByProperties(req, resp);
        }
    }

    private void findAllByProperties(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maChiNhanh = 0;
        String ngayBatDau = req.getParameter("ngayBatDau");
        String ngayKetThuc = req.getParameter("ngayKetThuc");
        switch ( req.getParameter("maChiNhanh") ) {
            case  "CN01":
                maChiNhanh = 1;
                break;
            case  "CN02":
                maChiNhanh = 2;
                break;
            case  "CN03":
                maChiNhanh = 3;
                break;
            case  "CN04":
                maChiNhanh = 4;
                break;
            case  "CN05":
                maChiNhanh = 5;
                break;
            default:
        }
        List<RevenueModel> list = service.findAllByProperties(maChiNhanh, ngayBatDau, ngayKetThuc);
        req.setAttribute("listBill", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/revenue/ql-revenue.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RevenueModel> list = service.findAll();
        req.setAttribute("listBill", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/revenue/ql-revenue.jsp");
        rd.forward(req, resp);
    }
}
