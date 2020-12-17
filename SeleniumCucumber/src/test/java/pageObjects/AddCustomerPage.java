package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
    }

    By lnkCustomers_menu= By.xpath("//a[@href='#']/span[text()='Customers']");
    By getLnkCustomers_menuitem=By.xpath("//span[@class='menu-item-title'][text()='Customers']");

    By btnAddNew=By.xpath("//a[@class='btn bg-blue']");
    By txtEmail=By.xpath("//input[@id='Email']");
    By txtPassword=By.xpath("//input[@id='Password']");
    By txtFirstName= By.xpath("//input[@id='FirstName']");
    By txtLastName=By.xpath("//input[@id='LastName']");
    By rdGender=By.xpath("//input[@id='Gender_Male']");
    By txtDOB=By.xpath("//input[@id='DateOfBirth']");
    By txtComName=By.xpath("//input[@id='Company']");
    By rdtaxexmpt=By.xpath("//input[@id='IsTaxExempt']");
    By lbxNewsLetter=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
    By lbxNewsLetter_item=By.xpath("//li[contains(text(),'Your store name')]");
    By lbxCusRole=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
    By lsitemAdministrator=By.xpath("//li[contains(text(),'Administrators')]");
    By lsitemMederator=By.xpath("//li[contains(text(),'Forum Moderators')]");
    By lsitemGuest=By.xpath("//li[contains(text(),'Guest')]");
    By lsitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
    By lsitemVendor=By.xpath("//li[contains(text(),'Vendors')]");
    By lsVendor=By.xpath("//select[@id='VendorId']");
    By lbxManageVendor=By.xpath("//option[contains(text(),'Vendor 1')]");
    By txtAdminComment=By.xpath("//textarea[@id='AdminComment']");
    By btnSave=By.xpath("//button[@name='save']");

    //Action Methods

    public String getPageTitle(){
        return ldriver.getTitle();
    }


    public void clickOnCustomerMenu(){
        ldriver.findElement(lnkCustomers_menu).click();
    }

    public void clickOnCustomerMenuItem(){
        ldriver.findElement(getLnkCustomers_menuitem).click();
    }

    public void clickOnAddButton(){
        ldriver.findElement(btnAddNew).click();
    }

    public void setEmail(String email){
        ldriver.findElement(txtEmail).sendKeys(email);
    }

    public void setpassword(String password){
        ldriver.findElement(txtPassword).sendKeys(password);
    }

    public void setFirstName(String firstName){
        ldriver.findElement(txtFirstName).sendKeys(firstName);
    }

    public void setLastName(String lastName){
        ldriver.findElement(txtLastName).sendKeys(lastName);
    }

    public void setGender(){
        ldriver.findElement(rdGender).click();
    }

    public  void setDOB(String dob){
        ldriver.findElement(txtDOB).sendKeys(dob);
    }

    public void setCompanyName(String comp){
        ldriver.findElement(txtComName).sendKeys(comp);
    }

    public void setRdtaxexmpt(){
        ldriver.findElement(rdtaxexmpt).click();
    }

    public void setNewsLetter() throws InterruptedException {
        ldriver.findElement(lbxNewsLetter).click();
        Thread.sleep(2000);
        ldriver.findElement(lbxNewsLetter_item).click();
    }

    public void setCustomerRole(String role) throws InterruptedException {
        ldriver.findElement(lbxCusRole).click();
        Thread.sleep(2000);
        WebElement listitem;
        if(role.equals("Administrators")){
            listitem=ldriver.findElement(lsitemAdministrator);
        }
        else if(role.equals("Guests")){
            listitem=ldriver.findElement(lsitemGuest);
        }
        else if(role.equals("Registered")){
            listitem=ldriver.findElement(lsitemRegistered);
        }
        else if(role.equals("Vendors")){
            listitem=ldriver.findElement(lsitemVendor);
        }
        else
        {
            listitem=ldriver.findElement(lsitemMederator);
        }

        //listitem.click();

        JavascriptExecutor js=(JavascriptExecutor)ldriver;
        js.executeScript("arguments[0].click()", listitem);


    }

    public void setvendor() throws InterruptedException {
        ldriver.findElement(lsVendor).click();
        Thread.sleep(2000);
        ldriver.findElement(lbxManageVendor).click();
    }

    public void setcomment(String comment){
        ldriver.findElement(txtAdminComment).sendKeys(comment);
    }

    public void clickSave(){
        ldriver.findElement(btnSave).click();
    }
}
