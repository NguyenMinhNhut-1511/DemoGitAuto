package DemoTT.Setup;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class Setup {
    private WebDriver driver;

    static String driverPath=" C:\\Chrome\\";

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver( String browserType, String webURL ){
        switch (browserType){
            case "chrome":
                driver = ChromeDriver(webURL);
                break;
            case "firefox":
                driver = Edge(webURL);
                break;
            default:
                driver = ChromeDriver(webURL);
        }
    }
    @Parameters({"browserType","webURL"})
    @BeforeClass
    public void BaseSetup(String browserType, String webURL){
        try {
            setDriver(browserType, webURL);
        } catch (Exception e){
            System.out.println("Lỗi" + e.getStackTrace());
        }
    }
    private WebDriver ChromeDriver(String webURL) {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(webURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    private WebDriver Edge(String webURL) {
        System.out.println("Launching edge browser...");
        System.setProperty("webdriver.edge.driver", driverPath + "msedge.exe");
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(webURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
//    @AfterClass
//    public void Shutdown() throws Exception{
//        driver.quit();
//    }
}
