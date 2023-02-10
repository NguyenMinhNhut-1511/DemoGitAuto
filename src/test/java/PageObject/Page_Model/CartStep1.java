package PageObject.Page_Model;

import PageObject.Base.PageObject_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartStep1 extends PageObject_Base {

    final private By btn_Submit_Continue_Step1_Selector = By.cssSelector("button[class='btn-og btn-step']");
    final private By txt_total = By.xpath("//div[@class='summary']//label[@id='carttotal']");


    public CartStep1(WebDriver driver) {
        super(driver);
        this.driver =driver;

    }

    private WebElement btn_Submit_Continue_Step1() {
        return this.driver.findElement(btn_Submit_Continue_Step1_Selector);
    }

    protected CartStep1 click_Submit_Continue_Step1() {
        wait.waitForClickAbleBySelector(btn_Submit_Continue_Step1_Selector).click();
        return this;
    }



}
