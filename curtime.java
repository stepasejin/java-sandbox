import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTimeExample {

    public static void main(String[] args) {
        // Get the current date and time
        Date currentDate = new Date();

        // Format the date into a string
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);

        // Display the current time
        System.out.println("Текущее время: " + formattedDate);
    }
}
