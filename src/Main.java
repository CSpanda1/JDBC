import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main
{
    public static void main(String[] args)
    {
        /*try(Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\testjava.db");
            Statement statement = connection.createStatement() ) {

            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");

        }
         */
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\testjava.db");
                Statement statement = connection.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");

                statement.execute("INSERT INTO contacts (name, phone, email)" + "VALUES('Tim', 6545678, 'tim@email.com') ");

                statement.close();
                connection.close();

        } catch (SQLException e)
        {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        }
}
