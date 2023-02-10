package TestScript_Demo;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import Init.*;

import java.util.concurrent.TimeUnit;

public class Demo {


//    @Test
//    public void OpenBHX() {
//        Init init = new Init();
//
//        WebDriver driver = null;
//        init.Setup(driver);
//        driver.get("https://bachhoaxanh.com"); //đi đến URL
//        System.out.println("Mở trang BHX");
//        driver.manage().window().maximize(); // phóng to trình duyệt full màn hình
//        System.out.println("Phóng to trình duyệt");
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        String Titleweb = driver.getTitle();  //get Title của trang web
//        System.out.println("getTitle : " + Titleweb);
//        WebElement box_Search = driver.findElement(By.xpath("//input[@id='text-search']"));
//        box_Search.click();
//        System.out.println("Click vào ô search");
//
//        //Dùng 1 chuỗi hoạt động (actions) bao gồm các bước sau :
//        Actions actions = new Actions(driver);
//        actions.sendKeys("Bánh Socola") //Nhập từ khoá bánh Socola
//                .sendKeys(Keys.ENTER)   //Nhấn phím Enter
//                .build()                //tạo chuỗi hành động hoặc thao tác mà bạn muốn thực hiện
//                .perform();             //Thực thi chuỗi hành động
////         box_Search.sendKeys("Bánh socola");  //Nhập từ khoá Bánh socola
//        System.out.println("Nhập từ khoá 'Bánh socola' vào ô search");
//        init.Sleep(1000);
////        box_Search.submit();
////        System.out.println("Submit từ khoá");
//        init.Sleep(2000);
//        WebElement text_Result_Search = driver.findElement(By.xpath("//body/section[1]/aside[2]/h1[1]"));
//        String text_result = text_Result_Search.getText();
//        System.out.println("getText : " + text_result);
//
//        init.TearDown();
//    }
//

//    public void Demo2()
//    {
//        package webdriver;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//        public class Topic_04_Dropdown {
//            // Khai báo
//            WebDriver driver;
//            Select select;
//            Random rand;
//
//            // Khai báo + khởi tạo
//            String projectPath = System.getProperty("user.dir");
//            String osName = System.getProperty("os.name");
//
//            @BeforeClass
//            public void beforeClass() {
//                if (osName.contains("Mac")) { // Mac
//                    System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//                } else { // Windows
//                    System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//                }
//
//                // Khởi tạo
//                driver = new FirefoxDriver();
//                rand = new Random();
//
//                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            }
//
//            @Test
//            public void TC_01_Default_Dropdown() {
//                driver.get("https://demo.nopcommerce.com/");
//
//                driver.findElement(By.cssSelector("a.ico-register")).click();
//
//                driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Joe");
//                driver.findElement(By.cssSelector("input#LastName")).sendKeys("Biden");
//
//                // Khởi tạo select để thao tác vs Day dropdown
//                select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
//                select.selectByVisibleText("1");
//
//                // Dropdown item expected
//                String[] monthExpected = { "Month", "January", "February", "March", "April",
//                        "May", "June", "July", "August",
//                        "September", "October", "November", "December" };
//
//                // Khởi tạo select để thao tác vs Month dropdown
//                select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
//
//                // Lấy ra tất cả các item đưa vào List Element
//                List<WebElement> monthItems = select.getOptions();
//
//                // Khai báo ArrayList để chứa text get ra từ List Element trên
//                List<String> monthItemText = new ArrayList<String>();
//
//                // Duyệt vòng lặp
//                for (WebElement element : monthItems) {
//                    // Add vào ArrayList
//                    monthItemText.add(element.getText());
//                }
//
//                // Verify bằng nhau
//                Assert.assertEquals(monthItemText, Arrays.asList(monthExpected));
//
//                select.selectByVisibleText("May");
//
//                // Khởi tạo select để thao tác vs Year dropdown
//                select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
//                select.selectByVisibleText("1965");
//
//                String emailAddress = "joebiden" + rand.nextInt(9999) + "@hotmail.com";
//
//                driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
//                driver.findElement(By.cssSelector("input#Company")).sendKeys("White House");
//                driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
//                driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
//
//                driver.findElement(By.cssSelector("button#register-button")).click();
//
//                Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
//
//                driver.findElement(By.cssSelector("a.ico-account")).click();
//
//                Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), "Joe");
//                Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), "Biden");
//
//                select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
//                Assert.assertEquals(select.getFirstSelectedOption().getText(), "13");
//
//                select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
//                Assert.assertEquals(select.getFirstSelectedOption().getText(), "May");
//
//                select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
//                Assert.assertEquals(select.getFirstSelectedOption().getText(), "1965");
//
//                Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
//                Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), "White House");
//            }
//
//            public void TC_02_Default_Dropdown() {
//                driver.get("https://rode.com/en/support/where-to-buy");
//
//                select = new Select(driver.findElement(By.id("country")));
//
//                select.selectByValue("Vietnam");
//                sleepInSecond(3);
//
//                Assert.assertEquals(select.getFirstSelectedOption().getText(), "Vietnam");
//
//                List<WebElement> dealers = driver.findElements(By.cssSelector("div#map h4"));
//
//                for (WebElement element : dealers) {
//                    System.out.println(element.getText());
//                }
//            }
//
//            @AfterClass
//            public void afterClass() {
//                driver.quit();
//            }
//
//            public void sleepInSecond(long timeInSecond) {
//                try {
//                    Thread.sleep(timeInSecond * 1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
}

