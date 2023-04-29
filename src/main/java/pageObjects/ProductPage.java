package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(css = ".o-productDetail__description")
    WebElement productDescription;
    @FindBy(css = ".m-price__new")
    WebElement productPrice;
    @FindBy(css = "#addBasket")
    WebElement addBasket;
    @FindBy(css = ".m-variation__item")
    List<WebElement> sizeList;
    @FindBy(css = ".m-notification__button.btn") //Cart Button -> .o-header__userInfo--item.bwi-cart-o.-cart Notification Cart Button -> .m-notification__button.btn
    WebElement cart;


    public ProductPage() {
        super();
    }

    //Add product info (description, price) to a text file
    public void productInfoToTxt() {
        String description = productDescription.getText();
        String price = productPrice.getText();

        File f = new File(System.getProperty("user.dir") + "/src/main/resources/productInfo.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write("Description: " + description + "\n");
            writer.write("Price: " + price + "\n");
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(description + price);
    }


    //Check whether size options available or not, if available then clicks and selects.
    public void addProductToBasket() {
        for (int i = 1; i <= sizeList.size(); i++) {
            WebElement el = getDriver().findElement(By.cssSelector(String.format(".m-variation__item:nth-of-type(%d)"
                    , i)));
            if (el.isEnabled()) {
                el.click();
                break;
            }
        }

        waitForWebElementAndClick(addBasket);
        waitFor(cart);
        waitForWebElementAndClick(cart);
    }
}