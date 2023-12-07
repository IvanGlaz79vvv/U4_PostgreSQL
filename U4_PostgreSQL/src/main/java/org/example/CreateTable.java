package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    static Connection con = null;
    static void getcreateTable(String sql) {
        try (Connection connection = CreateConnection.getConnect()) {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            System.err.println("Таблица НЕ СОЗДАНА");
            e.printStackTrace();//
        }
    }
}
