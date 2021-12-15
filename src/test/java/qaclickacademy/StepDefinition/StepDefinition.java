package qaclickacademy.StepDefinition;
//import java.awt.List;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import qaclickacademy.PageObjectManager.PageManager;
import qaclickacademy.TestBase.Base;
import qaclickacademy.pages.*;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.Action;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cucumber.listener.*;
import java.util.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import qaclickacademy.PageObjectManager.*;

public class StepDefinition extends Base {

	public static WebDriver driver=Base.driver;
	public static homepage homepageobj;
	public static File fl;
	public static List<String> tabs;

	@Given("^user open the url \"(.*)\"$")
	public void openUrl(String Screenshot) throws Exception
	{
		try
		{
			driver=Base.initialisation("url");
		
			fl=Base.captureScreenMethod(Base.driver, Screenshot);
			Reporter.addScreenCaptureFromPath(fl.toString());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	@When("^click enter email ID \"(.*)\" and click populateBtn \"(.*)\" and accept alert$")
	public void inputEmailClickpopulateBtn(String email,String Screenshot)throws Throwable
	{
		try {
		homepageobj=PageManager.gethomepageobj();
		driver.switchTo().defaultContent();
		
		homepageobj.emailInput.sendKeys(email);
		Thread.sleep(2000);
		homepageobj.populateBtn.click();
		Thread.sleep(2000);
		
		Alert a=driver.switchTo().alert();
		a.accept();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		fl=Base.captureScreenMethod(Base.driver,Screenshot);
		Reporter.addScreenCaptureFromPath(fl.toString());
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@And("^user fills the form \"(.*)\"$")
	public void form_fill(String Screenshot)throws Throwable
	{
		try
		{
			homepageobj=PageManager.gethomepageobj();
			JavascriptExecutor j=(JavascriptExecutor)(driver);
			j.executeScript("arguments[0].setAttribute('style', 'background:; border: 2px solid red;');",homepageobj.firsRadio1Question);
			Thread.sleep(2000);
			homepageobj.firstAnswer.click();
			Thread.sleep(2000);
			j.executeScript("arguments[0].setAttribute('style', 'background:; border: 2px solid red;');",homepageobj.checkboxQuestion);
			Thread.sleep(2000);
			List<WebElement> l=Base.driver.findElements(By.xpath("//*[@class='checkbox pb-20']/p/label/input"));
			for(WebElement w:l)
			{
				w.click();
			}
			Thread.sleep(2000);
			j.executeScript("arguments[0].setAttribute('style', 'background:; border: 2px solid red;');",homepageobj.dropdwnQuestion);
			Thread.sleep(2000);
			Select s=new Select(homepageobj.thirdAnswer);
			s.selectByIndex(2);
			Thread.sleep(2000);
			if(!(homepageobj.checkedCheckbox.isSelected()))
			{
				homepageobj.checkedCheckbox.click();
				Thread.sleep(2000);
				
				if(homepageobj.disabledScroll.isEnabled())
				{
					Actions s1=new Actions(driver);
					
					s1.dragAndDropBy(homepageobj.slideBardiv,235,0).build().perform();
				}
				
			}
			Thread.sleep(2000);
			homepageobj.commentBox.sendKeys("This is feedback !!!!! by user ");
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[@name='file' and @type='file']")).sendKeys("C:\\selectorHUB");
			fl=Base.captureScreenMethod(Base.driver,Screenshot);
			Reporter.addScreenCaptureFromPath(fl.toString());
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@And("^open another new window for new url \"(.*)\" and save \"(.*)\"$")
	public void openAnotherWindow(String uls_link,String Screenshot)throws Throwable
	{
		try
		{
			homepageobj=PageManager.gethomepageobj();
			JavascriptExecutor j=(JavascriptExecutor)(driver);
			j.executeScript("window.open()");
			tabs=new ArrayList<String>();
			Thread.sleep(3000);
			//driver.switchTo().window(tabs.get(1));
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
			  tabs = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs.get(1)); 
			driver.get(uls_link);
			Thread.sleep(3000);
			Actions s1=new Actions(driver);
			s1.moveToElement(homepageobj.cicdHeading).build().perform();
		
			fl=Base.captureScreenMethod(Base.driver,Screenshot);
			Reporter.addScreenCaptureFromPath(fl.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@And("^download image from CICD section \"(.*)\"$")
	public void dounloadImage(String Screenshot )throws Throwable
	{
		try
		{
			homepageobj=PageManager.gethomepageobj();
			Thread.sleep(2000);
			Thread.sleep(3000);
		
		    
			Actions s1=new Actions(driver);
			//s1.moveToElement(homepageobj.jenkinsImg).build().perform();
			Thread.sleep(3000);
			
				Thread.sleep(3000);
			s1.contextClick(homepageobj.jenkinsImg).build().perform();
			Thread.sleep(3000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			//s1.sendKeys(Keys.SHIFT,"v").build().perform();
			Thread.sleep(3000);
		
			// To press C key.
			
			// To press "test" key one by one.
			robot.keyPress(KeyEvent.VK_J);
			robot.keyPress(KeyEvent.VK_E);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyPress(KeyEvent.VK_K);
			robot.keyPress(KeyEvent.VK_I);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyPress(KeyEvent.VK_S);
		
		
		     Thread.sleep(2000);
		     robot.keyPress(KeyEvent.VK_ENTER); 
		     
		     robot.keyRelease(KeyEvent.VK_ENTER); 
		     Thread.sleep(2000);
		}
			catch(Exception e)
			{
			     Thread.sleep(2000);e.printStackTrace();
			}
	}
	@And("^upload image to form and submit \"(.*)\"$")
	public void submitForm(String Screenshot)throws Throwable
	{
		try
		{
			homepageobj=PageManager.gethomepageobj();
			Thread.sleep(2000);
			System.out.print("Hi image to upload");
			  Thread.sleep(2000);
	        driver.switchTo().window(tabs.get(0));
	        Thread.sleep(2000);
	        WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
	        addFile.sendKeys("C:\\Users\\paulj\\Downloads\\jenkins.svg");
	        Thread.sleep(2000);
	        Alert e=driver.switchTo().alert();
	        String alertText=e.getText();
	        Thread.sleep(2000);
	        System.out.print(alertText);
	     Reporter.addStepLog(alertText);
	        e.accept();
	        Thread.sleep(2000);
	        driver.switchTo().defaultContent();
	        Thread.sleep(2000);
	        Actions s1=new Actions(driver);
	        Thread.sleep(2000);
			s1.moveToElement(homepageobj.submitBtn).build().perform();			
			homepageobj.submitBtn.click();
			Thread.sleep(2000);
			s1.moveToElement(homepageobj.thankYouText).build().perform();	
			JavascriptExecutor j=(JavascriptExecutor)(driver);
			j.executeScript("arguments[0].setAttribute('style', 'background:; border: 2px solid red;');",homepageobj.thankYouText);
			Thread.sleep(2000);
			
			s1.moveToElement(homepageobj.formSubmitted).build().perform();	
		 j=(JavascriptExecutor)(driver);
			j.executeScript("arguments[0].setAttribute('style', 'background:; border: 2px solid red;');",homepageobj.formSubmitted);
			Thread.sleep(2000);
			if(homepageobj.formSubmitted.getText().contains("You have successfully submitted the form."))
				Reporter.addStepLog("Form submitted successfully !!");
			Thread.sleep(2000);
			fl=Base.captureScreenMethod(Base.driver,Screenshot);
			Reporter.addScreenCaptureFromPath(fl.toString());
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@And("^click on login button save \"(.*)\"$")
	public void clickOnsearchlogin(String Screenshot)throws Throwable

	{
		try
		{
			homepageobj=PageManager.gethomepageobj();
		
			Thread.sleep(2000);
			Robot b=new Robot();
			b.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			JavascriptExecutor j=(JavascriptExecutor)(Base.driver);
			j.executeScript("arguments[0].click();", homepageobj.loginBtn);
			//Actions a=new Actions(driver);
			//a.moveToElement(homepageobj.loginBtn).build().perform();
			//b.keyPress(KeyEvent.VK_ENTER);
			//b.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			
			fl=Base.captureScreenMethod(Base.driver, Screenshot);
			Reporter.addScreenCaptureFromPath(fl.toString());
			
			
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Then("^close browser$")
	public void closeBrowser()throws Throwable
	{
		try {
			
				driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@And("^user gives \"(.*)\" and \"(.*)\" and save \"(.*)\"$")
	public void username_password_enter(String uname,String pwd,String Screenshot)throws Throwable
	{
		try {
		homepageobj=PageManager.gethomepageobj();
		Thread.sleep(2000);
	
		homepageobj.userName.sendKeys(uname);
		homepageobj.userPwd.sendKeys(pwd);
		Thread.sleep(2000);
		fl=Base.captureScreenMethod(Base.driver, Screenshot);
		Reporter.addScreenCaptureFromPath(fl.toString());
		Thread.sleep(5000);
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	


}	 

	
	

