package hcmute.team5.controller.admin;

import hcmute.team5.model.CustomerModel;
import hcmute.team5.model.ProductModel;
import hcmute.team5.service.ICustomerService;
import hcmute.team5.service.IProductService;
import hcmute.team5.service.impl.CustomerService;
import hcmute.team5.service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = {"/admin-ql-product", "/admin-product-update", "/admin-product-delete", "/admin-product-add"})
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IProductService service = new ProductService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("ql-product")) {
            findAll(req, resp);
        }
        if(url.contains("product-update")) {
            findOneByProduct(req, resp);
        }
        if(url.contains("product-delete")) {
            deleteProduct(req, resp);
        }
        if(url.contains("add")) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/add-product.jsp");
            rd.forward(req, resp);
        }

    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maSP = req.getParameter("masp");
        String tenSP = req.getParameter("tensp");
        Float gia = Float.parseFloat(req.getParameter("gia"));
        String trangThai = req.getParameter("trangthai");
        ProductModel product = new ProductModel();
        product.setMaSP(maSP);
        product.setTenSP(tenSP);
        product.setGia(gia);
        product.setTrangThai(trangThai);
        service.updateProduct(product);
        req.setAttribute("note", "Cập nhật thành công");
        findAll(req, resp);
    }
    private void findOneByProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maSP = req.getParameter("maSP");
        ProductModel product = service.findOneByProduct(maSP);
        req.setAttribute("product", product);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/update-product.jsp");
        rd.forward(req, resp);
    }
    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maSP = req.getParameter("maSP");
        System.out.println(maSP);
        ProductModel product = new ProductModel();
        product.setMaSP(maSP);
        service.deleteProduct(product);
        findAll(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductModel> list = service.findAll();
        req.setAttribute("listProduct", list);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/ql-product.jsp");
        rd.forward(req, resp);
    }
    private void postProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maSP = req.getParameter("masp");
        String tenSP = req.getParameter("tensp");
        String maLoaiSP = req.getParameter("maloaisp");
        Float gia = Float.parseFloat(req.getParameter("gia"));
        String maChiNhanh = req.getParameter("machinhanh");
        String trangThai = req.getParameter("trangthai");
        if (service.findOneByProduct(maSP) == null) {
            ProductModel product = new ProductModel();
            product.setMaSP(maSP);
            product.setTenSP(tenSP);
            product.setMaLoaiSP(maLoaiSP);
            product.setGia(gia);
            product.setMachinhanh(maChiNhanh);
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
        if(url.contains("delete")){
            deleteProduct(req, resp);
        }
        if(url.contains("update")) {
            update(req, resp);
        }
        if(url.contains("add")) {
            postProduct(req, resp);
        }
    }
}
