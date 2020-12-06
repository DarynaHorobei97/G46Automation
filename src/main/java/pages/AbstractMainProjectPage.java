package pages;

import helpers.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printTabsNamesWithDifferentColors;

public  class AbstractMainProjectPage {

    protected WebDriver driver;
    protected Logger log;
    protected String title;

    protected final By loginField = By.id("login_field");
    protected final By passwordField = By.id("password");
    protected final By signInButton = By.name("commit");

    protected By tabs = By.xpath("//span[@data-content]");

    public AbstractMainProjectPage(WebDriver driver, String title) {

        this.driver = driver;
        this.title = title;
        this.log = LogManager.getLogger(this.title);
        printColorMessage("Page object is created: " + title + ",class: " + this.getClass().getName(), log, Level.DEBUG);
    }

    public void colorfulTabsNames() {
        List<WebElement> tabsList = driver.findElements(tabs);
        printTabsNamesWithDifferentColors(tabsList);

    }

    public void colorfulTabNames1(){
        List<WebElement> tabsList = driver.findElements(tabs);
        for (int i = 0; i <tabsList.size() ; i++) {
            printColorMessage(tabsList.get(i).getText(),log, Level.INFO);
        }


    }

}
