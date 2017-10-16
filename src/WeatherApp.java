import java.io.IOException;
import java.util.ArrayList;

public class WeatherApp {

    public final static String FILE_NAME = "cities.txt";
    public final static String RESULT_FILE_NAME = "result.txt";

    public static void main(String[] args) throws IOException {

        ArrayList<WeatherInfo> weatherInfoArrayList = new ArrayList<>();
        FileReading fileReading = new FileReading();

        int count = 0;
        String city = "wrocław";

        try {
            WeatherApi api = new WeatherApi();
            city = fileReading.fileReading(count);
            weatherInfoArrayList.add(count, new WeatherInfo(city, api.getDescription(city), api.getTemperature
                    (city)));
            FileWriting.fileWriting(weatherInfoArrayList.get(count));
            int temperature = api.getTemperature(city);
            String description = api.getDescription(city);
            System.out.printf("Pogoda w mieście %s: %s\n", city, description);
            System.out.printf("Aktualna temperatura: %d stopni\n", temperature);
        } catch (IOException e) {
            System.err.println("Nie udało się pobrać informacji dla miasta " + city);
        }
    }
}