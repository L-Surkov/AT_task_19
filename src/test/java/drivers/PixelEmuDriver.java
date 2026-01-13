package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulatorConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.URL;

public class PixelEmuDriver implements WebDriverProvider {

    private final EmulatorConfig emuConfig = ConfigFactory.create(EmulatorConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(emuConfig.platformName())
                .setAutomationName("UiAutomator2")
                .setDeviceName(emuConfig.deviceName())
                .setAvd(emuConfig.deviceAvd())
                .setAppPackage("org.wikipedia")
                .setNoReset(false)
                .setAppWaitActivity("*");

        try {
            URL url = new URL(emuConfig.hubUrl());

            return new AndroidDriver(url, options);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Android driver", e);
        }
    }
}