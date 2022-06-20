package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyPlanPage {

    private final String MY_PLAN_PAGE = "https://www.gymondo.com/train/timeline";
    private final String CSS_PLAN_SETTINGS_BUTTON = "button.plan-settings-button_button__1npuE";
    private final String CSS_MODAL_WINDOWS_CLOSE_BUTTON = "div.modal_closeWrapper__BBoXJ";
    private final String CSS_SCHEDULE_TRAINING_DAY_WARNING_NUMBER_SELECTED_DAYS = "div.plan-settings-modal_errorMessage__ALjDA";
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

    public WebElement getGreetingSubtitle() {
        return BasePage.getElementWithExplicitWait(driver, CSS_GREETING_SUBTITLE);
    }

    private WebElement getWarningNumberSelectedDays() {
        return BasePage.getElementWithExplicitWait(driver, CSS_SCHEDULE_TRAINING_DAY_WARNING_NUMBER_SELECTED_DAYS);
    }

    private WebElement getPlanSettingsDaysEndButton() {
        return BasePage.getElementWithExplicitWait(driver, CSS_PLAN_SETTINGS_DAYS_END_BUTTON);
    }

    private WebElement getPlanSettingsDaysEndProgramButton() {
        return BasePage.getElementWithExplicitWait(driver, CSS_PLAN_SETTINGS_DAYS_END_PROGRAM_BUTTON);
    }

    private WebElement getPlanSettingsDaysSaveButton() {
        return driver.findElementByCssSelector(CSS_PLAN_SETTINGS_DAYS_SAVE_BUTTON);
    }

    public void modalWindowsCloseButtonClick() {
        buttonClick(getModalWindowsCloseButton());
    }

    public void planSettingsButtonClick() {
        buttonClick(getPlanSettingsButton());
    }

    public void startNewProgramButtonClick() {
        buttonClick(getStartNewProgramButton());
    }

    public void planSettingsDaysEndButtonClick() {
        buttonClick(getPlanSettingsDaysEndButton());
    }

    public void planSettingsDaysEndProgramButtonClick() {
        buttonClick(getPlanSettingsDaysEndProgramButton());
    }

    public void planSettingsDaysSaveButtonClick() {
        buttonClick(getPlanSettingsDaysSaveButton());
    }

    private void planSettingsDaysAddDay(ScheduleTrainingDays day) {
        if (!planSettingsDaysButtonActivityCheck(day.getxPath())) {
            driver.findElementByXPath(day.getxPath()).click();
        }
    }

    private boolean planSettingsDaysButtonActivityCheck(String xPath) {
        return driver.findElementByXPath(xPath).getAttribute("aria-selected").equals("true");
    }

    public int planSettingsDaysNumberActiveDays() {
        int numberActiveDays = 0;
        for (ScheduleTrainingDays day : ScheduleTrainingDays.values()) {
            if (planSettingsDaysButtonActivityCheck(day.getxPath())) {
                numberActiveDays++;
            }
        }
        return numberActiveDays;
    }

    public boolean planSettingsDaysCheckActivitySaveButton() {
        return !driver.findElementByCssSelector("div.plan-settings-modal_footerButton__RJtdU button.btn-gym")
                .getAttribute("class").contains("btn--disabled");
    }

    public void planSettingsDaysAddOllDays() {
        for (ScheduleTrainingDays day : ScheduleTrainingDays.values()) {
            planSettingsDaysAddDay(day);
        }
    }

    public boolean warningNumberSelectedDaysDisplayed() {
        return getWarningNumberSelectedDays().getText().contains("Please select between 1 and 6 workouts per week.");
    }

    private void buttonClick(WebElement button) {
        button.click();
    }
}
