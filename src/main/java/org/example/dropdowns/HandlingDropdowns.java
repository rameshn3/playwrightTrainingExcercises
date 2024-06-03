package org.example.dropdowns;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;
public class HandlingDropdowns {

    public static void main(String[] args) {
        //create playwright, launch browser and new page
        Page page = Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false)).newPage();
        //launch the application
        page.navigate("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
        //get the daylocator
        Locator daydropdown = page.locator("select#select-demo");

        //select an option by label
        daydropdown.selectOption(new SelectOption().setValue("Saturday"));

        Locator selectedValue = page.locator(" p.selected-value.text-size-14");
        System.out.println(selectedValue.textContent());
        assertThat(selectedValue).containsText("Saturday");

        //select an option by value
        daydropdown.selectOption("Monday");
        System.out.println(selectedValue.textContent());
        assertThat(selectedValue).containsText("Monday");


        //select an option by index
        daydropdown.selectOption(new SelectOption().setIndex(3));
        System.out.println(selectedValue.textContent());
        assertThat(selectedValue).containsText("Tuesday");


        //Select multi selection dropdown
        Locator statesMsdropdown=page.locator("select[name='States']");
        statesMsdropdown.selectOption(new String[] {"California","New Jersey","Washington"});

        //fetching all the dropdown options
        Locator optionsList=statesMsdropdown.locator("option");
        System.out.println(optionsList.count());
        List<String>optionsinnerTexts=optionsList.allInnerTexts();

        optionsinnerTexts.forEach(option ->System.out.println(option));
    }
}