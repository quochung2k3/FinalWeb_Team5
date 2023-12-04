package hcmute.team5.DAO;

import hcmute.team5.model.AccountModel;

import java.util.List;

public interface IAccountDAO {
    AccountModel findOneByUsername(String username);
    void insert(AccountModel account);
    List<AccountModel> findAll();
    void deleteAccount(AccountModel account);
}
