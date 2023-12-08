package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.ICustomerDAO;
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
        String sql ="SELECT * FROM KhachHang";
        return query(sql, new CustomerMapper());
    }
    @Override
    public CustomerModel findOneByCustomer(String maKh) {
        String sql = "SELECT * FROM KhachHang WHERE makh = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maKh);
            rs = ps.executeQuery();
            while (rs.next()) {
                CustomerModel customer = new CustomerModel();
                customer.setMaKh(rs.getString(1));
                customer.setTen(rs.getString(2));
                customer.setNgaySinh(rs.getString(3));
                customer.setSdt(rs.getString(4));
                customer.setTongTienDaMua(rs.getInt(5));
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
            ps.setString(1, customer.getMaKh());
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
            ps.setString(1, customer.getMaKh());
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
    public void updateCustomer(CustomerModel customer) {
        String sql = "UPDATE KhachHang SET ten = ?, ngaysinh = ?, sdt = ? WHERE makh = ?;";
        update(sql, customer.getTen(), customer.getNgaySinh(), customer.getSdt(), customer.getMaKh());
    }
}