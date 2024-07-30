package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class BrowserContextTest {

    public static void testContext() {

        Playwright playwright = Playwright.create();
        Browser br = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bc = br.newContext();
        Page p1 = bc.newPage();
        p1.navigate("https://bp.com");
        p1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all")).click();

        Locator worldwide = p1.locator("text=Worldwide");
        Locator EuropeAndEurasia = p1.locator("text=Europe and Eurasia");
        Locator listOfCounties = p1.getByRole(AriaRole.TABPANEL);

        System.out.println(worldwide.count());
        for (int i = 0; i < worldwide.count(); i++) {
            if (worldwide.nth(i).textContent().equals("Worldwide")) {
                worldwide.nth(i).click();
                break;
            }
        }
        //worldwide.click();
        EuropeAndEurasia.click();
        System.out.println("list of country" + listOfCounties.allTextContents().toString().trim());
        br.close();

    }
}
