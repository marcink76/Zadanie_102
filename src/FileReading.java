import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {

    public int countLine()throws IOException{
        int lines = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(WeatherApp.FILE_NAME));
        while (bufferedReader.readLine() != null) lines++;
        bufferedReader.close();
        return lines;
    }

    public String fileReading(int line) throws IOException {
        int count = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(WeatherApp.FILE_NAME));
        String city = "";
        String row = null;

         while ((row = bufferedReader.readLine()) != null) {
            if (count == line) {
                city = row;
                break;
            }
            count++;
        }
        bufferedReader.close();
        return city;
    }
}
