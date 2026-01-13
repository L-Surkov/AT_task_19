package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigReader;
import config.RemoteConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        RemoteConfig config = ConfigReader.INSTANCE.getConfig();

        MutableCapabilities caps = new MutableCapabilities();

        String browserstackUser = System.getProperty("browserstack.user");
        String browserstackKey = System.getProperty("browserstack.key");
        if (browserstackUser == null || browserstackKey == null) {
            throw new IllegalArgumentException(
                    "JVM properties 'browserstack.user' and 'browserstack.key' must be set. " +
                            "Use: -Dbrowserstack.user=YOUR_USER -Dbrowserstack.key=YOUR_KEY"
            );
        }

        caps.setCapability("browserstack.user", browserstackUser);
        caps.setCapability("browserstack.key", browserstackKey);


        caps.setCapability("project", config.project());
        caps.setCapability("build", config.buildName());
        caps.setCapability("name", config.testName());


        caps.setCapability("deviceName", config.deviceName());
        caps.setCapability("osVersion", config.osVersion());


        caps.setCapability("app", config.app());
        caps.setCapability("appium:automationName", config.appiumAutomationName());

        try {
            return new RemoteWebDriver(
                    new URL("https://hub-cloud.browserstack.com/wd/hub"),
                    caps
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid BrowserStack URL", e);
        }
    }
}
