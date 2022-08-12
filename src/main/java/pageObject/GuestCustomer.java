package pageObject;

import driver.PageDriver;
import org.openqa.selenium.support.PageFactory;

public class GuestCustomer {
    public GuestCustomer() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }
}
