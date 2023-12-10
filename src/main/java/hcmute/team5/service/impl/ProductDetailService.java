package hcmute.team5.service.impl;


import hcmute.team5.DAO.IProductDAO;
import hcmute.team5.DAO.impl.ProductDAO;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;
import hcmute.team5.service.IProductDetailService;

import java.util.List;

public class ProductDetailService implements IProductDetailService {
    IProductDAO productDAL = new ProductDAO();

    @Override
    public ProductModel getDetailProduct(String maSP) {return productDAL.getDetailProduct(maSP);}

    public List<ProductModel> getListProDuctByProductType(String maLoaiSP, String maSP) {return productDAL.getListProDuctByProductType(maLoaiSP,maSP);}
    public List<ProductModel> getAllProduct(){return productDAL.getAllProduct();}
    public List<ProductTypeModel> getAllProductType(){return  productDAL.getAllProductType();}
    public List<ProductModel> getListProductByNCC (String mancc, String maSP){return  productDAL.getListProductByNCC(mancc,maSP);}
    public List<ProductModel> getListProDuctViewed(String maSP, String username){return productDAL.getListProDuctViewed(maSP,username);}
}
