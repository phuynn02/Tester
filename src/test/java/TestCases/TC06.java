package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.ChangePassWordPage;
import DataObjects.HomePage;
import DataObjects.LoginPage;
import DataObjects.MyTicketPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC06 {
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
    WebElement driver;
    @Test
    public void TC06() {
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();

        boolean headerpost1 = Constant.WEBDRIVER.findElement(By.xpath("//h1[normalize-space()='Manage ticket']")).isDisplayed();
        if (headerpost1 == true) {
            System.out.println("This is My ticket Page");
        } else {
            System.out.println("This not is My ticket Page");
        }
        // Click "Chane password"
        ChangePassWordPage changePasswordPage = homePage.gotoChangePassword();

        boolean headerpost2 = Constant.WEBDRIVER.findElement(By.xpath("//h1[normalize-space()='Change password']")).isDisplayed();
        if (headerpost2 == true) {
            System.out.println("This is ChangePassword Page");
        } else {
            System.out.println("This not is ChangePassword Page");

        }
    }
}