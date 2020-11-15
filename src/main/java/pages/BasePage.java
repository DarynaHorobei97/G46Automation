package pages;

import helpers.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.WebDriver;

import static helpers.ColorPrinter.printColorMessage;


public abstract class BasePage {
    protected WebDriver driver;
    protected Logger log;
    private String title;

    public BasePage(WebDriver driver, String title) {

        this.driver = driver;
        this.title = title;
        this.log = LogManager.getLogger(this.title);
        printColorMessage("Page object is created: " + title + ",class: " + this.getClass().getName(),log, Level.DEBUG);
    }
}
