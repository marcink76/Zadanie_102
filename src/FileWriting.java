import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class FileWriting {
    public static void fileWriting(WeatherInfo weatherInfo) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(WeatherApp.RESULT_FILE_NAME, true));
        bufferedWriter.write(weatherInfo.getCity() + ";" + weatherInfo.getDescription() + ";" + weatherInfo.getTemperature());
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}