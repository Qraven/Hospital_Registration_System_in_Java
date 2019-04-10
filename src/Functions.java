import java.sql.SQLException;
import java.util.Scanner;

public class Functions {

    Scanner sc = new Scanner(System.in);

    public Queries qr = new Queries();

    public void greeting() throws SQLException {

            int opcja;
            System.out.println("Witaj w szpitalu w Westwood!");
        while (true)
        {
            System.out.println("Co chcesz zrobić?");
            System.out.println("1 dla rejestracji pacjenta");
            System.out.println("2 dla wyswietlenia lekarzy oraz miejsc");
            System.out.println("3 dla wyjscia");
            System.out.println("Jaką opcję wybierasz?");
            opcja = sc.nextInt();

            if (opcja == 1) {
                qr.newPatient();
                qr.whichDoctor();
            } else if (opcja == 2) {
                qr.allDoctors();
            } else if (opcja == 3) {
                break;
            } else {
                System.out.println("Wybrałeś złą cyfrę!");
            }
        }
    }


}
