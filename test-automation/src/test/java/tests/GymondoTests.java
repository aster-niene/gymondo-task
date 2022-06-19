package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.MyPlanPage;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GymondoTests extends ChromeWebDriverTest {
    private LoginPage loginPage;
    private MyPlanPage myPlanPage;
    private final String LOGIN = "qa-prod1@gymondo.de";
    private final String PASSWORD = "purpleSquid22!";

    @BeforeEach
    public void init() {
        loginPage = new LoginPage(driver);
        myPlanPage = new MyPlanPage(driver);
    }

    @Test
    public void openLoginPage() throws InterruptedException {
        loginPage.open();
        assertThat(loginPage.atPage()).isTrue();
        loginPage.acceptButtonClick();
        loginPage.loginButtonClick();
        loginPage.inputLoginPassword(LOGIN, PASSWORD);
        loginPage.submitButtonClick();


        //driver.findElementByCssSelector("div.modal_closeWrapper__BBoXJ").click();
        myPlanPage.modalWindowsCloseButtonClick();


        System.out.println("OK");
    }

}
