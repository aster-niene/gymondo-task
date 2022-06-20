package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyPlanPage{

    private final String MY_PLAN_PAGE = "https://www.gymondo.com/train/timeline";
    private final String CSS_PLAN_SETTINGS_BUTTON = "button.plan-settings-button_button__1npuE";
    private final String CSS_MODAL_WINDOWS_CLOSE_BUTTON = "div.modal_closeWrapper__BBoXJ";
    private final String CSS_SCHEDULE_TRAINING_DAY_WARNING_NUMBER_SELECTED_DAYS = "div.plan-settings-modal_errorMessage__ALjDA";

    public final String X_PATH_SCHEDULE_TRAINING_DAY_SELECTOR_SUNDAY_BUTTON = "//button[@role='option'][1]";
    public final String X_PATH_SCHEDULE_TRAINING_DAY_SELECTOR_MONDAY_BUTTON = "//button[@role='option'][2]";
    public final String X_PATH_SCHEDULE_TRAINING_DAY_SELECTOR_TUESDAY_BUTTON = "//button[@role='option'][3]";
    public final String X_PATH_SCHEDULE_TRAINING_DAY_SELECTOR_WEDNESDAY_BUTTON = "//button[@role='option'][4]";
    public final String X_PATH_SCHEDULE_TRAINING_DAY_SELECTOR_THURSDAY_BUTTON = "//button[@role='option'][5]";
    public final String X_PATH_SCHEDULE_TRAINING_DAY_SELECTOR_FRIDAY_BUTTON = "//button[@role='option'][6]";
    public final String X_PATH_SCHEDULE_TRAINING_DAY_SELECTOR_SATURDAY_BUTTON = "//button[@role='option'][7]";

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
    }

    public WebElement getWarningNumberSelectedDays(){
        return BasePage.getElementWithExplicitWait(driver, CSS_SCHEDULE_TRAINING_DAY_WARNING_NUMBER_SELECTED_DAYS);
    }

    private WebElement getPlanSettingsDaysEndButton() {
        return BasePage.getElementWithExplicitWait(driver, CSS_PLAN_SETTINGS_DAYS_END_BUTTON);
    }
    private WebElement getPlanSettingsDaysEndProgramButton() {
        return BasePage.getElementWithExplicitWait(driver, CSS_PLAN_SETTINGS_DAYS_END_PROGRAM_BUTTON);
    }

    private WebElement getScheduleTraningDayButton (ScheduleTrainingDays day){
        return driver.findElementByXPath(day.getxPath());
    }

    private WebElement getPlanSettingsDaysSaveButton (){
        return driver.findElementByCssSelector(CSS_PLAN_SETTINGS_DAYS_SAVE_BUTTON);
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

    public void planSettingsDaysSaveButtonClick(){
        buttonClick(getPlanSettingsDaysSaveButton());
    }

    public void addDayToSchedule (WebElement day){
        buttonClick(day);
    }


    public void planSettingsDaysAddDay (ScheduleTrainingDays day){
        if(!buttonActivityCheck(day.getxPath())) {
            driver.findElementByXPath(day.getxPath()).click();
        }
    }
    private boolean buttonActivityCheck (String xPath){
        return driver.findElementByXPath(xPath).getAttribute("aria-selected").equals("true");
    }

    public int planSettingsDaysNumberActiveDays(){
        int numberActiveDays = 0;
        for(ScheduleTrainingDays day: ScheduleTrainingDays.values()){
            if(buttonActivityCheck(day.getxPath())){
                numberActiveDays++;
            }
        }


        return numberActiveDays;
    }











    public boolean checkActivitySaveButton(){
        WebElement planSettingsDaysSaveButton = driver.findElementByCssSelector("div.plan-settings-modal_footerButton__RJtdU button.btn-gym");
        if (planSettingsDaysSaveButton.getAttribute("class").contains("btn--disabled")) {
            return false;
        }
            return true;
    }

    public boolean warningNumberSelectedDaysDisplayed(){
        if(getWarningNumberSelectedDays().getText().contains("Please select between 1 and 6 workouts per week.")){
            return true;
        }
        else {
            return false;
        }
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
