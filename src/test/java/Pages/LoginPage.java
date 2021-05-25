package Pages;

import Utility.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class LoginPage extends BaseClass {

    public WebDriver driver;

    /**
     * Page Factory Element ID's
     */
    @FindBy(how = How.NAME, using = "username")
    WebElement userName;

    @FindBy(how = How.NAME, using = "passwd")
    WebElement passWord;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'login-button')]")
    public WebElement loginBtn;


    public LoginPage(WebDriver driver1) {
        this.driver = driver1;
    }

    public void loginToJ2Page(String uName, String pWord){
        userName.sendKeys(uName);
        passWord.sendKeys(pWord);
        loginBtn.click();
    }
}