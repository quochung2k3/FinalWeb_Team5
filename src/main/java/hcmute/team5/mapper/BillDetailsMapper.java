package hcmute.team5.mapper;

import hcmute.team5.model.AccountModel;
import hcmute.team5.model.BillDetailsModel;
import hcmute.team5.model.BillModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillDetailsMapper implements RowMapper<BillDetailsModel> {

    @Override
    public BillDetailsModel mapRow(ResultSet rs) {
        try {
            BillDetailsModel bill = new BillDetailsModel();
            bill.setMaSP(rs.getString("masanpham"));
            bill.setTenSP(rs.getString("tensanpham"));
            bill.setGia(rs.getFloat("gia"));
            bill.setPhanTramGiam(rs.getFloat("phantramgiam"));
            return bill;
        }
        catch (SQLException e) {
            return null;
        }
    }
}
