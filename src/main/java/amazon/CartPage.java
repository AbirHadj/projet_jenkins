package main.java.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    private WebDriver driver;


    private By selectQuantitySelector = By.cssSelector("#quantity");
    private By getFirstProductNameSelector = By.cssSelector(".a-text-bold + span");
    private By subtotalSelector = By.cssSelector("#sc-subtotal-label-activecart");





    /*public void selectQuantity (){
        Select quantiteDropdown = new Select(dropdown);
        quantiteDropdown.selectByIndex(quantity);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/







}
