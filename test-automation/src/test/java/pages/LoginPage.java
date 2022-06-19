package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.ChromeWebDriverTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.BasePage.GYMONDO_HOST;

public class LoginPage {

    private final String TITLE = "Gymondo Online Fitness - Get Fit & Happy at Home";
    private final String X_PATH_LOG_IN_BUTTON = "//nav[@class='top-nav']//div[text()='Log in']";
    private final String CSS_LOGIN_FIELD = "input[id='mail']";
    private final String CSS_PASSWORD_FIELD = "input[id='password']";
    private final String CSS_SUBMIT_BUTTON = "button[type='submit']";

    private ChromeDriver driver;

//    WebElement logInButton = driver.findElementByXPath(X_PATH_LOG_IN_BUTTON);
//    WebElement loginField = driver.findElementByCssSelector(CSS_LOGIN_FIELD);
//    WebElement passwordField = driver.findElementByCssSelector(CSS_PASSWORD_FIELD);
//    WebElement submitButton = driver.findElementByCssSelector(CSS_SUBMIT_BUTTON);

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;

    }

    public boolean atPage(){
        return driver.getTitle().equals(TITLE);
    }

    public void open() {
        driver.get(GYMONDO_HOST);
       // assertTrue(checkTitle());
    }


//    public void login(String name, String password) {
//        inputToFiled(loginField, name);
//        inputToFiled(passwordField, password);
//    }
//
    private void buttonClick(WebElement button) {
       // assertTrue(button.isDisplayed());
        button.click();
    }
//
//    public void submitButtonClick() {
//        buttonClick(submitButton);
//    }
//
    public void loginButtonClick() {
        buttonClick(getLoginButton());
    }

    private WebElement getLoginButton() {
        return  driver.findElementByXPath(X_PATH_LOG_IN_BUTTON);
    }
//
//    private boolean checkTitle() {
//        return driver.getTitle().equals(TITLE);
//    }
//
//    private void inputToFiled(WebElement field, String text) {
//        assertTrue(field.isDisplayed());
//        field.click();
//        field.clear();
//        field.sendKeys(text);
//    }

}
