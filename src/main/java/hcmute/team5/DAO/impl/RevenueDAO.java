package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.IRevenueDAO;
import hcmute.team5.mapper.ProductMapper;
import hcmute.team5.mapper.RevenueMapper;
import hcmute.team5.model.BillModel;
import hcmute.team5.model.ProductModel;
import hcmute.team5.model.RevenueModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class RevenueDAO extends AbstractDAO<RevenueModel> implements IRevenueDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<RevenueModel> findAll() {
        String sql ="SELECT * FROM HoaDon";
        return query(sql, new RevenueMapper());
    }

    @Override
    public List<RevenueModel> findAllByProperties(int maChiNhanh, String ngayBatDau, String ngayKetThuc) {
        String sql = "SELECT * FROM HoaDon WHERE (? = 0 OR maChiNhanh = ?) AND ngayin BETWEEN ? AND ?";
        return query(sql, new RevenueMapper(), maChiNhanh, maChiNhanh, ngayBatDau, ngayKetThuc);
    }
}