@Service
public class ElasticsearchWeatherService {
    
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    public void indexWeatherData(WeatherData weatherData) {
        IndexQuery query = new IndexQueryBuilder()
                .withId(weatherData.getId())
                .withObject(weatherData)
                .build();
        elasticsearchRestTemplate.index(query);
    }
}
