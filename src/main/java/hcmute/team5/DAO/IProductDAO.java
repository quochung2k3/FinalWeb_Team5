package hcmute.team5.DAO;

import hcmute.team5.model.CustomerModel;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;

import java.util.List;

public interface IProductDAO {
    public List<ProductModel> getListProDuctByProductType(String maLoaiSP, String maSP);
    public List<ProductModel> getListProductByNCC (String mancc, String maSP);
    public  ProductModel getDetailProduct(String maSP);
    public List<ProductTypeModel> getAllProductType();
    public List<ProductModel> getAllProduct();
    public List<ProductModel> getListProDuctViewed(String maSP, String username);
    public void insertviewed(String username, String masp);

    List<ProductModel> findAll(int pageSize, int index);

    void updateProduct(ProductModel product);

    ProductModel findOneByProduct(int maSP);
    void insert(ProductModel product);
    void deleteProduct(ProductModel product);
    void insertPro(ProductModel product);
    List<ProductModel> findAllByProperties(int maChiNhanh, String status, int maSP, int maLoaiSP, int pageSize, int index);
    int getNumOfProduct();
    ProductModel findExistProduct(String tenSP, int maChiNhanh);
    void inserttoCart(String username, String masp, int Soluong);
}