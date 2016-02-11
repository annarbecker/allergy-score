import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Allergy Score Reader");
      fill("#userAllergyScore").with("5");
      submit(".btn");
      assertThat(pageSource()).contains("allergic");
  }

  @Test
  public void allergyScore_returnsEggsForOne_eggs() {
    App testApp = new App();
    ArrayList<String> allergyList = new ArrayList<String>();
    allergyList.add("eggs");
    assertEquals(allergyList, testApp.allergyScore(1));
  }

  @Test
  public void allergyScore_returnsPeanutsForTwo_peanuts() {
    App testApp = new App();
    ArrayList<String> allergyList = new ArrayList<String>();
    allergyList.add("peanuts");
    assertEquals(allergyList, testApp.allergyScore(2));
  }

  @Test
  public void allergyScore_returnsShellfishForFour_shellfish() {
    App testApp = new App();
    ArrayList<String> allergyList = new ArrayList<String>();
    allergyList.add("shellfish");
    assertEquals(allergyList, testApp.allergyScore(4));
  }

  @Test
  public void allergyScore_returnsStrawberriesForEight_strawberries() {
    App testApp = new App();
    ArrayList<String> allergyList = new ArrayList<String>();
    allergyList.add("strawberries");
    assertEquals(allergyList, testApp.allergyScore(8));
  }

  @Test
  public void allergyScore_returnsPeanutsAndEggsForThree_peanutsAndEggs() {
    App testApp = new App();
    ArrayList<String> allergyList = new ArrayList<String>();
    allergyList.add("peanuts");
    allergyList.add("eggs");
    assertEquals(allergyList, testApp.allergyScore(3));
  }

  @Test
  public void allergyScore_returnsCatsPollenStrawberries_catsPollenStrawberries() {
    App testApp = new App();
    ArrayList<String> allergyList = new ArrayList<String>();
    allergyList.add("cats");
    allergyList.add("pollen");
    allergyList.add("strawberries");
    assertEquals(allergyList, testApp.allergyScore(200));
  }

}
