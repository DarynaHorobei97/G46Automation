package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final static String TITLE = "Домашняя не авторизированная страница";

    public HomePage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By titleMessage = By.xpath("//h1[@class = 'h000-mktg text-white lh-condensed-ultra mb-3']");
    @Step("Validate log out")
    public void validateLogOut(){
        Assert.assertTrue(driver.findElement(titleMessage).isDisplayed());
        Assert.assertEquals("Built for developers", driver.findElement(titleMessage).getText());

    }




}
