package DemoTT.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Name;

public class GioHang {
    private WebDriver driver;
    private By HoTen = By.cssSelector("#cusName");
    private By SDT = By.cssSelector("#cusPhone");

    private By dropdownTP = By.cssSelector("form[class='active'] div[class='btn-click country'] button[type='button']");

    private By dropdownQH = By.cssSelector("form[class='active'] div[class='btn-click district'] button[type='button']");

    private By dropdownPX = By.cssSelector("form[class='active'] div[class='wards'] button[type='button']");

    private By Nhapdiachi = By.cssSelector("#cusAddr");
    public GioHang(WebDriver driver) {
        this.driver = driver;
    }

    public void ThongTinDH(String Name,String sdt){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,300)");
        WebElement NhapTen = driver.findElement(HoTen);
        if (NhapTen.isDisplayed()) {
            NhapTen.sendKeys(Name);
        }
        WebElement NhapSDT = driver.findElement(SDT);
        if (NhapSDT.isDisplayed()) {
            NhapSDT.sendKeys(sdt);
        }
    }
    public void Diachi(String diachi) {
        WebElement NhapDiaChi = driver.findElement(Nhapdiachi);
        if (NhapDiaChi.isDisplayed()) {
            NhapDiaChi.sendKeys(diachi);
        }
        driver.findElement(dropdownTP).click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //HCM
        js.executeScript("document.querySelector(\"form[class='active'] div[class='btn-click country'] button[type='button']\").click()");
        driver.findElement(dropdownQH).click();
        sleep(2000);
        //Thu Duc
        js.executeScript("document.querySelector(\"div[class='btn-click district'] aside:nth-child(1) span:nth-child(1)\").click()");
        driver.findElement(dropdownPX).click();
        sleep(2000);
        //An Khanh
        js.executeScript("document.querySelector(\"div[class='wards'] aside:nth-child(1) span:nth-child(1)\").click()");

    }
    public void scroll(){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"button[type='button'] b\").click()");
        WebElement element7 = driver.findElement(By.xpath("//button[@class='submitorder']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element7);
    }
    public void OrderGiao(String Name,String sdt,String diachi){
        sleep(4000);
        log.info("GioiTinh");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element3 = driver.findElement(By.xpath("//div[@class='sex-customer']//span[contains(text(),'Anh')]//i[@class='cartnew-choose']"));
        js.executeScript("arguments[0].click();", element3);
        log.info("Nhap thong tin DH");
        ThongTinDH(Name,sdt);
        log.info("Diachi");
        Diachi(diachi);
        sleep(3000);
        scroll();
        //Radio button gi???i t??nh Nam
//    js.executeScript("document.querySelector(\"body > div:nth-child(10) > section:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(1) > span:nth-child(2) > i:nth-child(1)\").click();");
        log.info("DatHang");
        sleep(1000);
        WebElement element4 = driver.findElement(By.xpath("//h4[contains(text(),'????n h??ng:')]"));
        //Button ?????t h??ng
        js.executeScript("arguments[0].style.border='3px solid red'", element4); // Highlight c???m text "?????t h??ng"
        sleep(5000);
//    js.executeScript("document.querySelector(\"button[type='button'] b\").click()");
    }
    static Logger log = LogManager.getLogger(GioHang.class.getName());
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
