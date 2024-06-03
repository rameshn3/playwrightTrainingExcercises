package org.example.frames;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class HandlingFrames {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            page.navigate("https://letcode.in/frame");
            List<Frame> frames = page.frames();
            System.out.println("No.of frames available: " + frames.size());
        	frames.forEach(frame -> System.out.println(frame.url()));

            FrameLocator firstFrame = page.frameLocator("#firstFr");
            firstFrame.getByPlaceholder("Enter name").type("Ramesh");
            FrameLocator nestedFrame = firstFrame.frameLocator("iframe.has-background-white");
            nestedFrame.getByPlaceholder("Enter email").type("rameshn3@mail.com");

            firstFrame.getByPlaceholder("Enter name").fill("Ramesh Chennuboina");

            // Another way
//		Frame frame = page.frame("");
//		frame.locator("").fill("");
            playwright.close();
        }

        }

    }