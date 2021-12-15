package qaclickacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import qaclickacademy.TestBase.Base;

public class homepage {
	
	public static  WebDriver driver;
	public static WebElement ele;
	
	public homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(how=How.XPATH,using="//*[@name='q']")
	 public WebElement googlesearch;
	
	@FindBy(how=How.XPATH,using="//ul/li/a[text()='iFrame']")
	public WebElement iframelink;
	
	@FindBy(how=How.XPATH,using="//h3[contains(text(),'An iFrame')]")
	public WebElement nextpageH3;
	
	@FindBy(how=How.XPATH,using="//*[@id='user_name']")
	public WebElement loginUname;
	public void enterLoginUname(String uname)throws Throwable
	{
		try
		{
			//loginUname.click();
			loginUname.sendKeys(uname);
			Thread.sleep(2000);
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
	
	
	
	@FindBy(how=How.XPATH,using="//*[@name='name']")
	public WebElement userName;
	@FindBy(how=How.XPATH,using="//*[@name='password']")
	public WebElement userPwd;
	@FindBy(how=How.XPATH,using="//button[text()='Login' and @type='submit']")
	public WebElement loginBtn;
	@FindBy(how=How.NAME, using="email")
	public WebElement emailInput;
	@FindBy(how=How.ID, using="populate")
	public WebElement populateBtn;
	@FindBy(how=How.XPATH,using="//*[text()='How frequently do you make a purchase on an eCommerce website?']")
	public WebElement firsRadio1Question;
	@FindBy(how=How.XPATH,using="//input[@type='radio' and @id='month']")
	public WebElement firstAnswer;
	@FindBy(how=How.XPATH,using="//*[text()='What mode of payment do you prefer usually?']")
	public WebElement dropdwnQuestion;
	@FindBy(how=How.NAME,using="preferred-payment")
	public WebElement thirdAnswer;
	@FindBy(how=How.NAME,using="tried-ecom")
	public WebElement checkedAnswer;
	@FindBy(how=How.XPATH,using="//div[@class='disablebar']")
	public WebElement disabledScroll;
	@FindBy(how=How.XPATH,using="//*[text()='Which are the decisive factors before making an eCommerce purchase?']")
	public WebElement checkboxQuestion;
	@FindBy(how=How.NAME,using="tried-ecom")
	public WebElement checkedCheckbox;
	@FindBy(how=How.XPATH,using="//*[@class='disablebar']/div/div/div/div[@role='slider']")
	public WebElement slideBardiv;
	@FindBy(how=How.ID,using="comments")
	public WebElement commentBox;
	@FindBy(how=How.ID,using="submit-button")
	public WebElement submitBtn;
	@FindBy(how=How.XPATH,using="//h2[text()='Integrations With CI/CD Tools']")
	public WebElement cicdHeading;
	//h2[text()='Integrations With CI/CD Tools']
	@FindBy(how=How.XPATH,using="//img[@title='Jenkins']")
	public WebElement jenkinsImg;
	//LambdaTest Jenkins integration
	@FindBy(how=How.XPATH,using="//*[text()='Thank you!']")
	public WebElement thankYouText;
	
	@FindBy(how=How.XPATH,using="//*[text()='Thank you!']/../p")
	public WebElement formSubmitted;
	
	
	
	
	
}
