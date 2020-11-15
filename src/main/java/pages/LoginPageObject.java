package pages;

import helpers.Level;
import old.A;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInYellow;

public class LoginPageObject extends BasePage {

    private final static String TITLE = "Authorization page";
    public LoginPageObject(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By loginField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By signInButton = By.name("commit");
    private final By errorMessage = By.xpath("//div[@id='login']/p");
    private final By message = By.xpath("//div[contains(@class,'container-lg px-')]");

    private final By listOfRepositories = By.xpath("//a[@data-hovercard-type='repository']");
    private final By pomXml = By.xpath("//a[@title='pom.xml']");
    private final By selenuimVersion = By.xpath("//*[@id='LC33']");

    private final static Logger LOG = LogManager.getLogger("LoginPageObject");

    private final By avatar = By.xpath("//img[@class='avatar avatar-user']");
    private final By signOutButton = By.xpath("//button[contains(text(),'Sign out')]");
    private final By successIndicatorOfSigningOut = By.xpath("//h1[contains(text(),'Built')]");


    public LoginPageObject goToG46RepositoryThe1stVariant(String G46repositoryLink) {
        driver.get(G46repositoryLink);
        return new LoginPageObject(driver);
    }


    public LoginPageObject checkIfRepositoryIsPresentAndOpenIt(String nameOfRepository) {

        List<WebElement> listOfWebElements = driver.findElements(listOfRepositories);
        List<String> listOfRepositoriesNames = new ArrayList<>(listOfWebElements.size());

        for (int i = 0; i < listOfWebElements.size(); i++) {
            listOfRepositoriesNames.add(listOfWebElements.get(i).getText());

            if ((listOfWebElements.get(i).getText()).equals(nameOfRepository)) {
                listOfWebElements.get(i).click();
            }
        }
        return new LoginPageObject(driver);
    }


    public LoginPageObject findSeleniumVersion(String version) {
        driver.findElement(pomXml).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(selenuimVersion).getText();
        String seleniumVers = driver.findElement(selenuimVersion).getText().trim().substring(9, 17);
        LOG.info("Selenium version is " + seleniumVers);
        Assert.assertEquals(version, seleniumVers);
        return new LoginPageObject(driver);
    }


    public LoginPageObject signOutFromGitHub() {
        driver.findElement(avatar).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(signOutButton);
        Assert.assertEquals("Built for developers", driver.findElement(successIndicatorOfSigningOut).getText());
        return new LoginPageObject(driver);
    }


//    private SelenideElement login = $(byId("login_field"));
//    private SelenideElement pass = $(byId("password"));
//    private SelenideElement signInBut = $(byName("commit"));



    public LoginPageObject loginNegative(String login, String password) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        return new LoginPageObject(driver);
    }


    public MainPage login(String login, String password) {
        printColorMessage("Authorization is in progress", log, Level.INFO);
        //log.info("Authorization is in progress");
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        printColorMessage("Success authorization", log, Level.INFO);
        //log.info("Success authorization");
        return new MainPage(driver);
    }

    public LoginPageObject returnToLoginPage() {
        driver.navigate().back();
        return new LoginPageObject(driver);
    }


    public LoginPageObject validateErrorMessage(String message) {
        Assert.assertEquals(message, driver.findElement(errorMessage).getText());
        return this;
    }

    public LoginPageObject validateErrorMessage(String message, boolean noAdmin) {
        Assert.assertEquals(message, driver.findElement(this.message).getText());
        return this;
    }

    public LoginPageObject checkAuthFields() {
        // login.shouldBe(Condition.visible).sendKeys("login");
        printColorMessage("Authorization fields validation", log, Level.INFO);
        //log.info("Authorization fields validation");
        Assert.assertTrue("Login field is invisible", this.driver.findElement(loginField).isDisplayed());
        Assert.assertTrue("Password field is invisible", this.driver.findElement(passwordField).isDisplayed());
        Assert.assertTrue("Sign In button is invisible", this.driver.findElement(signInButton).isDisplayed());
        printColorMessage("Authorization fields are valid", log, Level.INFO);
        //log.info("Authorization fields are valid");
        return this;
    }


}
