package hcmute.team5.controller.user;


import hcmute.team5.model.ProductModel;
import hcmute.team5.service.IProductDetailService;
import hcmute.team5.service.impl.ProductDetailService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/user-product"})
public class DetailProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IProductDetailService service = new ProductDetailService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("product")) {
            getDetailProduct(req, resp);
        }
    }
    private void getDetailProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maSP = req.getParameter("pid");
        ProductModel p = service.getDetailProduct(maSP);
        req.setAttribute("detail",p);
        RequestDispatcher rd = req.getRequestDispatcher("/views/user/DetailProduct.jsp");
        rd.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
