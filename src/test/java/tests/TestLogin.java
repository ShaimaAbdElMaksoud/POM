package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginScreen;


public class TestLogin {

    //variables
    WebDriver driver;
    LoginScreen loginScreen;

    // method
    @Test
    @Description("Validate that user can login Successfully with valid user name and password")
    @Tag("Happy SC")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login")
    public void loginSuccessfully(){
        loginScreen.login("standard_user", "secret_sauce");
    }


    @Description("Validate that user errpr message will be displayed in cases user locked")
    @Test
    @Tag("Negative SC")
    @Severity(SeverityLevel.MINOR)
    @Story("Login")
    public void loginWithLockedAccount(){

        loginScreen.login("locked_out_user", "secret_sauce");
        Assert.assertTrue(loginScreen.errorMessageIsDisplayed(), "the error not displayed");
    }
    // config

    @BeforeMethod
    public void setup(){
        driver= new ChromeDriver();
        loginScreen= new LoginScreen(driver);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
