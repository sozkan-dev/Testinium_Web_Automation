package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Util;

import java.io.IOException;

public class HomePage extends BasePage {

    private @FindBy(css = "#onetrust-accept-btn-handler")
    WebElement acceptAllCookies;
    private @FindBy(css = "#genderManButton")
    WebElement genderSelection;
    private @FindBy(css = ".default-input.o-header__search--input")
    WebElement searchBar;
    private @FindBy(css = ".m-productCard__desc")
    WebElement productList;

    public HomePage() {
        super();
    }

    public void go_to_homepage() {
        navigateTo_URL(getURL());
    }

    public void accept_cookies() {
        waitForWebElementAndClick(acceptAllCookies);
        waitForWebElementAndClick(genderSelection);
    }

    public String getCurrentTabName() {
        return getTabName();
    }

    public void typeKey(int index) throws IOException, InterruptedException {
        sendKeys(searchBar, Util.getDataFromExcel(index));
        clearTextField(searchBar);

    }

    public void searchKey(int index) throws IOException {

        sendKeysEnter(searchBar, Util.getDataFromExcel(index));
    }


}