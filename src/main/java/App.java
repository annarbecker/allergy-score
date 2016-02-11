import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {}

  public static String allergyScore(Integer score) {
    String userAllergens = "";
    HashMap<Integer, String> allergens = new HashMap<Integer, String>();
      allergens.put(1, " eggs");
      allergens.put(2, " peanuts");
      allergens.put(4, " shellfish");
      allergens.put(8, " strawberries");
      allergens.put(16, " tomatoes");
      allergens.put(32, " chocolate");
      allergens.put(64, " pollen");
      allergens.put(128, "cats");

    Integer counter = 128;
    while (score > 0) {
      if(score >= counter) {
        userAllergens += allergens.get(counter);
        score -= counter;
      }
      counter /= 2;
    }
    return userAllergens.trim();
  }
}
