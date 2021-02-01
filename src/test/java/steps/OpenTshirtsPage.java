package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenTshirtsPage {

    WebDriver driver;

    @Given("^the user is on home page$")
    public void theUserIsOnHomePage() {
        System.setProperty("webdriver.chrome.driver","chromedriver-5");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @When("^I choose T-Shirts menu$")
    public void iChooseTShirtsMenu() {
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
    }

    @Then("^I should land on T-Shirts page$")
    public void iShouldLandOnTShirtsPage() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals("T-shirts - My Store", actualTitle);
        driver.quit();
    }
}
