package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemToCart {

    WebDriver driver;
    String itemValueBeforeCart;

    @Given("^the user is on Item page$")
    public void theUserIsOnItemPage() {
        System.setProperty("webdriver.chrome.driver","chromedriver-5");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?id_product=1&controller=product");
        //driver.manage().window().maximize();
    }

    @When("^I add item to cart$")
    public void iAddItemToCart() {
        itemValueBeforeCart = driver.findElement(By.xpath("//*[@id=\"our_price_display\"]")).getAttribute("textContent");
        driver.findElement(By.id("add_to_cart")).click();
    }

    @Then("^Window with message that product has been added successfully should appear$")
    public void windowWithMessageThatProductHasBeenAddedSuccessfullyShouldAppear() {
        String expectedMessage = "\n" +
                "\t\t\t\t\tProduct successfully added to your shopping cart\n" +
                "\t\t\t\t";
        String currentMessage = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")).getAttribute("textContent");
        Assert.assertEquals(expectedMessage, currentMessage);
    }

    @And("^Item price should match$")
    public void itemPriceShouldMatch() {
        String itemValue = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.ajax_block_products_total"))).getAttribute("innerHTML");
        Assert.assertEquals(itemValueBeforeCart, itemValue);
        driver.quit();
    }



}
