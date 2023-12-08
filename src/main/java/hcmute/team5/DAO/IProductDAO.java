package hcmute.team5.DAO;

import hcmute.team5.model.ProductModel;
import java.util.List;

public interface IProductDAO {
    public List<ProductModel> getListProDuctByCategory (String maLoaiSP);
    public List<ProductModel> getListProductByNCC (String ncc);
    public  ProductModel getDetailProduct(String maSP);

}
