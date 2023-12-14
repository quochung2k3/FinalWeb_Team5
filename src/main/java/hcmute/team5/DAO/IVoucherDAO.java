package hcmute.team5.DAO;

import hcmute.team5.model.VoucherModel;

import java.util.List;

public interface IVoucherDAO {
    List<VoucherModel> findAll(int pageSize, int index);

    VoucherModel findOneById(String name);

    int insertIntoVoucher(VoucherModel voucher);

    String getName(int maVC);

    void updateVoucher(VoucherModel voucher);

    void deleteVoucher(int maVC);

    List<VoucherModel> findAllByProperties(String status, int maVC, int pageSize, int index);

    int getNumOfVoucher();
}
