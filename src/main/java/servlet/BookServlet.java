package servlet;

import bean.Book;
import dao.BookDao;
import dao.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "*.books")
public class BookServlet extends BaseServlet {
    BookDao dao=new BookDaoImpl();

    public void findAll(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("entry findAll");
        try {
            List<Book> books = dao.findAll();





            System.out.println(books);













            List lists=new ArrayList();
            lists.add(1);
            lists.add(2);
            lists.add(3);
            req.setAttribute("books",books);
            req.setAttribute("lists",lists);
            req.getRequestDispatcher("/jsp/booklist.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
