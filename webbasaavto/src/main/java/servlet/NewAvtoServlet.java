package servlet;

import basa.ConnectionUrl;
import model.Avto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/views/newavto")
public class NewAvtoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectionUrl.createTable();

        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT into 'avto' (name, nameavto, engine, year, color, type) values (?, ?, ?, ?, ?, ?);");){
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            statement.setString(1, name);
            String nameAvto = req.getParameter("nameAvto").toLowerCase();
            statement.setString(2, nameAvto);
            int engine = Integer.parseInt(req.getParameter("engine"));
            statement.setInt(3, engine);
            int year = Integer.parseInt(req.getParameter("year"));
            statement.setInt(4, year);
            String color = req.getParameter("color").toLowerCase();
            statement.setString(5, color);
            String type = req.getParameter("type").toLowerCase();
            statement.setString(6, type);

            statement.execute();

            //statement.executeQuery();
            //System.out.println(resultSet.getMetaData());
            System.out.println("пришло");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("newavto", "Новая запись добавлена");

        getServletContext().getRequestDispatcher("/views/newavto.jsp").forward(req, resp);
    }
}
