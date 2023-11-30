package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.HomePage;
import DataObjects.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC07 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() +
                "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC7() {
        // Step 1: Open the home page
        HomePage homePage = new HomePage();
        homePage.open();

        // Step 2: Navigate to the register page
        RegisterPage registerPage = homePage.gotoRegisterPage();

        // Step 3: Attempt
        String validEmail = "g@gmail.com";
        String validPassword = "123456789";
        String validConfirmPassword = "123456789";
        String validPIP = "12345678910";
        String expectedWelcomeMessage = "Thank you for registering your account";
        String actualWelcomeMessage = registerPage.register(validEmail, validPassword,validConfirmPassword,validPIP).getlblRegisMsg().getText();

        Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "Welcome message is not displayed");


    }
    @Test
    public void TC10() {
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        String validEmail = "dtn7@gmail.com";
        String validPassword = "123456789";
        String validConfirmPassword = "123456";
        String validPIP = "123456789";

    }
    @Test
    public void TC11() {
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        String validEmail = "dtn7@gmail.com";
        String validPassword = "";
        String validConfirmPassword = "";
        String validPIP = "";
    }

}
