package hcmute.team5.mapper;

import hcmute.team5.model.CartModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements RowMapper<CartModel> {
    @Override
    public CartModel mapRow(ResultSet rs) {
        try {
            CartModel cart = new CartModel();
            cart.setTenSP(rs.getString("tensanpham"));
            cart.setSoLuong(rs.getInt("soluong"));
            cart.setGia(rs.getInt("gia"));
            cart.setDescription(rs.getString("description"));
            return cart;
        } catch (SQLException e) {
            return null;
        }
    }
}
