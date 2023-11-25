package hcmute.team5.service;

import hcmute.team5.model.UserModel;

public interface IUserService {
    public UserModel login(String username, String password);
    public UserModel findOneByUsername(String username);
    public void insert(UserModel account);
}
