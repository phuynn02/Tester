package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.ChangePassWordPage;
import DataObjects.HomePage;
import DataObjects.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC09 {
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
    public void TC09(){
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

        ChangePassWordPage changePasswordPage = homePage.gotoChangePassword();
        String expectedWelcomeMessage = "Your password has been updated!";
        String actualMsg2 = changePasswordPage.changePassword(Constant.PASSWORD,Constant.PASSWORD,Constant.PASSWORD).getlblMessageChange().getText();
        Assert.assertEquals(actualMsg2, expectedWelcomeMessage, "There was a problem with your " +
                "login and/or errors exist in your form.");
    }
}
