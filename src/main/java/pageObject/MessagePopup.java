package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePopup {
    public void MessagePopup(){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);

    }


    /*********
     * Locators
     */
    @FindBy(id= "com.nopstation.nopcommerce.nopstationcart:id/back_arrow")
    WebElement returnto;

    @FindBy(id= "com.nopstation.nopcommerce.nopstationcart:id/md_text_title")
    WebElement titletext;
    @FindBy(id= "com.nopstation.nopcommerce.nopstationcart:id/md_text_message")
    WebElement successtext;
    @FindBy(id= "com.nopstation.nopcommerce.nopstationcart:id/md_button_positive")
    WebElement Furthercontinue;

    /**********
     * Actions
     */
    public void succeedMessagepopup() throws InterruptedException{
        Thread.sleep(4000);
        returnto.click();
    }
}
