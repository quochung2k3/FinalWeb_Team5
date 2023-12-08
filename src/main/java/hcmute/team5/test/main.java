package hcmute.team5.test;

import hcmute.team5.DAO.impl.ProductDAO;
import hcmute.team5.model.ProductModel;

public class main {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        ProductModel p = dao.getDetailProduct("1");
            System.out.println(p.getTenSP());
    }
}
