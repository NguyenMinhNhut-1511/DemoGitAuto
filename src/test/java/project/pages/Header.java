package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import project.genarals.PageObject;

import java.util.concurrent.TimeUnit;

public class Header extends PageObject {
    private final WebDriver driver;
    private WebElement box_logoBHX() {
        return driver.findElement(By.cssSelector(".bhx-logo"));
    }
    private WebElement box_search_product() {
        return driver.findElement(By.cssSelector("#text-search"));
    }
    private WebElement box_histories() {
        return driver.findElement(By.className("histories"));
    }
    private WebElement box_cart() {
        return driver.findElement(By.className("bhx-cart"));
    }
    private WebElement btn_resetBoxSearch() {
        return driver.findElement(By.cssSelector("form[class='mainsearch'] div[class='reset']"));
    }
    public Header(WebDriver driver) {
        this.driver = driver;
    }
    //Functions
    public void click_logoBHX() {
        this.box_logoBHX().click();
    }
    public Header input_text_SearchProduct(String keyword) {
        this.box_search_product().sendKeys(keyword);
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        return this;
    }
    public Header click_reset_SearchProduct() {
        wait.waitFor_ClickAbleByElement(btn_resetBoxSearch());
        this.btn_resetBoxSearch().click();
        return this;
    }
    public Header enter_search_SearchProduct() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER)
                .build()
                .perform();
        return this;
    }
    public Header wait_suggestSearchDisplay() {
        wait.waitFor_visibilityOfSelector(By.className("easy-autocomplete-container searchhistory"));
        return this;

    }
    public void click_btn_Histories() {
        this.box_histories().click();
    }
    public void click_box_cart() {
        this.box_cart().click();
    }
}
