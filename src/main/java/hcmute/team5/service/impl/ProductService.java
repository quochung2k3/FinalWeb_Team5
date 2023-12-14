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
    public List<ProductModel> findAll(int pageSize, int index) {
        return productDAL.findAll(pageSize, index);
    }

    @Override
    public void updateProduct(ProductModel product) {
        productDAL.updateProduct(product);
    }

    @Override
    public ProductModel findOneByProduct(int maSP) {
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

    @Override
    public List<ProductModel> findAllByProperties(int maChiNhanh, String status, int maSP, int maLoaiSP, int pageSize, int index) {
        return productDAL.findAllByProperties(maChiNhanh, status, maSP, maLoaiSP, pageSize, index);
    }

    @Override
    public int getNumOfProduct() {
        return productDAL.getNumOfProduct();
    }

    @Override
    public ProductModel findExistProduct(String tenSP, int maChiNhanh) {
        return productDAL.findExistProduct(tenSP, maChiNhanh);
    }
}