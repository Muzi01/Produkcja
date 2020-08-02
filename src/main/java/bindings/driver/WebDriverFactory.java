package bindings.driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebDriverFactory {

    private final List<String> VALID_DRIVER_OPTIONS = new ArrayList<>(Arrays.asList("firefox", "chrome"));

    /**
     * Create browser specific and option specific web driver based on property file.
     * @return
     */
    public WebDriver createWebDriver() {

        String webDriverType;

        // Get driver option and exit if it is not a valid value.
        try {
            webDriverType = getWebDriverOption();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Error creating web driver!");
        }

        // Create and return web driver
        switch(webDriverType) {
            case "firefox":
                return createFireFoxDriver();
            case "chrome":
                return createChromeDriver();
            default:
                throw new RuntimeException("Unsupported webdriver: " + webDriverType);
        }
    }

    private String getWebDriverOption() throws Exception {
        String webDriverType = System.getProperty("selenium.options.driver");

        if (webDriverType == null) {
            throw new NullPointerException("The system property you are trying to set, selenium.options.driver, does not exists!");
        }

        if (!VALID_DRIVER_OPTIONS.contains(webDriverType)) {
            throw new Exception("The driver you have specified, " + webDriverType + ", is not a valid option or has not been implemented!");
        }

        return webDriverType;
    }

    public WebDriver createFireFoxDriver() {

        WebDriverManager.firefoxdriver().setup();

        // Configure firefox options
        FirefoxOptions options = this.getFirefoxOptions();

        // Create firefox driver
        FirefoxDriver firefoxDriver = new FirefoxDriver(options);

        // Set maximise here as firefox does not have command line argument for it
        String maximize = System.getProperty("firefox.selenium.options.maximize");

        if (maximize != null && maximize.equals("true")) {
            ((WebDriver) firefoxDriver).manage().window().maximize();
        }

        return firefoxDriver;
    }

    public WebDriver createChromeDriver() {

        WebDriverManager.chromedriver().setup();

        // Configure firefox options
        ChromeOptions options = this.getChromeOptions();

        // Create chrome driver
        ChromeDriver chromeDriver = new ChromeDriver(options);

        return chromeDriver;
    }

    private ChromeOptions getChromeOptions() {


        ChromeOptions chromeOptions = new ChromeOptions();

        String maximize = System.getProperty("chrome.selenium.options.maximize");
        String incognito = System.getProperty("chrome.selenium.options.incognito");
        String headless = System.getProperty("chrome.selenium.options.headless");

        if (maximize != null && maximize.equals("true")) {
            chromeOptions.addArguments("start-maximized");
        }
        if (incognito != null && incognito.equals("true")) {
            chromeOptions.addArguments("incognito");
        }

        if (headless != null && headless.equals("true")) {
            chromeOptions.addArguments("headless");
        }

        return chromeOptions;
    }

    private FirefoxOptions getFirefoxOptions() {

        FirefoxOptions firefoxOptions = new FirefoxOptions();

        String incognito = System.getProperty("firefox.selenium.options.incognito");
        String headless = System.getProperty("firefox.selenium.options.headless");

        if (incognito != null && incognito.equals("true")) {
            firefoxOptions.addArguments("-private");
        }

        if (headless != null && headless.equals("true")) {
            firefoxOptions.addArguments("-headless");
        }

        return firefoxOptions;
    }
}
