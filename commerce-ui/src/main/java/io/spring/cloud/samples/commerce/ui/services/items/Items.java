package io.spring.cloud.samples.commerce.ui.services.items;
import java.util.ArrayList;
import java.util.List;

import io.spring.cloud.samples.commerce.ui.services.items.Item;

public class Items {
	private List<Item> items;
	
    public Items() {
    	items = new ArrayList<Item>();
    }

    public Items(Long id, String name, String description, String category) {
    	items = new ArrayList<Item>();
    	this.items.add(new Item(id, name, description, category));
    }

    public Items(Item item) {
    	items = new ArrayList<Item>();
    	this.items.add(item);
    }

    public List<Item> geItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
