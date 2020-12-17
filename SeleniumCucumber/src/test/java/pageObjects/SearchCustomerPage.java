package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {

    public WebDriver ldriver;
    public WaitHelper waitHelper;

    public SearchCustomerPage(WebDriver driver) {
        ldriver = driver;
        PageFactory.initElements(ldriver, this);
        waitHelper = new WaitHelper(driver);
    }

    @FindBy(how = How.ID, using = "SearchEmail")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(how = How.ID, using = "SearchFirstName")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(how = How.ID, using = "SearchLastName")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(how = How.ID, using = "SearchMonthOfBirth")
    @CacheLookup
    WebElement dropMonthOfBirth;

    @FindBy(how = How.ID, using = "SearchDayOfBirth")
    @CacheLookup
    WebElement dropDayOfBirth;

    @FindBy(how = How.ID, using = "SearchCompany")
    @CacheLookup
    WebElement txtCompany;

    @FindBy(how = How.ID, using = "SearchIpAddress")
    @CacheLookup
    WebElement txtCompanyIP;

    @FindBy(how = How.XPATH, using = "//div[@class='k-multiselect-wrap k-floatwrap']")
    @CacheLookup
    WebElement txtCustRoles;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]")
    @CacheLookup
    WebElement lsitemAdminstrator;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Forum Moderators')]")
    @CacheLookup
    WebElement lsitemModerators;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
    @CacheLookup
    WebElement lsitemGuests;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
    @CacheLookup
    WebElement lsitemRegistered;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
    @CacheLookup
    WebElement lsitemVendors;

    @FindBy(how = How.ID, using = "search-customers")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(how = How.XPATH, using = "//table[@role='grid']")
    @CacheLookup
    WebElement tblSearchResults;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
    @CacheLookup
    WebElement table;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    @CacheLookup
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
    @CacheLookup
    List<WebElement> tableColumns;

    //Action methods

    public void setEmail(String email) {
        waitHelper.waitForHelper(txtEmail, 30);
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setFirstName(String firstname) {
        waitHelper.waitForHelper(txtFirstName, 30);
        txtFirstName.clear();
        txtFirstName.sendKeys(firstname);
    }

    public void setLastName(String lastName) {
        waitHelper.waitForHelper(txtLastName, 30);
        txtLastName.clear();
        txtLastName.sendKeys(lastName);
    }

    public void clickSearch() {
        btnSearch.click();
    }

    public int getNoOfRows() {
        return (tableRows.size());
    }

    public int getNoOfColumns() {
        return(tableColumns.size());
    }

    public boolean searchCustomerByEmail(String email){
        boolean flag=false;

        for(int i=1; i<=getNoOfRows();i++){
            String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
            if(emailid.equals(email)){
                flag=true;
            }
        }
        return flag;
    }






}
