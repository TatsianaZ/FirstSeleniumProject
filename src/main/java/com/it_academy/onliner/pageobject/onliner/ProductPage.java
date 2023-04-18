package com.it_academy.onliner.pageobject.onliner;

import com.it_academy.onliner.pageobject.BasePage;
import org.openqa.selenium.By;

import static java.lang.String.format;

public class ProductPage extends BasePage {

    private static final String PRODUCT_PAGE_TITLE_XPATH_PATTERN =
            "//*[contains(@class, 'header_title') and contains(text(), '%s')]";

    public boolean isProductPageTitleDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(PRODUCT_PAGE_TITLE_XPATH_PATTERN, title)));
    }
}
