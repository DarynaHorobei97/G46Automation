package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HomePage extends BasePage {
    private final static String TITLE = "Домашняя не авторизированная страница";

    public HomePage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By titleMessage = By.xpath("//h1[@class = 'h000-mktg text-white lh-condensed-ultra mb-3']");

    public void validateLogOut(){
        Assert.assertTrue(driver.findElement(titleMessage).isDisplayed());
        Assert.assertEquals("Built for developers", driver.findElement(titleMessage).getText());

    }




}
