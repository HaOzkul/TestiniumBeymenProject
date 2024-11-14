import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }


    public MainPage acceptCookies() {
        try {

            WebElement acceptButton = driver.findElement(By.id("onetrust-accept-btn-handler"));

            if (acceptButton.isDisplayed() && acceptButton.isEnabled()) {
                acceptButton.click();
                System.out.println("Çerezler kabul edildi.");
            } else {
                System.out.println("Çerezler kabul et butonu bulunamadı veya tıklanamaz durumda.");
            }
        } catch (Exception e) {

            System.out.println("Çerez kabul et butonu bulunamadı: " + e.getMessage());
        }
        return this;
    }

    public MainPage clickGenger() {

        click(By.id("genderWomanButton"));
        return this;
    }

    public MainPage clickSearchArea() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchArea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='o-header__search--input']"))); // ID'yi değiştirin


            searchArea.click();
            System.out.println("Arama alanına tıklanmış oldu.");
        } catch (Exception e) {

            System.out.println("Arama alanına tıklanırken hata oluştu: " + e.getMessage());
        }
        return this;
    }

    public MainPage sendKeysSearch() {
        sendKeys(By.id("o-searchSuggestion__input"), "şort");
        pressEnter("o-searchSuggestion__input");
        return this;
    }


}










