package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.ICustomerDAO;
import hcmute.team5.mapper.AccountMapper;
import hcmute.team5.mapper.CustomerMapper;
import hcmute.team5.model.AccountModel;
import hcmute.team5.model.CustomerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class CustomerDAO extends AbstractDAO<CustomerModel> implements ICustomerDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public List<CustomerModel> findAll() {
        String sql ="SELECT * FROM KhachHang INNER JOIN Account ON KhachHang.username = Account.username";
        return query(sql, new CustomerMapper());
    }
    @Override
    public CustomerModel findOneByCustomer(int maKh) {
        String sql = "SELECT * FROM KhachHang INNER JOIN Account ON KhachHang.username = Account.username WHERE makh = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maKh);
            rs = ps.executeQuery();
            while (rs.next()) {
                CustomerModel customer = new CustomerModel();
                customer.setMaKh(rs.getInt("makh"));
                customer.setTen(rs.getString("fullname"));
                customer.setNgaySinh(rs.getString("ngaysinh"));
                customer.setSdt(rs.getString("sdt"));
                customer.setTongTienDaMua(rs.getInt("tongtiendamua"));
                customer.setUsername(rs.getString("username"));
                conn.close();
                return customer;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void insert(CustomerModel customer) {
        String sql = "INSERT INTO KhachHang(makh, ten, ngaysinh, sdt, tongtiendamua) VALUES(?, ?, ?, ?, ?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, customer.getMaKh());
            ps.setString(2, customer.getTen());
            ps.setString(3, customer.getNgaySinh());
            ps.setString(4, customer.getSdt());
            ps.setFloat(5, customer.getTongTienDaMua());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteCustomer(CustomerModel customer) {
        String sql = "DELETE FROM KhachHang WHERE makh = ?";
        update(sql, customer.getMaKh());
    }

    @Override
    public void insertCus(CustomerModel customer) {
        String sql = "INSERT INTO KhachHang(makh, ten, ngaysinh, sdt, tongtiendamua) VALUES(?, ?, ?, ?, ?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, customer.getMaKh());
            ps.setString(2, customer.getTen());
            ps.setString(3, customer.getNgaySinh());
            ps.setString(4, customer.getSdt());
            ps.setFloat(5, customer.getTongTienDaMua());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CustomerModel> findAllByProperties(String name, String total) {
        if(total.equals("Tăng dần")) {
            total = "ASC";
        }
        if(total.equals("Giảm dần")) {
            total = "DESC";
        }
        if(total.equals("ALL")) {
            String sql ="SELECT * FROM KhachHang INNER JOIN Account ON KhachHang.username = Account.username WHERE KhachHang.username LIKE ?";
            name = '%'+name+'%';
            return query(sql, new CustomerMapper(), name);
        }
        else if(name.isEmpty()) {
            String sql ="SELECT * FROM KhachHang ORDER BY tongtiendamua ?";
            return query(sql, new CustomerMapper(), total);
        }
        else {
            String sql ="SELECT * FROM KhachHang WHERE username LIKE ? ORDER BY tongtiendamua ?";
            name = '%'+name+'%';
            return query(sql, new CustomerMapper(), name, total);
        }
    }

    @Override
    public void updateCustomer(CustomerModel customer) {
        String sql = "UPDATE KhachHang SET ngaysinh = ?, sdt = ? WHERE makh = ?;";
        update(sql, customer.getNgaySinh(), customer.getSdt(), customer.getMaKh());
        String sql2 = "UPDATE Account SET fullname = ? WHERE username = ?;";
        update(sql2, customer.getTen(), customer.getUsername());
    }
}