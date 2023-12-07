package org.example;

public class Main {
    public static void main(String[] args) {
        String sqlUsers = "create table if not exists \"Users\" (\n" +
                "id int generated always as identity,\n" +
                "name varchar(20) not null,\n" +
                "primary key(id)\n" +
                ");";

        String sqlContacts = "create table \"Contacts\"(\n" +
                "id int generated always as identity,\n" +
                "\"customerId\" int,\n" +
                "\"contactName\" varchar(255) not null,\n" +
                "phone varchar(15),\n" +
                "email varchar(100),\n" +
                "primary key (id),\n" +
                "constraint \"fk_Users_Contacts\"\n" +
                "foreign key(\"customerId\")\n" +
                "references \"Users\"(id)\n" +
                ");";

        String sqlTest = "create table \"tablicatest\"\n" +
                "(\n" +
                "    employe_id    integer not null\n" +
                "    primary key,\n" +
                "    first_name    text,\n" +
                "    last_name     text,\n" +
                "    email         text,\n" +
                "    phone_number  text,\n" +
                "    hire_date     text,\n" +
                "    job_id        text,\n" +
                "    salary        numeric,\n" +
                "    comission_pct integer\n" +
                ");";

        //////////////////////////////////////////
//        CreateTable.getcreateTable(sqlUsers);
//        CreateTable.getcreateTable(sqlContacts);

        CreateTable.getcreateTable(sqlTest);
        System.out.println("проверка Git");
    }
}