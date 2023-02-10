package project.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.genarals.InitSetup;
import project.pages.Header;
import project.pages.header.Location;

import static project.genarals.Constant.tinhThanh;
import static project.genarals.Constant.phuongXa;
import static project.genarals.Constant.quanHuyen;

public class HeaderCase extends InitSetup {
    WebDriver driver;
    Location location;
    Header header;

    @BeforeTest
    public void Setup(){ driver = getDriver();}

    @Test(description = "Case home button")
    public void NavigationToHomePage() {
        header = new Header(driver);
        header.click_logoBHX();
    }
    @Test(description = "Case search product")
    public void SearchProduct(){
        header = new Header(driver);
        header.input_text_SearchProduct("Thịt heo")
                .enter_search_SearchProduct();
    }
    @Test(description = "Case setting location")
    public void SettingLocation(){
        location = new Location(driver);
        location.click_btn_Location()
                .input_box_SearchProvince(tinhThanh)
                .select_province_Location(tinhThanh)
                .select_district_Location(phuongXa)
                .select_ward_Location(quanHuyen)
                .click_search_Location();
    }
}
