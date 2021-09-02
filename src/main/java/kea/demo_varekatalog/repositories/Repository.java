package kea.demo_varekatalog.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Repository {

    private DatabaseConnection databaseConnection = new DatabaseConnection();
    private Connection connection = databaseConnection.getConnection();

    // Methods made to perform try and catch and as well to be used multiple times in repositories
    public ResultSet executeQuery(String sql) {
        connection = databaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        }
        catch (Exception e) {
            System.out.println("Couldn't execute query...\n" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    protected void executeUpdate(String sql) {
        connection = databaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Couldn't execute update...\n" + e.getMessage());
            e.printStackTrace();
        }
        closeConnection();
    }

    private void closeConnection() {
        try {
            connection.close();
        }
        catch (Exception e) {
            System.out.println("Couldn't close connection...\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    public int findId(String table, String where, String value, String ColumnOfId) {

        ResultSet res = executeQuery("SELECT * FROM " + table + " WHERE " + where + " = '" + value + "';");

        try {
            res.next();
            return res.getInt(ColumnOfId);
        }
        catch (Exception e) {
            System.out.println("Couldn't find id...\n" + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public int calcNextId(String table) {
        ResultSet res = executeQuery("SELECT * FROM " + table + ";");

        int nextId = 0;

        try {
            while (res.next()) {
                nextId++;
            }
            connection.close();
        }
        catch (Exception e) {
            System.out.println("Something went wrong with calculating next id...\n" + e.getMessage());
        }
        return nextId + 1;
    }

    public ResultSet selectAll(String table) {
        connection = databaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("Select * FROM " + table + ";");
            return statement.executeQuery();
        }
        catch (Exception e) {
            System.out.println("Couldn't select all...\n" + e.getMessage());
            return null;
        }
    }

    public void closeCurrentConnection() {
        closeConnection();
    }
}
