package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.*;
import java.util.List;

public class CartPage extends BasePage {
    @FindBy(css = ".m-productPrice__content")
    WebElement productPrice;
    @FindBy(css = "#quantitySelect0-key-0")
    WebElement quantityDropdown;
    @FindBy(css = "#removeCartItemBtn0-key-0")
    WebElement deleteButton;
    @FindBy(css = ".icon.icon-cart")
    WebElement emptyCartIcon;


    public CartPage() {
        super();
    }

    public Boolean isCorrectPrice() throws IOException {

        waitFor(productPrice);
        String price = productPrice.getText()
                                   .trim();
        String pr = null;
        String stringLine = null;
        File f = new File(System.getProperty("user.dir") + "/src/main/resources/productInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));

        while ((stringLine = br.readLine()) != null) {
            if (stringLine.contains("Price")) {
                pr = stringLine.substring(stringLine.indexOf("Price:") + 6)
                               .trim();
                System.out.println(pr);
                break;
            }
        }
        System.out.println(pr);
        System.out.println("Page Price:" + price);
        br.close();

        return pr.equalsIgnoreCase(price);
    }

    public Boolean isQuantityMatch(int index) {
        if (index < 0 || index > 98) {
            index = 0;
        }
        Select dd = new Select(quantityDropdown);
        List<WebElement> options = dd.getOptions();
        String optionText = options.get(index)
                                   .getText();
        dd.selectByIndex(index);
        String result = String.valueOf(index + 1) + " adet";


        return result.equals(optionText);

    }

    public Boolean isDeleted() {
        waitForWebElementAndClick(deleteButton);
        return isVisible(emptyCartIcon);

    }


}