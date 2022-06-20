package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyPlanPage{

    private final String MY_PLAN_PAGE = "https://www.gymondo.com/train/timeline";
    private final String CSS_PLAN_SETTINGS_BUTTON = "button.plan-settings-button_button__1npuE";
    private final String CSS_MODAL_WINDOWS_CLOSE_BUTTON = "div.modal_closeWrapper__BBoXJ";
    private final String X_PATH_SCHEDULE_TRANING_DAYS_SELECTOR_SUNDAY_BUTTON = "//button[@role='option'][1]";
    private final String X_PATH_SCHEDULE_TRANING_DAYS_SELECTOR_MONDAY_BUTTON = "//button[@role='option'][2]";
    private final String X_PATH_SCHEDULE_TRANING_DAYS_SELECTOR_TUESDAY_BUTTON = "//button[@role='option'][3]";
    private final String X_PATH_SCHEDULE_TRANING_DAYS_SELECTOR_WEDNESDAY_BUTTON = "//button[@role='option'][4]";
    private final String X_PATH_SCHEDULE_TRANING_DAYS_SELECTOR_THURSDAY_BUTTON = "//button[@role='option'][5]";
    private final String X_PATH_SCHEDULE_TRANING_DAYS_SELECTOR_FRIDAY_BUTTON = "//button[@role='option'][6]";
    private final String X_PATH_SCHEDULE_TRANING_DAYS_SELECTOR_SATURDAY_BUTTON = "//button[@role='option'][7]";
    private final String CSS_PLAN_SETTINGS_DAYS_SAVE_BUTTON = "div.plan-settings-modal_footerButton__RJtdU button.btn-gym";
    private final String CSS_PLAN_SETTINGS_DAYS_END_BUTTON = "button.btn-gym--tertiary.plan-settings-modal_button__YJm7G";
    private final String CSS_PLAN_SETTINGS_DAYS_END_PROGRAM_BUTTON = "button.plan-settings-modal_button__YJm7G";

    private final String CSS_GREETING_SUBTITLE = "h2.gym-subtitle.header_subHeader__4iy8X";
    private final String CSS_START_NEW_PROGRAM_BUTTON = "button.recommendation_button__jtVz9";

    private ChromeDriver driver;

    public MyPlanPage(ChromeDriver driver) {
        this.driver = driver;
    }

    private WebElement getModalWindowsCloseButton() {
        return BasePage.getElementWithExplicitWait(driver, CSS_MODAL_WINDOWS_CLOSE_BUTTON);
    }
    private WebElement getPlanSettingsButton() {
        return BasePage.getElementWithExplicitWait(driver, CSS_PLAN_SETTINGS_BUTTON);
    }
    private WebElement getStartNewProgramButton() {
        return BasePage.getElementWithExplicitWait(driver, CSS_START_NEW_PROGRAM_BUTTON);
    }
    public WebElement getGreetingSubtitle(){
        return BasePage.getElementWithExplicitWait(driver, CSS_GREETING_SUBTITLE);
        //return driver.findElementByCssSelector(CSS_GREETING_SUBTITLE);
    }

    private WebElement getPlanSettingsDaysEndButton() {
        return BasePage.getElementWithExplicitWait(driver, CSS_PLAN_SETTINGS_DAYS_END_BUTTON);
    }
    private WebElement getPlanSettingsDaysEndProgramButton() {
        return BasePage.getElementWithExplicitWait(driver, CSS_PLAN_SETTINGS_DAYS_END_PROGRAM_BUTTON);
    }


    public void modalWindowsCloseButtonClick() {
        buttonClick(getModalWindowsCloseButton());
    }
    public void planSettingsButtonClick() {
        buttonClick(getPlanSettingsButton());
    }
    public void startNewProgramButtonClick(){
        buttonClick(getStartNewProgramButton());
    }

    public void planSettingsDaysEndButtonClick(){
        buttonClick(getPlanSettingsDaysEndButton());
    }
    public void planSettingsDaysEndProgramButtonClick(){
        buttonClick(getPlanSettingsDaysEndProgramButton());
    }



    public boolean checkActivitySaveButton(){
        WebElement planSettingsDaysSaveButton = driver.findElementByCssSelector("div.plan-settings-modal_footerButton__RJtdU button.btn-gym");
        if (planSettingsDaysSaveButton.getAttribute("class").contains("btn--disabled")) {
            return false;
        }
            return true;
    }








//    public void planSettingsButtonClick (){
//        buttonClick (planSettingsButton);
//    }
//    private void buttonClick (WebElement button){
//        assertTrue(button.isDisplayed());
//        button.click();
//    }


    //WebDriverWait wait=new WebDriverWait(driver, 20);
    //element1 = wait.until(ExpectedConditions.elementToBeClickable(By.className("fa-stack-1x")));
    private void buttonClick(WebElement button) {
        button.click();
    }

    private boolean buttonEnableCheck (){
        return true;
    }

}
