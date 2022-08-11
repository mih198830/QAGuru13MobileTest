package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/android.properties")
public interface AndroidConfig extends Config {
    @Key("device.name")
    String getGetDeviceName();

    @Key("device.os")
    String getOSVersion();
}
