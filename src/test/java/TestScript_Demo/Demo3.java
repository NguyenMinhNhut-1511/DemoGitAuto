package TestScript_Demo;

import Helpers.Logger.Log;
import Helpers.Logger.TestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Listeners(TestListener.class)
public class Demo3 {

    @Test
    public void Case1() {
        //khởi tạo chromedriver
        WebDriverManager.chromedriver().setup(); //khởi tạo chromedriver
        WebDriver driver = new ChromeDriver();
        //phóng to chrome full màn hình
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //đi đến trang bachhoaXANH
        driver.navigate().to("https://www.bachhoaxanh.com/");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        //Chọn địa chỉ

        try {
            WebElement box_diaChiHienTai = driver.findElement(By.xpath("//div[3]/div[1]/div[1]/div[2]"));

            box_diaChiHienTai.click(); // click vào chỗ chọn địa chỉ

            WebElement btn_dongChonDiaChi = driver.findElement(By.xpath("//a[contains(text(),'✕')]"));


            List<WebElement> List_tinhThanh = driver.findElements(By.xpath("//div[5]/div[2]/ul[1]/li"));
//        Log.info("Có " + List_tinhThanh.size() + " tỉnh thành: ");
            String tinhThanh_dachon = null;
            String quanHuyen_dachon = null;
            String phuongXa_dachon = null;
//        for (WebElement tinhThanh : List_tinhThanh) {
//            Log.info((List_tinhThanh.indexOf(tinhThanh) + 1 + ") " + tinhThanh.getText()));
//        }

            for (WebElement tinhThanh : List_tinhThanh) {
                if (tinhThanh.getText().trim().toString().equals("Cần Thơ")) {
                    tinhThanh_dachon = tinhThanh.getText();
                    tinhThanh.click();
                    sleep(500);
                    Log.info("Đã chọn " + tinhThanh_dachon);
                }
            }

            List<WebElement> List_quanHuyen = driver.findElements(By.xpath("//div[3]/div[6]/div[2]/ul[1]/li"));
//        Log.info(tinhThanh_dachon + " có " + List_quanHuyen.size() + " quận/huyện: ");

//        for (WebElement quanhuyen : List_quanHuyen) {
//            Log.info((List_quanHuyen.indexOf(quanhuyen) + 1 + ") " + quanhuyen.getText()));
//        }

            for (WebElement quanhuyen : List_quanHuyen) {
                if (quanhuyen.getText().trim().toString().equals("Huyện Vĩnh Thạnh")) {
                    quanHuyen_dachon = quanhuyen.getText();
                    quanhuyen.click();
                    sleep(500);
                    Log.info("Đã chọn " + quanHuyen_dachon);
                }
            }


//        btn_dongChonDiaChi.click();
//        sleep(5000);
////        WebDriverWait wait = new WebDriverWait(driver,10);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

//        box_diaChiHienTai = driver.findElement(By.xpath("//div[3]/div[1]/div[1]/div[2]/span[2]"));
////        wait.until(ExpectedConditions.textToBePresentInElement((WebElement) By.xpath("//div[3]/div[1]/div[1]/div[2]"), "Chọn tỉnh thành, quận huyện để xem chính xác tồn kho"));
//        String actual_text = box_diaChiHienTai.getText();
//        String expect_text = "Chọn tỉnh thành, quận huyện để xem chính xác tồn kho";


            List<WebElement> List_phuongXa = driver.findElements(By.xpath("//div[7]/div[2]/ul[1]/li"));
//        Log.info(quanHuyen_dachon + " có " + List_phuongXa.size() + " phường/xã: ");

//        for (WebElement phuongxa : List_phuongXa) {
//            Log.info((List_phuongXa.indexOf(phuongxa) + 1 + ") " + phuongxa.getText()));
//        }

            for (WebElement phuongxa : List_phuongXa) {
                if (phuongxa.getText().trim().toString().equals("Xã Thạnh Tiến")) {
                    phuongXa_dachon = phuongxa.getText();
                    phuongxa.click();
                    //sleep(2000);
                    Log.info("Đã chọn " + phuongXa_dachon);
                }
            }

            Log.info("Đã chọn - " + tinhThanh_dachon + " - " + quanHuyen_dachon + " - " + phuongXa_dachon);

            String actualText = box_diaChiHienTai.getText().trim().toString();


            Assert.assertEquals(actualText, "Giao tại: Huyện Vĩnh Thạnh, Cần Thơ Thay đổi1");

            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }

    }

    @Test
    public void Case2() {

        //khởi tạo chromedriver
        WebDriverManager.chromedriver().setup(); //khởi tạo chromedriver
        WebDriver driver = new ChromeDriver();
        //phóng to chrome full màn hình
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //đi đến trang bachhoaXANH
        driver.navigate().to("https://www.bachhoaxanh.com/");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        //Chọn địa chỉ
        WebElement box_diaChiHienTai = driver.findElement(By.xpath("//div[3]/div[1]/div[1]/div[2]/span[2]"));

        box_diaChiHienTai.click(); // click vào chỗ chọn địa chỉ

        WebElement btn_dongChonDiaChi = driver.findElement(By.xpath("//a[contains(text(),'✕')]"));


        List<WebElement> List_tinhThanh = driver.findElements(By.xpath("//div[5]/div[2]/ul[1]/li"));
//        Log.info("Có " + List_tinhThanh.size() + " tỉnh thành: ");
        String tinhThanh_dachon = null;
        String quanHuyen_dachon = null;
        String phuongXa_dachon = null;
//        for (WebElement tinhThanh : List_tinhThanh) {
//            Log.info((List_tinhThanh.indexOf(tinhThanh) + 1 + ") " + tinhThanh.getText()));
//        }

        for (WebElement tinhThanh : List_tinhThanh) {
            if (tinhThanh.getText().trim().toString().equals("Cần Thơ")) {
                tinhThanh_dachon = tinhThanh.getText();
                tinhThanh.click();
                sleep(500);
                Log.info("Đã chọn " + tinhThanh_dachon);
            }
        }

        List<WebElement> List_quanHuyen = driver.findElements(By.xpath("//div[3]/div[6]/div[2]/ul[1]/li"));
//        Log.info(tinhThanh_dachon + " có " + List_quanHuyen.size() + " quận/huyện: ");

//        for (WebElement quanhuyen : List_quanHuyen) {
//            Log.info((List_quanHuyen.indexOf(quanhuyen) + 1 + ") " + quanhuyen.getText()));
//        }

        for (WebElement quanhuyen : List_quanHuyen) {
            if (quanhuyen.getText().trim().toString().equals("Huyện Vĩnh Thạnh")) {
                quanHuyen_dachon = quanhuyen.getText();
                quanhuyen.click();
                sleep(500);
                Log.info("Đã chọn " + quanHuyen_dachon);
            }
        }
        btn_dongChonDiaChi.click();
        sleep(5000);

////        WebDriverWait wait = new WebDriverWait(driver,10);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        box_diaChiHienTai = driver.findElement(By.xpath("//div[3]/div[1]/div[1]/div[2]/span[2]"));
//        wait.until(ExpectedConditions.textToBePresentInElement((WebElement) By.xpath("//div[3]/div[1]/div[1]/div[2]"), "Chọn tỉnh thành, quận huyện để xem chính xác tồn kho"));
        String actual_text = box_diaChiHienTai.getText();
        String expect_text = "Chọn tỉnh thành, quận huyện để xem chính xác tồn kho";

        Assert.assertEquals(actual_text, expect_text);

        Log.info("Testcase 2 đúng");

        driver.quit();

    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            Log.info(ex.getMessage());
        }
    }

}


