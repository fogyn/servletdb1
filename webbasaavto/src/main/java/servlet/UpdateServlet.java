package servlet;

import basa.ConnectionUrl;
import model.Avto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/views/updateavtobyid")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ConnectionUrl.createTable();
        String update = "";
        Avto avtoById = new Avto();
        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("select * FROM 'avto' WHERE id = ?;");){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                avtoById.setId(resultSet.getInt("id"));
                avtoById.setName(resultSet.getString("name"));
                avtoById.setNameAvto(resultSet.getString("nameavto"));
                avtoById.setEngine(resultSet.getInt("engine"));
                avtoById.setYear(resultSet.getInt("year"));
                avtoById.setColor(resultSet.getString("color"));
                avtoById.setType(resultSet.getString("type"));

                req.setAttribute("updateid", true);
                req.setAttribute("avtobyid", avtoById);
            }
            else {
                update = "Такого id нет";
                //req.setAttribute("updateid", false);
                req.setAttribute("update", update);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/views/updateAvto.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String update = "";
        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE 'avto' SET name = ?, nameavto = ?, engine = ?, year = ?, color = ?, type = ? WHERE id = ?;");){
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            System.out.println(name);
            statement.setString(1, name);
            String nameAvto = req.getParameter("nameAvto").toLowerCase();
            statement.setString(2, nameAvto);
            System.out.println(nameAvto);
            int engine = Integer.parseInt(req.getParameter("engine"));
            statement.setInt(3, engine);
            int year = Integer.parseInt(req.getParameter("year"));
            statement.setInt(4, year);
            String color = req.getParameter("color").toLowerCase();
            System.out.println(color);
            statement.setString(5, color);
            String type = req.getParameter("type").toLowerCase();
            System.out.println(type);
            statement.setString(6, type);

            int id = Integer.parseInt(req.getParameter("id"));
            statement.setInt(7 ,id);

            statement.execute();

            if(statement.executeUpdate()==1){
                System.out.println("Авто отредактировано успешно");
                update = "Авто отредактировано успешно.";
            }
            else{
                System.out.println("Нет такого номера");
                update = "Нет такого номера id";
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("update", update);

        getServletContext().getRequestDispatcher("/views/updateAvto.jsp").forward(req, resp);
    }
}
