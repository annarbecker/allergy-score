import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
  String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/allergyResults", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/allergyResults.vtl");

      String userStringScore = request.queryParams("allergyScore");
      Integer score = Integer.parseInt(userStringScore);

      model.put("allergens", allergyScore(score));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static ArrayList<String> allergyScore(Integer score) {
    ArrayList<String> userAllergens = new ArrayList<String>();
    HashMap<Integer, String> allergens = new HashMap<Integer, String>();
      allergens.put(1, "eggs");
      allergens.put(2, "peanuts");
      allergens.put(4, "shellfish");
      allergens.put(8, "strawberries");
      allergens.put(16, "tomatoes");
      allergens.put(32, "chocolate");
      allergens.put(64, "pollen");
      allergens.put(128, "cats");

    Integer counter = 128;
    while (score > 0) {
      if(score >= counter) {
        userAllergens.add(allergens.get(counter));
        score -= counter;
      }
      counter /= 2;
    }
    return userAllergens;
  }
}
