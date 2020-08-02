package bindings.dataBaseDriver;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import io.cucumber.java.en.Given;
import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.sql.*;

public class SeleniumDataBaseTesting {
    Fairy fairy = Fairy.create();
    Person person = fairy.person();
    private Connection connection;
    private static Statement statement;
    private static ResultSet rs;
    private String user_login = person.getFirstName() ;
    private String user_pass  = "$P$BSNqytY1YyygAN8xxrQH..Kh5GJloo."; // Grudzien2021!
    private String user_nicename = person.getFirstName();
    private String user_email = person.getEmail();



@BeforeClass
    public void setUp() {
        String databaseURL = "jdbc:mysql://localhost:3306/fakestore";
        String user = "root";
        String password = "Pioneer123!";
        connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to Database...");
            connection = DriverManager.getConnection(databaseURL, user, password);
            if (connection != null) {
                System.out.println("Connected to the Database...");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Test

    public void getCustomersData() {
        try {
            String query = "select * from wpnt_users";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                String EmpId= rs.getString("user_login");
                String EmpName= rs.getString("user_email");

                System.out.println(EmpId+"\t"+EmpName+"\t");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void countAllcustomers() {
        try {
            String query = "select * from SALES";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                int EmpId= rs.getInt("customer_id");
                int EmpName= rs.getInt("activity_id");

                System.out.println(EmpId+"\t"+EmpName+"\t");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public String createNewCustomerinFakestore   () throws SQLException {

        String databaseURL = "jdbc:mysql://localhost:3306/fakestore";
        String user = "root";
        String password = "Pioneer123!";
        connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to Database...");
            connection = DriverManager.getConnection(databaseURL, user, password);
            if (connection != null) {
                System.out.println("Connected to the Database...");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        String sql = "INSERT INTO wpnt_users (user_login, user_pass, user_nicename, user_email,display_name) " +
                "VALUES"+"("+"'"+user_login+"'"+","+"'"+user_pass+"'"+","+"'"+user_nicename+"'"+","+"'"+user_email+"'"+","+"'"+user_nicename+"'"+")";
        statement = connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println(sql);
        return databaseURL;
    }
 @Given("I clean users table")
    public String tucane   () throws SQLException {

        String databaseURL = "jdbc:mysql://localhost:3306/fakestore";
        String user = "root";
        String password = "Pioneer123!";
        connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to Database...");
            connection = DriverManager.getConnection(databaseURL, user, password);
            if (connection != null) {
                System.out.println("Connected to the Database...");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        String sql = " TRUNCATE TABLE wpnt_users";
        statement = connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println(sql);
        return databaseURL;

    }


    @AfterClass
    public void tearDown() {
        if (connection != null) {
            try {
                System.out.println("Closing Database Connection...");
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}