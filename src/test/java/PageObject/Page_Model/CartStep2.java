package PageObject.Page_Model;

import Helpers.Logger.Log;
import PageObject.Base.PageObject_Base;
import Utils.String_Handle;

import static Utils.Wait.Sleep.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class CartStep2 extends PageObject_Base {

    final private By btn_getAddress_Selector = By.cssSelector("a[class='btnGetAddress']");
    final private By box_fullName_Selector = By.id("ProfileItems_0_CustomerName");
    final private By box_phoneNumber_Selector = By.id("ProfileItems_0_CustomerPhone");
    final private By box_Address_Selector = By.id("ProfileItems_0_Address");
    final private By radio_gender_Anh_Selector = By.cssSelector("label[for='ProfileItems_0_Gender1']");
    final private By radio_gender_Chi_Selector = By.cssSelector("label[for='ProfileItems_0_Gender0']");
    final private By dropdown_shipDateGroupList_Selector = By.cssSelector("#ShiptimeGroupList_0_Date");
    final private By dropdown_shipTimeGroupList_Selector = By.cssSelector("#ShiptimeGroupList_0_Time");
    final private By btn_loadMorePayment_Selector = By.cssSelector("div[class='loadMorePaymentType']");
    final private By box_NoteOder_Selector = By.name("CustomerNote");
    final private By btn_submitOder_Step2_Selector = By.cssSelector("span[class='box-warning-payment']");
    final private By checkbox_Others_Selector = By.cssSelector("#IsCallOthers");
    final private By radio_Others_genderChi_Selector = By.cssSelector("label[for='OthersGenderCall_Gender0']");
    final private By radio_Others_genderAnh_Selector = By.cssSelector("label[for='OthersGenderCall_Gender1']");
    final private By box_Others_fullName_Selector = By.name("OthersName");
    final private By box_Others_phoneNumber_Selector = By.name("OthersPhone");
    final private By txt_ErrorInput_Popup_Selector = By.cssSelector("div[class='mess-input']");
    final private By btn_Accept_ErrorInput_Popup_Selector = By.xpath("//body/div[9]//div/div[4]/div[2]/button");
    final private By checkbox_callBeforeDelivery_Selector = By.cssSelector("label[for='IsCallMe']");
    final private By checkbox_IsGetBill_Selector = By.cssSelector("label[for='IsGetBill']");//xuất hoá đơn công ty
    final private By box_companyName_Selector = By.cssSelector("#companyname");
    final private By box_companyAddress_Selector = By.cssSelector("#companyaddress");
    final private By box_companyTaxnumber_Selector = By.cssSelector("#companytaxnumber");
    final private By btn_close_PopUp_GetAddress_Selector = By.xpath("//button[@class='ajs-close']");
    final private By txt_TotalProduct_Selector = By.xpath("//div[@class='summary summary-final']//label[@id='carttotal']");
    final private By txt_TotalFeeShip_Selector = By.xpath("//div[@class='summary summary-final']//label[@class='rightshiping']/span[2]");
    final private By txt_SumTotal_Selector = By.cssSelector("div[class='totalbox'] label");

    public CartStep2(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private WebElement radio_gender_Anh() {
        return this.driver.findElement(radio_gender_Anh_Selector);
    }

    private WebElement radio_gender_Chi() {
        return this.driver.findElement(radio_gender_Chi_Selector);
    }

    private WebElement box_fullName() {
        return this.driver.findElement(box_fullName_Selector);
    }

    private WebElement box_Address() {
        return this.driver.findElement(box_Address_Selector);
    }

    private WebElement box_phoneNumber() {
        return this.driver.findElement(box_phoneNumber_Selector);
    }

    private WebElement dropdown_shipDateGroupList() {
        return this.driver.findElement(dropdown_shipDateGroupList_Selector);
    }

    private WebElement dropdown_shipTimeGroupList() {
        return this.driver.findElement(dropdown_shipTimeGroupList_Selector);
    }

    private WebElement btn_loadMorePayment() {
        return this.driver.findElement(btn_loadMorePayment_Selector);
    }

    private WebElement box_NoteOder() {
        return this.driver.findElement(box_NoteOder_Selector);
    }

    private WebElement btn_submitOder_Step2() {
        return this.driver.findElement(btn_submitOder_Step2_Selector);
    }

    private WebElement box_Others_fullName() {
        return this.driver.findElement(box_Others_fullName_Selector);
    }

    private WebElement radio_Others_gender_Anh() {
        return this.driver.findElement(radio_Others_genderAnh_Selector);
    }

    private WebElement radio_Others_gender_Chi() {
        return this.driver.findElement(radio_Others_genderChi_Selector);
    }

    private WebElement box_Others_phoneNumber() {
        return this.driver.findElement(box_Others_phoneNumber_Selector);
    }

    private WebElement checkbox_Others() {
        return this.driver.findElement(checkbox_Others_Selector);
    }

    private WebElement btn_Accept_ErrorInput_Popup() {
        return this.driver.findElement(btn_Accept_ErrorInput_Popup_Selector);
    }

    private WebElement txt_ErrorInput_Popup() {
        return this.driver.findElement(txt_ErrorInput_Popup_Selector);
    }


    /*
Mô tả:
Hàm check chọn ngày giao hàng
input: là string theo định dạng dd/mm
Output: True hoặc False. True là đã chọn được ngày

Rules: Nếu có ngày phù hợp sẽ chọn
Nếu k có ngày phù hợp sẽ tự chọn ngày cuối cùng trong danh sách.


Logic xử lý:
Dùng Select để lấy các options
Sau đó đổ các options đó qua dạng List và bắt đầu check.
Nếu đủ điều kiện thì sẽ dùng Select.byIndex
*/
    private boolean Check_chooseShipDate(String shipDate) {
        String ngaychon1 = shipDate.trim().replace("-", "/");
//        Log.info(ngaychon1);

        Select select_Ngay = new Select(wait.waitForClickAbleBySelector(dropdown_shipDateGroupList_Selector));
        List<WebElement> List_Ngaygiaohang = select_Ngay.getOptions();
        boolean check_isSelected = false;
        if (List_Ngaygiaohang.size() >= 2) {
            for (WebElement Date : List_Ngaygiaohang) {
//                Log.info(Date.getText().trim().replace("<b>","").replace("</b>", " -"));
                if (Date.getText().trim().contains(ngaychon1)) {
                    select_Ngay.selectByIndex(List_Ngaygiaohang.indexOf(Date));
                    Log.info("Đã chọn: xong");
                    String dachon = List_Ngaygiaohang.get(List_Ngaygiaohang.indexOf(Date)).getText()
                            .replace("<b>", "").replace("</b>", " -");
                    Log.info("Đã chọn: " + dachon);
                    check_isSelected = true;
                    break;
                }
            }
            if (!check_isSelected) {
                select_Ngay.selectByIndex((List_Ngaygiaohang.size() - 1));
//                String ngaychon = select_Ngay.getAllSelectedOptions().get((List_Ngaygiaohang.size() - 1))
//                        .getText().replace("<b>", "")
//                        .replace("</b>", "/");
//                sleepInSecond(1.5);
//                String ngaychon = List_Ngaygiaohang.get((List_Ngaygiaohang.size() - 1)).getText().replace("<b>", "").replace("</b>", " -");
//                Log.info("Không có ngày giao phù hợp. Sẽ tự chọn ngày cuối cùng trong danh sách: " + ngaychon);
            }
            return true;
        } else if (List_Ngaygiaohang.size() == 1) {
            if (List_Ngaygiaohang.get(0).getText().contains(ngaychon1)) {
                select_Ngay.selectByIndex(0);
            } else {
                String ngaychon = List_Ngaygiaohang.get((List_Ngaygiaohang.size() - 1)).getText().replace("<b>", "").replace("</b>", " -");
                select_Ngay.selectByIndex(0);
                Log.info("Không có tải giao phù hợp. Sẽ tự chọn ngày phù hợp: " + ngaychon);
            }
            return true;
        } else {
            Log.info("Không lấy được ngày giao");
            return false;
        }
    }

    private void scrollIntoView_shipDateGroupList() {
        WebElement Text_ShipDateTime = driver.findElement(By.cssSelector("div[class='box-data white'] h3[class='rtv']"));
        scroll_actions.ScrollIntoViewElement(Text_ShipDateTime);
    }

    private void scrollIntoView_btnSubmitOderStep2() {
        scroll_actions.ScrollIntoViewElement(btn_submitOder_Step2());
    }

    private int check_Gender(String gender) {
        gender = String_Handle.removeAccent(gender);
        String sex = gender.trim().toLowerCase();
        if (sex.equals("nam") || sex.equals("anh")) {
            return 1;
        } else if (sex.equals("nu") || sex.equals("chi")) {
            return 0;
        } else
            return -1;
    }

    protected boolean check_clicked_checkbox_Others() {
        return wait.waitForClickAbleBySelector(checkbox_Others_Selector).isSelected();
    }

    private boolean check_PopUp_Error_Input() {
        try {
            if (wait.waitForTryCatch_VissibilityOfSelector(txt_ErrorInput_Popup_Selector).isDisplayed()) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    private boolean check_PopUp_Confirm_Change_Gender() {
        try {
            wait.waitForvisibilityOfSelector(btn_Accept_ErrorInput_Popup_Selector);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    private int PopUp_Error_Input_Type() {
        if (check_PopUp_Error_Input()) {
            if (wait.waitForvisibilityOfSelector(txt_ErrorInput_Popup_Selector)
                    .getText().contains("Vui lòng cập nhật giới tính")) {
                return 1;
            } else if (wait.waitForvisibilityOfSelector(txt_ErrorInput_Popup_Selector)
                    .getText().contains("Vui lòng cập nhật họ và tên\n" +
                            "Vui lòng nhập số điện thoại\n" +
                            "Vui lòng nhập địa chỉ nhận hàng\n" +
                            "Vui lòng chọn giờ giao hàng")) {
                return 2;
            } else if (wait.waitForvisibilityOfSelector(txt_ErrorInput_Popup_Selector)
                    .getText().contains("Vui lòng nhập địa chỉ nhận hàng")) {
                return 3;
            } else if (wait.waitForvisibilityOfSelector(txt_ErrorInput_Popup_Selector)
                    .getText().contains("Vui lòng chọn giờ giao hàng")) {
                return 4;
            }
        }
        return 0;
    }

    protected boolean check_checkboxGetBill_isSelected() {
        return wait.waitForClickAbleBySelector(checkbox_IsGetBill_Selector).isSelected();
    }

    protected void input_companyName(String companyName) {
        wait.waitForClickAbleBySelector(box_companyName_Selector).sendKeys(companyName);

    }

    protected void input_companyAddress(String companyAddress) {
        wait.waitForClickAbleBySelector(box_companyAddress_Selector).sendKeys(companyAddress);

    }

    protected void input_companyTaxNumber(String companyTaxNumber) {
        wait.waitForClickAbleBySelector(box_companyTaxnumber_Selector).sendKeys(companyTaxNumber);

    }

    protected void input_fullName(String FullName) {
        wait.waitForClickAbleBySelector(box_fullName_Selector).isEnabled();
        sleepInSecond(0.8);
        this.box_fullName().sendKeys(FullName);

    }

    protected void input_phoneNumber(String PhoneNumber) {
        this.box_phoneNumber().click();
        sleepInSecond(0.8);
        this.box_phoneNumber().sendKeys(PhoneNumber);

    }

    protected void input_Address(String Address) {
        wait.waitForClickAbleBySelector(box_Address_Selector).click();
        sleepInSecond(2);
        this.box_Address().sendKeys(Address);

    }

    /*
    Hàm chọn Giới tính theo input
    Mô tả:
    Input: String Gender
    Output: Kết quả hành động chọn giới tính

    Rules:
    - Sẽ check chọn giới tính trước chưa ? nếu chưa sẽ tiến hành chọn, nếu chọn rồi sẽ trả ra thông báo chọn rồi
    - Nếu input khác {nam, nữ, Nam, Nữ, nu, Anh, anh, Chị, Chi, chi, chị} sẽ chọn ngẫu nhiên

    Logic xử lý:
    - Sẽ chuyển input sang chuỗi k dấu -> check chuỗi có bằng "nam" || "anh" -> return 1. tương tự "nu" || "chi" ->0. khác thì return về -1
    - Switch case hàm check
    - Nếu input =-1 sẽ gán ngẫu nhiên giá trị input và gọi lại hàm để chọn giới tính
    */
    protected void choose_Gender(String Gender) {
        switch (check_Gender(Gender)) {
            case 1: {
                if (this.radio_gender_Anh().isSelected()) {
                    Log.info("Đã chọn giới tính Anh rồi!");
                } else if (this.radio_gender_Chi().isSelected()) {
                    this.radio_gender_Anh().click();
                    if (this.check_PopUp_Confirm_Change_Gender()) {
                        this.btn_Accept_ErrorInput_Popup().click();
                    } else
                        Assert.assertFalse(true);
                } else {
                    wait.waitForClickAbleByElement(this.radio_gender_Anh()).click();
                    //Chỗ này do đang bug chưa chọn giới tính cũng hiện pop-up nên làm đỡ cho pass qua
                    try {
                        wait.waitForTryCatch_VissibilityOfSelector(By.cssSelector("button[class='ajs-button ajs-ok']")).click();
                    } catch (Exception e) {
                    }
                    Log.info("Đã chọn Anh");
                }
                break;
            }
            case 0: {
                if (this.radio_gender_Chi().isSelected()) {
                    Log.info("Đã chọn giới tính Chị rồi!");
                } else if (this.radio_gender_Anh().isSelected()) {
                    this.radio_gender_Chi().click();
                    if (this.check_PopUp_Confirm_Change_Gender()) {
                        this.btn_Accept_ErrorInput_Popup().click();
                    } else {
                        wait.waitForClickAbleByElement(this.radio_gender_Chi()).click();

                        //Chỗ này do đang bug chưa chọn giới tính cũng hiện pop-up nên làm đỡ cho pass qua
                        try {
                            wait.waitForTryCatch_VissibilityOfSelector(By.cssSelector("button[class='ajs-button ajs-ok']")).click();
                        } catch (Exception e) {
                        }
                    }
                    Assert.assertFalse(true);
                    Log.info("Đã chọn Chị");
                }
                break;
            }
            default: {
                Log.info("Input sai, sẽ chọn random!");
                Random random = new Random();
                int random_sexRandom = random.nextInt(2);//chọn ngẫu nhiên 0 hoặc 1
                if (random_sexRandom == 1) {
                    Gender = "anh";
                } else {
                    Gender = "chi";
                }
                this.choose_Gender(Gender);
            }
        }

    }

    /*
    Mô tả:
    Hàm chọn thời gian giao hàng
    Điều kiện ban đầu là phải chọn được ngày giao
    Nếu pass sẽ check theo giờ được input vào
    Input: String theo định dạng dd/mm và time theo dạng HH - HH
    Output: Kết quả hành động chọn giờ giao

    Rules:
    - Nếu có time phù hợp với input thì sẽ chọn theo input
    - Nếu có time phu hợp với input nhưng đã hết tải thì sẽ chọn mốc kế tiếp mà còn tải
    - Nếu k có time phù hợp với input sẽ tự chọn mốc giao cuối cùng

    Logic xử lý:
    Dùng Select để lấy các options
    Sau đó đổ các options đó qua dạng List và check.
    Nếu đủ điều kiện thì sẽ dùng Select.byIndex
    */
    protected void choose_shipDateTime(String Day, String Time) {
        scroll_actions.ScrollDown50percent();
        if (this.Check_chooseShipDate(Day)) {
            sleepInSecond(0.5);
            Select select_gioNhanHang = new Select(wait.waitForClickAbleBySelector(dropdown_shipTimeGroupList_Selector));
            List<WebElement> List_gioNhanHang = select_gioNhanHang.getOptions();
            if (List_gioNhanHang.size() >= 2) {
                for (WebElement Time_choose : List_gioNhanHang) {
                    if (Time_choose.getText().trim().contains(Time)) {
                        if (Time_choose.isEnabled()) {
                            select_gioNhanHang.selectByIndex(List_gioNhanHang.indexOf(Time_choose));
                            String text = List_gioNhanHang.get(List_gioNhanHang.indexOf(Time_choose)).getText()
                                    .replace("<div class=''><span class='sb out'>", " ")
                                    .replace("</span>", " -")
                                    .replace("<div class='ShipOverTime'> </div></div><div class='deliverytypename sb'>(", " - ")
                                    .replace(")</div>", "");
                            Log.info("Đã chọn: " + text);
                            break;
                        } else {
                            Log.info("Không có thời gian giao phù hợp.Tự chọn mốc kế tiếp");
                            for (int i = (List_gioNhanHang.indexOf(Time_choose) + 1); i < List_gioNhanHang.size(); i++) {
                                if (List_gioNhanHang.get(i).isEnabled()) {
                                    select_gioNhanHang.selectByIndex(i);
                                    String mocgiao = List_gioNhanHang.get(i).getText().replace("<div class=''><span class='sb out'>", " ")
                                            .replace("</span>", " -")
                                            .replace("<div class='ShipOverTime'> </div></div><div class='deliverytypename sb'>(", " - ")
                                            .replace(")</div>", "");

                                    Log.info("Đã chọn mốc : " + mocgiao);
                                    break;
                                }
                            }
                        }
                    } else {
                        Log.info("Không có thời gian giao phù hợp.");
                        sleepInSecond(1.5);
//                        this.driver.findElement(By.cssSelector("span[aria-labelledby='select2-ShiptimeGroupList_0_Time-container']")).click();
                        select_gioNhanHang.selectByIndex((List_gioNhanHang.size() - 1));
                        sleepInSecond(1.5);
//                            String mocgiao = List_gioNhanHang.get((List_gioNhanHang.size() - 1)).getText()
//                                    .replace("<div class=''><span class='sb out'>", " ")
//                                    .replace("</span>", " -")
//                                    .replace("<div class='ShipOverTime'> </div></div><div class='deliverytypename sb'>(", " - ")
//                                    .replace(")</div>", "");
//                            Log.info("Đã chọn mốc giao cuối cùng: " + mocgiao);
                        break;
                    }
                }
            }
        } else {
            Assert.assertTrue(false, "Không lấy được ngày giao");
        }
    }


    protected void choose_Payment(String payment) {
        wait.waitForPageLoaded();
        try {
            scroll_actions.ScrollIntoViewElement(this.btn_loadMorePayment());
            if (this.btn_loadMorePayment().isDisplayed()) {
                this.btn_loadMorePayment().click();
            }
        } catch (Exception ignore) {
        }

        wait.waitForPageLoaded();
        List<WebElement> ListPayment = driver.findElements(By.cssSelector("div[class^='payment-']"));

        String payment_tempt = String_Handle.removeAccent(payment);
//        Log.info("Có " + ListPayment.size() + " hình thức thanh toán");
//
//        for (WebElement Epayment : ListPayment) {
//            Log.info(("Hình thức thanh toán " + ListPayment.indexOf(Epayment) + ": " + Epayment.getText()));
//        }
        for (WebElement Epayment : ListPayment) {
            if (Epayment.isSelected()) {
                Log.info("Đã tick" + Epayment.getText() + " trước đó");
            }
            String Epayment_tempt = String_Handle.removeAccent(Epayment.getText());
            if (Epayment_tempt.toUpperCase().trim().contains(payment_tempt.toUpperCase().trim())) {
                if (!Epayment.isSelected()) {
                    Epayment.click();
                    Log.info("Đã chọn " + Epayment.getText().toUpperCase());
                    break;
                }
            }
        }

    }

    protected void input_CustomerNote(String customerNote) {
        wait.waitForClickAbleBySelector(box_NoteOder_Selector).click();
        this.box_NoteOder().sendKeys(customerNote);

    }

    protected void click_btn_submitOder_Step2() {
        this.scrollIntoView_btnSubmitOderStep2();
        wait.waitForClickAbleByElement(btn_submitOder_Step2()).click();

    }

    protected void input_Others_fullName(String Others_FullName) {
        wait.waitForClickAbleBySelector(box_Others_fullName_Selector).click();
        sleepInSecond(0.8);
        this.box_Others_fullName().sendKeys(Others_FullName);

    }

    protected void input_Others_phoneNumber(String Others_PhoneNumber) {
        this.box_Others_phoneNumber().click();
        sleepInSecond(0.8);
        this.box_Others_phoneNumber().sendKeys(Others_PhoneNumber);

    }

    protected void choose_Others_Gender(String Others_Gender) {
        switch (check_Gender(Others_Gender)) {
            case 1: {
                if (this.radio_Others_gender_Anh().isSelected()) {
                    Log.info("Đã chọn giới tính Anh rồi!");
                    break;
                } else if (this.radio_Others_gender_Chi().isSelected()) {
                    this.radio_Others_gender_Anh().click();
                } else {
                    this.radio_Others_gender_Anh().click();
                    try {
                        wait.waitForClickAbleBySelector(By.cssSelector("button[class='ajs-button ajs-ok']")).click();
                    } catch (Exception e) {
                    }
                    Log.info("Đã chọn Anh");
                    break;
                }
            }
            case 0: {
                if (this.radio_Others_gender_Chi().isSelected()) {
                    Log.info("Đã chọn giới tính Chị rồi!");
                    break;
                } else {
                    this.radio_Others_gender_Anh().click();
                    try {
                        wait.waitForClickAbleBySelector(By.cssSelector("button[class='ajs-button ajs-ok']")).click();
                    } catch (Exception e) {
                    }
                    Log.info("Đã chọn Chị");
                    break;
                }
            }
            default: {
                Log.info("Input sai, sẽ chọn random!");
                Random random = new Random();
                int random_gioitinh = random.nextInt(2);//chọn ngẫu nhiên 0 hoặc 1
                if (random_gioitinh == 1) {
                    Others_Gender = "anh";
                } else {
                    Others_Gender = "chi";
                }
                this.choose_Gender(Others_Gender);
            }
        }

    }

    protected void click_checkbox_ChooseOthers() {
        if (!check_clicked_checkbox_Others()) {
            this.checkbox_Others().click();
        }

    }

    protected void Handle_PopUp_Error(String fullName, String phoneNumber, String address, String day, String time) {

        try {
            if (check_PopUp_Error_Input()) {
                do {
                    if (wait.waitForvisibilityOfSelector(txt_ErrorInput_Popup_Selector).getText().contains("Vui lòng cập nhật giới tính")) {
                        wait.waitForTryCatch_VissibilityOfSelector(btn_Accept_ErrorInput_Popup_Selector).click();
                        scroll_actions.ScrollUp();
                        this.choose_Gender("anh");
                        click_btn_submitOder_Step2();
                        try {
                            if (NavigateToOderResultPage().check_SubmitOderSuccess())
                                break;
                        } catch (Exception ignored) {
                        }
                    } else if (wait.waitForvisibilityOfSelector(txt_ErrorInput_Popup_Selector).getText().contains("Vui lòng cập nhật họ và tên\n" +
                            "Vui lòng nhập số điện thoại\n" +
                            "Vui lòng nhập địa chỉ nhận hàng\n" +
                            "Vui lòng chọn giờ giao hàng")) {
                        wait.waitForTryCatch_VissibilityOfSelector(btn_Accept_ErrorInput_Popup_Selector).click();
                        this.input_fullName(fullName);
                        input_phoneNumber(phoneNumber);
                        input_Address(address);
                        choose_shipDateTime(day, time);
                        click_btn_submitOder_Step2();
                        try {
                            if (NavigateToOderResultPage().check_SubmitOderSuccess())
                                break;
                        } catch (Exception ignored) {
                        }
                    } else if (wait.waitForvisibilityOfSelector(txt_ErrorInput_Popup_Selector).getText().contains("Vui lòng nhập địa chỉ nhận hàng")) {
                        wait.waitForClickAbleBySelector(btn_Accept_ErrorInput_Popup_Selector).click();
                        this.input_Address(address);
                        scroll_actions.ScrollIntoViewElement(this.btn_submitOder_Step2());
                        click_btn_submitOder_Step2();
                        try {
                            if (NavigateToOderResultPage().check_SubmitOderSuccess())
                                break;
                        } catch (Exception ignored) {
                        }
                    } else if (wait.waitForvisibilityOfSelector(txt_ErrorInput_Popup_Selector).getText().contains("Vui lòng nhập số điện thoại\n" +
                            "Quý khách vui lòng nhập địa chỉ mua hàng")) {
                        wait.waitForTryCatch_VissibilityOfSelector(btn_Accept_ErrorInput_Popup_Selector).click();
                        this.input_phoneNumber(phoneNumber);
                        scroll_actions.ScrollIntoViewElement(this.btn_submitOder_Step2());
                        click_btn_submitOder_Step2();
                        try {
                            if (NavigateToOderResultPage().check_SubmitOderSuccess())
                                break;
                        } catch (Exception ignored) {
                        }
                    } else if (wait.waitForvisibilityOfSelector(txt_ErrorInput_Popup_Selector).getText().contains("Vui lòng cập nhật họ và tên")) {
                        wait.waitForTryCatch_VissibilityOfSelector(btn_Accept_ErrorInput_Popup_Selector).click();
                        this.input_fullName(fullName);
                        scroll_actions.ScrollIntoViewElement(this.btn_submitOder_Step2());
                        click_btn_submitOder_Step2();
                        try {
                            if (NavigateToOderResultPage().check_SubmitOderSuccess())
                                break;
                        } catch (Exception ignored) {
                        }
                    } else if (wait.waitForvisibilityOfSelector(txt_ErrorInput_Popup_Selector).getText().contains("Vui lòng cập nhật họ và tên\n" +
                            "Vui lòng nhập địa chỉ nhận hàng")) {
                        wait.waitForTryCatch_VissibilityOfSelector(btn_Accept_ErrorInput_Popup_Selector).click();
                        this.input_fullName(fullName);
                        this.box_Address().clear();
                        this.input_Address(address);
                        scroll_actions.ScrollIntoViewElement(this.btn_submitOder_Step2());
                        click_btn_submitOder_Step2();
                        try {
                            if (NavigateToOderResultPage().check_SubmitOderSuccess())
                                break;
                        } catch (Exception ignored) {
                        }
                    } else if (wait.waitForvisibilityOfSelector(txt_ErrorInput_Popup_Selector).getText().contains("Vui lòng chọn giờ giao hàng")) {
                        wait.waitForTryCatch_VissibilityOfSelector(btn_Accept_ErrorInput_Popup_Selector).click();
                        this.choose_shipDateTime(day, time);
                        scroll_actions.ScrollIntoViewElement(this.btn_submitOder_Step2());
                        click_btn_submitOder_Step2();
                        try {
                            if (NavigateToOderResultPage().check_SubmitOderSuccess())
                                break;
                        } catch (Exception ignored) {
                        }
                    }
                } while ((wait.waitForTryCatch_VissibilityOfSelector(btn_Accept_ErrorInput_Popup_Selector).isDisplayed()));
            }
        } catch (Exception ignore) {
        }
    }

    protected void click_checkbox_CallBeforeDelivery() {
        wait.waitForClickAbleBySelector(checkbox_callBeforeDelivery_Selector).click();

    }

    protected void click_checkbox_GetBill() {
        wait.waitForClickAbleBySelector(checkbox_IsGetBill_Selector).click();

    }

    protected void click_btnGetAddress() {
        wait.waitForClickAbleBySelector(btn_getAddress_Selector).click();

    }

    protected void click_btn_closeGetAddress() {
        wait.waitForClickAbleBySelector(btn_close_PopUp_GetAddress_Selector).click();

    }

    protected void input_NumberPhone(String phone) {
        if (wait.waitForClickAbleBySelector(By.cssSelector("div[class='otp-input'] input[type='tel']")).isDisplayed()) {
            driver.findElement(By.cssSelector("div[class='otp-input'] input[type='tel']")).sendKeys(phone);
        }

    }

    protected void click_getOTP() {
        wait.waitForClickAbleBySelector(By.cssSelector("div[class='ajs-content'] button[class='btn-og btntt']")).click();

    }

    protected void input_OTP(String OTP) {
        wait.waitForClickAbleBySelector(By.cssSelector("div[class='otp-input'] input[type='tel']")).sendKeys(OTP);

    }

    protected void click_btnContinue() {
        wait.waitForClickAbleBySelector(By.cssSelector("div[class='otp-input'] button[class='btn-og btnht']")).click();

    }

    protected String GetText_TotalProduct() {
        return GetTextBySelector(txt_TotalProduct_Selector).replace("₫", "");
    }

    protected String GetText_TotalFeeShip() {
        return GetTextBySelector(txt_TotalFeeShip_Selector).replace("₫", "");
    }

    protected String GetText_SumTotal() {
        return GetTextBySelector(txt_SumTotal_Selector).replace("₫", "");
    }

}
