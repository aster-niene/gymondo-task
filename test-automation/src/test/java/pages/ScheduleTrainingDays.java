package pages;

public enum ScheduleTrainingDays {

    SUNDAY("//button[@role='option'][1]"),
    MONDAY("//button[@role='option'][2]"),
    TUESDAY("//button[@role='option'][3]"),
    WEDNESDAY("//button[@role='option'][4]"),
    THURSDAY("//button[@role='option'][5]"),
    FRIDAY("//button[@role='option'][6]"),
    SATURDAY("//button[@role='option'][7]");


    private final String xPath;

    ScheduleTrainingDays(String xPath) {
        this.xPath = xPath;
    }

    public String getxPath() {
        return xPath;
    }
}
