package others;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BrowserFactory {

    private WebBrowser webBrowser;
    private WebDriver driver;



    public BrowserFactory(WebBrowser webBrowser) {
        this.webBrowser = webBrowser;
    }

    public WebDriver getDriver() throws Exception {
        switch (webBrowser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("drivers/chromedriver.exe").toURI().getPath());
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", ClassLoader.getSystemResource("drivers/geckodriver_old.exe").toURI().getPath());
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                driver = new FirefoxDriver(options);
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver", ClassLoader.getSystemResource("drivers/MicrosoftWebDriver.exe").toURI().getPath());
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalStateException("WebBrowser + " + webBrowser + " is not supported!");
        }
        return driver;
    }
}
