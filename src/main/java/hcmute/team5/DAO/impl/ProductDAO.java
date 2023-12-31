package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.IProductDAO;
import hcmute.team5.mapper.CustomerMapper;
import hcmute.team5.mapper.ProductMapper;
import hcmute.team5.model.CustomerModel;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.ProductTypeModel;
import hcmute.team5.model.ViewedModel;
import hcmute.team5.model.SupplierModel;

import java.sql.*;
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
                product.setMaSp(rs.getInt("masanpham"));
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
    public List<ProductModel> getAllProDuctByProductType(String maLoaiSP) {
        List<ProductModel> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham WHERE maloaisanpham = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maLoaiSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setMaSp(rs.getInt("masanpham"));
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
                category.setTenLoaiSP(rs.getString("tenloaisanpham"));list.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
    public List<SupplierModel> getAllSuppliers(){
        List<SupplierModel> list = new ArrayList<>();
        String sql = "SELECT * FROM NhaCungCap";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                SupplierModel sup = new SupplierModel();
                sup.setMaNcc(rs.getString("mancc"));
                sup.setTenNcc(rs.getString("tenncc"));
                list.add(sup);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<ProductModel> getNext3Product(int amount) {
        List<ProductModel> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham ORDER BY masanpham OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setMaSp(rs.getInt("masanpham"));
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
    public List<ProductModel> getTop3() {
        List<ProductModel> list = new ArrayList<>();
        String sql = "SELECT TOP 3 * FROM SanPham";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setMaSp(rs.getInt("masanpham"));
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
    public List<ProductModel> getAllProductByNCC(String mancc) {
        List<ProductModel> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham WHERE manhacungcap = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, mancc);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setMaSp(rs.getInt("masanpham"));
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
                product.setMaSp(rs.getInt("masanpham"));
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
    public SupplierModel getDetailProduct(String maSP){
        String sql = "SELECT * FROM SanPham sp JOIN NhaCungCap ncc ON sp.manhacungcap = ncc.mancc WHERE masanpham = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                SupplierModel product = new SupplierModel();
                product.setMaSp(rs.getInt("masanpham"));
                product.setTenSP(rs.getString("tensanpham"));
                product.setMaLoaiSP(rs.getString("maloaisanpham"));
                product.setTenNcc(rs.getString("tenncc"));
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
    public List<ProductModel> findAll(int pageSize, int index) {String sql ="SELECT * FROM SanPham ORDER BY masanpham OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        return query(sql, new ProductMapper(), index, pageSize);
    }
    @Override
    public ProductModel findOneByProduct(int maSP) {
        String sql = "SELECT * FROM SanPham WHERE masanpham = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setMaSp(rs.getInt(1));
                product.setTenSP(rs.getString(2));
                product.setMaLoaiSP(rs.getString(3));
                product.setGia(rs.getInt(4));
                product.setMaChiNhanh(rs.getInt(5));
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
        String sql = "INSERT INTO SanPham(tensanpham, maloaisanpham, gia, machinhanh, trangthai) VALUES(?, ?, ?, ?, ?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getTenSP());
            ps.setString(2, product.getMaLoaiSP());
            ps.setFloat(3, product.getGia());
            ps.setInt(4, product.getMaChiNhanh());
            ps.setString(5, product.getTrangThai());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteProduct(ProductModel product) {
        String sql = "DELETE FROM SanPham WHERE masanpham = ?";
        update(sql, product.getMaSp());
    }

    @Override
    public void insertPro(ProductModel product) {
        String sql = "INSERT INTO SanPham(tensanpham, maloaisanpham, gia, machinhanh, trangthai) VALUES(?, ?, ?, ?, ?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getTenSP());
            ps.setString(2, product.getMaLoaiSP());
            ps.setFloat(3, product.getGia());
            ps.setInt(4, product.getMaChiNhanh());
            ps.setString(5, product.getTrangThai());
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductModel> findAllByProperties(int maChiNhanh, String status, int maSP, int maLoaiSP, int pageSize, int index) {
        String sql = "SELECT * FROM SanPham WHERE (? = 0 or machinhanh = ?) AND (? = 'ALL' or trangthai = ?)" +
                "AND (? = 0 or masanpham = ?) AND (? = 0 or maloaisanpham = ?)" +"ORDER BY masanpham OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        return query(sql, new ProductMapper(), maChiNhanh, maChiNhanh, status, status, maSP, maSP,
                maLoaiSP, maLoaiSP, index, pageSize);
    }

    @Override
    public int getNumOfProduct() {
        int num = 0;
        String sql = "SELECT count(*) FROM SanPham";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
        }
        catch (Exception e) {
            if(conn != null) {
                try {
                    conn.rollback();
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        finally {
            try {
                conn.close();
                ps.close();
                rs.close();
            }
            catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        return num;
    }

    @Override
    public ProductModel findExistProduct(String tenSP, int maChiNhanh) {
        String sql = "SELECT * FROM SanPham WHERE tensanpham = ? AND machinhanh = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, tenSP);
            ps.setInt(2, maChiNhanh);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setMaSp(rs.getInt(1));
                product.setTenSP(rs.getString(2));
                product.setMaLoaiSP(rs.getString(3));
                product.setGia(rs.getInt(4));
                product.setMaChiNhanh(rs.getInt(5));
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
    public void updateProduct(ProductModel product) {String sql = "UPDATE SanPham SET tensanpham = ?, gia = ?, trangthai = ? WHERE masanpham = ?";
        String gia = String.valueOf(product.getGia());
        update(sql, product.getTenSP(), gia, product.getTrangThai(), product.getMaSp());
    }
    public void inserttoCart(String username, String masp, int Soluong)
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
}