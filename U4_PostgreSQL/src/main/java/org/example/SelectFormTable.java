package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectFormTable {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\033[0;32m";
    public static final String ANSI_CYAN = ("\033[0;36m");
    public static final String ANSI_BLUE = "\033[0;34m";

    public static List<String> get_C_and_B() {

        List<String> listResult = new ArrayList<>();

        try (Connection connect = CreateConnection.getConnect();
             Statement stmt = connect.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT first_name, last_name from tablicatest where first_name like '%b%' and first_name like '%c%';");

            System.out.println(ANSI_BLUE + "Запрос обработан" + ANSI_RESET);

            while (rs.next()) {
                listResult.add(rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("<<<<<<в именах которых есть «b» и «c»>>>>>>>");
        return listResult;
    }

    public static List<String> get_First_name_Last_name_Hire_date() {

        List<String> listResult = new ArrayList<>();

        try (Connection connect = CreateConnection.getConnect();
             Statement stmt = connect.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT first_name, last_name, hire_date from tablicatest \n" +
                    "where hire_date LIKE '%1987%';");

            System.out.println(ANSI_BLUE + "Запрос обработан" + ANSI_RESET);

            while (rs.next()) {
                listResult.add(rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("hire_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("<<<<<<приняты на работу в 1987 году>>>>>>>");
        return listResult;
    }///////////////////////////////////////////////////////////////

    public static List<String> get_Max_Salay() {
        List<String> listResult = new ArrayList<>();
        try (Connection connect = CreateConnection.getConnect();
             Statement stmt = connect.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT first_name,last_name, salary FROM tablicatest WHERE salary = ( SELECT MAX(salary) FROM tablicatest);");
            System.out.println(ANSI_BLUE + "Запрос обработан" + ANSI_RESET);
            while (rs.next()) {
                listResult.add(rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("<<<<<<максимальная зарплата>>>>>>>");
        return listResult;
    }//////////////////////////////////////////////////////////
    public static List<String> get_Min_Salay() {
        List<String> listResult = new ArrayList<>();
        try (Connection connect = CreateConnection.getConnect();
             Statement stmt = connect.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT first_name,last_name, salary FROM tablicatest WHERE salary = ( SELECT MIN(salary) FROM tablicatest);");//("SELECT first_name,last_name, MIN(salary) FROM tablicatest;");
            System.out.println(ANSI_BLUE + "Запрос обработан" + ANSI_RESET);
            while (rs.next()) {
                listResult.add(rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("<<<<<<имнимальная зарплата>>>>>>>");
        return listResult;
    }/////////////////////////////////////////////////////////////////

    public static List<String> get_even() {
        List<String> listResult = new ArrayList<>();

        try (Connection connect = CreateConnection.getConnect();
             Statement stmt = connect.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM tablicatest WHERE employe_id % 2 = 0;");

            System.out.println(ANSI_BLUE + "Запрос обработан" + ANSI_RESET);

            while (rs.next()) {
                listResult.add(rs.getString("employe_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("email") + " " + rs.getString("phone_number") + " " + rs.getString("hire_date") + " " + rs.getString("job_id") + " " + rs.getString("salary") + " " + rs.getString("comission_pct"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("<<<<<<<<<<<<четные записи>>>>>>>>>>>>>>");
        return listResult;
    }

        public static List<String> get_odd() {

            List<String> listResult = new ArrayList<>();

            try (Connection connect = CreateConnection.getConnect();
                 Statement stmt = connect.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM tablicatest WHERE employe_id % 2 > 0;");

                System.out.println(ANSI_BLUE + "Запрос обработан" + ANSI_RESET);

                while (rs.next()) {
                    listResult.add(rs.getString("employe_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("email") + " " + rs.getString("phone_number") + " " + rs.getString("hire_date") + " " + rs.getString("job_id") + " " + rs.getString("salary") + " " + rs.getString("comission_pct"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        System.out.println("<<<<<<нечетные записи>>>>>>>");
        return listResult;
    }

    public static List<String> get_Id_Name() {

        List<String> listResult = new ArrayList<>();

        try (Connection connect = CreateConnection.getConnect();
             Statement stmt = connect.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT employe_id, first_name from tablicatest;");

            System.out.println(ANSI_BLUE + "Запрос обработан" + ANSI_RESET);

            while (rs.next()) {
                listResult.add(rs.getString("employe_id") + " " + rs.getString("first_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("<<<<<<вывод всех имен и Employee ID>>>>>>>");
        return listResult;
    }

        public static List<String> get_LastName_HireDate() {

            List<String> listResult = new ArrayList<>();

            try (Connection connect = CreateConnection.getConnect();
                 Statement stmt = connect.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT last_name, hire_date from tablicatest;");

                System.out.println(ANSI_BLUE + "Запрос обработан" + ANSI_RESET);

                while (rs.next()) {
                    listResult.add(rs.getString("last_name") + " " + rs.getString("hire_date"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("\n<<<<<<вывод фамилии и даты рождения>>>>>>>");
            return listResult;
        }

    public static List<String> get_Id_FirstName_LastName_HireDate_DescendingOrder() {

        List<String> listResult = new ArrayList<>();

        try (Connection connect = CreateConnection.getConnect();
             Statement stmt = connect.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT employe_id, first_name, last_name from tablicatest ORDER BY employe_id;;");

            System.out.println(ANSI_BLUE + "Запрос обработан" + ANSI_RESET);

            while (rs.next()) {
                listResult.add(rs.getString("employe_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("<<<<<<вывод имени и фамилии и Employee ID в порядке убывания " +
                "номера Employee ID>>>>>>>");
        return listResult;
    }
    }