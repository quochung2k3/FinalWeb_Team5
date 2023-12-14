package hcmute.team5.service;

import hcmute.team5.model.CartModel;

import java.util.List;

public interface ICartService {
    List<CartModel> findAll(String username);

    List<CartModel> findOne(String masp, int soluong);
}
