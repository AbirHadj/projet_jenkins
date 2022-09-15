package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class SearchResultPage {
    private WebDriver driver;



private By rechercherResulatsSelector= By.cssSelector( "[data-cel-widget=search_result_2]");

    private final int TIMEOUT_COOKIE = 6;

    public SearchResultPage (WebDriver driver) {
        this.driver=driver;
    }


    public void SearchResults(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement premierResultat = wait.until(ExpectedConditions.elementToBeClickable(rechercherResulatsSelector));
        premierResultat.click();
    }
}
