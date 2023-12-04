package hcmute.team5.service.impl;

import hcmute.team5.DAO.IAccountDAO;
import hcmute.team5.DAO.ICustomerDAO;
import hcmute.team5.DAO.impl.AccountDAO;
import hcmute.team5.DAO.impl.CustomerDAO;
import hcmute.team5.model.CustomerModel;
import hcmute.team5.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerDAO customerDAL = new CustomerDAO();
    @Override
    public List<CustomerModel> findAll() {
        return customerDAL.findAll();
    }
}
