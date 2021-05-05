package servlet;

import basa.ConnectionUrl;

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
import java.util.HashMap;

@WebServlet("/views/deleteavtobyid")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ConnectionUrl.createTable();
        String delete = "";
        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM 'avto' WHERE id = ?;");){

            statement.setInt(1, id);


            if(statement.executeUpdate()==1){
                System.out.println("Авто удалено успешно");
                delete = "Авто удалено успешно.";
            }
            else{
                System.out.println("Нет такого номера");
                delete = "Нет такого номера id";
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("delete", delete);

        getServletContext().getRequestDispatcher("/views/deleteAvto.jsp").forward(req, resp);

    }
}
