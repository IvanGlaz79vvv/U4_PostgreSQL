package org.example;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class CreateConnection {
    private static String url = "jdbc:postgresql://localhost:5432/postgres?&user=postgres&password=root";
    static Connection con = null;
    static Connection getConnect() {
        try {
            con = getConnection(url);
            System.out.println("^^^^^^^Соединение установлено^^^^^^^");
        } catch (SQLException e) {
            System.out.println("!!!!!!!!Нет соединения с базой!!!!!!!!");
            e.printStackTrace();
        }
        return con;//
    }
}
