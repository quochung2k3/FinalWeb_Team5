package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.IAccountDAO;
import hcmute.team5.mapper.AccountMapper;
import hcmute.team5.model.AccountModel;

import java.sql.*;
import java.util.List;

public class AccountDAO extends AbstractDAO<AccountModel> implements IAccountDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public AccountModel findOneByUsername(String username) {
        String sql = "SELECT * FROM Account WHERE username = ?";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                AccountModel account = new AccountModel();
                account.setId(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassWord(rs.getString(3));
                account.setFullName(rs.getString(4));
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
    public void insert(AccountModel account) {
        String sql = "INSERT INTO Account(username, password, roleid, status) VALUES(?, ?, ?, ?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getUserName());
            ps.setString(2, account.getPassWord());
            ps.setInt(3, account.getRoleId());
            ps.setString(4, account.getStatus());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AccountModel> findAll(int fetch, int offset) {
        String sql ="SELECT * FROM Account ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        return query(sql, new AccountMapper(), offset, fetch);
    }

    @Override
    public void deleteAccount(AccountModel account) {
        String sql = "DELETE FROM Account WHERE id = ?";
        update(sql, account.getId());
    }

    @Override
    public void insertAcc(AccountModel account) {
        String sql = "INSERT INTO Account(username, password, roleid, status, fullname) VALUES(?, ?, ?, ?, ?)";
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getUserName());
            ps.setString(2, account.getPassWord());
            ps.setInt(3, account.getRoleId());
            ps.setString(4, account.getStatus());
            ps.setString(5, account.getFullName());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(AccountModel account) {
        String sql = "UPDATE Account SET fullname = ?, password = ?, roleid = ? WHERE username = ?";
        update(sql, account.getFullName(), account.getPassWord(), account.getRoleId(), account.getUserName());
    }

    @Override
    public List<AccountModel> findAllByProperties(String roleName, String status, String username, int pageSize, int index) {
        int roleId = 0;
        if(roleName.equals("Admin")) {
            roleId = 1;
        }
        if(roleName.equals("Customer")) {
            roleId = 2;
        }
        if(status.equals("All") && username.equals("")) {
            String sql ="SELECT * FROM Account WHERE roleid = ? ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            return query(sql, new AccountMapper(), roleId, index, pageSize);
        }
        else if(roleName.equals("All") && username.equals("")) {
            String sql ="SELECT * FROM Account WHERE status = ? ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            return query(sql, new AccountMapper(), status, index, pageSize);
        }
        else if(status.equals("All") && roleName.equals("All")) {
            String sql ="SELECT * FROM Account WHERE username LIKE ? ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            username = '%'+username+'%';
            return query(sql, new AccountMapper(), username, index, pageSize);
        }
        else if(username.equals("")) {
            String sql ="SELECT * FROM Account WHERE roleid = ? AND status = ? ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            return query(sql, new AccountMapper(), roleId, status, index, pageSize);
        }
        else if(status.equals("All")) {
            String sql ="SELECT * FROM Account WHERE roleid = ? AND username LIKE ? ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            username = '%'+username+'%';
            return query(sql, new AccountMapper(), roleId, username, index, pageSize);
        }
        else if(roleName.equals("All")) {
            String sql ="SELECT * FROM Account WHERE status = ? AND username LIKE ? ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            username = '%'+username+'%';
            return query(sql, new AccountMapper(), status, username, index, pageSize);
        }
        else {
            String sql ="SELECT * FROM Account WHERE roleid = ? AND status = ? AND username LIKE ? ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            username = '%'+username+'%';
            return query(sql, new AccountMapper(), roleId, status, username, index, pageSize);
        }
    }

    @Override
    public int getNumOfAccount() {
        int num = 0;
        String sql = "SELECT count(*) FROM Account";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
        }
        catch (Exception e) {
            if(conn != null) {
                try {
                    conn.rollback();
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        finally {
            try {
                conn.close();
                ps.close();
                rs.close();
            }
            catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        return num;
    }
}