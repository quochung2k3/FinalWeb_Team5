package hcmute.team5.controller.admin;

import hcmute.team5.model.AccountModel;
import hcmute.team5.model.ProductModel;
import hcmute.team5.service.IProductService;
import hcmute.team5.service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-ql-product", "/admin-product-update", "/admin-product-delete", "/admin-product-add", "/admin-product-search"})
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IProductService service = new ProductService();
    int pageSize = 5;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        req.setAttribute("name", account.getUserName());
        if (url.contains("ql-product")) {
            findAll(req, resp);
        }
        if (url.contains("product-update")) {
            findOneByProduct(req, resp);
        }
        if (url.contains("product-delete")) {
            deleteProduct(req, resp);
        }
        if (url.contains("add")) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/add-product.jsp");
            rd.forward(req, resp);
        }
        if (url.contains("product-search")) {
            findAllByProperties(req, resp);
        }

    }

    private void findAllByProperties(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = 0;
        int num2 = 0;
        int numpage = 0;
        String text = req.getParameter("index");
        int maChiNhanh = 0;
        int maSP = 0;
        int maLoaiSP = 0;
        switch (req.getParameter("maChiNhanh")) {
            case "CN01":
                maChiNhanh = 1;
                break;
            case "CN02":
                maChiNhanh = 2;
                break;
            case "CN03":
                maChiNhanh = 3;
                break;
            case "CN04":
                maChiNhanh = 4;
                break;
            case "CN05":
                maChiNhanh = 5;
                break;
            default:
        }
        if (!req.getParameter("maLoaiSP").isEmpty()) {
            maLoaiSP = Integer.parseInt(req.getParameter("maLoaiSP"));
        }
        if (!req.getParameter("maSP").isEmpty()) {
            maSP = Integer.parseInt(req.getParameter("maSP"));
        }
        String status = req.getParameter("status");
        List<ProductModel> listNum = service.findAllByProperties(maChiNhanh, status, maSP, maLoaiSP, 999999999, 0);
        int numOfProduct = listNum.size();
        req.setAttribute("numOfAccount", numOfProduct);
        if (numOfProduct % pageSize == 0) {
            numpage = numOfProduct / pageSize;
        } else {
            numpage = numOfProduct / pageSize + 1;
        }
        req.setAttribute("numpage", numpage);
        if (text == null || text.equals("1")) {
            index = 0;
            num2 = pageSize;
        } else if (text.equals(String.valueOf(numpage))) {
            int temp = Integer.parseInt(req.getParameter("index"));
            index = (temp - 1) * pageSize;
            num2 = numOfProduct;
        } else {
            int temp = Integer.parseInt(req.getParameter("index"));
            num2 = temp * pageSize;
            index = (temp - 1) * pageSize;
        }
        if (pageSize >= numOfProduct) {
            num2 = numOfProduct;
        }
        req.setAttribute("num2", num2);
        List<ProductModel> listProduct = service.findAllByProperties(maChiNhanh, status, maSP, maLoaiSP, pageSize, index);
        req.setAttribute("listProduct", listProduct);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/ql-product.jsp");
        rd.forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maSP = Integer.parseInt(req.getParameter("masp"));
        String tenSP = req.getParameter("tensp");
        int gia = Integer.parseInt(req.getParameter("gia"));
        String trangThai = req.getParameter("trangthai");
        ProductModel product = new ProductModel();
        product.setMaSp(maSP);
        product.setTenSP(tenSP);
        product.setGia(gia);
        product.setTrangThai(trangThai);
        service.updateProduct(product);
        req.setAttribute("note", "Cập nhật thành công");
        findAll(req, resp);
    }

    private void findOneByProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maSP = Integer.parseInt(req.getParameter("maSP"));
        ProductModel product = service.findOneByProduct(maSP);
        req.setAttribute("product", product);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/update-product.jsp");
        rd.forward(req, resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maSP = Integer.parseInt(req.getParameter("maSP"));
        System.out.println(maSP);
        ProductModel product = new ProductModel();
        product.setMaSp(maSP);
        service.deleteProduct(product);
        findAll(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("index");
        int index;
        int numOfProduct = service.getNumOfProduct();
        req.setAttribute("numOfAccount", numOfProduct);
        int numpage = 0;
        int num2 = 0;
        if (numOfProduct % pageSize == 0) {
            numpage = numOfProduct / pageSize;
        } else {
            numpage = numOfProduct / pageSize + 1;
        }
        req.setAttribute("numpage", numpage);
        if (text == null || text.equals("1")) {
            index = 0;
            num2 = pageSize;
        } else if (text.equals(String.valueOf(numpage))) {
            int temp = Integer.parseInt(req.getParameter("index"));
            index = (temp - 1) * pageSize;
            num2 = numOfProduct;
        } else {
            int temp = Integer.parseInt(req.getParameter("index"));
            num2 = temp * pageSize;
            index = (temp - 1) * pageSize;
        }
        if (pageSize >= numOfProduct) {
            num2 = numOfProduct;
        }
        req.setAttribute("num2", num2);
        List<ProductModel> list = service.findAll(pageSize, index);
        req.setAttribute("listProduct", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/ql-product.jsp");
        rd.forward(req, resp);
    }

    private void postProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenSP = req.getParameter("tensp");
        String maLoaiSP = req.getParameter("maloaisp");
        int gia = Integer.parseInt(req.getParameter("gia"));
        int maChiNhanh = Integer.parseInt(req.getParameter("machinhanh"));
        String trangThai = req.getParameter("trangthai");
        if (service.findExistProduct(tenSP, maChiNhanh) == null) {
            ProductModel product = new ProductModel();
            product.setTenSP(tenSP);
            product.setMaLoaiSP(maLoaiSP);
            product.setGia(gia);
            product.setMaChiNhanh(maChiNhanh);
            product.setTrangThai(trangThai);
            service.insertPro(product);
            req.setAttribute("note", "Thêm thành công");
            findAll(req, resp);

        } else {
            req.setAttribute("note", "Sản phẩm đã tồn tại!!");
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/add-product.jsp");
            rd.forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("delete")) {
            deleteProduct(req, resp);
        }
        if (url.contains("update")) {
            update(req, resp);
        }
        if (url.contains("add")) {
            postProduct(req, resp);
        }
    }
}