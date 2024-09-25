@Service
public class KafkaWeatherProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendWeatherData(String weatherData) {
        kafkaTemplate.send("weather-topic", weatherData);
    }
}
