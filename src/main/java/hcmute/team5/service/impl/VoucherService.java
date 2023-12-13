package hcmute.team5.service.impl;

import hcmute.team5.DAO.IVoucherDAO;
import hcmute.team5.DAO.impl.VoucherDAO;
import hcmute.team5.model.VoucherModel;
import hcmute.team5.service.IVoucherService;

import java.util.List;

public class VoucherService implements IVoucherService {
    IVoucherDAO voucherDAO = new VoucherDAO();
    @Override
    public List<VoucherModel> findAll() {
        return voucherDAO.findAll();
    }
}
