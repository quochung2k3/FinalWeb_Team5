package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.IProductDAO;
import hcmute.team5.mapper.CustomerMapper;
import hcmute.team5.mapper.ProductMapper;
import hcmute.team5.model.CustomerModel;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;
import hcmute.team5.model.ViewedModel;

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
                product.setImage(rs.getString("image"));
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
                product.setImage(rs.getString("image"));
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
                product.setImage(rs.getString("image"));
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
                product.setImage(rs.getString("image"));
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
    public void inserttoCard(String username, String masp, int Soluong)
    {
        String sql = "DECLARE @count int SET @count = (SELECT COUNT(*) FROM GioHang WHERE username = ? AND masp = ?) IF @count = 0 INSERT INTO GioHang VALUES (?,?,?) ELSE UPDATE GioHang SET soluong = soluong + ? WHERE username = ? AND masp = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2,masp);
            ps.setString(3, username);
            ps.setString(4,masp);
            ps.setInt(5, Soluong);
            ps.setInt(6, Soluong);
            ps.setString(7, username);
            ps.setString(8,masp);
            rs = ps.executeQuery();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
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
                product.setGia(rs.getInt(4));
                product.setMaChiNhanh(rs.getString(5));
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
            ps.setString(5, product.getMaChiNhanh());
            ps.setString(6, product.getTrangThai());
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
            ps.setString(5, product.getMaChiNhanh());
            ps.setString(6, product.getTrangThai());
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertviewed(String username, String masp){
        String sql = "DECLARE @count int SET @count = (SELECT COUNT(*) FROM DaXem WHERE username = ? AND masp = ?) IF @count = 0 INSERT INTO DaXem VALUES (?,?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2,masp);
            ps.setString(3, username);
            ps.setString(4,masp);
            rs = ps.executeQuery();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateProduct(ProductModel product) {
        String sql = "UPDATE SanPham SET tensanpham = ?, gia = ?, trangthai = ? WHERE masanpham = ?";
        String gia = String.valueOf(product.getGia());
        update(sql, product.getTenSP(), gia, product.getTrangThai(), product.getMaSP());
    }
}
