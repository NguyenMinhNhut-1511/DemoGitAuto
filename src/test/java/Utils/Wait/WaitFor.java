package Utils.Wait;

import Helpers.Logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static Utils.Constant.*;

public class WaitFor {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    WebDriverWait wait_short;


    public WaitFor(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, SHORT_WAIT_TIME);
        wait_short = new WebDriverWait(this.driver,WAIT_TIME_TRYCATCH);
        js = (JavascriptExecutor) this.driver;
    }

    public WebElement waitForClickAbleByElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForClickAbleBySelector(By Selector) {
        return wait.until(ExpectedConditions.elementToBeClickable(Selector));
    }

    public WebElement waitForvisibilityOfSelector(By Selector) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Selector));
    }

    public WebElement waitForvisibilityOfElement(WebElement Element) {
        return wait.until(ExpectedConditions.visibilityOf(Element));
    }

    public boolean waitFortextToBePresentInElement(WebElement Element, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElement(Element, text));
    }

    public boolean waitFortextToBePresentInSelector(By Selector, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(Selector, text));
    }

    public boolean waitForinvisibilityOfSelector(By Selector) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(Selector));
    }

    /**
     * Chờ đợi trang tải xong (Javascript) với thời gian mặc định từ config
     */
    public void waitForPageLoaded() {
        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            Log.info("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("Timeout waiting for page load (Javascript). (" + WAIT_PAGE_LOADED + "s)");
            }
        }
    }

    public WebElement waitForTryCatch_VissibilityOfSelector(By Selector)
    {
        WebElement Element = null;
        try {
            Element = wait_short.until(ExpectedConditions.visibilityOfElementLocated(Selector));
        }
        catch (Exception ignore){}
        return Element;
    }
}
