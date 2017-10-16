import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {

    public String fileReading(int line) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(WeatherApp.FILE_NAME));
        String city = "";
        String row = null;
        while ((row = bufferedReader.readLine()) != null) {
            System.out.println(row);
            city = row;
        }
        bufferedReader.close();
        return city;
    }

}
