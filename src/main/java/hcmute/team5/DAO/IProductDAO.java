package hcmute.team5.DAO;

import hcmute.team5.model.*;

import java.util.List;

public interface IProductDAO {
    public List<ProductModel> getListProDuctByProductType(String maLoaiSP, String maSP);
    public List<ProductModel> getListProductByNCC (String mancc, String maSP);
    public  ProductModel getDetailProduct(String maSP);
    public List<ProductTypeModel> getAllProductType();
    public List<ProductModel> getAllProduct();
    public List<ProductModel> getListProDuctViewed(String maSP, String username);
    public void insertviewed(String username, String masp);
    public List<SupplierModel> getAllSuppliers();
    List<ProductModel> findAll();
    void inserttoCart(String username, String masp, int Soluong);
    void updateProduct(ProductModel product);
    public List<ProductModel> getAllProductByNCC(String mancc);
    public List<ProductModel> getAllProDuctByProductType(String maLoaiSP);
    ProductModel findOneByProduct(String maSP);
    void insert(ProductModel product);
    void deleteProduct(ProductModel product);
    void insertPro(ProductModel product);

}
