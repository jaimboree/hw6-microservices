package io.spring.cloud.samples.commerce.ui.services.items;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jlstein
 * @since 10/18/16.
 */
@ConfigurationProperties(prefix = "item")
@RefreshScope
public class ItemProperties {

  List<String> items = new ArrayList<>();

  public List<String> getItems() {
    return items;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }

  public void addItem(String item) {
    this.items.add(item);
  }

  public Item[] getCategoryItemFromProperty(String category) {
      return getDummyItemFromProperty();
  }
  
  public Item[] getItemIdFromProperty(String id) {
      return getDummyItemFromProperty();
  }

  public Item[] getDummyItemFromProperty() {
	  Item[] item = {new Item(9999L, "N/A", "N/A", "N/A")};
      return item;
  }
}
