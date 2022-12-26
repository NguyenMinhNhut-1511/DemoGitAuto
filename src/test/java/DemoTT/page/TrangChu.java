package DemoTT.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TrangChu {
    private WebDriver driver;
    private By MenuThietBi = By.xpath("(//strong[contains(text(),'Thiết bị, dụng cụ y tế')])[1]");
    private By Kittest = By.xpath("//span[normalize-space()='Kit test covid']");

    public TrangChu(WebDriver driver){
        this.driver = driver;
    }
    public void ClickMenuThietBi(){
        WebElement MenuTB = driver.findElement(MenuThietBi);
        if (MenuTB.isDisplayed()){
                MenuTB.click();
        }
    }
    public void Kittest(){
        WebElement kittestcovid = driver.findElement(Kittest);
        if(kittestcovid.isDisplayed()){
            kittestcovid.click();
        }
    }

}
