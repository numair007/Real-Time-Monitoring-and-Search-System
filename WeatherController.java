@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private KafkaWeatherProducer kafkaWeatherProducer;

    @GetMapping("/fetch")
    public ResponseEntity<String> fetchWeather(@RequestParam String city) {
        String weatherData = weatherService.getWeatherData(city);
        kafkaWeatherProducer.sendWeatherData(weatherData);
        return ResponseEntity.ok("Weather data fetched and sent to Kafka");
    }
}
