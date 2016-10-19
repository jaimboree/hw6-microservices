package io.spring.cloud.samples.commerce.ui.services.prices;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@EnableConfigurationProperties(PriceProperties.class)
public class PriceService {

    @Autowired
    PriceProperties priceProperties;

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackPrice")
    public Map pricesAll() {
    	return restTemplate.getForObject("http://price/prices", Map.class);
    }

    @HystrixCommand(fallbackMethod = "fallbackPrice")
    public Map pricesById(String id) {
        return restTemplate.getForObject("http://price/price/" + id, Map.class);
    }

    private Map fallbackPrice() {
        return priceProperties.getDummyPriceFromProperty();
    }    

    private Map fallbackPrice(String id) {
        return priceProperties.getDummyPriceFromProperty();
    }    
}
