package Utils.Actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Keyboard_Actions {

    WebDriver driver;
    Actions actions;
    public Keyboard_Actions(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }




    public void enter_Keyboard() {
        actions.sendKeys(Keys.ENTER)
                .build()
                .perform();
    }


}
