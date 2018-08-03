package dao;

import bean.Book;
import bean.User;
import org.junit.Test;
import utils.Base64Utils;

import javax.servlet.http.Cookie;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class test {
    @Test
    public void name() {
        System.out.println(Base64Utils.encode("abc"));
        String src = Base64Utils.encode("efg");
        System.out.println(Base64Utils.decode(src));
    }

    @Test
    public void name1() {
        UserDao dao = new UserDaoImpl();
        User user = new User();
        user.setUsername("zhang");
        user.setPassword("123");
        dao.insert(user);
    }

    @Test
    public void name2() {
        UserDao dao = new UserDaoImpl();
        User user = new User();
        user.setUsername("zhang");
        user.setPassword("1");
        boolean b = dao.queryUsername(user);
        System.out.println(b);
    }

    @Test
    public void name3() {
        String str = "/abcd.asdas";
        System.out.println(str.indexOf("/"));
        System.out.println(str.indexOf("."));
        System.out.println(str.substring(str.indexOf("/") + 1, str.lastIndexOf(".")));
    }

    @Test
    public void name4() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replaceAll("-",""));
    }

    @Test
    public void name5() throws SQLException {
        BookDao dao=new BookDaoImpl();
        Book book=new Book();
        book.setTitle("php");
        book.setPrice(20);
        int i = dao.add(book);
        System.out.println(i);
    }

    @Test
    public void name6() throws SQLException {
        BookDao dao=new BookDaoImpl();
        List<Book> books = dao.findAll();
        System.out.println(books);
    }

    @Test
    public void name7() {
        Cookie cookie1=new Cookie("name1","zhang");
        Cookie cookie2=new Cookie("name1","zhang");
        System.out.println(cookie1==cookie2);
    }

    @Test
    public void name8() {
        LinkedList list=new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
//        list.removeFirst();
        list.remove("3");
        System.out.println(list);
    }
}
