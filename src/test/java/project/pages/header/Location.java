package project.pages.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.genarals.PageObject;

import java.util.List;

public class Location extends PageObject {
    private final WebDriver driver;
    //WebElements
    final private By tinhthanh_Selector = By.xpath("//div[3]/div[5]/div[2]/ul/li[1]");
    final private By list_tinhthanh_Selector = By.xpath("//div[3]/div[5]/div[2]/ul/li");
    final private By quanhuyen_Selector = By.xpath("//div[3]/div[6]/div[2]/ul/li[1]");
    final private By list_quanhuyen_Selector = By.xpath("//div[3]/div[6]/div[2]/ul/li");
    final private By phuongXa_Selector = By.xpath("//div[7]/div[2]/ul[1]/li[1]");
    final private By list_phuongXa_Selector = By.xpath("//div[7]/div[2]/ul[1]/li");
    private WebElement btn_location() {
        return driver.findElement(By.className("current_locate"));
    }
    private WebElement box_search_location() {
        return driver.findElement(By.cssSelector("#text-search-province"));
    }
    private WebElement btn_search_location() {
        return driver.findElement(By.cssSelector("div[class='box-search-province'] i[class='bhx-search']"));
    }
    private WebElement btn_close_location_popup() {
        return driver.findElement(By.className("close"));
    }
    public Location(WebDriver driver) {
        this.driver = driver;
    }
    public Location click_btn_Location() {
        this.btn_location().click();
        return this;
    }
    public Location select_ward_Location(String quanHuyen) {
        wait.waitFor_ClickAbleBySelector(quanhuyen_Selector);
        List<WebElement> list_quanHuyen = driver.findElements(list_quanhuyen_Selector);
        for (WebElement quanHuyen_seletor : list_quanHuyen) {
            if (quanHuyen_seletor.getText().trim().equals(quanHuyen.trim())) {
                quanHuyen_seletor.click();
                break;
            }
        }
        return this;
    }
    public Location select_district_Location(String phuongXa) {
        wait.waitFor_ClickAbleBySelector(phuongXa_Selector);
        List<WebElement> list_phuongXa = driver.findElements(list_phuongXa_Selector);
        for (WebElement phuongXa_chon : list_phuongXa) {
            if (phuongXa_chon.getText().trim().equals(phuongXa.trim())) {
                phuongXa_chon.click();
                break;
            }
        }
        return this;
    }
    public Location select_province_Location(String tinhThanh) {
        wait.waitFor_visibilityOfSelector(tinhthanh_Selector);
        List<WebElement> list_ketQuaSearch = driver.findElements(list_tinhthanh_Selector);
        for (WebElement tinhThanh_chon : list_ketQuaSearch) {
            if (tinhThanh_chon.getText().trim().equals(tinhThanh.trim())) {
                tinhThanh_chon.click();
                break;
            }
        }
        return this;
    }
    public Location input_box_SearchProvince(String tinhThanh) {
        this.box_search_location().sendKeys(tinhThanh);
        return this;
    }
    public Location click_search_Location() {
        wait.waitFor_ClickAbleByElement(btn_search_location());
        this.btn_search_location().click();
        return this;
    }
    public Location close_popup_Location() {
        wait.waitFor_ClickAbleByElement(btn_close_location_popup());
        this.btn_close_location_popup().click();
        return this;
    }
}
