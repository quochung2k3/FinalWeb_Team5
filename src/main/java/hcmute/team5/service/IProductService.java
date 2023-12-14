package hcmute.team5.service;

import hcmute.team5.model.ProductModel;
import java.util.List;
public interface IProductService {
    List<ProductModel> findAll(int pageSize, int index);

    public void updateProduct(ProductModel product);

    public ProductModel findOneByProduct(int maSP);
    public void deleteProduct(ProductModel product);

    void insertPro(ProductModel product);
    List<ProductModel> findAllByProperties(int maChiNhanh, String status, int maSP, int maLoaiSP, int pageSize, int index);
    public int getNumOfProduct();
    public ProductModel findExistProduct(String tenSP, int maChiNhanh);
}
