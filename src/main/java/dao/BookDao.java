package dao;

import bean.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    int add(Book book) throws SQLException;
    List<Book> findAll() throws SQLException;
}
