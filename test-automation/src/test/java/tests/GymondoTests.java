package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.MyPlanPage;

import static org.assertj.core.api.Assertions.assertThat;

public class GymondoTests extends ChromeWebDriverTest {
    private LoginPage loginPage;
    private MyPlanPage myPlanPage;

    @BeforeEach
    public void init() {
        loginPage = new LoginPage(driver);
        myPlanPage = new MyPlanPage(driver);
    }

    @Test
    public void openLoginPage() {
        loginPage.open();
        assertThat(loginPage.atPage()).isTrue();
//        loginPage.loginButtonClick();
        WebElement button = driver.findElementByCssSelector("nav.top-nav div.login-button-module--wrapper--_Sndu button.btn-gym");
        button.click();
        System.out.println("OK");
    }

}
