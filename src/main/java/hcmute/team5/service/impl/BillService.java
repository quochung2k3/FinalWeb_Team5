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
    public List<BillModel> findAll(int pageSize, int index) {
        return billDAO.findAll(pageSize, index);
    }

    @Override
    public List<BillModel> findAllBillByMaKH(int makh) {
        return billDAO.findAllBillByMaKH(makh);
    }

    @Override
    public List<BillDetailsModel> findAllById(int maHD) {
        return billDAO.findAllById(maHD);
    }

    @Override
    public List<BillModel> findAllByProperties(int maChiNhanh, int maHD, int pageSize, int index) {
        return billDAO.findAllByProperties(maChiNhanh, maHD, pageSize, index);
    }

    @Override
    public int getNumOfBill() {
        return billDAO.getNumOfBill();
    }

    @Override
    public void addBill(String ngay, int makh, int maCN, String tongTien) {
        billDAO.addBill(ngay, makh, maCN, tongTien);
    }

    @Override
    public int findCodeBill(int maKH) {
        return billDAO.findCodeBill(maKH);
    }

    @Override
    public void AddBillDetails(int maHD, int maSP, int soLuong) {
        billDAO.AddBillDetails(maHD, maSP, soLuong);
    }

    @Override
    public void AddPay(int maKH, int maVC, int maHD) {
        billDAO.AddPay(maKH, maVC, maHD);
    }

    @Override
    public void DeleteCart(String name) {
        billDAO.DeleteCart(name);
    }
}
