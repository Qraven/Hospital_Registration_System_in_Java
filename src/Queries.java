import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Queries {

    private String query;

    DBConnect db = new DBConnect();
    Scanner sc = new Scanner(System.in);

    public void newPatient() throws SQLException {
        System.out.println("Którego lekarza wybierasz?");
        query = "SELECT imie FROM lekarze";
        db.rs = db.stm.executeQuery(query); //Executing the previously set SQL query

        int i = 1;
        while(db.rs.next())
        {
            String name = db.rs.getString("imie");
            System.out.println(i + ". " + name);
            i++;
        }

    }

    public void whichDoctor() throws SQLException {
        String lekarz;
        System.out.println("Jaki jest twój wybór (podaj cyfrę poprzedzającą imie lekarza):");
        lekarz = sc.next();

        PreparedStatement preparedStatement = null;
        query = "UPDATE lekarze SET ZajetychMiejsc = ZajetychMiejsc + 1 WHERE ID=?";

        preparedStatement = db.con.prepareStatement(query);
        preparedStatement.setString(1, lekarz);
        int result;
        result = preparedStatement.executeUpdate();

        System.out.println("Zarejestrowano!");
    }

    public void allDoctors() throws SQLException {
        query = "SELECT * FROM lekarze";
        db.rs = db.stm.executeQuery(query);


        while (db.rs.next())
        {
            System.out.println(db.rs.getString("Imie") + " Zajetych miejsc:" + db.rs.getString("ZajetychMiejsc"));
        }
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
