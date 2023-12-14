package hcmute.team5.service.impl;

import hcmute.team5.DAO.IRevenueDAO;
import hcmute.team5.DAO.impl.RevenueDAO;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.RevenueModel;
import hcmute.team5.service.IRevenueService;

import java.util.List;

public class RevenueService implements IRevenueService {
    IRevenueDAO revenueDAL = new RevenueDAO();
    @Override
    public List<RevenueModel> findAll() {
        return revenueDAL.findAll();
    }

}
