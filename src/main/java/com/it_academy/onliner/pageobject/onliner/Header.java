package com.it_academy.onliner.pageobject.onliner;

import com.it_academy.onliner.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class Header extends BasePage {

    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTER =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";

    private final By onlinerLogo = By.xpath("//*[contains(@class, 'onliner_logo')]");

    public CatalogPage clickOnMainNavigationLink(String link) {
        waitForElementVisible(By.xpath(format(MAIN_NAVIGATION_LINK_XPATH_PATTER, link))).click();
        return new CatalogPage();
    }

    public WebElement getOnlinerLogo() {
        return waitForElementVisible(onlinerLogo);
    }
}
