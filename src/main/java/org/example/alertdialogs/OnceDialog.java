package org.example.alertdialogs;
import com.microsoft.playwright.*;
/**
 * Using onceDialog:
 * Here's an example of how to use onceDialog to handle a single dialog event:
 */
public class OnceDialog {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the URL
            page.navigate("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");

            Locator buttons = page.locator("text='Click Me'");
            // Set up a one-time listener for a single dialog event
            page.onceDialog(dialog -> {
                System.out.println("Dialog message: " + dialog.message());
                dialog.accept(); // Accept the dialog
            });

            // Trigger a single dialog
            buttons.first().click();  // Trigger an alert box

            // Set up a one-time listener for a confirm dialog event
            page.onceDialog(dialog -> {
                String message = dialog.message();
                System.out.println(message);
                dialog.accept();
            });
            buttons.nth(1).click();
            System.out.println(page.locator("#confirm-demo").textContent());


            // If another dialog appears later, it won't be handled by the previous listener
            // You would need to set up another listener for the next dialog
            page.onceDialog(dialog -> {
                System.out.println("Another dialog message: " + dialog.message());
                dialog.accept("Playwright"); // Accept the prompt with input
            });
            buttons.last().click();  // Trigger a prompt box
            System.out.println(page.locator("#prompt-demo").textContent());
        }
    }
}
