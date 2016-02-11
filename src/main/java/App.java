import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {}

  public static String allergyScore(Integer score) {
    if (score == 8) {
      return "strawberries";
    }
    else if (score == 4) {
      return "shellfish";
    }
    else if (score == 2) {
      return "peanuts";
    } else {
      return "eggs";
    }
  }
}
