package guru.qa.drivers;

import guru.qa.drivers.drivers_all.BrowserStackMobileDriver;
import guru.qa.drivers.drivers_all.RealOrEmulatorDriver;

public class DriverSwitcher {

    public static String getDriver(String driverSwitch) {

        switch (driverSwitch) {
            case "browserstack":
                return BrowserStackMobileDriver.class.getName();
            case "real_or_emul":
                return RealOrEmulatorDriver.class.getName();
            default:
                throw new RuntimeException("Select device: browserstack / real_or_emul");
        }
    }
}
