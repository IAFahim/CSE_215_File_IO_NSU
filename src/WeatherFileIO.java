import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class WeatherFileIO {


    static public int lines(String str) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(str));
        int size = 0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            size++;
        }
        sc.close();
        return size;
    }

    static public WeatherData[] readFromFile(String str, int size) throws FileNotFoundException {
        int differentCities = 2;
        WeatherData weatherData[] = new WeatherData[size / differentCities];
        if (weatherData.length > 0) {
            weatherData[0].setNumberOfCities(2);
        } else {
            return null;
        }
        Scanner sc = new Scanner(new FileInputStream(str));
        int i = 0, day = 0;
        while (sc.hasNextLine()) {
            weatherData[i] = new WeatherData(differentCities);
            for (int j = 0; j < differentCities; j++) {
                String city = sc.next();
                double temperature = sc.nextDouble();
                double humidity = sc.nextDouble();
                double windSpeed = sc.nextDouble();
                if (sc.hasNextLine()) sc.nextLine();
                weatherData[i].feedData(j, city, temperature, humidity, windSpeed, day);
            }
            day++;
            i++;
        }
        return weatherData;
    }

    public static void main(String[] args) throws IOException {
        String readPath = "weather_data.txt", writePath = "weather_summary.txt";
        int size = lines(readPath);
        WeatherData weatherData[] = readFromFile(readPath, size);
        FileWriter fileWriter = new FileWriter(writePath);
        for (int i = 0; i < weatherData[i].getNumberOfCities(); i++) {
            weatherData[i].setCitySwitch(i);
            fileWriter.write("In " + weatherData[i].getCity() + " :\n");

            WeatherData maxHumidity = Arrays.stream(weatherData).max((o1, o2) -> Double.compare(o1.getHumidity(), o2.getHumidity())).get();
            fileWriter.write("Humidity had the highest value of value on " + maxHumidity.getDay() + ".\n");

            WeatherData maxTemperature = Arrays.stream(weatherData).max((o1, o2) -> Double.compare(o1.getTemperature(), o2.getTemperature())).get();
            fileWriter.write("Temperature had the highest value of value on " + maxTemperature.getDay() + ".\n");

            WeatherData minTemperature = Arrays.stream(weatherData).min((o1, o2) -> Double.compare(o1.getTemperature(), o2.getTemperature())).get();
            fileWriter.write("Temperature had the lowest value of value on " + minTemperature.getDay() + ".\n");

            WeatherData minWind_speed = Arrays.stream(weatherData).min((o1, o2) -> Double.compare(o1.getWind_speed(), o2.getWind_speed())).get();
            fileWriter.write("Wind_Speed had the lowest value of value on " + minWind_speed.getDay() + ((weatherData[i].getNumberOfCities() - 1 != i) ? ".\n" : ""));
        }
        fileWriter.close();
    }
}
