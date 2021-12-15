package qaclickacademy.PageObjectManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

 

import qaclickacademy.TestBase.*;

import qaclickacademy.enums.Context;

import qaclickacademy.enums.EnvironmentType;

 

public class WebDriverManager {

 

                private WebDriver driver;

                private static Context driverType;

                private static EnvironmentType environmentType;

                private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

 

                public WebDriverManager() {

                                //driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();

                                environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();

                }

 

//            public WebDriver getDriver() {

//                            if(driver == null) driver = createDriver();

//                            return driver;

//            }

//

//            private WebDriver createDriver() {

//                               switch (environmentType) {        

//                    case LOCAL : driver = createLocalDriver();

//                           break;

//                    case REMOTE : driver = createRemoteDriver();

//                           break;

//                              }

//                               return driver;

//            }

//

//            public WebDriver createLocalDriver() {

//                            switch (driverType)

//                            {                 

//       case FIREFOX : driver = new FirefoxDriver();

//                            break;

//      case CHROME :

//            System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());

//            driver = new ChromeDriver();

//                            break;

//      case INTERNETEXPLORER : driver = new InternetExplorerDriver();

//                            break;

//                           

//                            default:

//                                            System.out.println("");

//                                            break;

//      }

//

//      if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();

//      driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);

//                            return driver;

//            }

//           

//

//            private WebDriver createRemoteDriver() {

//                            throw new RuntimeException("RemoteWebDriver is not yet implemented");

//            }

 

               

 

                public void closeDriver() {

                                driver.close();

                                driver.quit();

                }

               

 

                public void quitDriver()

                {

  try

 {

if(Base.driver!=null)
 {

	Base.driver.quit();

  System.out.println("Close first browser");

if(Base.driver!=null)

 {

	Base.driver.quit();

   System.out.println("Close Second browser");     

  }

 }

                                                               

   System.out.println("End");

 }

 catch(Exception e)

    {

   e.printStackTrace();       

   }

 finally

 {

  System.out.println("Finally");

  }

                }

               

                }

 

 

 