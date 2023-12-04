package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.ICustomerDAO;
import hcmute.team5.mapper.AccountMapper;
import hcmute.team5.mapper.CustomerMapper;
import hcmute.team5.model.CustomerModel;

import java.util.List;

public class CustomerDAO extends AbstractDAO<CustomerModel> implements ICustomerDAO {
    @Override
    public List<CustomerModel> findAll() {
        String sql ="SELECT * FROM KhachHang";
        return query(sql, new CustomerMapper());
    }
}