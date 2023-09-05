package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends Basepage{
 WebDriver driver;
 public AccountRegistrationPage(WebDriver driver)
 {
	 super(driver);
 }

@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtfirstname;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtlastname;
@FindBy(xpath="//input[@id='input-email']")
WebElement txtemail;
@FindBy(xpath="//input[@id='input-telephone']")
WebElement txttelephone;
@FindBy(xpath="//input[@id='input-password']")
WebElement txtpassword;
@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtconfirmpassword;



@FindBy(xpath="//input[@name='agree']")

WebElement chkpolicy;
@FindBy(xpath="//input[@value='Continue']")
WebElement btncontinue;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement msgConfirmation ;

public void setfirstname(String fname)
{
	txtfirstname.sendKeys(fname);
}
public void setlastname(String lname)
{
	txtlastname.sendKeys(lname);
}
public void setemail(String email)
{
	txtemail.sendKeys(email);
}
public void settelephone(String tel)
{
	txttelephone.sendKeys(tel);
}
public void setpassword(String pwd)
{
	txtpassword.sendKeys(pwd);
}
public void setconfirmpassword(String cpwd)
{
	txtconfirmpassword.sendKeys(cpwd);
}
public void setclickprivacypolicy()
{
	chkpolicy.click();
}
public void setclickcontinue()
//sol1
{
	btncontinue.click();
}

//sol2 
	//btnContinue.submit();
	
	//sol3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnContinue).click().perform();
				
	//sol4
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();", btnContinue);
	
	//Sol 5
	//btnContinue.sendKeys(Keys.RETURN);
	
	//Sol6  
	//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
public String getConfirmationMsg(){
try
{
	return (msgConfirmation.getText());
}catch (Exception  e) {
	return (e.getMessage());
}
}
}