package dao;

import bean.Student;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3p0Utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements DAO<Student> {

    @Override
    public List<Student> queryAll() throws SQLException {
        DataSource dataSource = C3p0Utils.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "select * from students ";
        List<Student> students = new ArrayList<>();
        try {
            students = runner.query(sql, new BeanListHandler<Student>(Student.class));
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollback(connection);
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return students;
    }



    @Override
    public List<Student> queryBlur(Student student) throws SQLException {
        DataSource dataSource = C3p0Utils.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "select * from students where name like ? or address like ? or phone like ? ";
        List<Student> students = new ArrayList<>();
        String name="%"+student.getName()+"%";
        String address="%"+student.getAddress()+"%";
        String phone="%"+student.getPhone()+"%";
        Object[] objects=new Object[]{name,address,phone};
        try {
            students = runner.query(sql, new BeanListHandler<Student>(Student.class),objects);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollback(connection);
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return students;
    }

    @Override
    public boolean queryExist(String name) throws SQLException {
        DataSource dataSource = C3p0Utils.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "select * from students where name=? ";
        Boolean result=false;
        try {
            Student student = runner.query(sql, new BeanHandler<Student>(Student.class), name);
            connection.commit();
            if (student!=null){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollback(connection);
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return result;
    }

    @Override
    public Student queryName(String name) throws SQLException {
        DataSource dataSource = C3p0Utils.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "select * from students where name=? ";
        Student student = new Student();
        try {
            student = runner.query(sql, new BeanHandler<Student>(Student.class), name);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollback(connection);
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return student;
    }

    @Override
    public Student queryId(int id) throws SQLException {
        DataSource dataSource = C3p0Utils.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "select * from students where id=? ";
        Student student = new Student();
        try {
            student = runner.query(sql, new BeanHandler<Student>(Student.class), id);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollback(connection);
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return student;
    }

    @Override
    public void insert(Student student) throws SQLException {
        DataSource dataSource = C3p0Utils.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "insert into students values(?,?,?,?)";
        Object[] objects=new Object[]{student.getId(),student.getName(),student.getAddress(),student.getPhone()};
        try {
            runner.update(sql,objects);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollback(connection);
        } finally {
            DbUtils.closeQuietly(connection);
        }
    }

    @Override
    public void update(Student student) throws SQLException {
        DataSource dataSource = C3p0Utils.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "update students set name=? , address=? , phone=? where id =?";
        Object[] objects=new Object[]{student.getName(),student.getAddress(),student.getPhone(),student.getId()};
        try {
            runner.update(sql,objects);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollback(connection);
        } finally {
            DbUtils.closeQuietly(connection);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        DataSource dataSource = C3p0Utils.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "delete from students where id=? ";
        try {
            runner.update(sql, id);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollback(connection);
        } finally {
            DbUtils.closeQuietly(connection);
        }
    }
}
