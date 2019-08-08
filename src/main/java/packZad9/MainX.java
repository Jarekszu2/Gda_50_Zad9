package packZad9;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainX {
    public static void main(String[] args) {
        System.out.println();

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String stringDateTimeFormatted = localDateTime.format(dateTimeFormatter);
        System.out.println(stringDateTimeFormatted);
        LocalDateTime localDateTime1 = LocalDateTime.parse(stringDateTimeFormatted, dateTimeFormatter);
        System.out.println(localDateTime1);
    }
}
