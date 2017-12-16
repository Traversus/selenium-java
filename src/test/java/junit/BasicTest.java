package junit;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

class BasicTest {
    private static Logger logger = LogManager.getLogger();
    private static ChromeDriverService service;
    private WebDriver driver = null;

    @BeforeAll
    static void initAll() throws IOException {
        logger.info("Starting ChromeDriverService");
        ChromeDriverManager.getInstance().setup();
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(ChromeDriverManager.getInstance().getBinaryPath()))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @BeforeEach
    void init() {
        logger.info("Creating a Chrome instance");
        driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
    }

    @Test
    @DisplayName(value = "Open Google Search")
    void TestNo1() {
        driver.navigate().to("https://www.google.co.uk");
        Assertions.assertEquals("Google", driver.getTitle());
    }

    @AfterEach
    void dispose() {
        logger.info("Destroying Chrome instance");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @AfterAll
    static void disposeAll() {
        logger.info("Closing down ChromeDriverService");
        service.stop();
    }
}
