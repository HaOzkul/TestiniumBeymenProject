import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasketPage extends BasePage {

    public int basketProductPrice;


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public BasketPage getBasketPrice() {
        String value = getText(By.xpath("//span[@class='priceBox__salePrice']")).replace("TL", "");
        value = value.replace(" ", "");
        value = value.replace(".", "");
        value = value.replace(",", "");
        basketProductPrice = Integer.parseInt(value);
        return this;
    }

    public BasketPage comparePrice(int productPrice) {

        Assert.assertEquals("Ürün Fiyatı Sepet İle aynı değildir", productPrice, basketProductPrice);
        return this;
    }

    public BasketPage deleteProduct() {

        click(By.id("removeCartItemBtn0-key-0"));
        return this;
    }
}
