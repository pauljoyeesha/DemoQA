package qaclickacademy.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.DOMConfiguration;

import qaclickacademy.PageObjectManager.FileReaderManager;
import qaclickacademy.log.Log;

public class Base {
	public static Properties prop;
	public static WebDriver driver;
	
	
public Base()
{
	try {
		prop=new Properties();
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.dir")+"\\src\\main\\java\\qaclickacademy\\Config\\config.properties");
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\qaclickacademy\\Config\\config.properties");
		prop.load(ip);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
public static WebDriver initialisation(String s)
{
	System.out.println("Initialisation of driver :" +driver);
	DOMConfigurator.configure(System.getProperty("user.dir")+prop.getProperty("Log4JFilePath"));
	Log.startTestCase("Testcase");
	Log.info("broswer is to be launched");
	String browsername=prop.getProperty("browser");
	if(browsername.equalsIgnoreCase("chrome"))
	{
		
		System.out.println("if block :" +driver);
		System.setProperty("webdriver.chrome.driver",FileReaderManager.getInstance().getConfigReader().getDriverPath());
		System.out.println(System.getProperty("ChromedriverPath"));
		driver=new ChromeDriver();
		System.out.println("Initial 2: " +driver);
		driver.manage().window().maximize();
		System.out.println("Initial 3: " +driver);
		System.out.println(System.getProperty("webdriver.chrome.driver",FileReaderManager.getInstance().getConfigReader().getDriverPath()));
	}
	
	System.out.println("Browser Initialisation" +driver);
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Browser initialised"+driver);
		try
		{
			driver.get(prop.getProperty(s));
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Initialised Finally: " +driver);
	return driver;
	
}


public static WebDriver getWebDriver()
{
	return driver;
}

public static String getDataFromPropertyFile(String data)
{
	return prop.getProperty(data);
}
public static File captureScreenMethod(WebDriver driver,String TestCaseNumber)
{
	SimpleDateFormat dt=new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
	String timestamp=dt.format(new Date());
	TakesScreenshot tk=(TakesScreenshot)(driver);
	File src=tk.getScreenshotAs(OutputType.FILE);
	StringTokenizer sr=new StringTokenizer((System.getProperty("user.dir")),"\\");
	LinkedList<String> l=new LinkedList<String>();
	while(sr.hasMoreTokens())
	{
		l.add(sr.nextToken());
		System.out.println(l);
	}
	StringBuilder screenshotDir=new StringBuilder();
	for(int i=0;i<l.size();i++)
	{
		screenshotDir.append("\\"+l.get(i));
	}
	System.out.println("Dir :"+"\\"+screenshotDir+"\\"+prop.getProperty(TestCaseNumber));
	
	File dst=new File("\\"+screenshotDir+"\\"+prop.getProperty(TestCaseNumber)+"\\screenshots"+timestamp+".png");
	try {
		FileUtils.copyFile(src, dst);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return dst;
}
}
