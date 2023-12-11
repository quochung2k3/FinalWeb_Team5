
package hcmute.team5.service;

import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;

import java.util.List;

public interface IProductDetailService {
    ProductModel getDetailProduct(String maSP);
    List<ProductModel> getListProductByNCC (String mancc, String maSP);
    List<ProductTypeModel> getAllProductType();
    List<ProductModel> getAllProduct();
    List<ProductModel> getListProDuctByProductType(String maLoaiSP, String maSP);
    public List<ProductModel> getListProDuctViewed(String maSP, String username);
    public void insertviewed(String username, String masp);
}
