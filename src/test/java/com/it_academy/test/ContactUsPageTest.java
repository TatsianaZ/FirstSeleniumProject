package com.it_academy.test;

import com.it_academy.onliner.pageobject.webdriveruniversity.ContactUsPage;
import com.it_academy.onliner.pageobject.webdriveruniversity.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ContactUsPageTest extends BaseTest {
    private HomePage homePage = new HomePage();
    private ContactUsPage contactUsPage = new ContactUsPage();

    @BeforeClass
    public void navigateToHomePage() {
        //все URL тестируемогот портала нужно вынести в отдельный классб напр. enum на уровень java
        homePage.navigate("https://webdriveruniversity.com/");
    }

    @Test
    public void testContactUsBrowserTitle() {
        homePage.clickOnSectionLink("CONTACT US");
        homePage.performValidationInLastOpenedWindowTabAndCloseItAfter(() ->
                assertThat(contactUsPage.getBrowserTitle())
                        .as("Browser title on Contact Us page is incorrect")
                        .isEqualTo("WebDriver | Contact Us")
        );
    }
}
