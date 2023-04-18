package com.it_academy.test.onliner;

import com.it_academy.onliner.framework.DriverManager;
import com.it_academy.onliner.pageobject.onliner.Header;
import com.it_academy.onliner.pageobject.onliner.ProductPage;
import com.it_academy.test.BaseTest;
import com.it_academy.utils.ScreenshotUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ProductPagesTest extends BaseTest {

    private Header header = new Header();

    @BeforeClass
    public void navigationToHomePage() {
        DriverManager.getWebDriver().get("https://www.onliner.by/");
    }

    @Test
    public void testIsHeadphonesProductTitleExists() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickOnCatalogClassifierCategoryLink("Аудиотехника")
                .clickOnProductLink("Наушники");
        assertThat(new ProductPage().isProductPageTitleDisplayed("Наушники и гарнитуры"))
                .as("Product page title is not displayed")
                .isTrue();
    }

    @Test
    public void testTakeScreenshotOfSpecificElement() {
        ScreenshotUtils.takeScreenshotOfSpecificElement(header.getOnlinerLogo());
    }

    @Test
    public void testSetGouLocation() throws InterruptedException {
        ChromeDriver driver = (ChromeDriver) DriverManager.getWebDriver();
        driver.get("https://www.gps-coordinates.net/my-location");
        Thread.sleep(5000);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Emulation.setGeolocationOverride(Optional.of(50.07),
                Optional.of(14.4),
                Optional.of(1)));

        driver.get("https://www.gps-coordinates.net/my-location");
        Thread.sleep(5000);
    }
}
