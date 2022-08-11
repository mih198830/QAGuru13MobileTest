package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AndroidConfig;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    static AndroidConfig phoneConfig = ConfigFactory.create(AndroidConfig.class);
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", config.user());
        mutableCapabilities.setCapability("browserstack.key", config.key());
        mutableCapabilities.setCapability("app", config.appUrl());
        mutableCapabilities.setCapability("device", phoneConfig.getGetDeviceName());
        mutableCapabilities.setCapability("os_version", phoneConfig.getOSVersion());

        mutableCapabilities.setCapability("project", "QAGuruMobileHomework");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "WikipediaAppSettingExistTest");

        return new RemoteWebDriver(getBrowserStackURL(), mutableCapabilities);
    }
        public static URL getBrowserStackURL() {
            try {
                return new URL(config.browserstackUrl());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
}
    //gradle clean android -Dos_version=11.0
