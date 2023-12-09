package hcmute.team5.test;

import hcmute.team5.DAO.impl.ProductDAO;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;
import java.util.List;
public class main {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        ProductModel p = dao.getDetailProduct("1");
        List<ProductModel> p_similar = dao.getListProDuctByProductType(p.getMaLoaiSP());
        for (ProductModel o : p_similar) {
            System.out.println(o.getGia());
        }
    }
}
