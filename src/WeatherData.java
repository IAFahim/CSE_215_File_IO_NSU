public class WeatherData {
    private static int numberOfCities;
    private String[] city;
    private double[] temperature;
    private double[] humidity;
    private double[] wind_speed;
    private int[] day;
    private static int citySwitch = 0;
    static final private String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public void setCitySwitch(int citySwitch) {
        this.citySwitch = citySwitch;
    }

    public static void setNumberOfCities(int numberOfCities) {
        WeatherData.numberOfCities = numberOfCities;
    }

    public static int getNumberOfCities() {
        return numberOfCities;
    }

    public WeatherData(int numberOfCities) {
        this.city = new String[numberOfCities];
        this.temperature = new double[numberOfCities];
        this.humidity = new double[numberOfCities];
        this.wind_speed = new double[numberOfCities];
        this.day = new int[numberOfCities];
    }

    public void feedData(int cityNumber, String city, double temperature, double humidity, double wind_speed, int day) {
        this.city[cityNumber] = city;
        this.temperature[cityNumber] = temperature;
        this.humidity[cityNumber] = humidity;
        this.wind_speed[cityNumber] = wind_speed;
        this.day[cityNumber] = day;
    }

    public void feedData(String city, double temperature, double humidity, double wind_speed, int day) {
        this.city[citySwitch] = city;
        this.temperature[citySwitch] = temperature;
        this.humidity[citySwitch] = humidity;
        this.wind_speed[citySwitch] = wind_speed;
        this.day[citySwitch] = day;
    }

    public String getCity() {
        return city[citySwitch];
    }

    public double getTemperature() {
        return temperature[citySwitch];
    }

    public double getHumidity() {
        return humidity[citySwitch];
    }

    public double getWind_speed() {
        return wind_speed[citySwitch];
    }

    public String getDay() {
        return days[day[citySwitch] % days.length];
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city: " + city + '\'' +
                ", temperature: " + temperature +
                ", humidity: " + humidity +
                ", wind_speed: " + wind_speed +
                '}';
    }
}