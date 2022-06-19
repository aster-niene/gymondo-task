package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.ChromeWebDriverTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.BasePage.GYMONDO_HOST;

public class LoginPage {

    private final String TITLE = "Gymondo Online Fitness - Get Fit & Happy at Home";
    //private final String X_PATH_LOG_IN_BUTTON = "//nav[@class='top-nav']//div[text()='Log in']";
    private final String CSS_LOG_IN_BUTTON = "li.menu-drawer-actions__item div.login-button-module--wrapper--_Sndu button.btn-gym";
    private final String CSS_LOGIN_FIELD = "input[id='mail']";
    private final String CSS_PASSWORD_FIELD = "input[id='password']";
    private final String CSS_SUBMIT_BUTTON = "button[type='submit']";
    private final String CSS_ACCEPT_BUTTON = "button.btn-gym.btn--flex.btn--medium";

    private ChromeDriver driver;

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;

    }
    public boolean atPage(){
        return driver.getTitle().equals(TITLE);
    }

    public void open() {
        driver.get(GYMONDO_HOST);
    }

    private WebElement getAcceptButton(){
        return BasePage.getElementWithExplicitWait(driver, CSS_ACCEPT_BUTTON);
        //return driver.findElementByCssSelector(CSS_ACCEPT_BUTTON);
    }

    private WebElement getLoginField(){
        return driver.findElementByCssSelector(CSS_LOGIN_FIELD);
    }
    private WebElement getPasswordField(){
        return driver.findElementByCssSelector(CSS_PASSWORD_FIELD);
    }
    private WebElement getSubmitButton(){
        return driver.findElementByCssSelector(CSS_SUBMIT_BUTTON);
    }
    private WebElement getLoginButton() {
        return BasePage.getElementWithExplicitWait(driver, CSS_LOG_IN_BUTTON);
        //return  driver.findElementByCssSelector(CSS_LOG_IN_BUTTON);
    }
    public void acceptButtonClick(){
        buttonClick(getAcceptButton());
    }
    public void inputLoginPassword(String name, String password) {
        inputToFiled(getLoginField(), name);
        inputToFiled(getPasswordField(), password);
    }
    private void buttonClick(WebElement button) {
        button.click();
    }

    public void submitButtonClick() {
        buttonClick(getSubmitButton());
    }

    public void loginButtonClick() {
        buttonClick(getLoginButton());
    }
    private void inputToFiled(WebElement field, String text) {
        assertTrue(field.isDisplayed());
        field.click();
        field.clear();
        field.sendKeys(text);
    }
}
