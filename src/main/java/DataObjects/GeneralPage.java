package DataObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//*[@id=\"content\"]/h1");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabMyTicket = By.xpath("//*[@id=\"menu\"]/ul/li[7]/a/span");
    private final By tabChangePassword = By.xpath("//*[@id=\"menu\"]/ul/li[8]/a/span");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabTimetable = By.xpath("//*[@id=\"menu\"]/ul/li[4]/a/span");

    //Elements
    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getlblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement tabBookTicket(){
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }
    protected WebElement tabMyTicket() { return Constant.WEBDRIVER.findElement(tabMyTicket);}
    protected WebElement tabChangePassword() {return Constant.WEBDRIVER.findElement(tabChangePassword);}
    protected WebElement tabRegister(){ return Constant.WEBDRIVER.findElement(tabRegister);}
    protected WebElement gettabTimetable(){return Constant.WEBDRIVER.findElement(tabTimetable);}
    //Methods
    public String getWelcomeMessage(){
        return this.getlblWelcomeMessage().getText();
    }
    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }
    public BookTicketPage gotoBookTicketPage(){
        this.tabBookTicket().click();
        return new BookTicketPage();
    }
    public MyTicketPage gotoMyTicketPage(){
        this.tabMyTicket().click();
        return new MyTicketPage();
    }
    public RegisterPage gotoRegisterPage(){
        this.tabRegister().click();
        return new RegisterPage();
    }
    public ChangePassWordPage gotoChangePassword(){
        this.tabChangePassword().click();
        return new ChangePassWordPage();
    }
    public TimeTablePage gotoTimtablePage(){
        this.gettabTimetable().click();
        return new TimeTablePage();
    }


}
