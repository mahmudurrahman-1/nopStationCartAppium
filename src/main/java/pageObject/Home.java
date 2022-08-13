package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

import java.util.List;

public class Home extends Common {
    public Home() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    /***************
     * All the locators
     */
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnAccept")
    WebElement btnAccept;
    @FindBy(className = "android.widget.ImageButton")
    List<WebElement> menuButton;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvProductName")
    List<WebElement> CategoryGroups;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvName")
    List<WebElement> listMenu;
    @FindBy(className = "androidx.recyclerview.widget.RecyclerView")
    WebElement homeCategoriesContainer;

    //pop up window accept
    public void ClickAccept() {
        btnAccept.click();
    }

    //scroll category
    public void scrollCategory() {
        horizontalScroll(homeCategoriesContainer);
    }
    //Select electronics

    public void FindEletronics() {
        CategoryGroups.get(2).click();

    }

}
