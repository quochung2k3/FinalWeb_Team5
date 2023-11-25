package hcmute.team5.DAO;

import hcmute.team5.model.UserModel;

public interface IUserDAO {
    UserModel findOneByUsername(String username);
    void insert(UserModel account);
}
