import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class FileWriting {
    public static void fileWriting(List<WeatherInfo> weatherInfo) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(WeatherApp.RESULT_FILE_NAME, true));

        for (WeatherInfo weatherInf : weatherInfo) {
            bufferedWriter.write(weatherInf.getCity() + ";" + weatherInf.getDescription() + ";" + weatherInf
                    .getTemperature());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}