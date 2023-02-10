package PageObject.Page;

import PageObject.Page_Model.SearchResult;
import org.openqa.selenium.WebDriver;

public class SearchResult_Page extends SearchResult {

    public SearchResult_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SearchResult_Page verify_SearchResult(String search_Keywords) {
        wait.waitForPageLoaded();
        verify_searchResult(search_Keywords);
        return this;
    }

    public SearchResult_Page AddProductRandomToCart()
    {
        AddProductRandom();
        return this;
    }


}
