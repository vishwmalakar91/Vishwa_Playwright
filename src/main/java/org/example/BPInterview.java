package org.example;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BPInterview {

    public static void mytest() {

        Playwright playwright = Playwright.create();
        Browser br = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        Page p1 = br.newPage();
        p1.navigate("https://www.saucedemo.com/");

        Locator username = p1.locator("#user-name");
        Locator pass = p1.locator("#password");
        Locator loginButton = p1.locator("#login-button");
        Locator loginError = p1.locator(".error-message-container");

        String userId = "user";
        String pwd = "invalid_password";
        username.fill(userId);
        pass.fill(pwd);
        loginButton.click();
        String myLoginError = loginError.innerText();
        //System.out.println(myLoginError);
        assertThat(loginError).hasText("Epic sadface: Username and password do not match any user in this service");

        p1.close();
        br.close();
        playwright.close();
    }
}
