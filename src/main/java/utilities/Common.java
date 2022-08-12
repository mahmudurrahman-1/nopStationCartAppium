package utilities;

import driver.PageDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.Arrays;

public class Common {


    public static void sendText(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void verticalScroll(WebElement element) {
        //Creating Vertical Scroll Event
        //Scrollable Element

        int centerX = element.getRect().x + (element.getSize().width / 2);

        double startY = element.getRect().y + (element.getSize().height * 0.9);

        double endY = element.getRect().y + (element.getSize().height * 0.1);
        //Type of Pointer Input
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        //Creating Sequence object to add actions
        Sequence swipe = new Sequence(finger, 1);
        //Move finger into starting position
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int) startY));
        //Finger comes down into contact with screen
        swipe.addAction(finger.createPointerDown(0));
        //Finger moves to end position
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(550),
                PointerInput.Origin.viewport(), centerX, (int) endY));
        //Get up Finger from Srceen
        swipe.addAction(finger.createPointerUp(0));

        //Perform the actions
        PageDriver.getCurrentDriver().perform(Arrays.asList(swipe));

    }


    public void horizontalScroll(WebElement element) {
        //Creating Horizontal Scroll Event
        //Scrollable Element
//        WebElement ele01 = driver.findElement(AppiumBy.id("net.skyscanner.android.main:id/nav_card_recycle_view"));

        int centerY = element.getRect().y + (element.getSize().height / 2);

        double startX = element.getRect().x + (element.getSize().width * .92);

        double endX = element.getRect().x + (element.getSize().width * 0.08);
        //Type of Pointer Input
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        //Creating Sequence object to add actions
        Sequence swipe = new Sequence(finger, 1);
        //Move finger into starting position
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), (int) startX, centerY));
        //Finger comes down into contact with screen
        swipe.addAction(finger.createPointerDown(0));
        //Finger moves to end position
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(400),
                PointerInput.Origin.viewport(), (int) endX, centerY));
        //Get up Finger from Srceen
        swipe.addAction(finger.createPointerUp(0));

        //Perform the actions
        PageDriver.getCurrentDriver().perform(Arrays.asList(swipe));

        try {
            Thread.sleep(3000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**********************
     * Touch Scroll
     */
    public void MakeScrollDown() {
        TouchAction action = new TouchAction(PageDriver.getCurrentDriver());
        action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(ofSeconds(1)))
                .moveTo(PointOption.point(115, 350)).release().perform();
    }
}
