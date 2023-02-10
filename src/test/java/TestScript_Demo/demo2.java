package TestScript_Demo;

import Helpers.Logger.Log;
import Helpers.Logger.TestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class demo2 {
    @Test
    public void Demo_01_Cart() {

        // Setup chromedriver
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // phóng to trình duyệt full màn hình
        driver.get("https://www.bachhoaxanh.com/"); // đi đến URL

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // set timeout load cho trang web
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // đợi

        //B1: Chọn địa chỉ
        WebElement box_diaChiHienTai = driver.findElement(By.className("current_locate"));
        box_diaChiHienTai.click(); // click vào chỗ chọn địa chỉ
        WebElement tinhThanh = driver.findElement(By.xpath("//li[contains(text(),'TP. Hồ Chí Minh')]"));
        tinhThanh.click(); // chọn tỉnh thành

        WebElement quanHuyen = driver.findElement(By.xpath("//li[contains(text(),'TP. Thủ Đức (Q2, Q9, Thủ Đức)')]"));
        quanHuyen.click();
        WebElement phuongXa = driver.findElement(By.xpath("//li[contains(text(),'Phường An Khánh (Q2)')]"));
        phuongXa.click();


        sleep(3000); // dừng 3s cho load lại xong trang web
        // Thread.sleep(2000);

        String Titleweb = driver.getTitle(); // get Title của trang web

        //B2: Search sản phẩm
        WebElement box_Search = driver.findElement(By.xpath("//input[@id='text-search']"));
        box_Search.sendKeys("Bánh socola"); // Nhập từ khoá Bánh socola

        System.out.println("Title : " + Titleweb);

        WebElement btn_chonMua_SuggestSearch = driver.findElement(
                By.xpath("//form[1]/div[1]/div[1]/ul[1]/li[4]/div[1]/div[1]/div[2]/a[1]"));
//        WebElement txt_tenSanPham = driver.findElement(By.xpath("//div[1]/ul[1]/li[4]/div[1]/div[1]/div[1]/div[2]/a[1]/h3[1]"));
//        String tenSP = txt_tenSanPham.getText().trim().toString();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sleep(2000);
        btn_chonMua_SuggestSearch.click(); // nhấn mua

        //Điều hướng qua trang giỏ hàng == Click nút giỏ hàng trên header
        driver.navigate().to("https://www.bachhoaxanh.com/gio-hang");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        //CLick nút tiếp tục
        WebElement btn_DatHangStep1 = driver.findElement(By.xpath("//button[contains(text(),'ĐẶT HÀNG')]"));
        btn_DatHangStep1.click();
        WebElement rdb_gioiTinh_Anh = driver.findElement(By.xpath("//label[@for='ProfileItems_0_Gender1']"));
        // System.out.println("Lấy E giới tính anh");
        WebElement rdb_gioiTinh_Chi = driver.findElement(By.xpath("//label[@for='ProfileItems_0_Gender0']"));

        // System.out.println("Lấy E giới tính chị");
        if (rdb_gioiTinh_Anh.isSelected() == true) {
            Log.info("Đã chọn giới tính Anh rồi!");
        } else if (rdb_gioiTinh_Chi.isSelected() == true) {
            Log.info("Đã chọn giới tính Chị rồi!");
        } else {
            Log.info("Giới tính chưa được chọn!");
            rdb_gioiTinh_Chi.click();
            Log.info("Đã chọn giới tính là Chị");
        }

        //Nhập Họ Tên
        WebElement box_HoTen = driver.findElement(By.id("ProfileItems_0_CustomerName"));
        box_HoTen.click();
        sleep(1500);
        box_HoTen.sendKeys("IT test Automation");
        sleep(500);

        //Nhập Số Điện Thoại
        WebElement box_Sdt = driver.findElement(By.id("ProfileItems_0_CustomerPhone"));
        box_Sdt.click();
        sleep(1000);
        box_Sdt.sendKeys("0938727300");
        sleep(500);


        //Nhập địa chỉ
        WebElement box_Address = driver.findElement(By.id("ProfileItems_0_Address"));
        box_Address.click();
        sleep(1000);
        box_Address.sendKeys("IT test 123 - Automation");
        sleep(500);

        //Scroll xuống tới text "*Lưu ý quy định tòa nhà/chung cư khi yêu cầu mang lên lầu" ( trừ hao để thấy được ngày nhận và thời gian nhận hàng.
        //đã thử Scroll xuống dropdown ngày nhận thì bị che bởi header
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement txt_apartmentnote = driver.findElement(By.xpath("//strong[@class='apartmentnote']"));
        js.executeScript("arguments[0].scrollIntoView(true);", txt_apartmentnote);
        sleep(2000);


        //Lấy ngày nhận
//        int n = -1;
//
//        int i = 1;
//
//        do {
//            WebElement dateNhanHang ;
//            List<WebElement> List_dateNhanHang;
//
//            dateNhanHang = driver.findElement(By.cssSelector("#select2-ShiptimeGroupList_0_Date-container"));
//
//            dateNhanHang.click();
//            sleep(500);
//
//            List_dateNhanHang = driver.findElements(By
//                    .xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/span[1]/span[1]/span[2]/ul[1]/li"));
//
//            n = List_dateNhanHang.size();
//
//
//            if (n > 0) {
////                System.out.println("Có " + n + " ngày nhận hàng:");
////                for (WebElement otp_dateNhanHang1 : List_dateNhanHang) {
////                    System.out.println(
////                            " - " + (List_dateNhanHang.indexOf(otp_dateNhanHang1) + 1) + ": " +
////                                    otp_dateNhanHang1.getText());
////                }
//
//                for (WebElement otp_dateNhanHang1 : List_dateNhanHang) {
//                    if ((List_dateNhanHang.indexOf(otp_dateNhanHang1) + 1) == List_dateNhanHang.size()) {
//                        sleep(500);
//                        otp_dateNhanHang1.click();
//                        sleep(500);
//                        dateNhanHang = driver.findElement(By.cssSelector("#select2-ShiptimeGroupList_0_Date-container"));
//                        String ngaynhan_Dachon = dateNhanHang.getText();
//                        System.out.println(" Đã chọn ngày " + ngaynhan_Dachon);
//                    }
//                }
//
//                sleep(2000);
//                //Lấy time nhận hàng
//                WebElement txt_timeNhanHang = driver
//                        .findElement(By.xpath(
//                                "//*[@class='select2-selection__rendered' and @id='select2-ShiptimeGroupList_0_Time-container']"));
//                txt_timeNhanHang.click();
//
//                List<WebElement> List_timeNhanHang = driver
//                        .findElements(By.xpath("//div[1]/form[1]/span[1]/span[1]/span[2]/ul[1]/li[1]/ul[1]/li"));
//
//
////                System.out.println("Ngày " + dateNhanHang.getText() + " có " + List_timeNhanHang.size() + " khung giờ sau: ");
////                for (WebElement otp_timeNhanHang : List_timeNhanHang) {
////                    System.out.println("- " + otp_timeNhanHang.getText());
////                }
//
//                //Chọn time nhận hàng
//                for (WebElement otp_timeNhanHang : List_timeNhanHang) {
//                    if ((List_timeNhanHang.indexOf(otp_timeNhanHang) + 1) == List_timeNhanHang.size()) {
//                        otp_timeNhanHang.click();
//                        sleep(500);
//                        WebElement txt_timeNhanHang_DaChon = driver
//                                .findElement(By.xpath("//div[1]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/span[1]"));
//                        System.out.println("Đã chọn khung giờ " + txt_timeNhanHang_DaChon.getText());
//                    }
//                }
//                sleep(300);
//            } else {
//
//                System.out.println("Chọn ngày giao lần " + i + " chưa được");
//                i++;
//                System.out.println("Chọn ngày giao lần " + i);
//                if (i == 3) {
//                    System.out.println("Không có tải giao");
//                    break;
//                }
//
//            }
//        } while (n <= 0);

        Select select_Ngay = new Select(driver.findElement(By.cssSelector("#ShiptimeGroupList_0_Date")));
        select_Ngay.selectByIndex(2);

        sleep(2);
        Select sl_gio = new Select(driver.findElement(By.cssSelector("#ShiptimeGroupList_0_Time")));
        sl_gio.selectByIndex(3);



        //Scroll xuống tới Elemt Xem thêm hình thức thanh toán
        WebElement morePayment = driver.findElement(By.xpath("//div[@class='loadMorePaymentType']"));
        js.executeScript("arguments[0].scrollIntoView(true);", morePayment);
        morePayment.click();

        //Chọn hình thức thanh toán
        List<WebElement> ListPayment = driver.findElements(By.cssSelector("div[class^='payment-']"));
        System.out.println("Có " + ListPayment.size() + " hình thức thanh toán");


//        for (WebElement payment : ListPayment) {
//
//            System.out.println("Hình thức thanh toán " + (ListPayment.indexOf(payment) + 1) + ": " + payment.getText());
//
//        }

        String httt = "Tiền mặt khi nhận hàng";
        for (WebElement payment : ListPayment) {
            if (payment.getText().trim().toString().equals(httt)) {
                if(payment.isSelected())
                {
                    Log.info("Đã chọn hình thức thanh toán " + httt.toUpperCase() + "trước đó");
                    break;
                }
                else{
                    payment.click();
                    Log.info("Chọn hình thức thanh toán " +httt.toUpperCase());
                    break;
                }

            }
        }
        sleep(2000);

        //Nhập ghi chú
        String ghiChu = "IT Automation test  đừng giao, huỷ giùm thì được.";
        WebElement box_ghiChu = driver.findElement(By.name("CustomerNote"));
        box_ghiChu.click();
        sleep(500);
        box_ghiChu.sendKeys(ghiChu);

        //Lấy số tiền ở ghb2 để lát qua trang ĐHTC verify
        WebElement txt_TongDonHang = driver.findElement(By.cssSelector("div[class='totalbox'] label"));
        String tongdonhang = txt_TongDonHang.getText().trim().toString();
        System.out.println("Tổng tiền đơn hàng ở B2 : " + tongdonhang);


        WebElement btn_datHang_Step2 = driver.findElement(By.xpath("//a[contains(text(),'XÁC NHẬN ĐƠN HÀNG')]"));

        js.executeScript("arguments[0].scrollIntoView(true);", btn_datHang_Step2);
        btn_datHang_Step2.click();

        sleep(3000);



        System.out.println("============================== THÔNG TIN ĐƠN HÀNG ==============================");

        String link = driver.getCurrentUrl();
        System.out.println("Link đặt hàng thành công: " + link);

        WebElement txt_datHangThanhCong = driver.findElement(By.xpath("//p[@class='msg message-thanks']"));
        System.out.println("Text : " + txt_datHangThanhCong.getText());

        WebElement txt_nguoiNhan = driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]"));
        System.out.println(txt_nguoiNhan.getText());


        WebElement txt_thoiGianNhanHang = driver.findElement(By.xpath("//div[1]/div[2]/ul[1]/li[4]"));
        System.out.println("Thời gian nhận hàng: " + txt_thoiGianNhanHang.getText());

        WebElement txt_ghiChu = driver.findElement(By.xpath("//div[1]/div[2]/ul[1]/li[5]//span[1]"));
        System.out.println("Ghi chú đơn hàng: " + txt_ghiChu.getText());
        WebElement txt_diaChiNhanHang = driver.findElement(By.xpath("//div[1]/div[2]/ul[1]/li[3]"));
        System.out.println("Địa chỉ nhận hàng: " + txt_diaChiNhanHang.getText());



        WebElement txt_tongTien = driver.findElement(By.xpath("//div[3]/div[2]/b[1]"));
        String tongtien_actual = txt_tongTien.getText().trim().toString();
        System.out.println("Tổng tiền: " + tongtien_actual);

        //Verify Tổng tiền đơn hàng
        Assert.assertEquals(tongtien_actual, tongdonhang);
        System.out.println("Verify okela");

        WebElement txt_thanhToan = driver.findElement(By.xpath("//div[2]/div[1]/div[1]/div[3]/div[3]/span[1]"));
        System.out.println(txt_thanhToan.getText());

        sleep(3000);

        WebElement btn_TrangChu = driver.findElement(By.cssSelector("a[class='btn-home']"));
        js.executeScript("arguments[0].scrollIntoView(true);", btn_TrangChu);

        sleep(1000);

        WebElement btn_HuyDonHang = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/a[1]"));
        btn_HuyDonHang.click();

//        js.executeScript("document.getElementsByClassName('nobuy cancelbtn ').click();");
        sleep(3000);

        List<WebElement> checkbox_huyDonHang = driver.findElements(By.cssSelector("[id^='checkbox_']"));

        int m = checkbox_huyDonHang.size();

        System.out.println("Có " + m + " sự lựa chọn");

        //clcik vào checkbox lý do khác
        js.executeScript("document.getElementById('checkbox_7').click()");
        sleep(1500);

        //nhập lý do khác
        driver.findElement(By.xpath("//textarea[contains(@placeholder,'Nhập nội dung góp ý')]")).sendKeys("IT test");

        sleep(500);

        //nhấn nút huỷ
        driver.findElement(By.cssSelector(".submit.submit-cancel")).click();
        sleep(3000);
        // driver.close();

        driver.quit();

    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
