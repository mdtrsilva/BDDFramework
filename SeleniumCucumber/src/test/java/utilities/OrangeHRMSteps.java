package utilities;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMSteps {

    WebDriver driver;
    @Given("Launch chrome browser")
    public void launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver","/Users/tharindu/eclipse-workspace/WebDrivers/chromedriver");
        driver=new ChromeDriver();

    }

    @When("I open OrangeHRM home page")
    public void i_open_orange_hrm_home_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }

    @Then("The Logo should present on the page")
    public void the_logo_should_present_on_the_page() {
        boolean status=driver.findElement(By.xpath("//*[@id='divLogo']/img")).isDisplayed();
        Assert.assertEquals(true, status);


    }

    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }

}
