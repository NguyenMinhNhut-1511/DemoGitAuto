package DemoTT.Page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LSMH {
    WebDriver driver;

    private By SDT = By.id("txtPhoneNumber");
    private By clicktieptuc = By.xpath("//form[@id='frmGetVerifyCode']//button[@type='submit'][contains(text(),'Tiếp tục')]");

    private By OTP=By.name("txtOTP");

    private By dangnhap= By.xpath("//form[@id='frmSubmitVerifyCode']//button[@type='submit'][contains(text(),'Tiếp tục')]");


    public LSMH(WebDriver driver){
        {
            this.driver = driver;
        }
    }

    public void loggin(String mainWindow) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Link tới trang dang nhap
        js.executeScript("window.open('https://staging.nhathuocankhang.com/lsmh/dang-nhap','_blank');");
        //String mainWindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        for (String child : set) {
            if (!mainWindow.equals(child)) {
                driver.switchTo().window(child);
                sleep(1000);
            }
        }
    }
    public void DangNhap(String sdt){
        WebElement NhapSDT = driver.findElement(SDT);
        if (NhapSDT.isDisplayed()) {
            NhapSDT.sendKeys(sdt);
        }
        driver.findElement(clicktieptuc).click();
        WebElement NhapOTP = driver.findElement(OTP);
        NhapOTP.sendKeys("2106");
        driver.findElement(By.xpath("//button[contains(text(),'Xác nhận')]")).submit();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element5 = driver.findElement(By.xpath("//b[@class='pending order-status']"));
        js.executeScript("arguments[0].style.border='3px solid red'", element5); // Highlight cụm text "chờ xác nhận"
    }
    public void DNLSMH(String sdt){
        log.info("DangNhap");
        DangNhap(sdt);
    }
    public void HuyDH(String mainWindow1) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //String mainWindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        for (String child : set) {
            if (!mainWindow1.equals(child)) {
                driver.switchTo().window(child);
                driver.findElement(By.xpath("//a[contains(text(),'Hủy')]")).click();
                sleep(2000);
                WebElement element6 = driver.findElement(By.xpath("//span[contains(text(),'Đổi ý, không mua nữa')]//i[@class='cartnew-choose']"));
                js.executeScript("arguments[0].click();", element6);
                driver.findElement(By.xpath("//button[@class='cancel-order-popup__content__actions__button cart-result-fr close-cancel-popup']")).click();
                driver.findElement(By.xpath("//button[@class='success-cencell-popup']")).click();
                sleep(5000);
            }
        }
        driver.switchTo().window(mainWindow1);
        driver.navigate().refresh();
        sleep(2000);
        WebElement element8 = driver.findElement(By.xpath("//body/section[@class='wrapper']/div[@class='main']/div[@id='list_order']/div[1]/div[1]/b[1]"));
        js.executeScript("arguments[0].style.border='3px solid red'", element8); // Highlight cụm text "đã huỷ"
    }

//    public void ReloadTrang(String mainWindow2){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Set<String> set = driver.getWindowHandles();
//        for (String child : set) {
//            if (!mainWindow2.equals(child)) {
//                driver.switchTo().window(child);
//                driver.navigate().refresh();
//                WebElement element8 = driver.findElement(By.xpath("//body/section[@class='wrapper']/div[@class='main']/div[@id='list_order']/div[1]/div[1]/b[1]"));
//                js.executeScript("arguments[0].style.border='3px solid red'", element8); // Highlight cụm text "đã huỷ"
//                //js.executeScript("alert('Kết thúc tiến trình test');");
//            }
//        }
//    }
    static Logger log = LogManager.getLogger(LSMH.class.getName());
    public static void main(String[]args){
        log.debug("debug log");
        log.error("error log");
        log.info("info log");
    }
    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
