package com.weather.service;

import com.weather.entity.Weather;
import com.weather.entity.WeatherResponse;
import com.weather.repo.WeatherRepository;
import org.apache.juli.logging.LogFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${openweathermap.api.key}")
    private  String apikey;
    @Autowired
    private WeatherRepository weatherRepository;
    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    public Weather getWeatherResponsebyCity(String city){
        logger.info("Getting weather details for city: "+city);
        logger.info("API Key: "+apikey);
        String url=String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric",city,apikey);
        logger.info("Constructed URL: "+url);
        WeatherResponse weatherResponse=restTemplate.getForObject(url,WeatherResponse.class);
        if(weatherResponse!=null){
            Weather weather=new Weather();
            weather.setCity(city);
            weather.setDescription(weatherResponse.getWeather().get(0).getDescription());
            weather.setTemparature(weatherResponse.getMain().getTemp());
           return weatherRepository.save(weather);
        }
        return null;
    }
}
