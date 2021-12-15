package qaclickacademy.Runner;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qaclickacademy.TestBase.*;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = {
		 "src/test/java/qaclickacademy/Feature/TC1.feature"
		 }
 
 ,
 glue={
		 "qaclickacademy.StepDefinition"
		 }
 ,
 plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/CucumberReport/ExtentReport.html","rerun:target/CucumberReport/rerun.txt" },
 
 format = {
			
			"pretty", "html:target/CucumberReport/index.html", 
			"json:target/CucumberReport"
					+ "/CumcumberJson.json",
					"junit:target/CucumberReport/CucumberJunit.xml" },
  dryRun = false
		 ,
		 monochrome= true
		 ,
		 strict = true
		  ,
	
	
	tags= {"@tc1"}
	     
		 
		 
 )



public class TestRunner {
	  public static RemoteWebDriver connection;
	String username = "pauljoyeesha9";
	  String accessKey = "a4NF0JnHrYGrQJNNwJCZatlIGEZtdZ41k41BPyyurEjt6QKGN6";
	 // driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
		private TestNGCucumberRunner testNGCucumberRunner2;

		@BeforeClass(alwaysRun=true)
		//public void setUpClass()throws Exception
		@org.testng.annotations.Parameters(value={"browser","version","platform"})
	    public void setUp() throws Exception {
		//{

			try {
		testNGCucumberRunner2=new TestNGCucumberRunner(this.getClass());
		
		//
	
	       DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", "chrome");
	        capabilities.setCapability("version", "70.0");
	        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
	        capabilities.setCapability("build", "LambdaTestSampleApp");
	        capabilities.setCapability("name", "LambdaTestJavaSample");
	        //DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("tunnel", true);
	     //  Base.driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
	        String gridURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
            System.out.println(gridURL);
	        connection = new RemoteWebDriver(new URL(gridURL), capabilities);
           System.out.println(capabilities);
           System.out.println(connection);
			} 
	        catch (MalformedURLException e) {
	            System.out.println("Invalid grid URL");
	        }
	    }
	  
		
		@Test(groups="cucumber",description="Run Cucumber Feature",dataProvider="features")
		public void feature(CucumberFeatureWrapper cucumberFeature)
		{

		testNGCucumberRunner2.runCucumber(cucumberFeature.getCucumberFeature());

		}
		@DataProvider
		public Object[][] features()
		{
		return testNGCucumberRunner2.provideFeatures();

		}
		@AfterClass(alwaysRun = true)
		public void tearDownClass() throws Exception {
		testNGCucumberRunner2.finish();
		}

}
