import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

public class ScenarioTest extends BaseTest {
    MainPage mainPage;
    BasketPage basketPage;
    SelectProductPage selectProductPage;
    ByLocator byLocator;

    private static Logger log = Logger.getLogger(ScenarioTest.class.getName());

    @BeforeClass
    public static void beforeClass() throws Exception {
        log.info("**************** Test started ****************");
    }

    @Before
    public void before() {
        mainPage = new MainPage(getWebDriver());
        basketPage = new BasketPage(BaseTest.getWebDriver());
        selectProductPage = new SelectProductPage(getWebDriver());
        byLocator = new ByLocator(BaseTest.getWebDriver());
        log.info("**************** Driver activated ***************");

    }


    @Test
    public void testmainPage() throws InterruptedException {
        log.info("**************** Insider test Started ***************");

        ExpectedConditions.titleIs("#1 Leader in Individualized, Cross-Channel CX — Insider");

        mainPage
                .acceptCookies()
                .clickGenger()
                .clickSearchArea()
                .sendKeysSearch();

        selectProductPage
                .clickshorts()
                .clickShortsSize()
                .getPrice()
                .addBasket()
                .clickBasket();

       basketPage
               .getBasketPrice()
               .comparePrice(selectProductPage.getProductPrice())
               .deleteProduct();



        log.info("**************** SCENARIO FINISHED *************");

    }


    @After
    public void after() throws InterruptedException {
        tearDown();
        log.info("**************** Test Finished ****************");
    }
}
