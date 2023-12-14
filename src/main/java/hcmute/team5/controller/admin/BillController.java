package hcmute.team5.controller.admin;

import hcmute.team5.model.AccountModel;
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
    int pageSize = 5;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        req.setAttribute("name", account.getUserName());
        if (url.contains("ql-bill")) {
            findAll(req, resp);
        }
        if (url.contains("bill-details")) {
            findAllById(req, resp);
        }
        if (url.contains("bill-search")) {
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
        int index = 0;
        int num2 = 0;
        int numpage = 0;
        String text = req.getParameter("index");
        switch (maChiNhanh) {
            case "CN01":
                maCN = 1;
                break;
            case "CN02":
                maCN = 2;
                break;
            case "CN03":
                maCN = 3;
                break;
            case "CN04":
                maCN = 4;
                break;
            case "CN05":
                maCN = 5;
                break;
            default:
        }
        int maHD = 0;
        String maHDReq = req.getParameter("maHoaDon");
        if (!maHDReq.isEmpty()) {
            maHD = Integer.parseInt(req.getParameter("maHoaDon"));
        }
        List<BillModel> listNum = service.findAllByProperties(maCN, maHD, 999999999, 0);
        int numOfAccount = listNum.size();
        req.setAttribute("numOfAccount", numOfAccount);
        if (numOfAccount % pageSize == 0) {
            numpage = numOfAccount / pageSize;
        } else {
            numpage = numOfAccount / pageSize + 1;
        }
        req.setAttribute("numpage", numpage);
        if (text == null || text.equals("1")) {
            index = 0;
            num2 = pageSize;
        } else if (text.equals(String.valueOf(numpage))) {
            int temp = Integer.parseInt(req.getParameter("index"));
            index = (temp - 1) * pageSize;
            num2 = numOfAccount;
        } else {
            int temp = Integer.parseInt(req.getParameter("index"));
            num2 = temp * pageSize;
            index = (temp - 1) * pageSize;
        }
        if (pageSize >= numOfAccount) {
            num2 = numOfAccount;
        }
        req.setAttribute("num2", num2);
        List<BillModel> list = service.findAllByProperties(maCN, maHD, pageSize, index);
        req.setAttribute("listBill", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/bill/ql-bill.jsp");
        rd.forward(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("index");
        int index;
        int numOfBill = service.getNumOfBill();
        req.setAttribute("numOfAccount", numOfBill);
        int numpage = 0;
        int num2 = 0;
        if (numOfBill % pageSize == 0) {
            numpage = numOfBill / pageSize;
        } else {
            numpage = numOfBill / pageSize + 1;
        }
        req.setAttribute("numpage", numpage);
        if (text == null || text.equals("1")) {
            index = 0;
            num2 = pageSize;
        } else if (text.equals(String.valueOf(numpage))) {
            int temp = Integer.parseInt(req.getParameter("index"));
            index = (temp - 1) * pageSize;
            num2 = numOfBill;
        } else {
            int temp = Integer.parseInt(req.getParameter("index"));
            num2 = temp * pageSize;
            index = (temp - 1) * pageSize;
        }
        if (pageSize >= numOfBill) {
            num2 = numOfBill;
        }
        req.setAttribute("num2", num2);
        List<BillModel> list = service.findAll(pageSize, index);
        req.setAttribute("listBill", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/bill/ql-bill.jsp");
        rd.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
