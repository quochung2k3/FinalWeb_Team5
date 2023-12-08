package hcmute.team5.service.impl;


import hcmute.team5.DAO.IProductDAO;
import hcmute.team5.DAO.impl.ProductDAO;
import hcmute.team5.model.ProductModel;
import hcmute.team5.service.IProductDetailService;

public class ProductDetailService implements IProductDetailService {
    IProductDAO productDAL = new ProductDAO();

    @Override
    public ProductModel getDetailProduct(String maSP) {return productDAL.getDetailProduct(maSP);}
}
