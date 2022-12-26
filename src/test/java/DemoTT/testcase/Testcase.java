package DemoTT.testcase;
import DemoTT.page.LSMH;
import DemoTT.base.Setup;
import DemoTT.page.ChonSp;
import DemoTT.page.GioHang;
import DemoTT.page.TrangChu;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Testcase extends Setup {
    private WebDriver driver;

    ChonSp chonsanpham; //test comment
    TrangChu trangchu;
    GioHang giohang;

    LSMH lichsumuahang;
    @BeforeClass
    public void setup() {
        driver = getDriver();
    }
    @Test
    public void Giaotainha()
    {
        trangchu = new TrangChu(driver);
        trangchu.ClickMenuThietBi();
        trangchu.Kittest();
        chonsanpham = new ChonSp(driver);
        chonsanpham.muaspgiohang();
        giohang = new GioHang(driver);
        giohang.OrderGiao("Phuc","0938727300","12344567");
        lichsumuahang = new LSMH(driver);
        lichsumuahang.loggin();
        lichsumuahang.DNLSMH("0938727300");
    }
}