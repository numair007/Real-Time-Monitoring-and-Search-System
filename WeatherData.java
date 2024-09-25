@Document(collection = "weather")
public class WeatherData {
    @Id
    private String id;
    private String weatherJson;

    public WeatherData(String weatherJson) {
        this.weatherJson = weatherJson;
    }

    // getters and setters
}

@Repository
public interface MongoWeatherRepository extends MongoRepository<WeatherData, String> {}
