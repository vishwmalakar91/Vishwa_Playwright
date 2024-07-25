package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.*;

import java.nio.file.Paths;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
            System.out.println(page.title());
            browser.close();

            Browser ff_browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            page = ff_browser.newPage();
            page.navigate("http://playwright.dev");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example1.png")));
            System.out.println(page.title());
            browser.close();

            Browser safbrowser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
            page = safbrowser.newPage();
            page.navigate("http://playwright.dev");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example3.png")));
            System.out.println(page.title());
            browser.close();
        }
    }
}