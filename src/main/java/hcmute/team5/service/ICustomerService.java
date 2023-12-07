package hcmute.team5.service;

import hcmute.team5.model.AccountModel;
import hcmute.team5.model.CustomerModel;

import java.util.List;

public interface ICustomerService {
    List<CustomerModel> findAll();

    public  void update(CustomerModel customer);

}





