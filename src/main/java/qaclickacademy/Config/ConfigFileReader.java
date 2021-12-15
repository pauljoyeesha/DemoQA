package qaclickacademy.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import qaclickacademy.enums.EnvironmentType;

import java.io.*;

public class ConfigFileReader {
private static Properties prop;
public ConfigFileReader()throws FileNotFoundException
{
	try {
		System.out.println(System.getProperty("user.dir"));
		prop=new Properties();
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/qaclickacademy/Config/config.properties");
		prop.load(ip);
	}

catch(Exception e)
{
	e.printStackTrace();
}
}
public String getScreenshotFolderPath() 
{
	

	String url=prop.getProperty("ScreenshotPath");
	if(url !=null)return url;
	else throw new RuntimeException("ScreenShot path file is not in config file");
	
	
			
}
@SuppressWarnings("unused")
public String getDriverPath()
{
	String driverpath=prop.getProperty("ChromedriverPath");
	String dr=System.getProperty("user.dir")+driverpath;
	System.out.println("The chromedriver path "+dr);
	if(dr!=null) return dr;
	
	else throw new RuntimeException("chrome driver path  path file is not in config file");

	
}
public Boolean getBrowserWindowSize()
{
	String windowSize=prop.getProperty("windowMaximize");
	if(windowSize !=null) return Boolean.valueOf(windowSize);
	return true;
}

public EnvironmentType getEnvironment()
{
	String env=prop.getProperty("environment");
	if(env ==null || env.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
	else if (env.equalsIgnoreCase("remote")) return EnvironmentType.REMOTE;
	else throw new RuntimeException("Environment Type key value in Configuration.properties is not matched :" +env);
}
public String getApplicationURL()
{
	String url=prop.getProperty("url");
	if(url !=null) return url;
	else throw new RuntimeException("Application URL key value in Configuration.properties is not matched :" +url);
} 
}
