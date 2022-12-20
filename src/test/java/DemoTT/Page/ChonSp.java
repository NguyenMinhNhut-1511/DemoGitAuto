package DemoTT.Page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class ChonSp {
    private WebDriver driver;
    private By Chonmua= By.xpath("//li[3]//div[1]//button[1]");
    private By GioHang=By.xpath("//a[contains(text(),'Xem giỏ hàng')]");

    public ChonSp(WebDriver driver) {
        this.driver = driver;
    }

    public void scroll()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver; //khởi tạo biến js
            js.executeScript("window.scrollTo(0,200)"); // scroll trang
            sleep(1000);
            js.executeScript("window.scrollTo(200,0)"); // scroll trang
            sleep(1500);
    }
    public void muasp(){
    driver.findElement(Chonmua).click();
    }
    public void giohang() {
    driver.findElement(GioHang).click();
    }
    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void muaspgiohang(){
    log.info("Chon mua sp");
    scroll();
    muasp();
    log.info("GioHang");
    giohang();
    }
    static Logger log = LogManager.getLogger(ChonSp.class.getName());
    public static void main(String[]args){
        log.debug("debug log");
        log.error("error log");
        log.info("info log");
    }
}