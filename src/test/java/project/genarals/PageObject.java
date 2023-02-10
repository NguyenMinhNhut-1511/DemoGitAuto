package project.genarals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageObject {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected WaitFor wait;
    //protected Scroll_Actions scroll_actions;
    public PageObject() {}
    protected PageObject(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) this.driver;
        wait = new WaitFor(this.driver);
        //scroll_actions = new Scroll_Actions(this.driver);
    }
    public PageObject clearAllCookies() {
        driver.manage().deleteAllCookies();
        return this;
    }
    public PageObject getUrl(String urlPath) {
        driver.get(urlPath);
        return this;
    }
    public PageObject redirectURL(String urlPath) {
        driver.navigate().to(urlPath);
        return this;
    }
    public PageObject refreshPage() {
        driver.navigate().refresh();
        return this;
    }
    public PageObject forwardToCurrentPage() {
        driver.navigate().forward();
        return this;
    }
    public PageObject backToPreviousPage() {
        driver.navigate().back();
        return this;
    }
}
