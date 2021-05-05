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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/views/getallavtobyname")
public class ByManufactoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectionUrl.createTable();
        List<Avto> list = new ArrayList<>();
        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * from 'avto' WHERE name like ? ORDER BY year;");){

            String nameparam = req.getParameter("name");
            statement.setString(1, nameparam);
            ResultSet resultSet = statement.executeQuery();

            int a = 0;
            while (resultSet.next()){
                a++;
                Avto av = new Avto();
                int id = resultSet.getInt("id");
                System.out.print("id = "+id+", ");
                av.setId(id);

                String name = resultSet.getString("name");
                System.out.print("Производитель : "+name+", ");
                av.setName(name);

                String nameavto = resultSet.getString("nameavto");
                System.out.print("модель : "+nameavto+", ");
                av.setNameAvto(nameavto);

                int engine = resultSet.getInt("engine");
                System.out.print("Объем : "+engine+", ");
                av.setEngine(engine);

                int year = resultSet.getInt("year");
                System.out.print("год : "+year+", ");
                av.setYear(year);

                String color = resultSet.getString("color");
                System.out.print("Цвет : "+color+", ");
                av.setColor(color);

                String type = resultSet.getString("type");
                System.out.print("кузов : "+type);
                av.setType(type);

                System.out.println();
                System.out.println("------------");
                list.add(av);
            }
            if(a==0){
                req.setAttribute("yearboolnot", "true");
                req.setAttribute("avto_notyear", "Авто такого производителя в базе нет");
            }
            else{
                req.setAttribute("yearbool", "true");
                req.setAttribute("all", list);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/views/select.jsp").forward(req, resp);
    }
}
