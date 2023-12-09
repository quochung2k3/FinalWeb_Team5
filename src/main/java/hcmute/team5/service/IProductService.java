package hcmute.team5.service;

import hcmute.team5.model.CustomerModel;
import hcmute.team5.model.ProductModel;

import java.util.List;

public interface IProductService {
    List<ProductModel> findAll();

    public void updateProduct(ProductModel product);

    public ProductModel findOneByProduct(String maSP);
    public void deleteProduct(ProductModel product);

    void insertPro(ProductModel product);
}
