package hcmute.team5.DAO.impl;

import hcmute.team5.DAO.DBConnectionSQL;
import hcmute.team5.DAO.GenericDAO;
import hcmute.team5.mapper.RowMapper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {
    Connection conn;

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBConnectionSQL().getConnection();
            ps = conn.prepareStatement(sql);
            setParameter(ps, parameters);
            rs = ps.executeQuery();
            while (rs.next()) {
                results.add(rowMapper.mapRow(rs));
            }
            return results;
        }
        catch (Exception e) {
            return null;
        }
        finally {
            try {
                conn.close();
                ps.close();
                rs.close();
            }
            catch (SQLException e){
                return null;
            }
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new DBConnectionSQL().getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            setParameter(ps, parameters);
            ps.executeUpdate();
            conn.commit();
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
            }
            catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }
    @Override
    public int insert(String sql, Object... parameters) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            int id = 0;
            conn = new DBConnectionSQL().getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(ps, parameters);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()) {
                id = rs.getInt(1);
            }
            conn.commit();
            return id;
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
        return 0;
    }

    private void setParameter(PreparedStatement ps, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Integer) {
                    ps.setInt(index, (Integer) parameter);
                } else if (parameter instanceof String) {
                    ps.setString(index, (String) parameter);
                } else if (parameter instanceof Timestamp) {
                    ps.setTimestamp(index, (Timestamp) parameter);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
