package qaclickacademy.PageObjectManager;

import java.io.FileNotFoundException;

import qaclickacademy.Config.ConfigFileReader;

public class FileReaderManager {
	private static ConfigFileReader configFileReader;
private static FileReaderManager fileReaderManager =new FileReaderManager();

private FileReaderManager()
{
}
public static FileReaderManager getInstance()
{
	return fileReaderManager;
}
public ConfigFileReader getConfigReader() {
	try
	{
		return (configFileReader==null)? new ConfigFileReader():configFileReader;
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	return configFileReader;
}
}
