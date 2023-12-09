package hcmute.team5.mapper;

import hcmute.team5.model.CustomerModel;
import hcmute.team5.model.ProductModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductModel>{
    @Override
    public ProductModel mapRow(ResultSet rs) {
        try {
            ProductModel product = new ProductModel();
            product.setMaSP(rs.getString("masanpham"));
            product.setTenSP(rs.getString("tensanpham"));
            product.setMaLoaiSP(rs.getString("maloaisanpham"));
            product.setGia(rs.getFloat("gia"));
            product.setMachinhanh(rs.getString("machinhanh"));
            product.setTrangThai(rs.getString("trangthai"));
            return product;
        }
        catch (SQLException e) {
            return null;
        }
    }
}
