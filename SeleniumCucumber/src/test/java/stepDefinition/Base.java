package stepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import org.apache.log4j.Logger;

public class Base {

    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage add_cp;
    public SearchCustomerPage search_cp;
    public static Logger logger;


    //Created for generated random string for EmailID
    public static String randomString(){
        String generatedString= RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
}
