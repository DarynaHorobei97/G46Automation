package tests;

import org.apache.xmlbeans.SystemProperties;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    protected static WebDriver driver;

    @Before
    public void setUp() {

        switch (System.getProperty("browser", "chrome")) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "opera":
                driver = new OperaDriver();
                break;
            default:
                driver = new EdgeDriver();
        }


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
        //open("https://github.com/login");
    }

    @After
    public void tearDown() {
        //closeWebDriver();
        driver.quit();
    }


}
