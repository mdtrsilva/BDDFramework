package stepDefinition;

import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import static java.lang.Thread.*;

public class Steps extends Base{



    @Given("launch the chrome browser")
    public void launch_the_chrome_browser() {

        logger= Logger.getLogger("nonCommerce"); //Added logger
        PropertyConfigurator.configure("Log4j.properties");//Added logger

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"//Drivers/chromedriver");
                //"/Users/tharindu/IdeaProjects/SeleniumCucumber/Drivers/chromedriver");
        driver=new ChromeDriver();

        logger.info("***** Launching browser ******");
        lp=new LoginPage(driver);


    }

    @When("open URL {string}")
    public void open_url(String url) {
        logger.info("***** Opening URL ******");
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("enter Email as {string} and Password as {string}")
    public void enter_email_as_and_password_as(String email, String password) {

        logger.info("***** Providing credentials ******");
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("click login button")
    public void click_login_button() {
        logger.info("***** Clicking loging button ******");

        lp.clickLogin();
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful")){
            driver.close();
            logger.info("***** Logging Pass ******");
            Assert.assertTrue(false);
        }
        else
        {
            logger.info("***** Logging Fail ******");
            Assert.assertEquals(title, driver.getTitle());
        }

    }

    @When("click log out button")
    public void click_log_out_button() throws InterruptedException {

        logger.info("***** Clicking Logout ******");
        lp.clickLogOut();
        sleep(2000);

    }


    @Then("close browser")
    public void close_browser() {
        logger.info("***** Closing browser ******");

        driver.quit();
    }


    //Steps for Add new customer
    @Then("user can view dashboard")
    public void user_can_view_dashboard() {

        logger.info("***** Navigating to Dashboard ******");
        add_cp=new AddCustomerPage(driver);
        String pageTitle=add_cp.getPageTitle();
        Assert.assertEquals("Dashboard / nopCommerce administration", pageTitle);

    }

    @When("click on customers menu")
    public void click_on_customers_menu() throws InterruptedException {

        logger.info("***** Clicking Customer Meunu ******");
        Thread.sleep(3000);
        add_cp.clickOnCustomerMenu();
    }

    @When("click on customers menu item")
    public void click_on_customers_menu_item() throws InterruptedException {

        logger.info("***** Clicking Customer Menu Item ******");
        Thread.sleep(3000);
        add_cp.clickOnCustomerMenuItem();
    }

    @When("click on Add new button")
    public void click_on_add_new_button() throws InterruptedException {

        logger.info("***** Clicking Add New Button ******");
        Thread.sleep(3000);
        add_cp.clickOnAddButton();
    }

    @Then("user can vew Add new customer page")
    public void user_can_vew_add_new_customer_page() throws InterruptedException {

        logger.info("***** Opeing Add new customer page ******");
        Thread.sleep(3000);
        String pageTitle=add_cp.getPageTitle();
        Assert.assertEquals("Add a new customer / nopCommerce administration",pageTitle);
    }

    @When("enter customer info")
    public void enter_customer_info() throws InterruptedException {

        logger.info("***** Entering Custome info ******");
        String email=Base.randomString()+"@gmail.com";
        add_cp.setEmail(email);

        add_cp.setpassword("1234");
        add_cp.setFirstName("Tharindu");
        add_cp.setLastName("Silva");
        add_cp.setGender();
        add_cp.setDOB("05/12/1990");
        add_cp.setCompanyName("Nilus Pte Ltd");
        add_cp.setRdtaxexmpt();
        add_cp.setNewsLetter();
        add_cp.setCustomerRole("Administrators");
        add_cp.setvendor();
        add_cp.setcomment("A new Customer");


    }

    @When("click on save button")
    public void click_on_save_button() throws InterruptedException {

        logger.info("***** Clicking Save Button ******");
        add_cp.clickSave();
        Thread.sleep(2000);
    }

    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String message) {

        logger.info("***** Add Customer Pass ******");
        Assert.assertTrue(driver.findElement(By.tagName("Body")).getText().contains("message"));

    }

    //Step for Search customer by EmailId

    @When("enter customer email")
    public void enter_customer_email() {

        logger.info("***** Entering Customer Email ******");
        search_cp=new SearchCustomerPage(driver);
        search_cp.setEmail("victoria_victoria@nopCommerce.com");

    }


    @When("click on search button")
    public void click_on_search_button() throws InterruptedException {

        logger.info("***** Clicking Search Button ******");
        search_cp.clickSearch();
        Thread.sleep(3000);
    }

    @Then("user should be able to find the email in the search table")
    public void user_should_be_able_to_find_the_email_in_the_search_table() {

        boolean result=search_cp.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
        Assert.assertEquals(true,result);
        logger.info("***** Search Customer Pass ******");
    }

}
