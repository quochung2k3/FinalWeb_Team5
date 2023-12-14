package hcmute.team5.mapper;

import hcmute.team5.model.CustomerModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<CustomerModel> {
    @Override
    public CustomerModel mapRow(ResultSet rs) {
        try {
            CustomerModel customer = new CustomerModel();
            customer.setMaKh(rs.getInt("makh"));
            customer.setTen(rs.getString("fullname"));
            customer.setNgaySinh(rs.getString("ngaysinh"));
            customer.setSdt(rs.getString("sdt"));
            customer.setTongTienDaMua(rs.getFloat("tongtiendamua"));
            customer.setUsername(rs.getString("username"));
            return customer;
        }
        catch (SQLException e) {
            return null;
        }
    }
}