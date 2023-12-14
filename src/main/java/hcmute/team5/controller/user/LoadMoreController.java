package hcmute.team5.controller.user;

import hcmute.team5.model.ProductModel;
import hcmute.team5.service.IProductDetailService;
import hcmute.team5.service.impl.ProductDetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(urlPatterns = {"/load"})
public class LoadMoreController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IProductDetailService service = new ProductDetailService();
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getTop3(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    private void getTop3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int amount = Integer.parseInt(req.getParameter("exits"));
        resp.setContentType("text/html; charset=UTF-8");
        List<ProductModel> list = service.getNext3Product(amount);
        PrintWriter out = resp.getWriter();
        for(ProductModel o: list){
            out.println("<div class=\"product col-md-4\" type=\"button\" onclick=\"productdetail(" + o.getMaSp() + ")\" >\n" +
                    "                        <div class=\"card\" style= \"height: 350px\">\n" +
                    "                            <div class=\"text-center\"><img style= \"width: 250px\" src=" + o.getImage() + "></div>\n" +
                    "                            <div class=\"about text-center\" >\n" +
                    "                                <h5 >" + o.getTenSP() + "</h5>\n" +
                    "                                <span><i class=\"me-1 fa fa-shopping-basket\"></i> " + o.getGia() + "$</span>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                        <br>\n" +
                    "                    </div>");
        }
    }
}
