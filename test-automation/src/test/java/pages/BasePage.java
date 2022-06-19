package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  final class BasePage {
    private BasePage() {}
    public static final String GYMONDO_HOST =  "https://www.gymondo.com";

    public static WebElement getElementWithExplicitWait(ChromeDriver driver, String cssSelector){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        return element;
    }

}
