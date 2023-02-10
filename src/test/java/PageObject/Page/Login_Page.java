package PageObject.Page;

import PageObject.Page_Model.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.Wait.Sleep.*;

public class Login_Page extends Login {


    public Login_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Phương thức này dùng để nhập các thông tin để đăng nhập và hành động gõ enter trên bàn phím để đăng nhập
      * @param PhoneNumber Số điện thoại
     * @param Password Mật khẩu
     * @return về đối tượng LoginPage (dùng để gọi những hàm khác của object này)
     */
    public Login_Page input_InfoLogin(String PhoneNumber, String Password) {
        check_BlockBHX();
        input_userName(PhoneNumber); //Nhập vào sđt
        click_btnSubmit();    //Click nút Tiếp Tục
        input_passWord(Password);//Nhập vào password
        keyboard_actions.enter_Keyboard();// Hành động enter trên bàn phím
        return this;
    }

    /**
     * Phương thức dùng để Verify khi đăng nhập thành công
     * @param expect_CustomerName Tên đúng của tài khoản đã đăng nhập
     */
    public Login_Page Verify_LoginSuccess(String expect_CustomerName) {
        wait.waitForPageLoaded();
        NavigateToHistoriesPage()
                .Verify_CustomerName(expect_CustomerName)
                .Verify_Link();
        return this;
    }

    /**
     *Phương thức này dùng để Verify khi đăng nhập thất bại
     *
     */
    public Login_Page Verify_LoginFail() {
        wait.waitForPageLoaded();
        verify_warningDangNhap();
        return this;
    }

/**
 * Xử lý khi chặn vào trang đăng nhập BHX, dùng trang web chặn khi login
 * Nếu không chặn sẽ không cần dùng đến
 */
    private void check_BlockBHX() {
        try {
            String text = driver.findElement(By.tagName("h1")).getText();
            if (!text.isEmpty()) {
                sleepInSecond(1.5);
                driver.navigate().refresh();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
