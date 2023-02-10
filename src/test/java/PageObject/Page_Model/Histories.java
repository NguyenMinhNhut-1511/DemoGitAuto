package PageObject.Page_Model;

import Helpers.Logger.Log;
import PageObject.Base.PageObject_Base;
import Utils.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Histories extends PageObject_Base {

    private SoftAssert softAssert = new SoftAssert();

    final private By txt_customerName_Selector = By.cssSelector("span[class='name']");

    public Histories(WebDriver driver) {
        super(driver);
        this.driver =driver;
    }

    private WebElement txt_customerName() {
        return this.driver.findElement(txt_customerName_Selector);
    }

    protected Histories verify_customerName(String expect_customerName) {
        wait.waitForvisibilityOfSelector(txt_customerName_Selector);
        String current_customerName = txt_customerName().getText().trim().replace("(", "").replace(")","");
        softAssert.assertEquals(current_customerName, expect_customerName);
        softAssert.assertAll();
        return this;
    }

    protected Histories verify_Link() {
        String current_Link = this.driver.getCurrentUrl();
        softAssert.assertEquals(current_Link, Constant.EXPECT_URL_LOGIN_SUCCESS);
        softAssert.assertAll();
        Log.info("Pass");
        return this;
    }

}
