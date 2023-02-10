package TestScript_Demo;


import Helpers.Capture.Capture;
import Helpers.ExcelHelpers.Excel_Helpers;
import Helpers.Logger.Log;
import Helpers.Logger.TestListener;
import PageObject.Page.Home_Page;
import Utils.Constant;
import Utils.Wait.WaitFor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static Init.Init.*;


@Listeners(TestListener.class)

public class DatHangFlows {
    WebDriver driver;
    Home_Page Home_page;
    WaitFor wait;
    Excel_Helpers excel;
    int i = 0;


    String Province, District, Ward, Expect_Location;
    String SearchProduct_Keyword;
    String Cus_Gender, Cus_phoneNumber, Cus_Name, Address;
    String Ship_Day, Ship_Time;
    String Payment, NoteOder;
    String Expect_InfoCustomer, Expect_ShipAddress;


    @BeforeSuite (alwaysRun = true)
    public void OpenBrowser() {
        driver = getChromeDriver();
        GotoURL(Constant.URL);
        Home_page = new Home_Page(driver);
        wait = new WaitFor(driver);
        wait.waitForPageLoaded();
//        String screenName = DatHangFlows.class.getName().replace("TestScript_Demo.", "");
//        Capture.startRecord(screenName);
        excel = new Excel_Helpers();
    }

    @AfterSuite
    public void CloseBrowser() {
//        DeleteAllCookie();
            TearDown();
//        Capture.stopRecord();
    }

    @BeforeMethod
    public void getDataFromExcelFile() throws Exception {
        i++;
        excel.SetExcelFile("DatHang.xlsx", "Sheet1");

        Province = excel.getCellData("province", i);
        District = excel.getCellData("district", i);
        Ward = excel.getCellData("ward", i);
        SearchProduct_Keyword = excel.getCellData(" SearchProduct_Keyword", i);
        Cus_Gender = excel.getCellData("Gender", i);
        Cus_Name = excel.getCellData("Cus_Name", i);
        Cus_phoneNumber = excel.getCellData("Cus_phoneNumber", i);
        Address = excel.getCellData("Address", i);
        Ship_Day = excel.getCellData("Ship_Day", i);
        Ship_Time = excel.getCellData("Ship_Time", i);
        Payment = excel.getCellData("Payment", i);
        NoteOder = excel.getCellData("NoteOder", i);

        Expect_Location = Ward + " " + District + " " + Province;
        Expect_InfoCustomer = Cus_Gender + " " + Cus_Name + ", " + Cus_phoneNumber;
        Expect_ShipAddress = Address + " " + Expect_Location;
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        String screenName = DatHangFlows.class.getName().replace("TestScript_Demo.", "");
        // Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Step
        // Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        // passed = SUCCESS và failed = FAILURE
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Capture.captureScreenshot(driver, screenName);
                Log.info("Đã chụp màn hình: " + result.getName());
            } catch (Exception e) {
                Log.info("Exception while taking screenshot " + e.getMessage());
            }
        }
        driver.manage().deleteAllCookies();
        Log.info("Đã xoá cookie");
    }

    @Test(priority = 1)
    public void DatHangKhoDC() {
        try {
            Home_page
                    .choose_Location(Province, District, Ward)
//                .verify_Location(Expect_Location)
                    .Search_Product(SearchProduct_Keyword)
                    .NavigateToSearchResultPage()
                    .AddProductRandomToCart()
                    .NavigateToHomePage()
                    .click_buttonCart()
                    .NavigateToCartStep1Page()
                    .click_Submit_Step1()
                    .NavigateCartStep2Page()
                    .input_CustomerInfo(Cus_Gender, Cus_phoneNumber, Cus_Name, Address)
                    .choose_ShipDateTime(Ship_Day, Ship_Time);

//
            String txt_SumTotal = Home_page.NavigateCartStep2Page().GetSumTotal();

            Home_page.NavigateCartStep2Page()
                    .choose_PaymentAndInput_Note(Payment, NoteOder)
                    .click_SubmitOder(Cus_Name, Cus_phoneNumber, Address, Ship_Day, Ship_Time);

//            Home_page.NavigateToOderResultPage()
//                    .Verify_OderInfo(Expect_InfoCustomer, Expect_ShipAddress, NoteOder, "", "", txt_SumTotal);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(false, "Case thất bại");
        }finally {
            driver.manage().deleteAllCookies();
            Log.info("xoá cookie");
            driver.get(Constant.URL);
            Log.info("trang chủ");
        }

    }

    @Test(priority = 2)
    public void DatHangKhoSieuThi() {

        try{
            Home_page
                    .choose_Location(Province, District, Ward)
//                .verify_Location(Expect_Location)
                    .Search_Product(SearchProduct_Keyword)
                    .NavigateToSearchResultPage()
                    .AddProductRandomToCart()
                    .NavigateToHomePage()
                    .click_buttonCart()
                    .NavigateToCartStep1Page()
                    .click_Submit_Step1()
                    .NavigateCartStep2Page()
                    .input_CustomerInfo(Cus_Gender, Cus_phoneNumber, Cus_Name, Address)
                    .choose_ShipDateTime(Ship_Day, Ship_Time);

//
//            String txt_TotalProduct = Home_page.NavigateCartStep2Page().GetText_TotalProduct();
//            String txt_TotalFeeShip = Home_page.NavigateCartStep2Page().GetFeeShip();
            String txt_SumTotal = Home_page.NavigateCartStep2Page().GetSumTotal();


            Home_page.NavigateCartStep2Page()
                    .choose_PaymentAndInput_Note(Payment, NoteOder)
                    .click_SubmitOder(Cus_Name, Cus_phoneNumber, Address, Ship_Day, Ship_Time);

            Home_page.NavigateToOderResultPage()
                    .Verify_OderInfo(Expect_InfoCustomer, Expect_ShipAddress, NoteOder, "", "", "");
        }catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(false, "Case thất bại");
        }finally {
            driver.manage().deleteAllCookies();
            Log.info("xoá cookie");
            driver.get(Constant.URL);
            Log.info("trang chủ");
        }

    }

}