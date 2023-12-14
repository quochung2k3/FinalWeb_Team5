package hcmute.team5.service;

import hcmute.team5.model.ProductModel;
import hcmute.team5.model.RevenueModel;

import java.util.List;

public interface IRevenueService {
    List<RevenueModel> findAll();
    List<RevenueModel> findAllByProperties(int maChiNhanh, String ngayBatDau, String ngayKetThuc);
}
