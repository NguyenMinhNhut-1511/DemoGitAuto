package project.genarals;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static project.genarals.Constant.driverPath;
import static project.genarals.Constant.driverPathMac;

public class InitSetup {
    private WebDriver driver;
    public WebDriver getDriver() {return driver;}
    @Parameters({"browserType","webURL"})
    @BeforeSuite
    public void initBaseSetup(String browserType, String webURL) {
        try {
            initBrowserDriver(browserType, webURL);
        } catch (Exception e){
            System.out.println("error.... " + Arrays.toString(e.getStackTrace()));
        }
    }
    @AfterSuite
    public void endThisSetup() {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.quit();
    }
    private void initBrowserDriver(String browserType, String webURL) {
        String osName = System.getProperty("os.name");
        String path;
        if (osName.contains("Windows")) {
            path = driverPath;
        }else {
            path = driverPathMac;
        }
        setDriver(browserType,path);
        driver.manage().window().maximize();
        driver.navigate().to(webURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    private void setDriver(String browserType,String path) {
        System.out.println("Launching "+ browserType +" browser...");
        if (browserType.equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", path + "firefoxdriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }
}
