package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.ICartDAO;
import hcmute.team5.mapper.AccountMapper;
import hcmute.team5.mapper.CartMapper;
import hcmute.team5.model.CartModel;

import java.util.List;

public class CartDAO extends AbstractDAO<CartModel> implements ICartDAO {
    @Override
    public List<CartModel> findAll(String username) {
        String sql ="SELECT * FROM GioHang INNER JOIN SanPham ON GioHang.masp = SanPham.masanpham WHERE username = ?";
        return query(sql, new CartMapper(), username);
    }
}
