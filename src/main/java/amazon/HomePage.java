package main.java.amazon;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private By acceptCookieSelector = By.cssSelector("[data-cel-widget=sp-cc-accept]");
    private  By searchElementsSelector  = By.cssSelector("[aria-label=Rechercher]");
    private  By loupeButtonSelector  = By.cssSelector("[type=submit]");

    final int TIMEOUT_COOKIE = 5;



    /**
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private static final Logger Log = LogManager.getLogger(HomePage.class);

    public void acceptCookie() {
        Log.info("J'accepte les cookies");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
    }

    //survoler la souris
    public void searchElement (String keyword) {
       /* on va remplacer le find element by la methode find direct @find et la la page factory
        */
       WebElement searchBar = driver.findElement(searchElementsSelector);
        searchBar. sendKeys(keyword);

        WebElement loupeButton = driver.findElement(loupeButtonSelector);
        loupeButton.click();
    }


}

