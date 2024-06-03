package org.example.inputInteractions;
import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat

public class BasicCalculatorExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the URL
            page.navigate("https://testsheepnz.github.io/BasicCalculator.html");

            // Enter values into the first number and second number input fields
            page.fill("#number1Field", "10");
            page.fill("#number2Field", "20");

            // Select an operation from the dropdown menu
            page.selectOption("#selectOperationDropdown", "1"); // Operation: Add

            // Click on the "Calculate" button
            page.click("#calculateButton");

            // Fetch the result
            String result = page.textContent("#numberAnswerField");

            // Assert the result
          //  assertThat(result).;

            System.out.println("Calculation successful! Result: " + result);
        }
    }
}
