package hcmute.team5.service;

import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;
import hcmute.team5.model.SupplierModel;

import java.util.List;

public interface IProductDetailService {
    SupplierModel getDetailProduct(String maSP);

    List<ProductModel> getListProductByNCC(String mancc, String maSP);

    List<ProductTypeModel> getAllProductType();

    List<ProductModel> getListProDuctByProductType(String maLoaiSP, String maSP);

    List<ProductModel> getListProDuctViewed(String maSP, String username);

    void insertviewed(String username, String masp);
    List<SupplierModel> getAllSuppliers();
    List<ProductModel> getAllProductByNCC(String mancc);
    public List<ProductModel> getAllProDuctByProductType(String maLoaiSP);
    void inserttoCart(String username, String masp, int Soluong);
    public List<ProductModel> getTop3();
    public List<ProductModel> getNext3Product(int amount);
}
