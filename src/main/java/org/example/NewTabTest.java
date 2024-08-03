package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class NewTabTest {

    public static void tabTest() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext br = browser.newContext();
            Page page1 = br.newPage();
            page1.navigate("https://www.orangehrm.com/");

            Page linkdin = page1.waitForPopup(() -> {
                page1.locator(".social-icon img[src*=\"linkedin\"]").click();
            });

            linkdin.waitForLoadState();
            linkdin.waitForTimeout(2000);
            System.out.println(linkdin.title());

            linkdin.close();
            page1.close();

            br.close();

        }
    }
}
