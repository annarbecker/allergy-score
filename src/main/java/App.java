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

    //loop - if score is greater than or equal to the key
      //add key value to string
      //subract key from score
    //return the string
    for (Integer i = 128; i > 0; i /= 2) {
      if (score >= allergens(i)) {
        userAllergens += allergens.get(i);
        score -= allergens(i);
      }
    }
    return userAllergens;
    //
    // if (score ) {
    //
    // }
    //
    //
    // if (score == 8) {
    //   return "strawberries";
    // }
    // else if (score == 4) {
    //   return "shellfish";
    // }
    // else if (score == 2) {
    //   return "peanuts";
    // } else {
    //   return "eggs";
    // }
  }
}
