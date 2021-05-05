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


@WebServlet("/views/getallavtobeetwinyear")
public class YearBetweenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectionUrl.createTable();
        List<Avto> list = new ArrayList<>();
        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * from 'avto' WHERE year BETWEEN ? AND ? ORDER BY year;");){

            int yearparam = Integer.parseInt(req.getParameter("yearmin"));
            statement.setInt(1,yearparam);
            int yearparam2 = Integer.parseInt(req.getParameter("yearmax"));
            statement.setInt(2,yearparam2);
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
                req.setAttribute("yearboolbetweennot", "true");
                req.setAttribute("avto_notyear", "Авто таких лет в базе нет");
            }
            else{
                req.setAttribute("yearbetweenbool", "true");
                //req.setAttribute("avto_yearbetween", list);
                req.setAttribute("all", list);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/views/select.jsp").forward(req, resp);
    }
}
