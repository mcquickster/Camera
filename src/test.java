import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class test {
    public static void main(String[] args) {
        String string = "02/25/2022";
        String string2 = "02/26/2022";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(string, formatter);
        LocalDate date2 = LocalDate.parse(string2, formatter);
      //  System.out.println(date); // 2010-01-02
        if (date.isBefore(date2)){
            System.out.println(true);
        }

    }
}
