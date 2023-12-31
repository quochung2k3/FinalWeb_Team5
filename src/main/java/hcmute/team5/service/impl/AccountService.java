package hcmute.team5.service.impl;

import hcmute.team5.DAO.IAccountDAO;
import hcmute.team5.DAO.impl.AccountDAO;
import hcmute.team5.model.AccountModel;
import hcmute.team5.model.CustomerModel;
import hcmute.team5.service.IAccountService;

import java.util.List;

public class AccountService implements IAccountService {
    IAccountDAO accountDAL = new AccountDAO();

    @Override
    public AccountModel login(String username, String password) {
        AccountModel account = accountDAL.findOneByUsername(username);
        if (account != null && account.getPassWord().equals(password)) {
            return account;
        }
        return null;
    }

    @Override
    public AccountModel findOneByUsername(String username) {
        return accountDAL.findOneByUsername(username);
    }

    @Override
    public void insert(AccountModel account) {
        accountDAL.insert(account);
    }

    @Override
    public void insertAcc(AccountModel account) {
        accountDAL.insertAcc(account);
    }

    @Override
    public void insertCus(CustomerModel customer) {
        accountDAL.insertCus(customer);
    }

    @Override
    public List<AccountModel> findAll(int fetch, int offset) {
        return accountDAL.findAll(fetch, offset);
    }

    @Override
    public void deleteAccount(AccountModel account) {
        accountDAL.deleteAccount(account);
    }

    @Override
    public void update(AccountModel account) {
        accountDAL.update(account);
    }

    @Override
    public List<AccountModel> findAllByProperties(String roleName, String status, String username, int pageSize, int index) {
        return accountDAL.findAllByProperties(roleName, status, username, pageSize, index);
    }

    @Override
    public int getNumOfAccount() {
        return accountDAL.getNumOfAccount();
    }
}
