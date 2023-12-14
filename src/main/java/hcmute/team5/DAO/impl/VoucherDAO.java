package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.IVoucherDAO;
import hcmute.team5.mapper.VoucherMapper;
import hcmute.team5.model.VoucherModel;
import java.sql.*;
import java.util.List;

public class VoucherDAO extends AbstractDAO<VoucherModel> implements IVoucherDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public List<VoucherModel> findAll(int pageSize, int index) {
        String sql ="SELECT * FROM Voucher ORDER BY mavoucher OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        return query(sql, new VoucherMapper(), index, pageSize);
    }

    @Override
    public VoucherModel findOneById(String name) {
        String sql = "SELECT * FROM Voucher WHERE tenvoucher = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                VoucherModel voucher = new VoucherModel();
                voucher.setMaVC(rs.getInt("mavoucher"));
                voucher.setTenVC(rs.getString("tenvoucher"));
                voucher.setPhanTramGiam(rs.getFloat("phantramgiam"));
                voucher.setNgayBatDau(rs.getString("ngaybatdau"));
                voucher.setNgayKetThuc(rs.getString("ngayketthuc"));
                voucher.setSoLuong(rs.getInt("soluong"));
                conn.close();
                return voucher;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int insertIntoVoucher(VoucherModel voucher) {
        String phanTramGiam = String.valueOf(voucher.getPhanTramGiam());
        String sql = "INSERT INTO Voucher(tenvoucher, phantramgiam, ngaybatdau, ngayketthuc, soluong)" +
                "VALUES(?, ?, ?, ?, ?)";
        return insert(sql, voucher.getTenVC(), phanTramGiam,
                voucher.getNgayBatDau(), voucher.getNgayKetThuc(), voucher.getSoLuong());
    }

    @Override
    public String getName(int maVC) {
        String name = "";
        String sql = "SELECT tenvoucher FROM Voucher WHERE mavoucher = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maVC);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
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
        return name;
    }

    @Override
    public void updateVoucher(VoucherModel voucher) {
        String phanTramGiam = String.valueOf(voucher.getPhanTramGiam());
        String sql = "UPDATE Voucher SET tenvoucher = ?, phantramgiam = ?, " +
                "ngaybatdau = ?, ngayketthuc = ?, soluong = ?, status = 'Active' WHERE mavoucher = ?;";
        update(sql, voucher.getTenVC(), phanTramGiam, voucher.getNgayBatDau(),
                voucher.getNgayKetThuc(), voucher.getSoLuong(), voucher.getMaVC());
    }

    @Override
    public void deleteVoucher(int maVC) {
        String sql = "UPDATE Voucher SET status = 'Disabled' WHERE mavoucher = ?";
        update(sql, maVC);
    }

    @Override
    public List<VoucherModel> findAllByProperties(String status, int maVC, int pageSize, int index) {
        String sql = "";
        if(status.equals("Còn hiệu lực")) {
            sql = "SELECT * FROM Voucher WHERE status = 'Active'\n" +
                    "AND ngayketthuc > CURRENT_TIMESTAMP\n" +
                    "AND (? = 0 OR mavoucher = ?) ORDER BY mavoucher OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        }
        else if (status.equals("Hết hiệu lực")) {
            sql = "SELECT * FROM Voucher WHERE (status = 'Disabled'\n" +
                    "OR ngayketthuc < CURRENT_TIMESTAMP)\n" +
                    "AND (? = 0 OR mavoucher = ?) ORDER BY mavoucher OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        }
        else {
            sql = "SELECT * FROM Voucher WHERE mavoucher = ? ORDER BY mavoucher OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            return query(sql, new VoucherMapper(), maVC, index, pageSize);
        }
        return query(sql, new VoucherMapper(), maVC, maVC, index, pageSize);
    }

    @Override
    public int getNumOfVoucher() {
        int num = 0;
        String sql = "SELECT count(*) FROM Voucher";
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
}
