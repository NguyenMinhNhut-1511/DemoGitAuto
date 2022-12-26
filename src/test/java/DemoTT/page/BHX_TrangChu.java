package DemoTT.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BHX_TrangChu {

    private WebDriver driver;

    private By box_Search =  By.cssSelector("#text-search");

    public BHX_TrangChu (WebDriver driver) {
        this.driver = driver;
    }

    public void ClickBoxSearch() {
        WebElement box_Search_Ele = driver.findElement(box_Search);
        if (box_Search_Ele.isDisplayed()) {
            box_Search_Ele.click();
        } else {
            System.out.println("No see the box Search");
        }
    }


}
