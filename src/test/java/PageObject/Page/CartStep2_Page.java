package PageObject.Page;

import Helpers.Logger.Log;
import PageObject.Page_Model.*;
import org.openqa.selenium.WebDriver;

public class CartStep2_Page extends CartStep2 {


    public CartStep2_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public CartStep2_Page input_CustomerInfo(String Gender, String PhoneNumber, String FullName, String Address) {
        input_fullName(FullName);
                choose_Gender(Gender);
                input_phoneNumber(PhoneNumber);
                input_Address(Address);
        return this;
    }

    public CartStep2_Page input_OthersInfo(String Others_Gender, String Others_PhoneNumber, String Others_FullName) {
        click_checkbox_ChooseOthers();
        input_fullName(Others_FullName);
        choose_Gender(Others_Gender);
        input_phoneNumber(Others_PhoneNumber);
        return this;
    }

    public CartStep2_Page choose_ShipDateTime(String Ship_Day, String Ship_Time) {
        choose_shipDateTime(Ship_Day, Ship_Time);
        return this;
    }

    public CartStep2_Page choose_PaymentAndInput_Note(String Payment, String noteOder) {
        choose_Payment(Payment);
        input_CustomerNote(noteOder);
        return this;
    }

    public CartStep2_Page click_SubmitOder(String fullName, String phoneNumber, String address, String day, String time) {
        click_btn_submitOder_Step2();
        Handle_PopUp_Error(fullName, phoneNumber, address, day, time);
        return this;
    }

    public CartStep2_Page GetBill(String companyName, String companyAddress, String companyTaxnumber) {
        if (!check_checkboxGetBill_isSelected()) {
            click_checkbox_GetBill();
        }
        input_companyName(companyName);
        input_companyAddress(companyAddress);
        input_companyTaxNumber(companyTaxnumber);
        return this;
    }

    public CartStep2_Page GetAddress(String PhoneNumber, String OTP) {
        click_btnGetAddress();
        input_phoneNumber(PhoneNumber);
        click_getOTP();
        input_OTP(OTP);
        click_btnContinue();
        return this;
    }

    public String GetTotalProduct() {
        String total = GetText_TotalProduct();
        Log.info("Tổng tiền sản phẩm" + total);
        return total;
    }

    public String GetFeeShip() {
        String total = GetText_TotalFeeShip();
        Log.info("Tổng tiền Ship" + total);
        return total;
    }

    public String GetSumTotal() {
        String total = GetText_SumTotal();
        Log.info("Tổng đơn hàng: " + total);
        return total;
    }

}
