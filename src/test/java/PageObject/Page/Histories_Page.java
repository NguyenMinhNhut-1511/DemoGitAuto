package PageObject.Page;

import PageObject.Page_Model.Histories;
import org.openqa.selenium.WebDriver;

public class Histories_Page extends Histories {

    public Histories_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Histories_Page Verify_CustomerName(String expect_CustomerName)
    {
        verify_customerName(expect_CustomerName);
        return this;
    }
    public Histories_Page Verify_Link() {
        verify_Link();
        return this;
    }
}
