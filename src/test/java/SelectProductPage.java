import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectProductPage extends BasePage {


    public int productPrice;

    public SelectProductPage(WebDriver driver) {
        super(driver);

    }

    public SelectProductPage clickshorts() {

        click(By.xpath("(//span[@class='m-productCard__desc'])[1]"));
        return this;
    }

    public SelectProductPage clickShortsSize() {
        click(By.xpath("(//span[@class='m-variation__item -criticalStock'])[1]"));
        return this;
    }

    public SelectProductPage getPrice() {
        String value = getText(By.id("priceNew")).replace("TL", "");
        value = value.replace(" ", "");
        value = value.replace(".", "");
        productPrice = Integer.parseInt(value) * 100;

        return this;
    }

    public SelectProductPage addBasket() {
        click(By.id("addBasket"));
        return this;
    }

    public SelectProductPage clickBasket() {

        click(By.xpath("//a[@title='Sepetim']"));
        return this;

    }


    public int getProductPrice() {
        return this.productPrice;
    }

}


