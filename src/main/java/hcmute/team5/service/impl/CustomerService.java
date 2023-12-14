package hcmute.team5.service.impl;

import hcmute.team5.DAO.ICustomerDAO;
import hcmute.team5.DAO.impl.CustomerDAO;
import hcmute.team5.model.CustomerModel;
import hcmute.team5.service.ICustomerService;
import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerDAO customerDAL = new CustomerDAO();
    @Override
    public List<CustomerModel> findAll(int pageSize, int index) {
        return customerDAL.findAll(pageSize, index);
    }

    @Override
    public void updateCustomer(CustomerModel customer) {
        customerDAL.updateCustomer(customer);
    }

    @Override
    public CustomerModel findOneByCustomer(int maKh) {
        return customerDAL.findOneByCustomer(maKh);
    }

    @Override
    public void deleteCustomer(CustomerModel customer) {
        customerDAL.deleteCustomer(customer);
    }

    public void insertCus(CustomerModel customer){ customerDAL.insertCus(customer);}

    @Override
    public List<CustomerModel> findAllByProperties(String name, String total, int pageSize, int index) {
        return customerDAL.findAllByProperties(name, total, pageSize, index);
    }

    @Override
    public int getNumOfCustomer() {
        return customerDAL.getNumOfCustomer();
    }
}
