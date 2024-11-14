import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class BasePage {
    static WebDriver driver = null;
    static Wait<WebDriver> wait = null;
    private static Logger log = Logger.getLogger(ScenarioTest.class.getName());


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = (new FluentWait<>(this.driver)).withTimeout(Duration.ofSeconds(80L)).pollingEvery(Duration.ofSeconds(1L));

    }


    public static WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }


    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public static void pressEnter(String elementId) {
        driver.findElement(By.id(elementId)).sendKeys(Keys.RETURN);
    }

    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
        System.out.println("( " + by + " ) element is clicked.");
    }

    public String getText(By by) {
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    public void hoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public WebElement findElementWithWait(By by, int second) {
        BaseTest.getWebDriver().manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
        return BaseTest.getWebDriver().findElement(by);
    }

    public static void visibilityOf(WebElement by) {
        wait.until(ExpectedConditions.visibilityOf((WebElement) by));
    }

    public boolean checkElementIsExist(By by) {
        try {
            WebElement element = driver.findElement(by);
            return element.isDisplayed() || element.isEnabled();
        } catch (Exception var3) {
            return false;
        }
    }

    public static void scroll(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public void mouseHover(By by) {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(by);
        builder.moveToElement(element).build().perform();
    }

    public void doesStartsWithUrl(String url) {

        boolean bln;
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.startsWith(url))
            bln = true;
        else
            bln = false;

        Assert.assertTrue("Starts with URL", bln);

    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            log.info("true");
            System.out.println("( " + by + " ) element is visible.");
            return true;
        } catch (Exception e) {
            log.info("false" + e.getMessage());
            return false;
        }
    }

    public ArrayList<String> getAllDataInList(By by) {
        ArrayList<String> list = new ArrayList();
        List<WebElement> elementList = driver.findElements(by);
        for (int i = 0; i < elementList.size(); i++) {
            String data = ((WebElement) elementList.get(i)).getText();
            list.add(data);
        }
        return list;
    }

    public void mouseOver(WebElement webElement) {
        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor) driver).executeScript(javaScript, webElement);

    }
}
