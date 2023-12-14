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
        List<ProductModel> c= dao.getNext3Product(3);
        for(ProductModel o:c){
            System.out.println(o.getMaSp());
        }
    }
}
