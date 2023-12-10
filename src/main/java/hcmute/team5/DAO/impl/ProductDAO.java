package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.IProductDAO;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO{
    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;
    PreparedStatement ps = null;

    @Override
    public List<ProductModel> getListProDuctViewed(String maSP, String username) {
        List<String> list = new ArrayList<>();
        List<ProductModel> list_p = new ArrayList<>();
        String sql = "SELECT dx.masp FROM DaXem dx join Account ac on dx.username = ac.username WHERE dx.masp != ? AND ac.username = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.setString(2, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        for(String i : list){
            ProductModel p = getDetailProduct(i);
            list_p.add(p);
        }
        return list_p;
    }
    public List<ProductModel> getListProDuctByProductType(String maLoaiSP, String maSP) {
        List<ProductModel> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham WHERE maloaisanpham = ? AND masanpham != ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maLoaiSP);
            ps.setString(2, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setMaSP(rs.getString("masanpham"));
                product.setTenSP(rs.getString("tensanpham"));
                product.setGia(rs.getInt("gia"));
                list.add(product);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<ProductTypeModel> getAllProductType(){
        List<ProductTypeModel> list = new ArrayList<>();
        String sql = "SELECT * FROM loaisanpham";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductTypeModel category = new ProductTypeModel();
                category.setMaLoaiSP(rs.getString("maloaisanpham"));
                category.setTenLoaiSP(rs.getString("tenloaisanpham"));
                list.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
    public List<ProductModel> getAllProduct() {
        List<ProductModel> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setMaSP(rs.getString("masanpham"));
                product.setTenSP(rs.getString("tensanpham"));
                product.setGia(rs.getInt("gia"));
                product.setTrangThai(rs.getString("trangthai"));
                list.add(product);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<ProductModel> getListProductByNCC(String mancc, String maSP) {
        List<ProductModel> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham WHERE manhacungcap = ? AND masanpham != ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, mancc);
            ps.setString(2, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setMaSP(rs.getString("masanpham"));
                product.setTenSP(rs.getString("tensanpham"));
                product.setGia(rs.getInt("gia"));
                list.add(product);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
                product.setDescription(rs.getString("description"));
                product.setMaNcc(rs.getString("manhacungcap"));
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
