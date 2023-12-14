package hcmute.team5.controller.admin;

import hcmute.team5.model.AccountModel;
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

@WebServlet(urlPatterns = {"/admin-ql-voucher", "/admin-voucher-add", "/admin-voucher-update", "/admin-voucher-delete", "/admin-voucher-search"})
public class VoucherController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IVoucherService service = new VoucherService();
    int pageSize = 5;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        req.setAttribute("name", account.getUserName());
        if (url.contains("ql-voucher")) {
            findAll(req, resp);
        }
        if (url.contains("voucher-update")) {
            findOneById(req, resp);
        }
        if (url.contains("voucher-add")) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/voucher/add-voucher.jsp");
            rd.forward(req, resp);
        }
        if (url.contains("voucher-delete")) {
            deleteVoucher(req, resp);
        }
        if (url.contains("voucher-search")) {
            findAllByProperties(req, resp);
        }
    }

    private void findAllByProperties(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = 0;
        int num2 = 0;
        int numpage = 0;
        String text = req.getParameter("index");
        String status = req.getParameter("status");
        int maVC = 0;
        String maVCText = req.getParameter("maVC");
        if (!maVCText.isEmpty()) {
            maVC = Integer.parseInt(req.getParameter("maVC"));
        }
        List<VoucherModel> listNum = service.findAllByProperties(status, maVC, 999999999, 0);
        int numOfVoucher = listNum.size();
        req.setAttribute("numOfAccount", numOfVoucher);
        if (numOfVoucher % pageSize == 0) {
            numpage = numOfVoucher / pageSize;
        } else {
            numpage = numOfVoucher / pageSize + 1;
        }
        req.setAttribute("numpage", numpage);
        if (text == null || text.equals("1")) {
            index = 0;
            num2 = pageSize;
        } else if (text.equals(String.valueOf(numpage))) {
            int temp = Integer.parseInt(req.getParameter("index"));
            index = (temp - 1) * pageSize;
            num2 = numOfVoucher;
        } else {
            int temp = Integer.parseInt(req.getParameter("index"));
            num2 = temp * pageSize;
            index = (temp - 1) * pageSize;
        }
        if (pageSize >= numOfVoucher) {
            num2 = numOfVoucher;
        }
        req.setAttribute("num2", num2);
        List<VoucherModel> list = service.findAllByProperties(status, maVC, pageSize, index);
        req.setAttribute("listVoucher", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/voucher/ql-voucher.jsp");
        rd.forward(req, resp);
    }

    private void deleteVoucher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maVC = Integer.parseInt(req.getParameter("maVC"));
        service.deleteVoucher(maVC);
        findAll(req, resp);
    }

    private void findOneById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maVC = Integer.parseInt(req.getParameter("maVC"));
        String tenVC = service.getName(maVC);
        VoucherModel voucher = service.findOneById(tenVC);
        req.setAttribute("voucher", voucher);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/voucher/update-voucher.jsp");
        rd.forward(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("index");
        int index;
        int numOfVoucher = service.getNumOfVoucher();
        req.setAttribute("numOfAccount", numOfVoucher);
        int numpage = 0;
        int num2 = 0;
        if (numOfVoucher % pageSize == 0) {
            numpage = numOfVoucher / pageSize;
        } else {
            numpage = numOfVoucher / pageSize + 1;
        }
        req.setAttribute("numpage", numpage);
        if (text == null || text.equals("1")) {
            index = 0;
            num2 = pageSize;
        } else if (text.equals(String.valueOf(numpage))) {
            int temp = Integer.parseInt(req.getParameter("index"));
            index = (temp - 1) * pageSize;
            num2 = numOfVoucher;
        } else {
            int temp = Integer.parseInt(req.getParameter("index"));
            num2 = temp * pageSize;
            index = (temp - 1) * pageSize;
        }
        if (pageSize >= numOfVoucher) {
            num2 = numOfVoucher;
        }
        req.setAttribute("num2", num2);
        List<VoucherModel> list = service.findAll(pageSize, index);
        req.setAttribute("listVoucher", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/voucher/ql-voucher.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("voucher-add")) {
            insertIntoVoucher(req, resp);
        }
        if (url.contains("voucher-update")) {
            updateVoucher(req, resp);
        }
    }

    private void updateVoucher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maVC = Integer.parseInt(req.getParameter("maVC"));
        String tenVC = req.getParameter("tenVoucher");
        float phanTramGiam = Float.parseFloat(req.getParameter("phanTramGiam"));
        String ngayBatDau = req.getParameter("ngayBatDau");
        String ngayKetThuc = req.getParameter("ngayKetThuc");
        int soLuong = Integer.parseInt(req.getParameter("soLuong"));
        VoucherModel voucher = new VoucherModel();
        voucher.setMaVC(maVC);
        voucher.setTenVC(tenVC);
        voucher.setPhanTramGiam(phanTramGiam);
        voucher.setNgayBatDau(ngayBatDau);
        voucher.setNgayKetThuc(ngayKetThuc);
        voucher.setSoLuong(soLuong);
        service.updateVoucher(voucher);
        req.setAttribute("note", "Cập nhật thành công");
        findAll(req, resp);
    }

    private void insertIntoVoucher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenVC = req.getParameter("tenVoucher");
        float phanTramGiam = Float.parseFloat(req.getParameter("phanTramGiam"));
        String ngayBatDau = req.getParameter("ngayBatDau");
        String ngayKetThuc = req.getParameter("ngayKetThuc");
        int soLuong = Integer.parseInt(req.getParameter("soLuong"));
        if (service.findOneById(tenVC) == null) {
            VoucherModel voucher = new VoucherModel();
            voucher.setTenVC(tenVC);
            voucher.setPhanTramGiam(phanTramGiam);
            voucher.setNgayBatDau(ngayBatDau);
            voucher.setNgayKetThuc(ngayKetThuc);
            voucher.setSoLuong(soLuong);
            service.insertIntoVoucher(voucher);
            req.setAttribute("note", "Thêm thành công");
            findAll(req, resp);

        } else {
            req.setAttribute("note", "Voucher đã tồn tại!!");
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/voucher/add-voucher.jsp");
            rd.forward(req, resp);
        }
        findAll(req, resp);
    }
}