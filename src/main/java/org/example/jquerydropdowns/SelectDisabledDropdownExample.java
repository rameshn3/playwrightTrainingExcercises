package org.example.jquerydropdowns;
import com.microsoft.playwright.*;

public class SelectDisabledDropdownExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the URL
            page.navigate("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");

            // Click the "Drop Down with Disabled values" dropdown to open it
            page.click("span[aria-labelledby='select2-disable-search-container']");

            // Wait for the dropdown options to be visible
            page.waitForSelector("ul.select2-results__options");

            // Select the desired value by clicking on it
            // Ensure you select a non-disabled option, e.g., "American Samoa"
            page.click("li.select2-results__option:has-text('American Samoa')");

            // Assert the selected value
            String selectedValue = page.innerText("span[aria-labelledby='select2-disable-search-container']");
            if (!selectedValue.equals("American Samoa")) {
                throw new AssertionError("Selected value is incorrect: " + selectedValue);
            }

            System.out.println("Assertion passed: Selected value is 'American Samoa'");

            // Additional actions or assertions can be performed here
        }
    }
}