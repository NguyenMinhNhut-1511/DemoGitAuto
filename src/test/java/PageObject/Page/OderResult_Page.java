package PageObject.Page;

import PageObject.Page_Model.OderResult;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class OderResult_Page extends OderResult {
    SoftAssert softAssert;

    public OderResult_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        softAssert = new SoftAssert();
    }

    public OderResult Verify_SumTotal(String expect_SumTotal) {
        verify_total(expect_SumTotal);
        return this;
    }
    public OderResult Verify_OderInfo(String Expect_InfoCustomer, String Expect_ShipAddress, String Expect_Note, String ShipDateTime, String Payment, String expect_SumTotal ) {
        verify_InfoCustomer(Expect_InfoCustomer);
        verify_ShipAddress(Expect_ShipAddress);
//        verify_customerNote(Expect_Note);
//        verify_shipDateTime(ShipDateTime);
//        verify_Payment(Payment);
//        verify_total(expect_SumTotal);

        return this;
    }
}
