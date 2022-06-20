package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProgramsPage {
    private final String CSS_START_PROGRAM_BUTTON = "button.hero_startBtn__tuZ8g";
    private final String CSS_PLAN_SETTINGS_SAVE_BUTTON = "button.btn-gym.btn--small";



    private ChromeDriver driver;

    public ProgramsPage(ChromeDriver driver) {
        this.driver = driver;
    }

    private WebElement getStartProgramButton() {
        return BasePage.getElementWithExplicitWait(driver, CSS_START_PROGRAM_BUTTON);
    }
    private WebElement getPlanSettingsSaveButton() {
        return BasePage.getElementWithExplicitWait(driver, CSS_PLAN_SETTINGS_SAVE_BUTTON);
    }


    public void startProgramButtonClick() {
        buttonClick(getStartProgramButton());
    }
    public void planSettingsSaveButtonClick() {
        buttonClick(getPlanSettingsSaveButton());
    }


    private void buttonClick(WebElement button) {
        button.click();
    }

}
