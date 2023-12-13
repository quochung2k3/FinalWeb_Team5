package hcmute.team5.controller.user;


import hcmute.team5.model.AccountModel;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;
import hcmute.team5.service.IProductDetailService;
import hcmute.team5.service.impl.AccountService;
import hcmute.team5.service.impl.ProductDetailService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(urlPatterns = {"/user-product"})
public class DetailProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IProductDetailService service = new ProductDetailService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        req.setAttribute("name", account.getUserName());
        if(url.contains("product")) {
            getDetailProduct(req, resp, account);
        }
    }
    private void getDetailProduct(HttpServletRequest req, HttpServletResponse resp, AccountModel account) throws ServletException, IOException {
        String maSP = req.getParameter("pid");
        ProductModel p = service.getDetailProduct(maSP);
        req.setAttribute("detail",p);

        String maLoaiSP = p.getMaLoaiSP();
        List<ProductModel> p_similar = service.getListProDuctByProductType(maLoaiSP, maSP);
        req.setAttribute("detail_same",p_similar);

        String mancc = p.getMaNcc();
        List<ProductModel> p_similarncc = service.getListProductByNCC(mancc, maSP);
        req.setAttribute("detail_same_ncc",p_similarncc);


        String username = account.getUserName();
        List<ProductModel> p_viewed = service.getListProDuctViewed(maSP,username);
        req.setAttribute("detail_viewed",p_viewed);

        service.insertviewed(username,maSP);

        RequestDispatcher rd = req.getRequestDispatcher("/views/user/DetailProduct.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        inserttoCart(req,resp);
        doGet(req,resp);
    }
    private void inserttoCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        AccountModel account = (AccountModel) req.getSession(false).getAttribute("account");
        String username = account.getUserName();
        String maSP = req.getParameter("pid");
        int Soluong = Integer.parseInt(req.getParameter("quantity"));
        service.inserttoCart(username,maSP,Soluong);
    }
}
