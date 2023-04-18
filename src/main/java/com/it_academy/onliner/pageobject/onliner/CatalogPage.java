package com.it_academy.onliner.pageobject.onliner;

import com.it_academy.onliner.pageobject.BasePage;
import org.openqa.selenium.By;

import static java.lang.String.format;

public class CatalogPage extends BasePage {

    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";

    private static final String CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and contains(text(), '%s')]";

    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";

    public CatalogPage clickOnCatalogClassifierLink(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link)))
                .click();
        return this;
    }

    public CatalogPage clickOnCatalogClassifierCategoryLink(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN, link)))
                .click();
        return this;
    }

    public ProductPage clickOnProductLink(String product) {
        waitForElementVisible(By.xpath(format(PRODUCT_XPATH_PATTERN, product)))
                .click();
        return new ProductPage();
    }
}
