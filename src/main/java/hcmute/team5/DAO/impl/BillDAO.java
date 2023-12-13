package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.IBillDAO;
import hcmute.team5.mapper.AccountMapper;
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
        if(maHD == 0) {
            String sql ="SELECT * FROM HoaDon WHERE machinhanh = ? ORDER BY mahd OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            return query(sql, new BillMapper(), maChiNhanh, index, pageSize);
        }
        else if(maChiNhanh == 0) {
            String sql ="SELECT * FROM HoaDon WHERE mahd = ? ORDER BY mahd OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            return query(sql, new BillMapper(), maHD, index, pageSize);
        }
        else {
            String sql ="SELECT * FROM HoaDon WHERE machinhanh = ? AND mahd = ? ORDER BY mahd OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
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