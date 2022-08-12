package Hooks;

import driver.PageDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.CustomerProductAdd;
import pageObject.Home;
import utilities.ExcelDataParser;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class CustomerProductTest {

    /************
     * All the instances for class
     */
    Home homepage = new Home();
    CustomerProductAdd product_Page = new CustomerProductAdd();
    ExcelDataParser reader = new ExcelDataParser();


    /************
     * Actions performed as per Gherkins order
     */
    //home page after opening app
    @Given("^Mike on home page after opening nopCart mobile app$")
    public void openApp() throws InterruptedException {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        homepage.ClickAccept();
    }
    //Scroll left to right and click electronics from categories list
    @When("^Mike click \"([^\"]*)\" from our categories list from home page$")
    public void Electronics(String category) throws IOException, InvalidFormatException {
        List<Map<String,String>> testdata= reader.getData("src/main/resources/ExcelData/FirstScenario.xlsx","FirstScen");
        String electronics= testdata.get(0).get("Category");
      if(category.equals(electronics)){
          homepage.scrollCategory();
          homepage.FindEletronics();
      }
    }

    // Scroll down and click on "Nokia Lumia 1020"
    @And("^Mike click to \"([^\"]*)\" product details page$")
    public void ProductDetails(String product) throws InterruptedException, IOException,InvalidFormatException {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        List<Map<String, String>> testdata = reader.getData("src/main/resources/ExcelData/FirstScenario.xlsx", "FirstScen");
        String nokialumia = testdata.get(0).get("Product");
        System.out.println(nokialumia);
        if (product.equals(nokialumia)) {
            Thread.sleep(7000);
            product_Page.scrolltoNokia();
            product_Page.selectNokia();
        }
    }

    //Select size = large from product details page
    @Then("^Mike select size \"([^\"]*)\" from product details page$")
    public void SelecSize(String size) throws InterruptedException,IOException,InvalidFormatException {
        List<Map<String, String>> testdata = reader.getData("src/main/resources/ExcelData/FirstScenario.xlsx", "FirstScen");
        String large = testdata.get(0).get("Size");
        if (size.equals(large)) {
            Thread.sleep(8000);
            product_Page.scrollingDown();
            product_Page.DetailsPageSizeAction();
        }
    }

    //Quantity increased by 2
    @And("^Mike click plus button to increase Qty by \"([^\"]*)\"$")
    public void QuantityIncrease(String Quantity) throws IOException,InvalidFormatException {
        List<Map<String, String>> testdata = reader.getData("src/main/resources/ExcelData/FirstScenario.xlsx", "FirstScen");
        String two = testdata.get(0).get("Quantity");
        if (Quantity.equals(two)) {
            product_Page.DetailsPageaddAction();
        }
    }

    // Added to the cart
    @And("^Mike click add to cart button to add the product in his cart$")
    public void addTocart() throws InterruptedException {
        product_Page.AddtoCartButton();
        Thread.sleep(3000);
    }
}
