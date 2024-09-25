@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private final String apiKey = "your_openweathermap_api_key";
    
    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getWeatherData(String city) {
        String url = String.format(
                "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", 
                city, apiKey
        );
        return this.restTemplate.getForObject(url, String.class);
    }
}
