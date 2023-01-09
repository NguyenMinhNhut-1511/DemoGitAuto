package DemoTT.base;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class Setup {
    public WebDriver driver;

    //static String driverPath=" C:\\Chrome\\";

    // khai báo phương thức getDriver() có kiểu dữ liệu là Webdriver
    // ko có biến trong method
    // và kiểu dữ liệu trả về và driver
    public WebDriver getDriver() {
        return driver;
    }


    private void setDriver(String browserType, String webURL){
        switch (browserType){
            case "chrome":
                driver = ChromeDriver(webURL);
                break;
            case "Edge":
                driver = Edge(webURL);
                break;
            case "firefox":
                driver = Firefox(webURL);
                break;
            default:
                driver = ChromeDriver(webURL);
        }
    }
    @Parameters({"browserType","webURL"})
    @BeforeClass
    public void BaseSetup(String browserType, String webURL) {
        try {
            setDriver(browserType, webURL);
        } catch (Exception e){
            System.out.println("Lỗi" + e.getStackTrace());
        }
    }
    private WebDriver ChromeDriver(String webURL) {
        System.out.println("Launching Chrome browser...");
        //System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
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
        //System.setProperty("webdriver.edge.driver", driverPath + "msedge.exe");
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(webURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver Firefox(String webURL) {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(webURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public void PrintWord (String word) {
        System.out.println(word);
    }

    @AfterMethod
    public void Teardown () {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        System.out.println("run duoc teardown...");
    }
//    @AfterClass
//    public void Shutdown() throws Exception{
//        //Teardown();
//        driver.quit();
//    }
}
