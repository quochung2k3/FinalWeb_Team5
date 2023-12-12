package hcmute.team5.service;

import hcmute.team5.model.BillDetailsModel;
import hcmute.team5.model.BillModel;

import java.util.List;

public interface IBillService {
    List<BillModel> findAll();
    List<BillDetailsModel> findAllById(String maHD);
    List<BillModel> findAllByProperties(String maChiNhanh, String maHD);
}
