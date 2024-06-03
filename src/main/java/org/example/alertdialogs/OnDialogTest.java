package org.example.alertdialogs;
import com.microsoft.playwright.*;

/**
 * Using onDialog:
 * Here's an example of how to use onDialog to handle multiple dialog events:
 */
public class OnDialogTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the URL
            page.navigate("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");

            Locator buttons = page.locator("text='Click Me'");
            // Set up a persistent listener for all dialog events
            page.onDialog(dialog -> {
                System.out.println("Dialog message: " + dialog.message());
                dialog.accept("Ramesh"); // Accept the dialog
            });

            // Trigger multiple dialogs
            buttons.first().click(); // Trigger an alert box
            buttons.nth(1).click(); // Trigger another alert box
            buttons.last().click(); // Trigger a prompt box
        }
    }
}
