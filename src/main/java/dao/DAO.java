package dao;

import java.sql.SQLException;
import java.util.List;

/*
 * @param T:DAO处理的实体类类型
 * */
public interface DAO<T> {
    List<T> queryAll() throws SQLException;





    List<T> queryBlur(T t) throws SQLException;

    boolean queryExist(String name) throws SQLException;

    /*
     * 返回具体的一个值
     * */
    T queryName(String name) throws SQLException;

    T queryId(int id) throws SQLException;

    /*
     * 插入一个值
     * */
    void insert(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(int id) throws SQLException;


}
