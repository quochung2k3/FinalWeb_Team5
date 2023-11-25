package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.IUserDAO;
import hcmute.team5.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO implements IUserDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public UserModel findOneByUsername(String username) {
        String sql = "SELECT * FROM user_table WHERE username = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserModel account = new UserModel();
                account.setId(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassWord(rs.getString(3));
                account.setRoleId(rs.getInt(6));
                conn.close();
                return account;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insert(UserModel account) {
        String sql = "INSERT INTO user(username, password, roleid) VALUES(?, ?, ?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getUserName());
            ps.setString(2, account.getPassWord());
            ps.setInt(3, account.getRoleId());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
