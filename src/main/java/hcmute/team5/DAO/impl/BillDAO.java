package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.IBillDAO;
import hcmute.team5.mapper.AccountMapper;
import hcmute.team5.mapper.BillDetailsMapper;
import hcmute.team5.mapper.BillMapper;
import hcmute.team5.model.BillDetailsModel;
import hcmute.team5.model.BillModel;

import java.util.List;

public class BillDAO extends AbstractDAO<BillModel> implements IBillDAO {

    @Override
    public List<BillModel> findAll() {
        String sql = "SELECT * FROM HoaDon";
        return query(sql, new BillMapper());
    }

    @Override
    public List<BillDetailsModel> findAllById(String maHD) {
        String sql = "SELECT * FROM ChiTietHD INNER JOIN SanPham ON ChiTietHD.masanpham = SanPham.masanpham\n" +
                "INNER JOIN ThanhToan ON ChiTietHD.mahd = ThanhToan.mahd\n" +
                "INNER JOIN Voucher ON ThanhToan.mavoucher = Voucher.mavoucher\n" +
                "WHERE ChiTietHD.mahd = ?";
        return query(sql, new BillDetailsMapper(), maHD);
    }

    @Override
    public List<BillModel> findAllByProperties(String maChiNhanh, String maHD) {
        if(maHD.equals("")) {
            String sql ="SELECT * FROM HoaDon WHERE machinhanh = ?";
            return query(sql, new BillMapper(), maChiNhanh);
        }
        else if(maChiNhanh.equals("All")) {
            String sql ="SELECT * FROM HoaDon WHERE mahd = ?";
            return query(sql, new BillMapper(), maHD);
        }
        else {
            String sql ="SELECT * FROM HoaDon WHERE machinhanh = ? AND mahd = ?";
            return query(sql, new BillMapper(), maChiNhanh, maHD);
        }
    }
}