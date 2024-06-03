package org.example.jquerydropdowns;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SelectJqueryDropdownExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the URL
            page.navigate("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");

            // Click the dropdown to open it
            page.click("span.select2-selection.select2-selection--single");

            // Wait for the dropdown options to be visible
            page.waitForSelector("ul.select2-results__options");

            // Select the desired value by clicking on it
            //  page.click("li.select2-results__option:has-text('India')");

            // Select the desired value by clicking on it
            page.click("li.select2-results__option:has-text('Australia')");

            //selecting another option
            // Click the dropdown to open it
            page.click("span.select2-selection.select2-selection--single");

            // Wait for the dropdown options to be visible
            page.waitForSelector("ul.select2-results__options");

            // Select the desired value by clicking on it
            page.click("li.select2-results__option:has-text('India')");

        }
    }
}