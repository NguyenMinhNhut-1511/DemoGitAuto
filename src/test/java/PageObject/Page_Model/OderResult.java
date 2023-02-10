package PageObject.Page_Model;

import Helpers.Logger.Log;
import PageObject.Base.PageObject_Base;
import Utils.String_Handle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class OderResult extends PageObject_Base {

    private final By txt_OderSuccess_Selector = By.xpath("//p[@class='msg message-thanks']//p[@class='msg message-thanks']");
    private final By txt_customerName_Selector = By.xpath("//div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]");
    private final By txt_Address_Selector = By.xpath("//div[1]/div[2]/ul[1]/li[3]");
    private final By txt_ShipDateTime_Selector = By.xpath("//div[1]/div[2]/ul[1]/li[4]");
    private final By txt_customerNote_Selector = By.xpath("//div[1]/div[2]/ul[1]/li[5]//span[1]");
    private final By txt_total_Selector = By.xpath("//div[3]/div[2]/b[1]");
    private final By txt_Payment_Selector = By.xpath("//div[2]/div[1]/div[1]/div[3]/div[3]/span[1]");
    private final By btn_Home_Selector = By.cssSelector("a[class='btn-home']");
    private final By btn_cancel_Oder_Selector = By.xpath("//body/div[1]/div[2]/div[1]/a[1]");
    private final By list_checkbox_Reason_Cancel_Oder_Selector = By.cssSelector("[id^='checkbox_']");
    private final By box_reason_Cancel_Oder_Selector = By.xpath("//textarea[contains(@placeholder,'Nhập nội dung góp ý')]");
    private final By btn_accept_Cancel_Oder_Selector = By.cssSelector(".submit.submit-cancel");
    private final By btn_close_PopUpCancel_Oder_Selector = By.cssSelector("div[class='frm-CancelOrder'] button[class='close']");

    public OderResult(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private WebElement txt_OderSuccess() {
        return this.driver.findElement(txt_OderSuccess_Selector);
    }

    private WebElement txt_customerName() {
        return this.driver.findElement(txt_customerName_Selector);
    }

    private WebElement txt_Address() {
        return this.driver.findElement(txt_Address_Selector);
    }

    private WebElement txt_shipDateTime() {
        return this.driver.findElement(txt_ShipDateTime_Selector);
    }

    private WebElement txt_customerNote() {
        return this.driver.findElement(txt_customerNote_Selector);
    }

    private WebElement txt_Total() {
        return this.driver.findElement(txt_total_Selector);
    }

    private WebElement txt_Payment() {
        return this.driver.findElement(txt_Payment_Selector);
    }

    private WebElement btn_Home() {
        return this.driver.findElement(btn_Home_Selector);
    }

    private WebElement btn_cancelOder() {
        return this.driver.findElement(btn_cancel_Oder_Selector);
    }

    private List<WebElement> list_checkbox_Reason_CancelOder() {
        return this.driver.findElements(list_checkbox_Reason_Cancel_Oder_Selector);
    }

    private WebElement box_reason_CancelOder() {
        return this.driver.findElement(box_reason_Cancel_Oder_Selector);
    }

    private WebElement btn_accept_CancelOder() {
        return this.driver.findElement(btn_accept_Cancel_Oder_Selector);
    }

    private WebElement btn_close_PopUpCancelOder() {
        return this.driver.findElement(btn_close_PopUpCancel_Oder_Selector);
    }


    private void scrollIntoView_BtnHome() {
        scroll_actions.ScrollIntoViewElement(this.btn_Home());
    }

    protected boolean check_SubmitOderSuccess() {
//        return wait.waitFortextToBePresentInSelector(txt_OderSuccess_Selector, "ĐẶT HÀNG THÀNH CÔNG");
        return driver.getCurrentUrl().contains("dat-hang-thanh-cong");
    }


    protected OderResult verify_InfoCustomer(String expect_InfoCustomer) {
        wait.waitForPageLoaded();
//        wait.waitFortextToBePresentInSelector(txt_OderSuccess_Selector, "ĐẶT HÀNG THÀNH CÔNG");
        String current_InfoCustomer = this.txt_customerName().getText()
                .replace("Người nhận:", "")
                .toLowerCase().trim();
        String temp = expect_InfoCustomer.toLowerCase().trim();

        Assert.assertEquals(current_InfoCustomer, temp);
        return this;
    }

    protected OderResult verify_ShipAddress(String expect_ShipAddress) {
        String current_ShipAddress = this.txt_Address().getText()
                .replace(",", "")
                .replace("Phường ","")
                .replace("Xã ","")
                .replace("TP. ", "")
                .replace("Thành Phố ", "")
                .replace("Huyện ","")
                .replace(" (Q2 Q9 Thủ Đức)","")
                .replace(" (Q2)","")
                .replace(" (Q9)","")
                .replace(" (Q.Thủ Đức)","")
                .toLowerCase().trim();

        String temp = expect_ShipAddress.toLowerCase().trim();
        Assert.assertEquals(current_ShipAddress, temp);
        return this;
    }

    protected OderResult verify_shipDateTime(String expect_DateTime) {
        String current_DateTime = this.txt_shipDateTime().getText()
                .replace("Dự kiến giao vào:", "");
        Assert.assertEquals(current_DateTime, expect_DateTime);
        return this;
    }

    protected OderResult verify_customerNote(String expect_customerNote) {
        String current_customerNote = this.txt_customerNote().getText();
        Assert.assertEquals(current_customerNote, expect_customerNote);
        return this;
    }

    protected OderResult verify_total(String expect_total) {
        String current_total = this.txt_Total().getText().replace("₫", "");
        Assert.assertEquals(current_total, expect_total);
        return this;
    }

    protected OderResult verify_Payment(String expect_Payment) {
        String Current = this.txt_Payment().getText()
                .replace("Thanh toán", "")
                .replace("khi nhận hàng", "")
                .trim().toLowerCase();
        String current_Payment = String_Handle.removeAccent(Current);
        String temp = String_Handle.removeAccent(expect_Payment.trim().toLowerCase());
        Assert.assertEquals(current_Payment, temp);
        return this;
    }


    protected OderResult CancelOder(int Option, String lyDoHuy) {
        this.scrollIntoView_BtnHome();
        btn_cancelOder().click();
        wait.waitForClickAbleByElement(this.btn_close_PopUpCancelOder());

        int m = list_checkbox_Reason_CancelOder().size();

        switch (Option) {
            case 1: {   // Tôii muốn mua đơn hàng khác
                wait.waitForClickAbleBySelector(By.cssSelector("label[for='checkbox_1']")).click();
                if (btn_accept_CancelOder().isEnabled()) {
                    btn_accept_CancelOder().click();
                }
            }break;
            case 2: {  //Không còn nhu cầu mua
                wait.waitForClickAbleBySelector(By.cssSelector("label[for='checkbox_2']")).click();
                if (btn_accept_CancelOder().isEnabled()) {
                    btn_accept_CancelOder().click();
                }
            } break;
            case 3: {  //Tìm chỗ khác giá tốt hơn
                wait.waitForClickAbleBySelector(By.cssSelector("label[for='checkbox_3']")).click();
                if (btn_accept_CancelOder().isEnabled()) {
                    btn_accept_CancelOder().click();
                }
            }break;
            case 4: { //Lý do khác
                wait.waitForClickAbleBySelector(By.cssSelector("label[for='checkbox_7']")).click();
                if (btn_accept_CancelOder().isEnabled()) {
                    btn_accept_CancelOder().click();
                }
                wait.waitForvisibilityOfSelector(box_reason_Cancel_Oder_Selector).sendKeys(lyDoHuy);
                this.btn_accept_CancelOder().click();
            }break;
            case 5: {
                js.executeScript("document.getElementById('checkbox_5').click()");
                if (btn_accept_CancelOder().isEnabled()) {
                    btn_accept_CancelOder().click();
                }
                break;
            }
            case 7: {

                js.executeScript("document.getElementById('checkbox_7').click()");
                wait.waitForClickAbleByElement(this.box_reason_CancelOder());
                if (lyDoHuy.isEmpty() || lyDoHuy.equals(" ")) {
                    lyDoHuy = "Huỷ đơn hàng.";
                }
                box_reason_CancelOder().sendKeys(lyDoHuy);
                btn_accept_CancelOder().click();
                break;
            }
            case 8: {
                js.executeScript("document.getElementById('checkbox_6').click()");
                if (btn_accept_CancelOder().isEnabled()) {
                    btn_accept_CancelOder().click();
                }
                break;
            }
            default:
                System.out.println("Không có Option " + Option);
        }
        return this;
    }


}
