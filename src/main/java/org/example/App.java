package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.*;

import java.nio.file.Paths;

/**
 * Hello world!
 */
public class App {
    public static void testPlaywright() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("outputs/screenshots/example.png")));
            System.out.println(page.title());
            browser.close();

            Browser ff_browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
            page = ff_browser.newPage();
            page.navigate("http://playwright.dev");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("outputs/screenshots/example1.png")));
            System.out.println(page.title());
            browser.close();

            Browser safbrowser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
            page = safbrowser.newPage();
            page.navigate("http://playwright.dev");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("outputs/screenshots/example3.png")));
            System.out.println(page.title());
            browser.close();
        }
    }

    public static void main(String[] args) {
        testPlaywright();
    }
}
