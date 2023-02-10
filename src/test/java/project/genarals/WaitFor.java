package project.genarals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static project.genarals.Constant.SHORT_WAIT_TIME;

public class WaitFor {
    WebDriver driver;
    WebDriverWait wait;

    public WaitFor(WebDriver driver) {
        this.driver = driver;
        wait= new WebDriverWait(this.driver, SHORT_WAIT_TIME);
    }
    public void waitFor_ClickAbleByElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitFor_ClickAbleBySelector(By Selector) {
        wait.until(ExpectedConditions.elementToBeClickable(Selector));
    }
    public void waitFor_visibilityOfSelector(By Selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selector));
    }
    public void waitFor_visibilityOfSelector(WebElement Element) {
        wait.until(ExpectedConditions.visibilityOf(Element));
    }
    public void waitFor_textToBePresentInElement(WebElement Element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(Element,text ));
    }
    public void waitFor_textToBePresentInSelector(By Selector, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selector,text ));
    }
}
