package io.spring.cloud.samples.commerce.ui.services.items;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@EnableConfigurationProperties(ItemProperties.class)
public class ItemService {

    @Autowired
    ItemProperties itemProperties;

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackItems")
    public Item[] itemsAll() {
        return restTemplate.getForObject("http://item/items", Item[].class);
    }

    @HystrixCommand(fallbackMethod = "fallbackItem")
    public Item[] itemsByCategory(String category) {
        return restTemplate.getForObject("http://item/category/" + category, Item[].class);
    }
    
    private Item[] fallbackItem(String category) {
        return itemProperties.getCategoryItemFromProperty(category);
    }

    private Item[] fallbackItems() {
        return itemProperties.getDummyItemFromProperty();
    }
}
