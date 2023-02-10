package Utils.Actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Scroll_Actions {

    WebDriver driver;
    JavascriptExecutor js;
    Actions actions ;

    public Scroll_Actions(WebDriver driver) {
        this.driver = driver;
        js= (JavascriptExecutor) this.driver;
        actions = new Actions(this.driver);
    }

    public Scroll_Actions ScrollIntoViewElement(WebElement Element)
    {
        js.executeScript("arguments[0].scrollIntoView(true);", Element);
        return this;
    }

    public Scroll_Actions ScrollDown()
    {
        actions
                .sendKeys(Keys.PAGE_DOWN)
                .build()
                .perform();

        return this;
    }

    public Scroll_Actions ScrollDown(int times)
    {
        for(int i = 1; i<=times; i++)
        {
            this.ScrollDown();
        }
        return this;
    }

    public Scroll_Actions ScrollUp()
    {
        actions
                .sendKeys(Keys.PAGE_UP)
                .build()
                .perform();

        return this;
    }

    public Scroll_Actions ScrollUp(int times)
    {
        for(int i = 1; i<=times; i++)
        {
            this.ScrollUp();
        }

        return this;
    }

    public void ScrollDown50percent()
    {
        js.executeScript("window.scrollBy(0, window.innerHeight/2);");
    }
}
