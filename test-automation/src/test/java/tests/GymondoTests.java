package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.MyPlanPage;
import pages.ProgramsPage;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GymondoTests extends ChromeWebDriverTest {
    private LoginPage loginPage;
    private MyPlanPage myPlanPage;
    private ProgramsPage programsPage;
    private final String LOGIN = "qa-prod1@gymondo.de";
    private final String PASSWORD = "purpleSquid22!";

    @BeforeEach
    public void init() {
        loginPage = new LoginPage(driver);
        myPlanPage = new MyPlanPage(driver);
        programsPage = new ProgramsPage(driver);
    }

    @Test
    public void openLoginPage() throws InterruptedException {
        loginPage.open();
        assertThat(loginPage.atPage()).isTrue();
        loginPage.acceptButtonClick();
        loginPage.loginButtonClick();
        loginPage.inputLoginPassword(LOGIN, PASSWORD);
        loginPage.submitButtonClick();

        myPlanPage.modalWindowsCloseButtonClick();
        preperNewTrainingProgram();
        myPlanPage.planSettingsButtonClick();
        assertThat(myPlanPage.checkActivitySaveButton()).isFalse();


        //String startProgramm = driver.findElementByCssSelector("button.btn-gym.btn--flex.btn--medium.recommendation_button__jtVz9").getAttribute("type");





        System.out.println("OK");
    }


    private void preperNewTrainingProgram(){
        if(myPlanPage.getGreetingSubtitle().getText().contains("Select a program and start planning your workout routine.")){
            createNewTrainingProgram();
        }
        else if (myPlanPage.getGreetingSubtitle().getText().contains("You have")){
            deleteOldTrainingProgram();
            createNewTrainingProgram();
        }
    }
    private void createNewTrainingProgram(){
        myPlanPage.startNewProgramButtonClick();
        programsPage.startProgramButtonClick();
        programsPage.planSettingsSaveButtonClick();
    }
    private void deleteOldTrainingProgram(){
        myPlanPage.planSettingsButtonClick();
        myPlanPage.planSettingsDaysEndButtonClick();
        myPlanPage.planSettingsDaysEndProgramButtonClick();
    }

}
