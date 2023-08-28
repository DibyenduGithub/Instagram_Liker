package Generic_Utility;
import java.io.FileInputStream;
import java.util.Properties;

public class Configdata_Utility {

	public String commondata(String key) throws Throwable 
	{
	FileInputStream fs = new FileInputStream ("./src/test/resources/config.properties");
	Properties pro = new Properties();
    pro.load(fs);
    String keyvalue = pro.getProperty(key);
    return keyvalue;
    }
	
}
