import java.io.IOException;
import java.util.ArrayList;

public class WeatherApp {

    public final static String FILE_NAME = "cities.txt";
    public final static String RESULT_FILE_NAME = "result.txt";

    public static void main(String[] args) throws IOException {

        ArrayList<WeatherInfo> weatherInfoArrayList = new ArrayList<>();
        FileReading fileReading = new FileReading();

        int count = 0;
        String city = "";

        try {
            WeatherApi api = new WeatherApi();
            do {
                city = fileReading.fileReading(count);
                System.out.println(city);
                weatherInfoArrayList.add(count, new WeatherInfo(city, api.getDescription(city), api.getTemperature(city)));
                FileWriting.fileWriting(weatherInfoArrayList.get(count));
                System.out.println(weatherInfoArrayList.get(count).toString());
                count++;
            } while (count < fileReading.countLine());
        } catch (IOException e) {
            System.err.println("Nie udało się pobrać informacji dla miasta " + city);
        }
    }
}