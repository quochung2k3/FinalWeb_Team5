package hcmute.team5.DAO;

import hcmute.team5.model.AccountModel;
import hcmute.team5.model.CustomerModel;

import java.util.List;

public interface ICustomerDAO {
    List<CustomerModel> findAll();

    void updateCustomer(CustomerModel customer);

    CustomerModel findOneByCustomer(int maKh);
    void insert(CustomerModel customer);
    void deleteCustomer(CustomerModel customer);
    void insertCus(CustomerModel customer);
    List<CustomerModel> findAllByProperties(String name, String total);
}
