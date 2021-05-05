package basa;

import org.sqlite.JDBC;

import java.awt.*;
import java.sql.*;

public class ConnectionUrl {

    public static final String URL = "jdbc:sqlite:dbavto.db";

    static {
        try {
            DriverManager.registerDriver(new JDBC());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Driver not registred");
        }
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:dbavto.db");
    }

    public static void createTable() {

        try (Connection connection = ConnectionUrl.createConnection()) {
            System.out.println(connection.getMetaData().getURL());
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE if not exists 'avto' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text NOT NULL, 'nameavto' text NOT  NULL, " +
                    "'engine' INTEGER NOT NULL, 'year' INTEGER NOT NULL, 'color' text NOT NULL, 'type' text NOT NULL);");
            System.out.println("Table Avto Created");
            ResultSet rez_i = statement.executeQuery("SELECT max(id) as idm FROM 'avto';");
            System.out.println(rez_i.getInt("idm"));

            if (rez_i.getInt("idm")==0) {
                String query = "INSERT into 'avto' (name, nameavto, engine, year, color, type) values ('Vaz', 'classic', 1500, 2005, 'Белый', 'седан'), ('Vaz', 'niva', 1700, 2010, 'Красный', 'хэчбэк'), ('Vaz', 'kalina', 1300, 2012, 'Белый', 'универсал'), ('Vaz', 'granta', 1300, 2012, 'Синий', 'sedan'), \n" +
                        "('Vaz', 'vesta', 1800, 2015, 'Черный', 'универсал'), ('Audi', 'A3', 2000, 2008, 'красный', 'седан'), ('Audi', 'A4', 1800, 2015, 'черный', 'купе'), ('Audi', 'A3', 2500, 2018, 'белый', 'седан'), ('Audi', 'A8', 3000, 2010, 'синий', 'седан'), \n" +
                        "('BMW', '3', 1800, 2001, 'красный', 'седан'), ('BMW', '5', 2500, 2013, 'серый', 'универсал'), ('BMW', '7', 4000, 2017, 'желтый', 'седан'), \n" +
                        "('Mitsubishi', 'лансер', 1500, 2008, 'серый', 'седан'), ('Mitsubishi', 'асх', 2000, 2018, 'серый', 'хэчбэк'), ('Reno', 'дастер', 2000, 2014, 'зеленый', 'хэчбэк');";
                System.out.println("query = " + query);
                statement.execute(query);
                System.out.println("Вставка данных прошла - Успешно");
            }
            else{
                System.out.println("Таблица уже не пустая");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
