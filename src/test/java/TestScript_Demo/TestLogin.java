//package TestScript_Demo;
//
//import Helpers.Capture.Capture;
//import Helpers.ExcelHelpers.Excel_Helpers;
//import Helpers.Logger.Log;
//import Helpers.Logger.TestListener;
//import PageObject.Page.Home_Page;
//import PageObject.Page_Model.Home;
//import Utils.Constant;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;
//import org.testng.annotations.*;
//
//import static Init.Init.*;
//
//@Listeners(TestListener.class)
//public class  TestLogin {
//
//    WebDriver driver;
//    Home_Page Home_page;
//    Excel_Helpers excel;
//
//    String expect_customerName;  //theo Format như :  (Anh) Lợi
//    String phoneNumber;
//    String passWord;
//
//
//    int i =1;
//
//    @BeforeTest
//    public void OpenBrowser() throws Exception {
//        driver = getChromeDriver();
//        Home_page = new Home_Page(driver);
//        excel = new Excel_Helpers();
//        String name = Home_page.getClass().getName();
//        Capture.startRecord(name.replace("PageObject.Page.", ""));
//        GotoURL(Constant.URL);
//    }
//
//    /**
//     * Hàm này sẽ chạy trước mỗi "@Test" để đọc dữ liệu cho mỗi case
//     *
//     * @throws Exception
//     */
//    @BeforeMethod
//    public void getDataTestFromExcel() throws Exception {
//        excel.SetExcelFile("Login_BHX.xlsx", "Sheet1");
//        i++;
//        expect_customerName = excel.getCellData("customername", i);
//        phoneNumber = excel.getCellData("phonenumber", i);
//        passWord = excel.getCellData("password", i);
//    }
//
//    @AfterMethod
//    public void clearAllCookies() {
//        driver.manage().deleteAllCookies();
//        Log.info("Đã xoá cookie");
//    }
//
//    @AfterSuite
//    public void CloseBroswer() {
//        TearDown();
//        Capture.stopRecord();
//
//    }
//
//    /**
//     * Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Step
//     * <p>
//     * Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
//     * passed = SUCCESS và failed = FAILURE
//     */
//    // Nó sẽ thực thi sau mỗi lần thực thi testcase (@Test)
//    @AfterMethod
//    public void takeScreenshot(ITestResult result) {
//
//        if (ITestResult.FAILURE == result.getStatus()) {
//            try {
//                Capture.captureScreenshot(driver, result.getName());
//                Log.info("Đã chụp màn hình: " + result.getTestContext());
//            } catch (Exception e) {
//                Log.info("Exception while taking screenshot " + e.getMessage());
//            }
//        }
//    }
//
//    @Test
//    //Case đăng nhập thành công
//    public void Case1_LoginSuccess() {
//        //Mở trang chủ -> click nút LSMH -> đá trang đăng nhập và bắt đầu nhập input
//
//
//        Home_page.click_buttonHistories()
//                .NavigateToLoginPage()
//                .input_InfoLogin(phoneNumber, passWord)
//                .Verify_LoginSuccess(expect_customerName);
//    }
//    @Test
//    //Case đăng nhập không thành công do nhập sai Pass
//    public void Case2_LoginFail() {
//        Home_page
//                .click_buttonHistories()
//                .NavigateToLoginPage()
//                .input_InfoLogin(phoneNumber, passWord)
//                .Verify_LoginFail();
//
//    }
//    /**
//     * Case đăng nhập không thành công
//     * Đi từ trang chủ -> click nút LSMH -> trang đăng nhập rồi thực hiện đăng nhập
//     */
//    @Test
//    public void Case3() {
//
//        Home_page
//                .click_buttonHistories()
//                .NavigateToLoginPage()
//                .input_InfoLogin(phoneNumber, passWord)
//                .Verify_LoginSuccess(expect_customerName);
//    }
//
//
//
//
//}
