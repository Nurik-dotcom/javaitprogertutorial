package com.example;

import java.sql.*;



public class DatabaseHandler extends Config {
    Connection dbConnection;
    public Connection getDbConnection() 
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);    
                return dbConnection;
            }
    
    public void signUp(User user) throws SQLException, ClassNotFoundException {
        String insert = "insert into " + Const.USER_TABLE + "(" + Const.USER_NAME + "," + Const.USER_SURNAME + "," + Const.USER_USERNAME + "," + Const.USER_PSWR + "," + Const.USER_GENDER + "," + Const.USER_LOCATION + "," + Const.USER_EMAIL + ")" + "values(?,?,?,?,?,?,?)";
        PreparedStatement Prst = getDbConnection().prepareStatement(insert);
        Prst.setString(1, user.getFirstName());
        Prst.setString(2, user.getSurName());
        Prst.setString(3, user.getUserName());
        Prst.setString(4, user.getPassword());
        Prst.setString(5, user.getGender());
        Prst.setString(6, user.getLocation());
        Prst.setString(7, user.getEmail());
        try {
            Prst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet getUser(User user) throws ClassNotFoundException {
        ResultSet rst = null;
        String select = "select * from " + Const.USER_TABLE + " where " + Const.USER_USERNAME + " =? and " + Const.USER_PSWR + " =?";
        try {
            PreparedStatement lol = getDbConnection().prepareStatement(select);
            lol.setString(1, user.getUserName());
            lol.setString(2, user.getPassword());
            rst = lol.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rst;
    }
}


