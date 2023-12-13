package hcmute.team5.mapper;

import hcmute.team5.model.ProductModel;
import hcmute.team5.model.RevenueModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RevenueMapper implements RowMapper<RevenueModel>{
    @Override
    public RevenueModel mapRow(ResultSet rs) {
        try {
            RevenueModel revenue = new RevenueModel();
            revenue.setMaChiNhanh(rs.getString("machinhanh"));
            revenue.setDiaChi(rs.getString("diachi"));
            return revenue;
        }
        catch (SQLException e) {
            return null;
        }
    }

}
