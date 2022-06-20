package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ChromeWebDriverTest {
    public static ChromeDriver driver;

    @BeforeAll
    public static void setUp() {
        String baseDirectory = Paths.get("").toAbsolutePath().toString();
        Path webDriverPath = Paths.get(baseDirectory, "/src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", webDriverPath.toString());
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void close() {
        driver.quit();
    }
}
