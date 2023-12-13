package hcmute.team5.controller.admin;

import hcmute.team5.model.VoucherModel;
import hcmute.team5.service.IVoucherService;
import hcmute.team5.service.impl.VoucherService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-ql-voucher"})
public class VoucherController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IVoucherService service = new VoucherService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("ql-voucher")) {
            findAll(req, resp);
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<VoucherModel> list = service.findAll();
        req.setAttribute("listVoucher", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/voucher/ql-voucher.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
