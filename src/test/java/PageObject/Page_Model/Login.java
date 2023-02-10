package PageObject.Page_Model;

import PageObject.Base.PageObject_Base;
import Utils.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login extends PageObject_Base {

    final private By box_phoneNumber_Selector = By.cssSelector("input[id='phone']");
    final private By box_passWord_Selector = By.cssSelector("input[id='Password']");;
    final private By btn_submit_Selector = By.cssSelector("button[onclick='otp_login.beforeSubmitPhone()']");
    final private By txt_warning_dangNhap_Selector = By.cssSelector("div[class='error-lst blue']");


    public Login(WebDriver driver) {
        super(driver);
        this.driver =driver;
    }

    private WebElement box_userName() {
        return this.driver.findElement(box_phoneNumber_Selector);
    }

    private WebElement btn_submit() {
        return this.driver.findElement(btn_submit_Selector);
    }

    private WebElement box_passWord() {
        return this.driver.findElement(box_passWord_Selector);
    }

    private WebElement txt_warning_dangNhap() {
        return this.driver.findElement(txt_warning_dangNhap_Selector);
    }




    protected Login input_userName(String username) {
        wait.waitForClickAbleBySelector(box_phoneNumber_Selector);
        this.box_userName().sendKeys(username);
        return this;
    }

    protected Login input_passWord(String password) {
        wait.waitForClickAbleBySelector(box_passWord_Selector);
        this.box_passWord().sendKeys(password);
        return this;
    }

    protected Login click_btnSubmit() {
        wait.waitForClickAbleBySelector(btn_submit_Selector);
        this.btn_submit().click();
        return this;
    }


    protected Login verify_warningDangNhap() {
        wait.waitFortextToBePresentInSelector(txt_warning_dangNhap_Selector, Constant.TEXT_WARNING_DANG_NHAP_FALSE);
        String currentText = txt_warning_dangNhap().getText();
        softAssert.assertEquals(currentText, Constant.TEXT_WARNING_DANG_NHAP_FALSE);
        softAssert.assertAll();
        return this;
    }
}



