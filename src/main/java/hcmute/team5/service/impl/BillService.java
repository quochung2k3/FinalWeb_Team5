package hcmute.team5.service.impl;

import hcmute.team5.DAO.IBillDAO;
import hcmute.team5.DAO.impl.BillDAO;
import hcmute.team5.model.BillDetailsModel;
import hcmute.team5.model.BillModel;
import hcmute.team5.service.IBillService;

import java.util.List;

public class BillService implements IBillService {
    IBillDAO billDAO = new BillDAO();
    @Override
    public List<BillModel> findAll() {
        return billDAO.findAll();
    }

    @Override
    public List<BillDetailsModel> findAllById(int maHD) {
        return billDAO.findAllById(maHD);
    }

    @Override
    public List<BillModel> findAllByProperties(int maChiNhanh, int maHD) {
        return billDAO.findAllByProperties(maChiNhanh, maHD);
    }
}
