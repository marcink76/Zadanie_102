import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReading {

    public List<String> fileReading() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(WeatherApp.FILE_NAME));
        List<String> cityList = new ArrayList<>();
        String row;

        while ((row = bufferedReader.readLine()) != null) {
            cityList.add(row);
        }

        bufferedReader.close();
        return cityList;
    }
}