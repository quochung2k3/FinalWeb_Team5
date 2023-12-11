package hcmute.team5.test;

import hcmute.team5.DAO.impl.ProductDAO;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;
import java.util.List;
public class main {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        dao.insertviewed("luankh@gmail.com","1");
    }
}
