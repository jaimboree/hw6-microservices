package io.spring.cloud.samples.commerce.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.cloud.samples.commerce.ui.services.items.Item;
import io.spring.cloud.samples.commerce.ui.services.prices.Price;
import io.spring.cloud.samples.commerce.ui.services.items.ItemService;
import io.spring.cloud.samples.commerce.ui.services.prices.PriceService;

@RestController
public class UiController {

    @Autowired
    ItemService itemService = new ItemService();
    PriceService priceService = new PriceService();

    @RequestMapping("/items")
    public String itemsAll() {
        //Item[] items = itemService.itemsAll();
    	//make call to price service
        String price = priceService.pricesAll();

        /*
        for(Item i : items)
        {
        	if (price.getPrices().containsKey(i.getId()))
        		i.setPrice(price.getPrices().get(i.getId()));
        }
    	*/
    	//join data
    	
    	return price;
    }
    
    @RequestMapping("/items/category")
    public Item[] itemsByCategory() {
        //make call to item servic
    	return itemService.itemsByCategory("shoes");
    }

}
