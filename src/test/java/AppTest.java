import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
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
      assertThat(pageSource()).contains("");
  }

  @Test
  public void allergyScore_returnsEggsForOne_eggs() {
    App testApp = new App();
    assertEquals("eggs", testApp.allergyScore(1));
  }

  @Test
  public void allergyScore_returnsPeanutsForTwo_peanuts() {
    App testApp = new App();
    assertEquals("peanuts", testApp.allergyScore(2));
  }

  @Test
  public void allergyScore_returnsShellfishForFour_shellfish() {
    App testApp = new App();
    assertEquals("shellfish", testApp.allergyScore(4));
  }

  @Test
  public void allergyScore_returnsStrawberriesForEight_strawberries() {
    App testApp = new App();
    assertEquals("strawberries", testApp.allergyScore(8));
  }

  @Test
  public void allergyScore_returnsPeanutsAndEggsForThree_peanutsAndEggs() {
    App testApp = new App();
    assertEquals("peanuts eggs", testApp.allergyScore(3));
  }

  @Test
  public void allergyScore_returnsCatsPollenStrawberries_catsPollenStrawberries() {
    App testApp = new App();
    assertEquals("cats pollen strawberries", testApp.allergyScore(200));
  }

}
