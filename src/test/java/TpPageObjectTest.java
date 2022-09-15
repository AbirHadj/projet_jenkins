import amazon.HomePage;

import amazon.SearchResultPage;
import commun.SetupTeardown;
import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.amazon.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpPageObjectTest extends SetupTeardown {


    //nom de la classe.non de la classe à l'interieur de la grande classe();
    @Test
    public void testPO()  {

        ChromeOptions options = new ChromeOptions();
        FirefoxOptions options2 = new FirefoxOptions();
        EdgeOptions op3 = new  EdgeOptions ();


        final  String searchKeyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
        final int searchResultIndex = 0;
        final int quantityIndex =2 ;

        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();
        homePage.searchElement("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");

        SearchResultPage SearchResults = new SearchResultPage(driver);
        SearchResults.SearchResults();

        ProductPage productPage = new ProductPage(driver);
        productPage.addtoCart();
        productPage.RefuseAppleCare();
        productPage.openCart();

    }



    }
