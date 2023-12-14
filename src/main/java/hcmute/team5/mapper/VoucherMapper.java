package hcmute.team5.mapper;

import hcmute.team5.model.AccountModel;
import hcmute.team5.model.VoucherModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VoucherMapper implements RowMapper<VoucherModel>{
    @Override
    public VoucherModel mapRow(ResultSet rs) {
        try {
            VoucherModel voucher = new VoucherModel();
            voucher.setMaVC(rs.getInt("mavoucher"));
            voucher.setTenVC(rs.getString("tenvoucher"));
            voucher.setPhanTramGiam(rs.getFloat("phantramgiam"));
            voucher.setNgayBatDau(rs.getString("ngaybatdau"));
            voucher.setNgayKetThuc(rs.getString("ngayketthuc"));
            voucher.setSoLuong(rs.getInt("soluong"));
            return voucher;
        }
        catch (SQLException e) {
            return null;
        }
    }
}
