package hcmute.team5.service.impl;

import hcmute.team5.DAO.IAccountDAO;
import hcmute.team5.DAO.impl.AccountDAO;
import hcmute.team5.model.AccountModel;
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
    public List<AccountModel> findAll() {
        return accountDAL.findAll();
    }
}
