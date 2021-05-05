package servlet.select;

import basa.ConnectionUrl;
import model.ManufactoryCol;

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


@WebServlet("/views/getallname&avto")
public class SelectManCol extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectionUrl.createTable();
        List<ManufactoryCol> listNames = new ArrayList<>();
        try(Connection connection = ConnectionUrl.createConnection();
            Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT name, count(nameavto) as num FROM 'avto' GROUP BY name;");
            while (resultSet.next()) {
                ManufactoryCol manufactoryCol = new ManufactoryCol();
                String name = resultSet.getString("name");
                manufactoryCol.setName(name);
                System.out.print("Производитель : " + name + ", ");
                int num  = resultSet.getInt("num");
                manufactoryCol.setCount(num);
                System.out.print("Количество авто в базе : " + num + ", ");
                System.out.println();
                System.out.println("--------------");
                listNames.add(manufactoryCol);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("namecol", "true");
        req.setAttribute("names_cols", listNames);
        getServletContext().getRequestDispatcher("/views/select.jsp").forward(req, resp);
    }
}
