package hcmute.team5.controller.admin;

import hcmute.team5.model.BillDetailsModel;
import hcmute.team5.model.BillModel;
import hcmute.team5.service.IBillService;
import hcmute.team5.service.impl.BillService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-ql-bill", "/admin-bill-details", "/admin-bill-search"})
public class BillController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IBillService service = new BillService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("ql-bill")) {
            findAll(req, resp);
        }
        if(url.contains("bill-details")) {
            findAllById(req, resp);
        }
        if(url.contains("bill-search")) {
            findAllByProperties(req, resp);
        }
    }

    private void findAllById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maHD = Integer.parseInt(req.getParameter("mahd"));
        List<BillDetailsModel> list = service.findAllById(maHD);
        req.setAttribute("listBillDetails", list);
        req.setAttribute("MaHD", maHD);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/bill/bill-details.jsp");
        rd.forward(req, resp);
    }

    private void findAllByProperties(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maChiNhanh = req.getParameter("maChiNhanh");
        int maCN = 0;
        switch ( maChiNhanh ) {
            case  "CN01":
                maCN = 1;
                break;
            case  "CN02":
                maCN = 2;
                break;
            case  "CN03":
                maCN = 3;
                break;
            case  "CN04":
                maCN = 4;
                break;
            case  "CN05":
                maCN = 5;
                break;
            default:
        }
        int maHD = 0;
        String maHDReq = req.getParameter("maHoaDon");
        if(!maHDReq.isEmpty()) {
            maHD = Integer.parseInt(req.getParameter("maHoaDon"));
        }
        List<BillModel> list = service.findAllByProperties(maCN, maHD);
        req.setAttribute("listBill", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/bill/ql-bill.jsp");
        rd.forward(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BillModel> list = service.findAll();
        req.setAttribute("listBill", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/bill/ql-bill.jsp");
        rd.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
