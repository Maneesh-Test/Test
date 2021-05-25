package Utility;

import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

    Properties props;

    public ConfigDataProvider(){
        File src = new File("C:/Users/admin/IdeaProjects/Test/src/test/java/Config/Config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            props = new Properties();
            props.load(fis);
        } catch (IOException e) {
            Reporter.log("Unable to read config properties file", true);
        }
    }

    public String getDataFromConfig(String keyToSearch){
        return props.getProperty(keyToSearch);
    }

    public String getBrowser(){ return props.getProperty("chromeBrowser"); }

    public String getFirefoxBrowser(){ return props.getProperty("firefoxBrowser"); }

    public String getUrl(){
        return props.getProperty("url");
    }
}
