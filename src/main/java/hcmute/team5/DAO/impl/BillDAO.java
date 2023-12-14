package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.IBillDAO;
import hcmute.team5.mapper.BillDetailsMapper;
import hcmute.team5.mapper.BillMapper;
import hcmute.team5.model.BillDetailsModel;
import hcmute.team5.model.BillModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BillDAO extends AbstractDAO<BillModel> implements IBillDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<BillModel> findAllBillByMaKH(int makh) {
        String sql = "SELECT * FROM HoaDon WHERE makh = ?";
        return query(sql, new BillMapper(), makh);
    }

    @Override
    public List<BillModel> findAll(int pageSize, int index) {
        String sql = "SELECT * FROM HoaDon ORDER BY mahd OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        return query(sql, new BillMapper(), index, pageSize);
    }

    @Override
    public List<BillDetailsModel> findAllById(int maHD) {
        String sql = "SELECT * FROM ChiTietHD INNER JOIN SanPham ON ChiTietHD.masanpham = SanPham.masanpham\n" +
                "INNER JOIN ThanhToan ON ChiTietHD.mahd = ThanhToan.mahd\n" +
                "INNER JOIN Voucher ON ThanhToan.mavoucher = Voucher.mavoucher\n" +
                "WHERE ChiTietHD.mahd = ?";
        return query(sql, new BillDetailsMapper(), maHD);
    }

    @Override
    public List<BillModel> findAllByProperties(int maChiNhanh, int maHD, int pageSize, int index) {
        if (maHD == 0) {
            String sql = "SELECT * FROM HoaDon WHERE machinhanh = ? ORDER BY mahd OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            return query(sql, new BillMapper(), maChiNhanh, index, pageSize);
        } else if (maChiNhanh == 0) {
            String sql = "SELECT * FROM HoaDon WHERE mahd = ? ORDER BY mahd OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            return query(sql, new BillMapper(), maHD, index, pageSize);
        } else {
            String sql = "SELECT * FROM HoaDon WHERE machinhanh = ? AND mahd = ? ORDER BY mahd OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            return query(sql, new BillMapper(), maChiNhanh, maHD, index, pageSize);
        }
    }

    @Override
    public int getNumOfBill() {
        int num = 0;
        String sql = "SELECT count(*) FROM HoaDon";
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
    public void addBill(String ngay, int makh, int maCN, String tongTien) {
        String sql = "INSERT INTO HoaDon(ngayin, makh, machinhanh, tongtien, tiendanhan, tienthoi) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ngay);
            ps.setInt(2, makh);
            ps.setInt(3, maCN);
            ps.setString(4, tongTien);
            ps.setString(5, tongTien);
            ps.setFloat(6, 0);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int findCodeBill(int maKH) {
        int num = 0;
        String sql = "SELECT TOP 1 mahd FROM HoaDon WHERE makh = ? ORDER BY mahd DESC";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maKH);
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
    public void AddBillDetails(int maHD, int maSP, int soLuong) {
        String sql = "INSERT INTO ChiTietHD(mahd, masanpham, soluong) VALUES(?, ?, ?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maHD);
            ps.setInt(2, maSP);
            ps.setInt(3, soLuong);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void AddPay(int maKH, int maVC, int maHD) {
        if (maVC == 0) {
            String sql = "INSERT INTO ThanhToan(makh, mahd) VALUES(?, ?)";
            try {
                conn = new DBConnectionSQL().getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, maKH);
                ps.setInt(2, maHD);
                ps.executeUpdate();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            String sql = "INSERT INTO ThanhToan(makh, mavoucher, mahd) VALUES(?, ?, ?)";
            try {
                conn = new DBConnectionSQL().getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, maKH);
                ps.setInt(2, maVC);
                ps.setInt(3, maHD);
                ps.executeUpdate();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void DeleteCart(String name) {
        String sql = "DELETE FROM GioHang WHERE username = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}