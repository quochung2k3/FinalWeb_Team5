package hcmute.team5.DAO;

import hcmute.team5.model.AccountModel;

public interface IAccountDAO {
    AccountModel findOneByUsername(String username);
    void insert(AccountModel account);
}
