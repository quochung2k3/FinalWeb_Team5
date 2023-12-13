package hcmute.team5.mapper;

import hcmute.team5.model.AccountModel;
import hcmute.team5.model.BillModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillMapper implements RowMapper<BillModel> {
    @Override
    public BillModel mapRow(ResultSet rs) {
        try {
            BillModel bill = new BillModel();
            bill.setMaHD(rs.getString("mahd"));
            bill.setMaChiNhanh(rs.getInt("machinhanh"));
            bill.setNgayIn(rs.getTimestamp("ngayin"));
            bill.setMaKH(rs.getString("makh"));
            bill.setTongTien(rs.getFloat("tongtien"));
            bill.setTienDaNhan(rs.getFloat("tiendanhan"));
            bill.setTienThoi(rs.getFloat("tienthoi"));
            return bill;
        }
        catch (SQLException e) {
            return null;
        }
    }
}
