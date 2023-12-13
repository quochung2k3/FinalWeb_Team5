package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.IVoucherDAO;
import hcmute.team5.mapper.VoucherMapper;
import hcmute.team5.model.VoucherModel;

import java.util.List;

public class VoucherDAO extends AbstractDAO<VoucherModel> implements IVoucherDAO {
    @Override
    public List<VoucherModel> findAll() {
        String sql ="SELECT * FROM Voucher";
        return query(sql, new VoucherMapper());
    }
}
