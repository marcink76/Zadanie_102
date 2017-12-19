import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherApp {

    public final static String FILE_NAME = "cities.txt";
    public final static String RESULT_FILE_NAME = "result.txt";

    public static void main(String[] args) throws IOException {

        List<WeatherInfo> weatherInfoList = new ArrayList<>();
        FileReading fileReading = new FileReading();
        WeatherApi weatherApi = new WeatherApi();
        List<String> cityList = fileReading.fileReading();


        for (String cities : cityList) {
            System.out.println(cities);
            weatherInfoList.add(new WeatherInfo(cities, weatherApi.getDescription(cities), weatherApi.getTemperature
                    (cities)));
        }

        for (WeatherInfo weatherInfos : weatherInfoList) {
            try {
                FileWriting.fileWriting(weatherInfos);
            } catch (IOException e) {
                System.err.println("Nie udało się zapisać pliku.");
            }
        }
    }
}