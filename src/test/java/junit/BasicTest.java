package junit;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BasicTest {
    private WebDriver driver = null;

    @BeforeAll
    static void initAll() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeEach
    void init() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName(value = "Open Google Search")
    void TestNo1() {
        driver.navigate().to("https://www.google.co.uk");
        Assertions.assertEquals("Google", driver.getTitle());
    }

    @AfterEach
    void dispose() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
