package main.java.commun;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.commun.ImportResultToxray;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


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
    public void teardown(ITestResult result) throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {

        ImportResultToxray res = new ImportResultToxray();

        if(result.getStatus() == ITestResult.SUCCESS)
        {
            System.out.println("passed **");
            res.generateJsonResults("PASSED");
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs (OutputType.FILE);
            FileHandler.copy(source, new File(System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png"));


        }
        else if(result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("FAILED******");
            res.generateJsonResults("FAILED");
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs (OutputType.FILE);
            FileHandler.copy(source, new File(System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png"));
        }
        else if(result.getStatus() == ITestResult.SKIP ){

            System.out.println("Skiped***");
            res.generateJsonResults("SKIPED");
        }
    res.RemonteResultats();
        driver.quit();

    }


}
