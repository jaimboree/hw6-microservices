package io.spring.cloud.samples.commerce.ui.services.prices;

import java.util.HashMap;

public class Price{
	HashMap<String, String> prices;
	
    public Price() {
    	prices = new HashMap<String, String>();
    }

    public Price(String id, String price) {
    	prices = new HashMap<String, String>();
    	prices.put(id, price);
    }

    public HashMap<String, String> getPrices() {
        return prices;
    }

    public void setPrice(HashMap<String, String> prices) {
        this.prices = prices;
    }
}
