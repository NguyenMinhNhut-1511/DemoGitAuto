package PageObject.Page_Model;

import Helpers.Logger.Log;
import PageObject.Base.PageObject_Base;
import org.openqa.selenium.*;
import org.testng.Assert;

import static Utils.Wait.Sleep.*;

import java.util.List;


public class Home extends PageObject_Base {

    final private By btn_currentLocation_Selector = By.className("current_locate"); //nút chọn địa chỉ giao trên header
    final private By box_searchProduct_Selector = By.cssSelector("input[id='text-search']");      //box tìm kiếm sản phẩm trên header
    final private By box_searchProvince_Selector = By.cssSelector("input[id='text-search-province']");
    final private By province_Selector = By.cssSelector("li[data-provid='3']");
    final private By list_Provinces_Selector = By.cssSelector("li[data-provid]");
    final private By district_Selector = By.xpath("//div[3]/div[6]/div[2]/ul/li[1]");
    final private By list_Districts_Selector = By.cssSelector("li[data-distid]");
    final private By ward_Selector = By.xpath("//div[7]/div[2]/ul[1]/li[1]");
    final private By list_wards_Selector = By.cssSelector("li[data-wardid]");
    final private By btn_OderHistories_Selector = By.cssSelector("a[class='histories']");
    final private By txt_chooseLocation_Selector = By.cssSelector("div[class='chooseLocation']");     //Khu vực đã chọn trong box chọn địa chỉ giao hàng
    final private By btn_close_PopUp_ChooseLocation_Selector = By.cssSelector("a[class='close']");
    final private By btn_Cart_Selector = By.xpath("//a[@class='temcart no']");
    final private By list_suggestSearch_Result_Selector = By.cssSelector("a[class='s-keysuggest']");



    //Khởi tạo 1 đối tượng Home_Page có input là 1 Webdriver
    public Home(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    //Lấy Element box của ô địa chỉ hiện tại
    private WebElement box_searchProvince() {
        return this.driver.findElement(box_searchProvince_Selector);
    }

    //Lấy Element box SEARCH của ô địa chỉ hiện tại
    private WebElement btn_currentLocation() {
        return this.driver.findElement(btn_currentLocation_Selector);
    }

    //Lấy Element box của ô search product
    private WebElement box_searchProduct() {
        return this.driver.findElement(box_searchProduct_Selector);
    }

    //Lấy Element btn Lịch sử mua hàng
    private WebElement btn_oderHistories() {
        return this.driver.findElement(btn_OderHistories_Selector);
    }

    //Lấy Element Location đã chọn Lịch sử mua hàng
    private WebElement txt_chooseLocation() {
        return this.driver.findElement(txt_chooseLocation_Selector);
    }

    private WebElement btn_close_PopUp_ChooseLocation() {
        return this.driver.findElement(btn_close_PopUp_ChooseLocation_Selector);
    }


    protected void click_btnCurrentLocation() {
        wait.waitForClickAbleByElement(btn_currentLocation()).click();

    }

    //hành động nhập text vào ô box search sản phẩm
    protected void input_boxSearchProduct(String keyword) {
        sleepInSecond(3);
        this.box_searchProduct().sendKeys(keyword);
        this.box_searchProduct().submit();
        sleepInSecond(0.5);
    }


    //hành động nhập nhấn vào phím enter trên keyboard
    protected void Enter_boxSearchProduct() {
        keyboard_actions.enter_Keyboard();
    }

    //hành động nhập text vào ô box search tỉnh thành
    protected Home input_boxSearchProvince(String keyword) {
        wait.waitForClickAbleBySelector(box_searchProvince_Selector).click();
        this.box_searchProvince().sendKeys(keyword);
        return this;
    }

    protected Home click_btn_close_PopUp_ChooseLocation() {
        this.btn_close_PopUp_ChooseLocation().click();
        return this;
    }

    protected Home verify_SearchProvince(String keyword) {
        By itemSearchProvince_Selector = By.cssSelector("div[class='itemsearch']");
        wait.waitForvisibilityOfSelector(By.cssSelector("div[class='box-search-province'] li:nth-child(1)"));
        List<WebElement> list_ketQuaSearch = this.driver.findElements(itemSearchProvince_Selector);
        this.btn_close_PopUp_ChooseLocation();

        int n = list_ketQuaSearch.size();
        for (int i = 0; i < n; i++) {
            Log.info(list_ketQuaSearch.get(i).getText());
        }

        if (n >= 2) {
            for (WebElement ketQua : list_ketQuaSearch) {
                String text = ketQua.getText().toLowerCase().trim().replace(",", "");
                Log.info(text);
                Assert.assertTrue(text.contains(keyword.toLowerCase().trim()));
            }
        } else if (n == 1) {
            String text = list_ketQuaSearch.get(0).getText().toLowerCase().trim().replace(",", "");
            Log.info(text);
            Assert.assertTrue(text.contains(keyword.toLowerCase().trim()));
        } else {
            WebElement textFail = this.driver.findElement(By.cssSelector("span[class='s-viewmore']"));
            String result_search_text = textFail.getText();
            Log.info(result_search_text);
        }
        return this;
    }


    //Chọn tỉnh/thành theo input nhập vào
    protected Home choose_Province(String Province) {
        String tempt = Province.toLowerCase().trim();
        wait.waitForClickAbleBySelector(province_Selector);
        List<WebElement> list_Province = this.driver.findElements(list_Provinces_Selector);

        for (WebElement province_choose : list_Province) {
            if (province_choose.getText().trim().toLowerCase().contains(tempt)) {
                province_choose.click();
                break;
            }
        }
        return this;
    }

    //Chọn quận/Huyện theo input nhập vào
    protected Home choose_District(String District) {
        String tempt = District.toLowerCase().trim();
        wait.waitForClickAbleBySelector(district_Selector);
        List<WebElement> list_District = this.driver.findElements(list_Districts_Selector);

        for (WebElement district_choose : list_District) {
            if (district_choose.getText().trim().toLowerCase().contains(tempt)) {
                district_choose.click();
                break;
            }
        }
        return this;
    }

    //Chọn phường/xã theo input nhập vào
    protected Home choose_Ward(String Ward) {
        String tempt = Ward.toLowerCase().trim();
        wait.waitForvisibilityOfSelector(ward_Selector);
        List<WebElement> list_Ward = this.driver.findElements(list_wards_Selector);

        for (WebElement ward_choose : list_Ward) {
            if (ward_choose.getText().trim().toLowerCase().contains(tempt)) {
                ward_choose.click();
                break;
            }
        }
        return this;
    }

    //Verify địa chỉ đã chọn
    protected Home verify_LocationChose(String expect) {
        wait.waitForPageLoaded();
        Log.info("Đã chờ xong");
        sleepInSecond(0.8);
        this.click_btnCurrentLocation();
        wait.waitForvisibilityOfSelector(txt_chooseLocation_Selector);
        String current = this.txt_chooseLocation().getText()
                .replace("Khu vực đã chọn: ", "")
                .replace("Phường ","")
                .replace("Xã ","")
                .replace("TP. ", "")
                .replace("Thành Phố ", "")
                .replace("Huyện ","")
                .replace(" (Q2, Q9, Thủ Đức)","")
                .replace(" (Q2)","")
                .replace(" (Q9)","")
                .replace(" (Q.Thủ Đức)","")
                .replace(",","")
                .toLowerCase().trim();
        this.btn_close_PopUp_ChooseLocation().click();

        String expect_tempt = expect
                .replace("Khu vực đã chọn: ", "")
                .replace("Phường ","")
                .replace("Xã ","")
                .replace("TP. ", "")
                .replace("Thành Phố ", "")
                .replace("Huyện ","")
                .replace(",","")
                .toLowerCase().trim();
        Assert.assertEquals(current,expect_tempt);
        return this;
    }

    // Click vào nút Lịch Sử Mua Hàng
    protected Home click_btnHistories() {
        wait.waitForClickAbleBySelector(btn_OderHistories_Selector).click();
        return this;
    }

    // Click vào nút Giỏ Hàng
    protected Home click_btnCart() {
        wait.waitForClickAbleBySelector(btn_Cart_Selector).click();
        return this;
    }
}
