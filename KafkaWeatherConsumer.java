@Service
public class KafkaWeatherConsumer {
    
    @Autowired
    private MongoWeatherRepository mongoWeatherRepository;
    
    @Autowired
    private ElasticsearchWeatherService elasticsearchWeatherService;

    @KafkaListener(topics = "weather-topic", groupId = "weather-group")
    public void consumeWeatherData(String weatherData) {
        // Save to MongoDB
        WeatherData weather = new WeatherData(weatherData);
        mongoWeatherRepository.save(weather);

        // Index in Elasticsearch (optional)
        elasticsearchWeatherService.indexWeatherData(weather);
    }
}
