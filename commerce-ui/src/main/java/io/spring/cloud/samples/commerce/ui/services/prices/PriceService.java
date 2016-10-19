package io.spring.cloud.samples.commerce.ui.services.prices;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "fallbackDummy")
    public String pricesAll() {
    	return restTemplate.getForObject("http://price/prices", String.class);
    }

    @HystrixCommand(fallbackMethod = "fallbackPrice")
    public Price pricesById(String id) {
        return restTemplate.getForObject("http://price/price/" + id, Price.class);
    }

    private Price fallbackPrice() {
        return priceProperties.getDummyPriceFromProperty();
    }
    
    private String fallbackDummy() {
        return "This is failing";
    }
}
