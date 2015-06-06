package com.hackday.internal.impl;

import com.hackday.bookmybook.constants.BookConstants;
import com.hackday.database.DbConnection;
import com.hackday.references.ConfigReferences;
import com.hackday.structures.BookDetails;
import com.mysql.jdbc.Connection;

import java.sql.SQLException;

/**
 * Created by rajesh.kalloor on 06/06/15.
 */
public class BookOperations {

    private static final String userName = BookConstants.userName;
    private static final String password = BookConstants.password;
    private static final String url = BookConstants.dbURL;
    static DbConnection dbConnection = new DbConnection(userName, password, url);

    public void addBookToDB(BookDetails book) throws SQLException {

        String title = book.getBook_title();
        String category = book.getCategory();
        String owner = book.getOwner();
        String status = "AVAILABLE";

        System.out.println("title is ::: " +title);
        System.out.println("category is ::: " +category);
        System.out.println("owner is ::: " +owner);
        System.out.println("status is ::: " +status);


        System.out.println("DB Conn ::: ");

        String insertQuery = "insert into books (title, category, owner, status) values (\"" +title+ "\", \"" +category+ "\", \"" +owner+ "\", \"" +status+ "\")";

        Connection conn = dbConnection.establishConnection();
        dbConnection.executeUpdate(conn, insertQuery);
//        while (result.next()) {
//            System.out.println(result.getString("id"));
//        }
        dbConnection.closeConnection(conn);
    }
}
