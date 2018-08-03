package dao;

import bean.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3p0Utils;
import utils.UUIDUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public int add(Book book) throws SQLException {
        DataSource dataSource = C3p0Utils.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        QueryRunner runner = new QueryRunner(dataSource);
        book.setId(UUIDUtils.getUUID());
        String sql = "insert into books values(?,?,?)";
        Object[] objects = {book.getId(), book.getTitle(), book.getPrice()};
        int result = runner.update(sql, objects);
        connection.commit();
        return result;
    }

    @Override
    public List<Book> findAll() throws SQLException {
        DataSource dataSource = C3p0Utils.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "select * from books";
        List<Book> result = runner.query(sql, new BeanListHandler<Book>(Book.class));
        connection.commit();
        return result;
    }
}
