package hcmute.team5.service.impl;

import hcmute.team5.DAO.IUserDAO;
import hcmute.team5.DAO.impl.UserDAO;
import hcmute.team5.model.UserModel;
import hcmute.team5.service.IUserService;

public class UserService implements IUserService {
    IUserDAO accountDAL = new UserDAO();
    @Override
    public UserModel login(String username, String password) {
        UserModel account = accountDAL.findOneByUsername(username);
        if (account != null && account.getPassWord().equals(password)) {
            return account;
        }
        return null;
    }

    @Override
    public UserModel findOneByUsername(String username) {
        return accountDAL.findOneByUsername(username);
    }

    @Override
    public void insert(UserModel account) {
        accountDAL.insert(account);
    }
}
