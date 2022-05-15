package guru.qa.drivers.drivers_all;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static guru.qa.helpers.Browserstack.browserstackLogin;
import static guru.qa.helpers.Browserstack.browserstackPassword;

public class BrowserStackMobileDriver implements WebDriverProvider {

    public static URL getBrowserStackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.appium_version", "1.22.0");
        mutableCapabilities.setCapability("browserstack.user", browserstackLogin);
        mutableCapabilities.setCapability("browserstack.key", browserstackPassword);
        mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        mutableCapabilities.setCapability("device", "Google Pixel 3");
        mutableCapabilities.setCapability("os_version", "9.0");
        mutableCapabilities.setCapability("project", "QA.GURU lesson 11/22");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "Sample tests run");

        return new RemoteWebDriver(getBrowserStackUrl(), mutableCapabilities);
    }


}
