package io.spring.cloud.samples.commerce.ui.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.cloud.samples.commerce.ui.services.items.Item;
import io.spring.cloud.samples.commerce.ui.services.items.ItemService;
import io.spring.cloud.samples.commerce.ui.services.prices.PriceService;

@RestController
public class UiController {

    @Autowired
    ItemService itemService;
    @Autowired
    PriceService priceService;

    @RequestMapping("/items")
    public Item[] itemsAll() {
        Item[] items = itemService.itemsAll();
    	//make call to price service
        Map price = priceService.pricesAll();

    	//join data
        for(int i=0; i<items.length; i++)
        {
        	if (price.containsKey(items[i].getId().toString()))
        		items[i].setPrice(price.get(items[i].getId().toString()).toString());
        }
    	return items;
    }
    
    @RequestMapping("/category/{category}")
    public Item[] itemsByCategory( @PathVariable("category") String category) {
    	Item[] items = itemService.itemsByCategory(category);
        Map price = priceService.pricesAll();

    	//join data
        for(int i=0; i<items.length; i++)
        {
        	if (price.containsKey(items[i].getId().toString()))
        		items[i].setPrice(price.get(items[i].getId().toString()).toString());
        }
    	return items;
    }

    @RequestMapping("/item/{itemId}")
    public Item itemsById(@PathVariable("itemId") String itemId) {
    	Item[] items = itemService.itemsById(itemId);
        Map price = priceService.pricesById(itemId);
        

        Item item = new Item();
        for (Item i : items){
            if (price.containsKey("price"))
            	i.setPrice(price.get("price").toString());
        	item = i;
        }
        
    	return item;
    }
}
