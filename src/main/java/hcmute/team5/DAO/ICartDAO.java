package hcmute.team5.DAO;

import hcmute.team5.model.BillModel;
import hcmute.team5.model.CartModel;

import java.util.List;

public interface ICartDAO {
    List<CartModel> findAll(String username);
}
