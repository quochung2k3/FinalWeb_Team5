package hcmute.team5.service;

import hcmute.team5.model.CartModel;
import hcmute.team5.model.CustomerModel;

import java.util.List;

public interface ICartService {
    List<CartModel> findAll(String username);
    List<CartModel> findOne(String masp, int soluong);
}
