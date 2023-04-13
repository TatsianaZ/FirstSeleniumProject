package com.it_academy.onliner.pageobject.webdriveruniversity;

import com.it_academy.onliner.pageobject.BasePage;
import org.openqa.selenium.By;

import java.util.Arrays;

public class ContactUsPage extends BasePage {
    private static final String BUTTON_XPATH_PATTERN =
            "//*[@id='form_buttons']//input[@value='%s']";
    private final By contactReplyMessage = By.xpath("//*[@id='contact_reply']//h1");

    public enum ContactUsFormWithValues {
        FIRST_NAME("//*[@id='contact_form']//input[@name='first_name']", "text"),
        LAST_NAME("//*[@id='contact_form']//input[@name='last_name']", "text"),
        EMAIL_NAME("//*[@id='contact_form']//input[@name='email']", "text@text.com"),
        MESSAGE("//*[@id='contact_form']//*[@name='message']", "text");

        ContactUsFormWithValues(String xpath, String value) {
            this.xpath = xpath;
            this.value = value;
        }

        private String xpath;
        private String value;

    }

    public ContactUsPage fillInContactUsForm() {
        Arrays.stream(ContactUsFormWithValues.values())
                .forEach(enumItem ->
                        fillInFieldWithValue(waitForElementVisible(By.xpath(enumItem.xpath)), enumItem.value));
        return this;
    }

    public ContactUsPage clickOnButton(String button) {
        waitForElementVisible(By.xpath(String.format(BUTTON_XPATH_PATTERN, button)))
                .click();
        return this;
    }

    public String getFormContactFormReplyMessage() {
        return waitForElementVisible(contactReplyMessage).getText();
    }

}
