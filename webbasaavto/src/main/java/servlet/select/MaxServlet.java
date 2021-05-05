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


@WebServlet("/views/getnamemaxavto")
public class MaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectionUrl.createTable();
        List<ManufactoryCol> list = new ArrayList<>();

        try(Connection connection = ConnectionUrl.createConnection();
            Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM (SELECT name, count(nameavto) as num FROM 'avto' GROUP BY name) WHERE num = (SELECT max(num) as max FROM (SELECT name, count(nameavto) as num FROM 'avto' GROUP BY name));");

            while (resultSet.next()) {
                ManufactoryCol manufactoryMax = new ManufactoryCol();
                String name = resultSet.getString("name");
                manufactoryMax.setName(name);
                System.out.print("Производитель с максимальным числом авто в базе: " + name + ", ");
                int num = resultSet.getInt("num");
                manufactoryMax.setCount(num);
                System.out.print("Количество авто в базе : " + num + ", ");
                System.out.println();
                System.out.println("--------------");
                list.add(manufactoryMax);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("namemaxbool", "true");
        req.setAttribute("namemax", list);
        getServletContext().getRequestDispatcher("/views/select.jsp").forward(req, resp);
    }
}
