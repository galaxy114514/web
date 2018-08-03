package dao;

import bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.C3p0Utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User query(User user) {
        DataSource dataSource = C3p0Utils.getDataSource();
        QueryRunner runner = new QueryRunner(dataSource);
        User result=null;
        try {
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            String sql = "select * from users where username=? and password=?";
            Object[] objects=new Object[]{user.getUsername(),user.getPassword()};
            result = runner.query(sql, new BeanHandler<>(User.class), objects);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void insert(User user) {
        DataSource dataSource = C3p0Utils.getDataSource();
        QueryRunner runner = new QueryRunner(dataSource);
        try {
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            String sql = "insert into users values(?,?)";
            Object[] objects = new Object[]{user.getUsername(), user.getPassword()};
            runner.update(sql, objects);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean queryUsername(User user) {
        DataSource dataSource = C3p0Utils.getDataSource();
        QueryRunner runner = new QueryRunner(dataSource);
        boolean isExist=false;
        try {
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            String sql = "select * from users where username=?";
            User query = runner.query(sql, new BeanHandler<User>(User.class), user.getUsername());
            if (query!=null){
                isExist=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }
}
