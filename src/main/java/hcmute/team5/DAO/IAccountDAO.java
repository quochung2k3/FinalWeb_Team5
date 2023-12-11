package hcmute.team5.DAO;

import hcmute.team5.model.AccountModel;

import java.util.List;

public interface IAccountDAO {
    AccountModel findOneByUsername(String username);
    void insert(AccountModel account);
    List<AccountModel> findAll(int fetch, int offset);
    void deleteAccount(AccountModel account);
    void insertAcc(AccountModel account);
    void update(AccountModel account);
    List<AccountModel> findAllByProperties(String roleName, String status, String username);
}
