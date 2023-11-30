package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.HomePage;
import DataObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC08 {
    WebDriver driver;
    String PathScreenshot = System.getProperty("user.dir") + "/Screenshot/";
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() +
                "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }
    @Test
    public void TC08()  {
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("TC_08 - User can't login with an account hasn't been activated");
        LoginPage loginPage = homePage.gotoLoginPage();
        String username = "ngantam168@gmail.com";
        String password= "123456789aa";
        String expectedWelcomeMessage = "Invalid username or password. Please try again.";

        String actualWelcomeMessage = loginPage.login(username, password).getlblErrorLoginMsg().getText();

        Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "There was a problem with your " +
                "login and/or errors exist in your form.");

//
    }

}
