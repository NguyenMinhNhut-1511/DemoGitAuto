package PageObject.Page_Model;

import Helpers.Logger.Log;
import PageObject.Base.PageObject_Base;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

public class SearchResult extends PageObject_Base {
    final private By txt_ketQuaSearch_Selector = By.cssSelector("h1[class='resulttext']");

    public SearchResult(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private WebElement txt_resultSearch() {
        return this.driver.findElement(txt_ketQuaSearch_Selector);
    }

    private int SearchResult_Type() {
        wait.waitForPageLoaded();
        String url = driver.getCurrentUrl();
        //type 1: Trang kết quả tìm kiếm
        //type 0: Trang cate
        if (url.contains("tim-kiem")) {
            return 1;
        } else
            return 0;
    }

    protected SearchResult AddProductRandom() {
        wait.waitForPageLoaded();
        List<WebElement> list_btnMua = this.driver.findElements(By.xpath("//div[@class='boxproduct']//li[@class='product hasNotUnit']//a[@class='buy']"));
        int n = list_btnMua.size();
        Random random = new Random();
        if (n > 0) {
            int random1 = 19;
                    //random.nextInt((n));
            Log.info("random1: " + random1);
            if(random1>8)
            {
                scroll_actions.ScrollDown50percent();
            }
            list_btnMua.get(random1).click();
            this.thongTinSanPhamchonMua(random1);
        } else {
            Log.info("Không có sản phẩm");
        }
        return this;
    }

    private void thongTinSanPhamchonMua(int index) {
        List<WebElement> list_boxSP = this.driver.findElements(By.xpath("//div[@class='boxproduct']//li[@class='product hasNotUnit']"));
        List<WebElement> list_TenSP = this.driver.findElements(By.xpath("//div[@class='boxproduct']//li[@class='product hasNotUnit']//h3"));
        List<WebElement> list_GiaSP = this.driver.findElements(By.xpath("//div[@class='boxproduct']//li[@class='product hasNotUnit']//div[@class='price']"));

        String ten_SP = list_TenSP.get(index).getText();
        String id_SP = list_boxSP.get(index).getAttribute("data-product");
        String code_SP = list_boxSP.get(index).getAttribute("data-sku");
        String giaTien_SP = list_GiaSP.get(index).getText();

        Log.info("Thông tin sản phẩm:\n- Tên SP:  " + ten_SP + "\n- Id SP: " + id_SP + "\n- Code SP: " + code_SP + "\n- Giá SP: " + giaTien_SP);
    }


    protected void verify_ketquatimkiem(String keywords) {
        String[] keys = keywords.toLowerCase().split(" ");
        int dem = 0;

        if (SearchResult_Type() == 1) {
            List<WebElement> list_tenSP = this.driver.findElements(By.xpath("//div[@class='boxproduct']//li[@class='product hasNotUnit']//h3"));
            int n = list_tenSP.size();
            if (n >= 1) {
                for (int i = 0; i < n; i++) {
                    Log.info(list_tenSP.get(i).getText());
                    for (int index = 0; index < keys.length; index++) {
                        if (list_tenSP.get(i).getText().toLowerCase().trim().contains(keys[index])) {
                            dem++;
                        }
                    }
                    if (keys.length >= 2) {
                        if (dem < 2) {
                            Log.info("Verify sai : " + list_tenSP.get(i).getText());
                        }
                    } else if (keys.length == 1) {
                        if (dem < 1) {
                            Log.info("Verify sai : " + list_tenSP.get(i).getText());
                        }
                    }
//                if (!(list_tenSP.get(i).getText().toLowerCase().trim().contains(Constant.KEY1.toLowerCase())
//                        && list_tenSP.get(i).getText().toLowerCase().trim().contains(Constant.KEY2.toLowerCase()))
//                        || (list_tenSP.get(i).getText().toLowerCase().trim().contains(Constant.KEY1.toLowerCase())
//                        || list_tenSP.get(i).getText().toLowerCase().trim().contains(Constant.KEY2.toLowerCase()))) {
//                    Log.info("SP Sai: " + list_tenSP.get(i).getText() + "\n");
//
                }
            } else {
                Log.info("Không có sản phẩm phù hợp với từ khoá " + keywords);
            }
        }
        else {
            scroll_actions.ScrollDown(2);
            List<WebElement> list_tenSP1 = this.driver.findElements(By.xpath("//div[7]/ul[1]/li//h3"));
            Log.info(list_tenSP1.size());
            int m = list_tenSP1.size();
            if (m >= 1) {
                for (int i = 0; i < m; i++) {
                    Log.info(list_tenSP1.get(i).getText());
                    for (int index1 = 0; index1 < keys.length; index1++) {
                        if (list_tenSP1.get(i).getText().toLowerCase().trim().contains(keys[index1])) {
                            dem++;
                        }
                    }
                    if (keys.length >= 2) {
                        if (dem < 1) {
                            Log.info("Verify sai : " + list_tenSP1.get(i).getText());
                        }
                    }
//                if (!(list_tenSP.get(i).getText().toLowerCase().trim().contains(Constant.KEY1.toLowerCase())
//                        && list_tenSP.get(i).getText().toLowerCase().trim().contains(Constant.KEY2.toLowerCase()))
//                        || (list_tenSP.get(i).getText().toLowerCase().trim().contains(Constant.KEY1.toLowerCase())
//                        || list_tenSP.get(i).getText().toLowerCase().trim().contains(Constant.KEY2.toLowerCase()))) {
//                    Log.info("SP Sai: " + list_tenSP.get(i).getText() + "\n");
//
                }
            } else {
                Log.info("Không có sản phẩm phù hợp với từ khoá " + keywords);
            }
        }
    }

        protected SearchResult verify_searchResult (String keywords){
//        if (!this.verify_ketquatimkiem(keywords)) {
//            Assert.assertTrue(this.verify_ketquatimkiem(keywords));
//        }
//        Assert.assertTrue(this.verify_ketquatimkiem(keywords));
            verify_ketquatimkiem(keywords);
            return this;
        }
    }
