package PageObject.Page;

import PageObject.Page_Model.*;
import org.openqa.selenium.WebDriver;

public class Home_Page extends Home {

    public Home_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Home_Page choose_Location(String Province, String District, String Ward) {
        wait.waitForPageLoaded();
        click_btnCurrentLocation();
                choose_Province(Province);
                choose_District(District);
                choose_Ward(Ward);
        return this;
    }

    public Home_Page verify_Location(String Expect_Location) {
        verify_LocationChose(Expect_Location);
        return this;
    }

    public Home_Page Search_Product(String Search_keywords) {
                input_boxSearchProduct(Search_keywords);
//                Enter_boxSearchProduct();
        return this;
    }

    public Home_Page click_buttonHistories(){
        click_btnHistories();
        return this;
    }

    public Home_Page click_buttonCart(){
        click_btnCart();
        return this;
    }

}
