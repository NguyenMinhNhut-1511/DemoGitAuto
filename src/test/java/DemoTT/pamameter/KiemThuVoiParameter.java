package DemoTT.pamameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class KiemThuVoiParameter {
    WebDriver driver;

    @Parameters({"thegioididong", "url"})
    @Test
    public void kiemthutieudetrangweb(String ten, String url){
        driver.get(ten);
        System.out.println("kiểm tra tiêu đề trang" + " " + ten + " "+ "CurrentUrl " + url);
        assertEquals(driver.getTitle(), "Thegioididong.com - Điện thoại, Laptop, Phụ kiện, Đồng hồ chính hãng");
        assertEquals(driver.getCurrentUrl(), "https://www.dienmayxanh.com/");

    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("trước các test thực hiện mở trình duyệt");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        System.out.println("Sau các test thực hiện đóng trình duyệt");
    }
}
