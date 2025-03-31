package POM_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(xpath="//a[text()='Leads' and @href='index.php?module=Leads&action=index']")
private WebElement LeadsMenu;
@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
private WebElement ContantsMenu;
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement accountsIconMenu;
@FindBy(xpath="//a[text()='Sign Out']")
private WebElement signOutOption;
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public WebElement getLeadsMenu() {
	return LeadsMenu;
}
public WebElement getContantsMenu() {
	return ContantsMenu;
}
public WebElement getAccountsIconMenu() {
	return accountsIconMenu;
}
public WebElement getSignOutOption() {
	return signOutOption;
}
public void clickOnLeadsMenu() {
	getLeadsMenu().click();
}
public void clickOnContactsMenu() {
	getContantsMenu().click();
}
/**
 * This a business library to perform signout operation
 */
public void signOutOperation(WebDriver driver) {
	Actions act = new Actions(driver);
	act.moveToElement(getAccountsIconMenu()).perform();
	getSignOutOption().click();
}
}
