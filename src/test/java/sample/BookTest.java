package sample;

import com.hackday.bookmybook.constants.BookConstants;
import com.hackday.database.DbConnection;
import com.hackday.references.ConfigReferences;
import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rajesh.kalloor on 06/06/15.
 */
public class BookTest {

    public static void main(String[] args) throws SQLException {
        String userName = BookConstants.userName;
        String password = BookConstants.password;
        String dbURL = BookConstants.dbURL;
        String title = "title3";
        String category = "category3";
        String owner = "owner3";
        String status = "BOOKED";


        String query = "insert into books (title, category, owner, status) values (\"" +title+ "\", \"" +category+ "\", \"" +owner+ "\", \"" +status+ "\")";

        System.out.println("QUERY IS ::: " +query);

        //String query = "select * from books";



        DbConnection dbConnection = new DbConnection(userName, password, dbURL);
        Connection connection = dbConnection.establishConnection();
        dbConnection.executeUpdate(connection, query);
//        while (result.next()) {
//            System.out.println(result.getString("id"));
//        }
        dbConnection.closeConnection(connection);
    }
}

