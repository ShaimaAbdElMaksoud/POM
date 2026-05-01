package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen {

    // variable
    WebDriver driver;

    private final By userName=By.id("user-name");
    private final By password=By.id("password");
    private final By loginButton=By.id("login-button");
    private final By errorMessage=By.xpath("//div[@class='error-message-container error']");

    // constractor

    public LoginScreen(WebDriver driver){
      this.driver=driver;
    }


    // actions (methods)
    public void login(String user, String pass){
        driver.findElement(userName).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

    public boolean errorMessageIsDisplayed(){
      return  driver.findElement(errorMessage).isDisplayed();  // true

    }
}
