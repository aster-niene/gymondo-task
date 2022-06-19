package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyPlanPage{

    private final String MY_PLAN_PAGE = "https://www.gymondo.com/train/timeline";
    private final String CSS_PLAN_SETTINGS_BUTTON = "button.plan-settings-button_button__1npuE";
    private final String X_PATH_TRANING_DAYS_SELECTOR_SUNDAY_BUTTON = "//button[@role='option'][1]";
    private final String X_PATH_TRANING_DAYS_SELECTOR_MONDAY_BUTTON = "//button[@role='option'][2]";
    private final String X_PATH_TRANING_DAYS_SELECTOR_TUESDAY_BUTTON = "//button[@role='option'][3]";
    private final String X_PATH_TRANING_DAYS_SELECTOR_WEDNESDAY_BUTTON = "//button[@role='option'][4]";
    private final String X_PATH_TRANING_DAYS_SELECTOR_THURSDAY_BUTTON = "//button[@role='option'][5]";
    private final String X_PATH_TRANING_DAYS_SELECTOR_FRIDAY_BUTTON = "//button[@role='option'][6]";
    private final String X_PATH_TRANING_DAYS_SELECTOR_SATURDAY_BUTTON = "//button[@role='option'][7]";
    private final String X_PATH_PLAN_TRANING_DAYS_SAVE_BUTTON = "//button//div[text()='Save']";

    private ChromeDriver driver;

    public MyPlanPage(ChromeDriver driver) {
        this.driver = driver;
    }

    //private final String TITLE = "Gymondo Online Fitness - Get Fit & Happy at Home";
    //private final String CSS_ACCOUNT_MENU_BUTTON = "span.header_navItem__ph4Aw";
    //private final String CSS_YOUR_ACCOUNT_BUTTON = "li.user-actions_bold__BsKkr";
    //private final String CSS_GREETING_HEADER = "div.header_greeting__B-XLP";


    /*WebElement menuAccountButton = driver.findElementByCssSelector(CSS_ACCOUNT_MENU_BUTTON);
    WebElement yourAccountButton = driver.findElementByCssSelector(CSS_YOUR_ACCOUNT_BUTTON);

    public void menuAccountButtonClick (){
        buttonClick (menuAccountButton);
    }
    public void yourAccountButtonClick (){
        buttonClick (yourAccountButton);
    }*/

//    WebElement planSettingsButton = driver.findElementByCssSelector(CSS_PLAN_SETTINGS_BUTTON);
//    WebElement traningDaySundayButton = driver.findElementByXPath(X_PATH_TRANING_DAYS_SELECTOR_SUNDAY_BUTTON);
//    WebElement traningDayMondayButton = driver.findElementByXPath(X_PATH_TRANING_DAYS_SELECTOR_MONDAY_BUTTON);
//    WebElement traningDayTuesdayButton = driver.findElementByXPath(X_PATH_TRANING_DAYS_SELECTOR_TUESDAY_BUTTON);
//    WebElement traningDayWednesdayButton = driver.findElementByXPath(X_PATH_TRANING_DAYS_SELECTOR_WEDNESDAY_BUTTON);
//    WebElement traningDayThursdayButton = driver.findElementByXPath(X_PATH_TRANING_DAYS_SELECTOR_THURSDAY_BUTTON);
//    WebElement traningDayFridayButton = driver.findElementByXPath(X_PATH_TRANING_DAYS_SELECTOR_FRIDAY_BUTTON);
//    WebElement traningDaySaturdayButton = driver.findElementByXPath(X_PATH_TRANING_DAYS_SELECTOR_SATURDAY_BUTTON);
//    WebElement planTraningDaysSaveButton = driver.findElementByXPath(X_PATH_PLAN_TRANING_DAYS_SAVE_BUTTON);






//    public void planSettingsButtonClick (){
//        buttonClick (planSettingsButton);
//    }
//    private void buttonClick (WebElement button){
//        assertTrue(button.isDisplayed());
//        button.click();
//    }

    private boolean buttonEnableCheck (){
        return true;
    }

}
