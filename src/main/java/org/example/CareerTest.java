package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class CareerTest {
    public static void career() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            Page page = browser.newPage();
            page.navigate("https://www.bp.com/");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Careers ")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Professionals ")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Locations ")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("India ")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Global business services in")).click();
            browser.close();

        }
    }
}
