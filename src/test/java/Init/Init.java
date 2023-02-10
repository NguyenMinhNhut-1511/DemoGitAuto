package Init;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static Utils.Constant.*;
import static Utils.Wait.Sleep.*;

public class Init {


    private static WebDriver driver;


    public static WebDriver getChromeDriver() {
//        String projectPath = System.getProperty("user.dir");
//        String osName = System.getProperty("os.name");
//        if (osName.contains("Windows")) {//src\test\resources
//            System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\browser_Driver\\chromedriver.exe");
//        } else  //MAC
//        {
//            System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/browser_Driver/chromedriver");
//        }

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);
        return driver;
    }

    public static void GotoURL(String URL) {
        driver.get(URL);
    }

    public static void DeleteAllCookie() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public static void TearDown() {
        sleepInSecond(2);
        driver.quit();
    }

}




