package hcmute.team5.service.impl;

import hcmute.team5.DAO.IProductDAO;
import hcmute.team5.DAO.impl.ProductDAO;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;
import hcmute.team5.model.SupplierModel;
import hcmute.team5.service.IProductDetailService;

import java.util.List;

public class ProductDetailService implements IProductDetailService {
    IProductDAO productDAL = new ProductDAO();

    @Override
    public ProductModel getDetailProduct(String maSP) {
        return productDAL.getDetailProduct(maSP);
    }

    public List<ProductModel> getListProDuctByProductType(String maLoaiSP, String maSP) {return productDAL.getListProDuctByProductType(maLoaiSP,maSP);}
    public List<ProductModel> getAllProduct(){return productDAL.getAllProduct();}
    public List<ProductTypeModel> getAllProductType(){return  productDAL.getAllProductType();}
    public List<ProductModel> getListProductByNCC (String mancc, String maSP){return  productDAL.getListProductByNCC(mancc,maSP);}
    public List<ProductModel> getListProDuctViewed(String maSP, String username){return productDAL.getListProDuctViewed(maSP,username);}
    public void insertviewed(String username, String masp){productDAL.insertviewed(username,masp);}
    public void inserttoCart(String username, String masp, int Soluong){productDAL.inserttoCart(username, masp, Soluong);}
    public List<SupplierModel> getAllSuppliers(){return productDAL.getAllSuppliers();}
    public List<ProductModel> getAllProductByNCC(String mancc) {return  productDAL.getAllProductByNCC(mancc);}
    public List<ProductModel> getTop3(){return productDAL.getTop3();}
    public List<ProductModel> getNext3Product(int amount){return productDAL.getNext3Product(amount);}
    public List<ProductModel> getAllProDuctByProductType(String maLoaiSP){return productDAL.getAllProDuctByProductType(maLoaiSP);}
}
