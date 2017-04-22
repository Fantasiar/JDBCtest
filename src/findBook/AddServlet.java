package findBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by Fantasia on 2017/4/19.
 */
@WebServlet(name = "AddServlet",urlPatterns = "/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        double price=Double.valueOf(request.getParameter("price"));
        int bookCount=Integer.valueOf(request.getParameter("bookCount"));
        String author=request.getParameter("author");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/test";
            Connection con= DriverManager.getConnection(url,"root","fds5211314");
            String sql="insert into books(name,price,bookCount,author) values(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDouble(2,price);
            ps.setInt(3,bookCount);
            ps.setString(4,author);
            int row=ps.executeUpdate();
            if (row>0){
                System.out.print("<h2>成功添加了"+row+"条数据！<h2>");
            }
            ps.close();
            con.close();
        }catch (Exception e){
            System.out.print("<h2>图书信息添加失败!<h2>");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
