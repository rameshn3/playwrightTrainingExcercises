package org.example.alertdialogs;

import com.microsoft.playwright.*;
import java.util.function.Consumer;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

//
//class MyDialog implements Consumer<Dialog>{
//
//	@Override
//	public void accept(Dialog dialog) {
//		System.out.println(dialog.message());
//		String defaultValue = dialog.defaultValue();
//		System.out.println(defaultValue);
//		dialog.accept("Koushik");
//	}
//
//}


public class HandlingAlerts {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
            Locator buttons = page.locator("text='Click Me'");

            Consumer<Dialog> alert = new Consumer<Dialog>() {
                public void accept(Dialog dialog) {
                    System.out.println(dialog.message());
                    String defaultValue = dialog.defaultValue();
                    System.out.println(defaultValue);
                    dialog.dismiss();
                    page.offDialog(this);
                }
            };

            page.onDialog(a -> {
                String message = a.message();
                System.out.println(message);
                a.accept();
            });
            buttons.first().click();

            page.onDialog(b -> {
                String message = b.message();
                System.out.println(message);
                b.accept();
            });
            buttons.nth(1).click();
            System.out.println(page.locator("#confirm-demo").textContent());


            page.onDialog(c -> {
                String message = c.message();
                System.out.println(message);
                System.out.println(c.defaultValue());
                c.accept("Ramesh");
            });
            buttons.last().click();
            System.out.println(page.locator("#prompt-demo").textContent());

            //
            page.waitForTimeout(3000);

            page.navigate("https://the-internet.herokuapp.com/basic_auth");
            System.out.println(page.locator("h3").textContent());

            playwright.close();
        }
    }
}