package hcmute.team5.service;

import hcmute.team5.model.AccountModel;
import java.util.List;

public interface IAccountService {
    AccountModel login(String username, String password);
    AccountModel findOneByUsername(String username);
    void insert(AccountModel account);
    void insertAcc(AccountModel account);
    List<AccountModel> findAll();
    void deleteAccount(AccountModel account);
}
