package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

import java.util.List;

public class MoneyOrder extends Common {
    public MoneyOrder(){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
    }

    /**************
     * Locators
     */
    @FindBy(className = "android.widget.ScrollView")
    WebElement scrolldown;
    @FindBy(className = "android.widget.RelativeLayout")
    List<WebElement> allCate;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnContinue")
    WebElement submitbutton;

    /****************
     * Actions

     */
//Scrolls down
    public void setScrolldown()  {
        verticalScroll(scrolldown,100);
    }

//Submits the payment way
    public void submitMoneyrder(){
        submitbutton.click();
    }

}
