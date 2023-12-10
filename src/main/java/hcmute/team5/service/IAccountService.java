package hcmute.team5.service;

import hcmute.team5.model.AccountModel;
import java.util.List;

public interface IAccountService {
    public AccountModel login(String username, String password);
    public AccountModel findOneByUsername(String username);
    public void insert(AccountModel account);
    void insertAcc(AccountModel account);
    List<AccountModel> findAll();
    public void deleteAccount(AccountModel account);
    public void update(AccountModel account);
    List<AccountModel> findAllByProperties(String roleName, String status, String username);
}
