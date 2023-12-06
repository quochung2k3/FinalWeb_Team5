package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.IBillDAO;
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
        String sql = "SELECT * FROM ChiTietHD INNER JOIN SanPham ON ChiTietHD.masanpham = SanPham.masanpham WHERE ChiTietHD.mahd = ?";
        return query(sql, new BillDetailsMapper(), maHD);
    }

}
