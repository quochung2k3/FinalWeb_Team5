package hcmute.team5.test;

import hcmute.team5.DAO.impl.CartDAO;
import hcmute.team5.DAO.impl.ProductDAO;
import hcmute.team5.model.CartModel;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;
import hcmute.team5.model.SupplierModel;

import java.util.List;
public class main {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        SupplierModel p = dao.getDetailProduct("1");
        System.out.println(p.getTenNcc());

    }
}
