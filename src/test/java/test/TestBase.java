package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import test.Jenkins.Attachments;

import java.util.Map;

public class TestBase {

    static String selenoidUserLogin = System.getProperty("selenoidUserLogin", "user1");
    static String selenoidUserPassword = System.getProperty("selenoidUserPassword", "1234");
    static String selenoidRemoteServerUrl = System.getProperty(
            "selenoidRemoteServerUrl", "selenoid.autotests.cloud");
    static String browser = System.getProperty("browser", "chrome");
    static String browserVersion = System.getProperty("browserVersion", "128.0");
    static String browserSize = System.getProperty("browserResolution", "1920x1080");

    @BeforeAll
    static void setupConfig () {
        //Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

        Configuration.browserSize = browserSize;
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.remote = "https://" +
                selenoidUserLogin + ":" + selenoidUserPassword +"@" + selenoidRemoteServerUrl + "/wd/hub";
        Configuration.remote = "https://" +
                selenoidUserLogin + ":" + selenoidUserPassword +"@" + selenoidRemoteServerUrl + "/wd/hub";

        // Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        Selenide.closeWebDriver();
    }
}
