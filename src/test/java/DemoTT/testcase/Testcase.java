package DemoTT.testcase;
import DemoTT.Page.LSMH;
import DemoTT.base.Setup;
import DemoTT.page.ChonSp;
import DemoTT.page.GioHang;
import DemoTT.page.TrangChu;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Testcase extends Setup {
    private WebDriver driver;

    ChonSp chonsanpham;
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
        trangchu=new TrangChu(driver);
        trangchu.ClickMenuThietBi();
        trangchu.Kittest();
        chonsanpham=new ChonSp(driver);
        chonsanpham.muaspgiohang();
        giohang=new GioHang(driver);
        giohang.OrderGiao("It test","0938727300","12344567");
        lichsumuahang=new LSMH(driver);
        lichsumuahang.loggin(driver.getWindowHandle());
        lichsumuahang.DNLSMH("0938727300");
        lichsumuahang.HuyDH(driver.getWindowHandle());
        //lichsumuahang.ReloadTrang(driver.getWindowHandle());
    }
}