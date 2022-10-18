import java.sql.*;

public class Main
{
    public static void main(String[] args)
    {
        /**
         * One way of closing a database connection
         */
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
                //connection.setAutoCommit(false);

            /**
             * Lines 31 to 32 are how to insert data into a database
             */
                /*
            statement.execute("INSERT INTO contacts (name, phone, email)" + "VALUES('Jane', 4829484, 'jane@somewhere.com') ");
            statement.execute("INSERT INTO contacts (name, phone, email)" + "VALUES('Fido', 9038, 'dog@email.com') ");*/

            /**
             * Line 37 is how to update data in a database
             */
           /* statement.execute("UPDATE contacts SET phone = 5566789 WHERE name = 'Jane' ");*/

            /**
             * Line 42 is how to delete data from a database
             */
            /*statement.execute("DELETE FROM contacts WHERE name = 'Joe' ");*/

            statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();

            while(results.next())
            {
                System.out.println(results.getString("name" ) + " " + results.getInt("phone") + " " + results.getString("email"));
            }
            results.close();

                statement.close();
                connection.close();

        } catch (SQLException e)
        {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        }
}
