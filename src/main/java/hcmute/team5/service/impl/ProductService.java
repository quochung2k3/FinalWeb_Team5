package hcmute.team5.service.impl;

import hcmute.team5.DAO.IProductDAO;
import hcmute.team5.DAO.impl.ProductDAO;
import hcmute.team5.model.ProductModel;
import hcmute.team5.service.ICustomerService;
import hcmute.team5.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductDAO productDAL = new ProductDAO();
    @Override
    public List<ProductModel> findAll() {
        return productDAL.findAll();
    }

    @Override
    public void updateProduct(ProductModel product) {
        productDAL.updateProduct(product);
    }

    @Override
    public ProductModel findOneByProduct(String maSP) {
        return productDAL.findOneByProduct(maSP);
    }

    @Override
    public void deleteProduct(ProductModel product) {
        productDAL.deleteProduct(product);
    }

    @Override
    public void insertPro(ProductModel product) {
        productDAL.insertPro(product);
    }

}
