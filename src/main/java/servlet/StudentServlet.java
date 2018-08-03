package servlet;

import bean.Student;
import dao.StudentDAO;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"*.do"})
public class StudentServlet extends BaseServlet {


    //添加
    public void addStudent(HttpServletRequest req, HttpServletResponse resp) {
        Student student = new Student();
        StudentDAO dao = new StudentDAO();
        try {
            BeanUtils.populate(student, req.getParameterMap());
            boolean exist = dao.queryName(student.getName()) == null ? false : true;
            if (exist) {
                req.setAttribute("message", "用户已存在");
                req.setAttribute("student", student);
                req.getRequestDispatcher("/jsp/addStudent.jsp").forward(req, resp);
            } else {
                dao.insert(student);
                req.setAttribute("message", "添加成功");
                req.setAttribute("student", student);
                req.getRequestDispatcher("/jsp/addStudent.jsp").forward(req, resp);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //删除
    public void deleteStudent(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        StudentDAO dao = new StudentDAO();
        try {
            dao.delete(Integer.parseInt(id));
            resp.sendRedirect("/web/queryStudent.do");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //改
    public void updateStudent(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        StudentDAO dao = new StudentDAO();
        Student student = new Student();
        if (id != null) {
            try {
                student = dao.queryId(Integer.parseInt(id));
                req.setAttribute("student", student);
                req.getRequestDispatcher("/jsp/updateStudent.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BeanUtils.populate(student, req.getParameterMap());
                Student student1 = dao.queryName(student.getName());
                student.setId(student1.getId());
                dao.update(student);
                req.setAttribute("student", student);
                req.setAttribute("message", "更新成功");
                req.getRequestDispatcher("/jsp/updateStudent.jsp").forward(req, resp);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //查
    public void queryStudent(HttpServletRequest req, HttpServletResponse resp) {
        Student student = new Student();
        student.setName(req.getParameter("name") == "" ? null : req.getParameter("name"));
        student.setAddress(req.getParameter("address") == "" ? null : req.getParameter("address"));
        student.setPhone(req.getParameter("phone") == "" ? null : req.getParameter("phone"));
        StudentDAO dao = new StudentDAO();
        List<Student> students = null;
        try {
            students = dao.queryBlur(student);
            req.setAttribute("info", student);
            req.setAttribute("students", students);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
