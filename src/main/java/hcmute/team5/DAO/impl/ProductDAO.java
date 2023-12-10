package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.IProductDAO;
import hcmute.team5.mapper.CustomerMapper;
import hcmute.team5.mapper.ProductMapper;
import hcmute.team5.model.CustomerModel;
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
    @Override
    public List<ProductModel> findAll() {
        String sql ="SELECT * FROM SanPham";
        return query(sql, new ProductMapper());
    }
    @Override
    public ProductModel findOneByProduct(String maSP) {
        String sql = "SELECT * FROM SanPham WHERE masanpham = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setMaSP(rs.getString(1));
                product.setTenSP(rs.getString(2));
                product.setMaLoaiSP(rs.getString(3));
                product.setGia(rs.getFloat(4));
                product.setMachinhanh(rs.getString(5));
                product.setTrangThai(rs.getString(6));
                conn.close();
                return product;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void insert(ProductModel product) {
        String sql = "INSERT INTO SanPham(masanpham, tensanpham, maloaisanpham, gia, machinhanh, trangthai) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getMaSP());
            ps.setString(2, product.getTenSP());
            ps.setString(3, product.getMaLoaiSP());
            ps.setFloat(4, product.getGia());
            ps.setString(5, product.getMachinhanh());
            ps.setString(6, product.gettrangThai());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteProduct(ProductModel product) {
        String sql = "DELETE FROM SanPham WHERE masanpham = ?";
        update(sql, product.getMaSP());
    }

    @Override
    public void insertPro(ProductModel product) {
        String sql = "INSERT INTO SanPham(masanpham, tensanpham, maloaisanpham, gia, machinhanh, trangthai) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getMaSP());
            ps.setString(2, product.getTenSP());
            ps.setString(3, product.getMaLoaiSP());
            ps.setFloat(4, product.getGia());
            ps.setString(5, product.getMachinhanh());
            ps.setString(6, product.gettrangThai());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateProduct(ProductModel product) {
        String sql = "UPDATE SanPham SET tensanpham = ?, gia = ?, trangthai = ? WHERE masanpham = ?;";
        update(sql, product.getTenSP(), product.getGia(), product.gettrangThai(), product.getMaSP());
    }


}
