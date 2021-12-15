package qaclickacademy.PageObjectManager;
import qaclickacademy.pages.*;
import org.openqa.selenium.WebDriver;
import qaclickacademy.TestBase.*;


public class PageManager extends Base{
	public static WebDriver driver=Base.driver;
	public static homepage homepageobj;
public PageManager(WebDriver driver)
{
	this.driver=driver;
	
}
public static homepage gethomepageobj()
{
	homepageobj=null;
	return(homepageobj==null)?homepageobj=new homepage(driver): homepageobj;
	
			
}
}
