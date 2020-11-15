package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProfileForm extends BasePage {

    private final static String TITLE = "Profile form";
    private final By viewProfileAndMoreButton = By.xpath("//details/summary[@aria-label='View profile and more']/span[@class='dropdown-caret']");
    private final By signOutButton = By.xpath("//button[contains(text(),'Sign out')]");
    private final By successIndicatorOfSigningOut = By.xpath("//h1[contains(text(),'Built')]");

    public ProfileForm(WebDriver driver) {
        super(driver, TITLE);
    }


    public LoginPageObject signOutFromGitHub() {
        driver.findElement(viewProfileAndMoreButton).click();
        Assert.assertTrue(driver.findElement(viewProfileAndMoreButton).isDisplayed());
        Assert.assertTrue(driver.findElement(signOutButton).isDisplayed());
        driver.findElement(signOutButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("Built for developers", driver.findElement(successIndicatorOfSigningOut).getText());
        return new LoginPageObject(driver);
    }

    public LoginPageObject signOutFromGitHub(boolean isSignOutWithoutCheck) {
        driver.findElement(viewProfileAndMoreButton).click();
        Assert.assertTrue(driver.findElement(viewProfileAndMoreButton).isDisplayed());
        Assert.assertTrue(driver.findElement(signOutButton).isDisplayed());
        driver.findElement(signOutButton).click();
        return new LoginPageObject(driver);
    }


}
