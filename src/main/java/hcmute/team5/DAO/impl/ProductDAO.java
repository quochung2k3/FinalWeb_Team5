package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.IProductDAO;
import hcmute.team5.model.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO{
    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;
    PreparedStatement ps = null;

    @Override
    public List<ProductModel> getListProDuctByCategory(String maLoaiSP) {
        return null;
    }

    @Override
    public List<ProductModel> getListProductByNCC(String ncc) {
        return null;
    }

    @Override
    public ProductModel getDetailProduct(String maSP){
        String sql = "SELECT * FROM SanPham WHERE masanpham = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setMaSP(rs.getString("masanpham"));
                product.setTenSP(rs.getString("tensanpham"));
                product.setMaLoaiSP(rs.getString("maloaisanpham"));
                product.setGia(rs.getInt("gia"));
                product.setTrangThai(rs.getString("trangthai"));
                conn.close();
                return product;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
