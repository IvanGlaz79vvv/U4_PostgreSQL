package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Map;

public class InsertToTable {
    //String insert = "INSERT INTO tablicatest (first_name, last_name, email, phone_number, hire_date, job_id, salary, comission_pct) VALUES(";
    public static void getInsertToTable(String insert, BufferedReader br) throws IOException, FileNotFoundException {

            String reader = br.readLine().toString();
            ParseCSV parseCSV = new ParseCSV();
            Map map = parseCSV.getParseCSV(reader);

//            System.out.println("map.size() = " + map.size());
//            System.out.println("map: \n" + map);

            StringBuilder sb = new StringBuilder(insert);
            for (int i = 0; i < map.size(); i++) {
                String s = "'" + map.get(i) + "', ";
                sb.append(s);
            }
            int start = sb.lastIndexOf(", ");
            sb.delete(start, sb.length());
            insert = sb.append(");").toString();
//            System.out.println("\ninsert: \n" + insert);


            CreateConnection connectTable = new CreateConnection();
            try (Connection connect = connectTable.getConnect()) {
                Statement pstm = connect.createStatement();
                pstm.executeUpdate(insert);
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }