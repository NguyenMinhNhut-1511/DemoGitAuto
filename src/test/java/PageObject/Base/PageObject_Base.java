package PageObject.Base;

import PageObject.Page.*;
import PageObject.Page_Model.*;
import PageObject.Page_Model.CartStep1;
import Utils.Actions.Keyboard_Actions;
import Utils.Actions.Scroll_Actions;
import Utils.Wait.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;


public class PageObject_Base {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected WaitFor wait;
    protected Scroll_Actions scroll_actions;
    protected Keyboard_Actions keyboard_actions;
    protected SoftAssert softAssert;


    public PageObject_Base(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) this.driver;
        wait = new WaitFor(this.driver);
        scroll_actions = new Scroll_Actions(this.driver);
        keyboard_actions = new Keyboard_Actions(this.driver);
        softAssert = new SoftAssert();
    }

    public CartStep2_Page NavigateCartStep2Page()
    {
        return new CartStep2_Page(this.driver);
    }
    public Login_Page NavigateToLoginPage() {
        return new Login_Page(this.driver);
    }
    public Histories_Page NavigateToHistoriesPage()
    {
        return new Histories_Page(this.driver);
    }
    public Home_Page NavigateToHomePage() {
        return new Home_Page(this.driver);
    }
    public OderResult_Page NavigateToOderResultPage() {
        return new OderResult_Page(this.driver);
    }
    public SearchResult_Page NavigateToSearchResultPage() {
        return new SearchResult_Page(this.driver);
    }
    public CartStep1_Page NavigateToCartStep1Page() {
        return new CartStep1_Page(this.driver);
    }


    public String GetTextBySelector(By Selector) {
        return this.driver.findElement(Selector).getText();
    }







}
