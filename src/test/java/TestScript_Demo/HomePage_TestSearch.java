package TestScript_Demo;


import Helpers.Logger.TestListener;
import org.testng.annotations.*;



@Listeners(TestListener.class)
public class HomePage_TestSearch {
//
//    WebDriver driver;
//    WaitFor wait;
//    String tinhThanh = "TP. Hồ Chí Minh";
//    String quanHuyen = "TP. Thủ Đức (Q2, Q9, Thủ Đức)";
//    String phuongXa = "Phường An Khánh (Q2)";
//
//    String expect_boxDiaChiHienTai = "Khu vực đã chọn: " + phuongXa + ", " + quanHuyen + ", " + tinhThanh;
//
//    String keyword_timSanPham = "Bánh Socola";
//    Home_Page Home_Page;
//
//    @BeforeSuite
//    public void SetUpChromeDriver() {
//        driver = getChromeDriver();
//    }
//
//    @BeforeTest
//    public void OpenBrowser() {
//        GotoURL(Constant.URL);
//        wait = new WaitFor(driver);
//        Home_Page = new Home_Page(driver);
//        wait.waitForPageLoaded();
//
//    }
//
//    @AfterMethod
//    public void clearAllCookies() {
//        driver.manage().deleteAllCookies();
//    }
//
//    @AfterSuite
//    public void TearDown() {
//        Init.TearDown();
//    }
//
//    //Chọn tỉnh thành quận huyện
//    @Test(priority = 1)
//    public void case1() {
//        Home_Page
//                .click_btnDiaChi()
//                .Chon_tinhThanh(tinhThanh)
//                .Chon_quanHuyen(quanHuyen)
//                .Chon_phuongXa(phuongXa)
//                .verify_diaChiDaChon(expect_boxDiaChiHienTai);
//
//    }
//    @Test(priority = 2, description = "Tìm kiếm sản phẩm và verify kết quả tìm kiếm")
//    public void Case2() {
//        Home_Page
//                .input_boxSearchProduct("Bánh Socola")
//                .enter_boxSearchProduct()
//                .NavigateToSearchResultPage(driver)
//                .verify_KetQuaSearch("Bánh Socola");
//    }
//    @Test(priority = 3, description = "Tìm kiếm tỉnh thành và verify kết quả tìm kiếm")
//    public void Case3() {
//        Home_Page
//                .click_btnDiaChi()
//                .input_boxSearchProvince("Bình chánh")
//                .verify_SearchProvince("Bình chánh");
//    }

}
