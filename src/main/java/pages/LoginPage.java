package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{// extends BasePage {

    @FindBy(id = "login_field")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(name = "commit")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        //super(driver);
      //  PageFactory.initElements(this.driver, this);
    }

    public void checkAuthFields(){
        Assert.assertTrue("Login field is invisible", loginField.isDisplayed());
        Assert.assertTrue("Password field is invisible", password.isDisplayed());
        Assert.assertTrue("Sign In button is invisible", signInButton.isDisplayed());
    }
}
