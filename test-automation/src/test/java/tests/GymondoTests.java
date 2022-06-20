package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MyPlanPage;
import pages.ProgramsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class GymondoTests extends ChromeWebDriverTest {
    private final int MAXIMUM_NUMBER_ACTIVE_DAYS = 6;
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
    public void planSettingsAddingWorkoutsDays() throws InterruptedException {
        loginPage.open();
        assertThat(loginPage.atPage()).isTrue();
        loginPage.acceptButtonClick();
        loginPage.loginButtonClick();
        loginPage.inputLoginPassword(LOGIN, PASSWORD);
        loginPage.submitButtonClick();
        myPlanPage.modalWindowsCloseButtonClick();
        preperNewTrainingProgram();

        myPlanPage.planSettingsButtonClick();
        assertThat(myPlanPage.planSettingsDaysCheckActivitySaveButton()).isFalse();
        myPlanPage.planSettingsDaysAddOllDays();
        assertThat(myPlanPage.warningNumberSelectedDaysDisplayed()).isTrue();
        assertThat(myPlanPage.planSettingsDaysCheckActivitySaveButton()).isTrue();
        myPlanPage.planSettingsDaysSaveButtonClick();
        Thread.sleep(500);
        myPlanPage.planSettingsButtonClick();
        assertThat(myPlanPage.planSettingsDaysNumberActiveDays()).isEqualTo(MAXIMUM_NUMBER_ACTIVE_DAYS);
    }

    private void preperNewTrainingProgram() {
        if (myPlanPage.getGreetingSubtitle().getText().contains("Select a program and start planning your workout routine.")) {
            createNewTrainingProgram();
        } else if (myPlanPage.getGreetingSubtitle().getText().contains("You have") || myPlanPage.getGreetingSubtitle().getText().contains("Today is your")) {
            deleteOldTrainingProgram();
            createNewTrainingProgram();
        }
    }

    private void createNewTrainingProgram() {
        myPlanPage.startNewProgramButtonClick();
        programsPage.startProgramButtonClick();
        programsPage.planSettingsSaveButtonClick();
    }

    private void deleteOldTrainingProgram() {
        myPlanPage.planSettingsButtonClick();
        myPlanPage.planSettingsDaysEndButtonClick();
        myPlanPage.planSettingsDaysEndProgramButtonClick();
    }
}
