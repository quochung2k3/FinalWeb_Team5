package hcmute.team5.service.impl;

import hcmute.team5.DAO.ICartDAO;
import hcmute.team5.DAO.impl.CartDAO;
import hcmute.team5.model.CartModel;
import hcmute.team5.service.ICartService;

import java.util.List;

public class CartService implements ICartService {
    ICartDAO cartDAO = new CartDAO();

    @Override
    public List<CartModel> findAll(String username) {
        return cartDAO.findAll(username);
    }

    public List<CartModel> findOne(String masp, int soluong) {
        return cartDAO.findOne(masp, soluong);
    }
}
