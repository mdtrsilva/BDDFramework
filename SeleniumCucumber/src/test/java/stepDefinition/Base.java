package stepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Base {

    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage add_cp;
    public SearchCustomerPage search_cp;


    //Created for generated random string for EmailID
    public static String randomString(){
        String generatedString= RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
}
