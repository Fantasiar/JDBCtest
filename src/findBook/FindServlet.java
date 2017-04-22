package findBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fantasia on 2017/4/18.
 */
@WebServlet(name = "FindServlet",urlPatterns = "/FindServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/test";
            Connection con= DriverManager.getConnection(url,"root","fds5211314");
            Statement stmt=con.createStatement();
            String sql="select * from books";
            ResultSet rs=stmt.executeQuery(sql);
            List<Book> list=new ArrayList<Book>();
            while (rs.next()){
                Book book=new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setBookCount(rs.getInt("bookCount"));
                book.setAuthor(rs.getString("author"));
                list.add(book);
            }
            request.setAttribute("list",list);
            rs.close();
            stmt.close();
            con.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("book_list.jsp").forward(request,response);
    }
}
