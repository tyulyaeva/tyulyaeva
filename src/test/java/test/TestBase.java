package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import test.Jenkins.Attachments;

import java.util.Map;
import java.util.UUID;

public class TestBase {
//    private static final String SELENOID_URL = System.getProperty("selenoid.url");
//    private static final String SELENOID_LOGIN = System.getProperty("selenoid.login");
//    private static final String SELENOID_PASSWORD = System.getProperty("selenoid.password");

    String selenoidUserLogin = System.getProperty("selenoidUserLogin", "user1");
    String selenoidUserPassword = System.getProperty("selenoidUserPassword", "1234");
    String selenoidRemoteServerUrl = System.getProperty(
            "selenoidRemoteServerUrl", "selenoid.autotests.cloud");
    static String browser = System.getProperty("browser", "chrome");
    static String browserVersion = System.getProperty("browserVersion", "128.0");
    static String browserSize = System.getProperty("browserResolution", "1920x1080");

    @BeforeAll
    static void setupConfig(){
//        Configuration.browserSize = "1920x1080";
//        SelenideLogger.addListener("allure", new AllureSelenide());
//        Configuration.baseUrl = "https://demoqa.com/";
//        Configuration.pageLoadStrategy ="eager";
//        Configuration.timeout = 10000;
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//        Configuration.browserCapabilities = capabilities;
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = false;

//        String selenoidHost = System.getProperty("selenoid_host", "selenoid.autotests.cloud");
//        String selenoidLogin = System.getProperty("selenoid_login", "user1");
//        String selenoidPassword = System.getProperty("selenoid_password", "1234");
//        String browser = System.getProperty("browser", "chrome");
//        String browserVersion = System.getProperty("browserVersion", "127.0");
//        String screenResolution = System.getProperty("screenResolution", "1920x1080");
//
//        WebDriverManager.chromedriver()
//                .clearDriverCache()
//                .clearResolutionCache()
//                .setup();
//
//        Configuration.baseUrl = "https://demoqa.com/";
//        Configuration.browserSize = screenResolution;
//        Configuration.browser = browser;
//        Configuration.browserVersion = browserVersion;
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.timeout = 10000;
//        Configuration.remote = String.format("https://%s:%s@%s/wd/hub",
//                selenoidLogin,
//                selenoidPassword,
//                selenoidHost);


//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//        Configuration.browserCapabilities = capabilities;
//
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true,
                "name", "Test: " + UUID.randomUUID()
        ));
        Configuration.remote = "https://" +
                selenoidUserLogin + ":" + selenoidUserPassword +"@" + selenoidRemoteServerUrl + "/wd/hub";        Configuration.browserCapabilities = capabilities;
        Configuration.holdBrowserOpen = false;
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
