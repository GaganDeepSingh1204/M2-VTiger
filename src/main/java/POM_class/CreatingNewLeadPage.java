package POM_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadPage {
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement FirstNameTextField;
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTextField ;
	@FindBy(xpath="//input[@name='company']")
	private WebElement companyTextField;
	@FindBy(xpath="//input[@id='designation']")
	private WebElement titleTextField;
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement mobileTextField;
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailTextField;
	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement leadSourceDropdown;
	@FindBy(xpath="//input[@name='noofemployees']")
	private WebElement noOFEmployeesTextField;
	@FindBy(xpath="//input[@name='city']")
	private WebElement cityTextField;
	@FindBy(xpath="//input[@name='country']")
	private WebElement countryTextField;
	@FindBy(xpath="//input[@name='state']")
	private WebElement stateTextField;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getFirstNameTextField() {
		return FirstNameTextField;
	}
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	public WebElement getCompanyTextField() {
		return companyTextField;
	}
	public WebElement getTitleTextField() {
		return titleTextField;
	}
	public WebElement getMobileTextField() {
		return mobileTextField;
	}
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}
	public WebElement getNoOFEmployeesTextField() {
		return noOFEmployeesTextField;
	}
	public WebElement getCityTextField() {
		return cityTextField;
	}
	public WebElement getCountryTextField() {
		return countryTextField;
	}
	public WebElement getStateTextField() {
		return stateTextField;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}

	/** 
	 * this is a business library to create new lead
	 * @param fName
	 * @param lName
	 * @param company
	 * @param title
	 * @param mobile
	 */
	public void createNewLead(String fName,String lName,String company) {
		getFirstNameTextField().sendKeys(fName);
		getLastNameTextField().sendKeys(lName);
		getCompanyTextField().sendKeys(company);
		getSaveButton().click();
	}
	/**
	 * this is a business library to create new lead
	 * @param fName
	 * @param lName
	 * @param company
	 * @param title
	 * @param mobile
	 */
	public void createNewLead(String lName,String company,String leadSource,String noOfEmployees,String mobile )
	{
		getLastNameTextField().sendKeys(lName);
		getCompanyTextField().sendKeys(company);
		Select sel = new Select(getLeadSourceDropdown());
		sel.selectByValue(leadSource);
		getNoOFEmployeesTextField().sendKeys(noOfEmployees);
		getMobileTextField().sendKeys(mobile);
		getSaveButton().click();
	}
	/**
	 * this is a business library to create new lead
	 * @param lName
	 * @param company
	 * @param leadSource
	 * @param noOfEmployee
	 * @param city
	 * @param country
	 * @param state
	 */
	public void createNewLead(String lName,String company,String noOfEmployee, String mobile, String email, String city,String country,String state )
	{
		getLastNameTextField().sendKeys(lName);
		getCompanyTextField().sendKeys(company);
		getNoOFEmployeesTextField().sendKeys(noOfEmployee);
		getMobileTextField().sendKeys(mobile);
		getEmailTextField().sendKeys(email);
		getCityTextField().sendKeys(city);
		getCountryTextField().sendKeys(country);
		getStateTextField().sendKeys(state);
		getSaveButton().click();
		
	}
	
}
