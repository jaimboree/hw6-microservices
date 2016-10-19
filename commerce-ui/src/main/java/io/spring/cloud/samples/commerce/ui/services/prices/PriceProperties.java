package io.spring.cloud.samples.commerce.ui.services.prices;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

/**
 * @author jlstein
 * @since 10/18/16.
 */
@ConfigurationProperties(prefix = "price")
@RefreshScope
public class PriceProperties {

  List<String> prices = new ArrayList<>();

  public List<String> getPrices() {
    return prices;
  }

  public void setPrices(List<String> prices) {
    this.prices = prices;
  }

  public void addPrice(String price) {
    this.prices.add(price);
  }

  public Price getDummyPriceFromProperty() {
      return new Price("9999", "N/A");
  }
}
