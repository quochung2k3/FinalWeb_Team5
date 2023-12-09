package hcmute.team5.DAO;

import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;

import java.util.List;

public interface IProductDAO {
    public List<ProductModel> getListProDuctByProductType(String maLoaiSP);
    public List<ProductModel> getListProductByNCC (String ncc);
    public  ProductModel getDetailProduct(String maSP);
    public List<ProductTypeModel> getAllProductType();
    public List<ProductModel> getAllProduct();

}
