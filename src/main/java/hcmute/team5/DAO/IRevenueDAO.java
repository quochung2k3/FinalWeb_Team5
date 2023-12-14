package hcmute.team5.DAO;

import hcmute.team5.model.BillModel;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.RevenueModel;

import java.util.List;

public interface IRevenueDAO {
    List<RevenueModel> findAll();
    List<RevenueModel> findAllByProperties(int maChiNhanh, String ngayBatDau, String ngayKetThuc);
}
