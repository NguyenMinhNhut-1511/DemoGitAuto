package PageObject.Page;

import PageObject.Page_Model.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartStep1_Page extends CartStep1 {

    public CartStep1_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By btn_Submit_CartStep1_Selector = By.cssSelector("button[class='btn-og btn-step']");


    public CartStep1_Page click_Submit_Step1() {
      wait.waitForClickAbleBySelector(btn_Submit_CartStep1_Selector).click();
        return this;
    }
//
}
