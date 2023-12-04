package hcmute.team5.mapper;

import hcmute.team5.model.AccountModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<AccountModel> {
    @Override
    public AccountModel mapRow(ResultSet rs) {
        try {
            AccountModel news = new AccountModel();
            news.setId(rs.getInt("id"));
            news.setUserName(rs.getString("username"));
            news.setFullName(rs.getString("fullname"));
            news.setPassWord(rs.getString("password"));
            news.setStatus(rs.getString("status"));
            news.setRoleId(rs.getInt("roleid"));
            return news;
        }
        catch (SQLException e) {
            return null;
        }
    }
}
