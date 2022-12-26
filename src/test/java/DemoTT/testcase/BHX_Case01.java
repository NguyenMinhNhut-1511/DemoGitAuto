package DemoTT.testcase;

import DemoTT.base.Setup;
import DemoTT.page.BHX_TrangChu;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// kế thừa class Setup
public class BHX_Case01 extends Setup {

    // khai báo biến "driver" có kiểu dữ liệu là WebDriver
    // để dùng ở phần ở dưới
    private WebDriver driver;

    // khai báo biến
    BHX_TrangChu bhx_trangchu;

    Setup bhx_setup;


    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void ClickBoxSearch () {
        bhx_trangchu = new BHX_TrangChu(driver);
        bhx_trangchu.ClickBoxSearch();
        // Sử dụng method ở setup
        bhx_setup = new Setup();
        bhx_setup.PrintWord("Sử dụng method ở setup");
    }

}