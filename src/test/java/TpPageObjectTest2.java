import amazon.HomePage;
import commun.SetupTeardown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TpPageObjectTest2  extends SetupTeardown {

    ChromeOptions options = new ChromeOptions();
    FirefoxOptions options2 = new FirefoxOptions();
    EdgeOptions op3 = new  EdgeOptions ();


    final  String searchKeyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
    final int searchResultIndex = 0;
    final int quantityIndex =2 ;

    //
    //nom de la classe.non de la classe à l'interieur de la grande classe();

    @Test
    public void test() {

        HomePage homePage = new HomePage(driver);
        WebElement loginButton = driver.findElement(By.cssSelector("#nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton);
        actions.perform();
    }



    }
