package org.example.dropdowns;
import com.microsoft.playwright.*;
public class CheckAllCheckboxDemoTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the URL
            page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");

            // Locate and check multiple checkboxes
            // Here we assume the checkboxes have certain labels or unique properties
            page.check("input[type='checkbox'][id='isAgeSelected']");
            page.check("input[type='checkbox'][value='Option 1']");
            page.check("input[type='checkbox'][value='Option 2']");
            page.check("input[type='checkbox'][value='Option 3']");
            page.check("input[type='checkbox'][value='Option 4']");

            // Assertions to verify checkboxes are checked
            assert page.isChecked("input[type='checkbox'][id='isAgeSelected']");
            assert page.isChecked("input[type='checkbox'][value='Option 1']");
            assert page.isChecked("input[type='checkbox'][value='Option 2']");
            assert page.isChecked("input[type='checkbox'][value='Option 3']");
            assert page.isChecked("input[type='checkbox'][value='Option 4']");

            System.out.println("All checkboxes are checked successfully.");

            // Additional actions or assertions can be performed here
        }
    }
}
