package org.example;

import com.microsoft.playwright.*;

import java.util.List;

public class TableScraping {

    public static void scrapTable() {
        Playwright playwright = Playwright.create();
        Browser br = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bc1 = br.newContext();
        Page p1 = bc1.newPage();
        p1.navigate("https://practice.expandtesting.com/tables");

        Locator table1Rows = p1.locator("table#table1 tr");

        table1Rows.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));
        String due = table1Rows.locator(":scope", new Locator.LocatorOptions().setHasText("Jason")).locator("//td[text()=\"Jason\"]/following-sibling::td[2]").textContent();
        System.out.println(due);

        p1.close();
        bc1.close();
        br.close();
        playwright.close();

    }
}
