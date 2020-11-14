package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.ColorPrinter.printMessageInYellow;

public class MainPage extends BasePage {

    private final static String TITLE = "Main page";

    public MainPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private By successTitle = By.xpath("*//h2[@class='shelf-title']");

    public void validateLogin() {
        printMessageInYellow("Checking if authorization is successful", log);
        // log.info("Checking if authorization is successful");
        Assert.assertTrue(driver.findElement(successTitle).isDisplayed());
        Assert.assertEquals("Checking failed", "Learn Git and GitHub without any code!",
                driver.findElement(successTitle).getText());
        printMessageInYellow("Success", log);
        // log.info("Success");
    }

    public ProjectPage openOurProjectpage() {
        driver.get("https://github.com/DarynaHorobei97/G46Automation");
        return new ProjectPage(driver);
    }
}
