package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.code.ProjectPage;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.Level.INFO;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginPage extends BasePage{

    private final static String TITLE = "Страница авторизации";

    private final By loginField = By.id("login_field");
    private final By passwordField= By.id("password");
    private final By signInButton= By.name("commit");

    private final By errorMessage = By.xpath("//div[@id = 'login']/p");
    private final By message = By.xpath("//div[contains(@class, 'container-lg px-')]");

    public LoginPage(WebDriver driver) {
        super(driver, TITLE);
    }
    @Step("Check negative log in")
    public LoginPage loginNegative(String login, String password){
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    @Step("Log in")
    public ProjectPage login(String login, String password){
        printColorMessage("Проводится авторизация в приложение", log, INFO);
        webDriverWait_10.until(elementToBeClickable(loginField));
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        printColorMessage("Авторизация успешна!", log, INFO);
        return new ProjectPage(driver);
    }

    public LoginPage validateErrorMessage(String message, boolean isAdmin){
        Assert.assertEquals(message, driver.findElement(errorMessage).getText());
        return this;
    }

    public LoginPage validateErrorMessage(String message){
        Assert.assertEquals(message, driver.findElement(this.message).getText());
        return this;
    }
    @Step("Return to Login page")
    public LoginPage returnToLoginPage(){
        driver.navigate().back();
        return new LoginPage(driver);
    }
    @Step("Check auth fields")
    public LoginPage checkAuthFields(){
        printColorMessage("Валидируются поля для авторизации", log, INFO);
        Assert.assertTrue("Поле Логин видимо", this.driver.findElement(loginField).isDisplayed());
        Assert.assertTrue("Поле Пароль видимо", this.driver.findElement(passwordField).isDisplayed());
        Assert.assertTrue("Кнопка Войти видима", this.driver.findElement(signInButton).isDisplayed());
        printColorMessage("Поля валидны!", log, INFO);
        return this;
    }
}