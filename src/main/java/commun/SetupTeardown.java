package commun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;


public class SetupTeardown {
String browser="chrome";

    public WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
       /* //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //  ChromeOptions options = new ChromeOptions(); des options sur chrome drivers
        //options.setCapability(CapabilityType.BROWSER_NAME,"chrome");
       // driver = new RemoteWebDriver(new URL("http://admin:admin@192.168.121.22:4444"), options);
        // driver = new ChromeDriver(); ce qu'on a fait da sles lignes précédentes remplace cette ligne
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();

        */
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
            break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
            break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;

        }


        //driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }


}
