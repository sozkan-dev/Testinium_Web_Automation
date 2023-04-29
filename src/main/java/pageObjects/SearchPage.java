package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    private @FindBy(css = ".m-productCard__desc")
    WebElement product;

    public SearchPage() {
        super();
    }

    public void selectProduct() {
        waitForWebElementAndClick(product);
    }


}