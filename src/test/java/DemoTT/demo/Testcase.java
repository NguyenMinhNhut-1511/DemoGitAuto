package DemoTT.demo;
import DemoTT.Page.LSMH;
import DemoTT.Setup.Setup;
import DemoTT.Page.ChonSp;
import DemoTT.Page.GioHang;
import DemoTT.Page.TrangChu;
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
        giohang.OrderGiao("Phuc","0938727300","12344567");
        lichsumuahang=new LSMH(driver);
        lichsumuahang.loggin();
        lichsumuahang.DNLSMH("0938727300");
    }
}