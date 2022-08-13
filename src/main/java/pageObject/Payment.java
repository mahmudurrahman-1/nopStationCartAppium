package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

import java.util.List;
import java.util.Set;

public class Payment extends Common {

public Payment(){
    PageFactory.initElements(PageDriver.getCurrentDriver(),this);
}

    /*****************
     * Locators
     */
    @FindBy(className= "android.widget.Button")
    WebElement nextbutton;
    @FindBy(id= "com.nopstation.nopcommerce.nopstationcart:id/checkoutButton")
    WebElement confirmbtn;



    /********************
     * Actions
     */

    // It switches Native app to webview and clicks next button
    public void switchToWebView() throws InterruptedException {
        Set<String> contextNames = PageDriver.getCurrentDriver().getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        Thread.sleep(3000);
        PageDriver.getCurrentDriver().context("NATIVE_APP"); // set context to NATIVE_APP
        nextbutton.click();

    }
    //Order Confirm
    public void finalConfirm(){
        confirmbtn.click();
    }
    //Success message


}
