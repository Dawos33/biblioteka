package com.biblioteka.commons;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbStuff {
    private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String dbAddress = "jdbc:mysql://localhost:3306/";
    private String userPass = "?user=root&password=";
    private String dbName = "BIBLIOTEKA";
    private String userName = "root";
    private String password = "";

    private Connection con;

    public DbStuff() {

        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            createDatabase();
        }
    }

    private void createDatabase() {
        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + userPass + password);
            Statement s = con.createStatement();
            s.executeUpdate("CREATE DATABASE " + dbName + " IF NOT EXISTS TIGER;");
        }
        catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void createTableCub1() {
        String myTableName = "CREATE TABLE nowaTabela ("
                + "id INT(64) NOT NULL AUTO_INCREMENT,"
                + "initials VARCHAR(2),"
                + "agentDate DATE,"
                + "agentCount INT(64), "
                + "PRIMARY KEY(id))";
        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            Statement s = con.createStatement();
            //This line has the issue
            s.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e ) {
            System.out.println("An error has occured on Table Creation");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("An Mysql drivers were not found");
        }
    }

}
