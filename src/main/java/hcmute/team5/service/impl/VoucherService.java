package hcmute.team5.service.impl;

import hcmute.team5.DAO.IVoucherDAO;
import hcmute.team5.DAO.impl.VoucherDAO;
import hcmute.team5.model.VoucherModel;
import hcmute.team5.service.IVoucherService;
import java.util.List;

public class VoucherService implements IVoucherService {
    IVoucherDAO voucherDAO = new VoucherDAO();
    @Override
    public List<VoucherModel> findAll(int pageSize, int index) {
        return voucherDAO.findAll(pageSize, index);
    }

    @Override
    public VoucherModel findOneById(String name) {
        return voucherDAO.findOneById(name);
    }

    @Override
    public int insertIntoVoucher(VoucherModel voucher) {
        return voucherDAO.insertIntoVoucher(voucher);
    }

    @Override
    public String getName(int maVC) {
        return voucherDAO.getName(maVC);
    }

    @Override
    public void updateVoucher(VoucherModel voucher) {
        voucherDAO.updateVoucher(voucher);
    }

    @Override
    public void deleteVoucher(int maVC) {
        voucherDAO.deleteVoucher(maVC);
    }

    @Override
    public List<VoucherModel> findAllByProperties(String status, int maVC, int pageSize, int index) {
        return voucherDAO.findAllByProperties(status, maVC, pageSize, index);
    }

    @Override
    public int getNumOfVoucher() {
        return voucherDAO.getNumOfVoucher();
    }

}
