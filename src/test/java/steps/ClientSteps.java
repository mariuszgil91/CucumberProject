package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClientSteps {

    WebDriver driver;

    @Given("^the user is on landing page$")
    public void setup() throws Throwable {
        System.setProperty("webdriver.chrome.driver","chromedriver-5");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().window().maximize();
    }

    @When("^she provides the email as ([^\"]*)$")
    public void she_provides_the_email_as(String email) throws Throwable {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("^she provides the password as ([^\"]*)$")
    public void she_provides_the_password_as(String password) throws Throwable {
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    @And("^she signs-up$")
    public void she_signs_up() throws Throwable {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Then("^she should be logged in to the application$")
    public void she_should_be_logged_in_to_the_application() throws Throwable {
        String actualTitle = driver.getTitle();
        Assert.assertEquals("My account - My Store", actualTitle);
    }
}
