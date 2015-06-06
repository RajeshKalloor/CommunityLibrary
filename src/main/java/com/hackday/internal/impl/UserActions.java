package com.hackday.internal.impl;

import com.hackday.database.DatabaseHelper;
import com.hackday.database.DbConnection;
import com.hackday.structures.CreateUser;
import com.hackday.structures.LoginInDetail;
import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by siba.sethy on 6/6/15.
 */
public class UserActions {
    private String userTable="users";
    ResultSet rs=null;
    public boolean validateLogin(LoginInDetail loginInDetail) {
        String query = "select count(*) as count from " + userTable + " where user_id= '" + loginInDetail.getUser_id()+"' and password='"+loginInDetail.getPassword()+"';";
         boolean flag=false;
        DbConnection dbConnection = new DbConnection();
        Connection conn = dbConnection.establishConnection();
        Integer num=0;
        try {
            rs=dbConnection.executeQuery(conn, query);
            while (rs.next()) {
                 num = rs.getInt("count");

            }
        if (num>0)
            flag= true;
            dbConnection.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs=null;
        return flag;
    }

    public boolean addUser(CreateUser createUser) {
        String query = "select count(*) as count from " + userTable + " where user_id= '" + createUser.getUser_id()+"' ;";
        String updateQuery="insert into users (user_id, name,pincode, location, address, mobile_no, password) values ('" + createUser.getUser_id()+"','"+createUser.getName()+"','"+createUser.getPincode()+"','"+createUser.getLocation()+"','"+createUser.getAddress()+"','"+createUser.getMobile_no()+"','"+createUser.getPassword()+"');";
        boolean flag=false;
        DbConnection dbConnection = new DbConnection();
        Connection conn = dbConnection.establishConnection();
        Integer num=0;
        try {
            rs=dbConnection.executeQuery(conn, query);
            while (rs.next()) {
                num = rs.getInt("count");


            }
            if (num>0) {
                flag = false;
            }
            else
            {
                 System.out.println("update query-->"+updateQuery);
                 dbConnection.executeUpdate(conn,updateQuery);
                flag=true;
            }
            dbConnection.closeConnection(conn);

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return flag;
    }


}
