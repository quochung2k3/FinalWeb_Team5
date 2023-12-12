package hcmute.team5.DAO;

import hcmute.team5.model.BillDetailsModel;
import hcmute.team5.model.BillModel;

import java.util.List;

public interface IBillDAO {
    List<BillModel> findAll();
    List<BillDetailsModel> findAllById(int maHD);
    List<BillModel> findAllByProperties(String maChiNhanh, String maHD);
}
