package servlet.select;

import basa.ConnectionUrl;
import model.Avto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/views/getallname")
public class SelectManufactures extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectionUrl.createTable();
        List<String> listNames = new ArrayList<>();
        try(Connection connection = ConnectionUrl.createConnection();
            Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT name FROM 'avto';");
            while (resultSet.next()) {

                String name = resultSet.getString("name");
                System.out.print("Производитель : " + name + ", ");
                listNames.add(name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allname", "true");
        req.setAttribute("names", listNames);
        getServletContext().getRequestDispatcher("/views/select.jsp").forward(req, resp);
    }
}
