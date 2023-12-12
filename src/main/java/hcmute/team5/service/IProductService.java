package hcmute.team5.service;

import hcmute.team5.model.CustomerModel;
import hcmute.team5.model.ProductModel;

import java.util.List;

public interface IProductService {
    List<ProductModel> findAll();

    public void updateProduct(ProductModel product);
    public void inserttoCard(String username, String masp, int Soluong);
    public ProductModel findOneByProduct(String maSP);
    public void deleteProduct(ProductModel product);

    void insertPro(ProductModel product);
}
