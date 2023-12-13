package hcmute.team5.DAO;

import hcmute.team5.model.VoucherModel;

import java.util.List;

public interface IVoucherDAO {
    List<VoucherModel> findAll();
}
