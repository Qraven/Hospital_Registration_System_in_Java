import java.sql.*;

public class DBConnect {

    protected Connection con;
    public Statement stm;
    public ResultSet rs;
    public ResultSet rs2;

    public DBConnect()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/szpital?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            stm = con.createStatement();


        }catch(Exception ex)
        {
            System.out.println("Error: " + ex);
        }
    }

}
