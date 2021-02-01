package pages;

import BaseClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Create account
    By createAccountEmail = By.id("email_create");
    By submitCreateAccountButton = By.id("SubmitCreate");

    //Sign in
    By signInEmail = By.id("email");
    By signInPassword = By.id("passwd");
    By signInButton = By.id("SubmitLogin");

}
