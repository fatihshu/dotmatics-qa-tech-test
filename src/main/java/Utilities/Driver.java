package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
        private Driver() {}
        private static RemoteWebDriver remoteWebDriver ;

        public static RemoteWebDriver get() {
            if (remoteWebDriver == null) {
                String browser = ConfigurationReader.get("browser");
                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        remoteWebDriver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        remoteWebDriver = new FirefoxDriver();
                        break;
                }
            }
            return remoteWebDriver;
        }

        public static void closeDriver () {
            if (remoteWebDriver != null) {
                remoteWebDriver.quit();
                remoteWebDriver = null;
            }
        }
    }

