package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.ICustomerDAO;
import hcmute.team5.mapper.CustomerMapper;
import hcmute.team5.model.CustomerModel;

import java.sql.*;
import java.util.List;

public class CustomerDAO extends AbstractDAO<CustomerModel> implements ICustomerDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<CustomerModel> findAll(int pageSize, int index) {
        String sql = "SELECT * FROM KhachHang INNER JOIN Account ON KhachHang.username = Account.username ORDER BY makh OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        return query(sql, new CustomerMapper(), index, pageSize);
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
        String sql = "INSERT INTO KhachHang(ngaysinh, sdt, username, isActive) VALUES(?, ?, ?, ?, ?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getNgaySinh());
            ps.setString(2, customer.getSdt());
            ps.setString(3, customer.getUsername());
            ps.setInt(4, 1);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CustomerModel> findAllByProperties(String name, String total, int pageSize, int index) {
        if (total.equals("ALL")) {
            String sql = "SELECT * FROM KhachHang INNER JOIN Account ON KhachHang.username = Account.username\n" +
                    "WHERE Account.fullname LIKE ? ORDER BY makh OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            name = '%' + name + '%';
            return query(sql, new CustomerMapper(), name, index, pageSize);
        } else if (name.isEmpty()) {
            if (total.equals("Tăng dần")) {
                String sql = "SELECT * FROM KhachHang INNER JOIN Account ON KhachHang.username = Account.username\n" +
                        "ORDER BY tongtiendamua ASC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                return query(sql, new CustomerMapper(), index, pageSize);
            } else {
                String sql = "SELECT * FROM KhachHang INNER JOIN Account ON KhachHang.username = Account.username\n" +
                        "ORDER BY tongtiendamua DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                return query(sql, new CustomerMapper(), index, pageSize);
            }
        } else {
            if (total.equals("Tăng dần")) {
                String sql = "SELECT * FROM KhachHang INNER JOIN Account ON KhachHang.username = Account.username\n" +
                        "WHERE Account.fullname LIKE ? ORDER BY tongtiendamua ASC\n" +
                        "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                name = '%' + name + '%';
                return query(sql, new CustomerMapper(), name, index, pageSize);
            } else {
                String sql = "SELECT * FROM KhachHang INNER JOIN Account ON KhachHang.username = Account.username\n" +
                        "WHERE Account.fullname LIKE ? ORDER BY tongtiendamua DESC\n" +
                        "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                name = '%' + name + '%';
                return query(sql, new CustomerMapper(), name, index, pageSize);
            }
        }
    }

    @Override
    public int getNumOfCustomer() {
        int num = 0;
        String sql = "SELECT count(*) FROM KhachHang";
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
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                conn.close();
                ps.close();
                rs.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return num;
    }

    @Override
    public void updateCustomer(CustomerModel customer) {
        String sql = "UPDATE KhachHang SET ngaysinh = ?, sdt = ? WHERE makh = ?;";
        update(sql, customer.getNgaySinh(), customer.getSdt(), customer.getMaKh());
        String sql2 = "UPDATE Account SET fullname = ? WHERE username = ?;";
        update(sql2, customer.getTen(), customer.getUsername());
    }
}