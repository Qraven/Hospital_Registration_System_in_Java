import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        DBConnect db = new DBConnect();
        Functions functions = new Functions();

        functions.greeting();

    }

}
