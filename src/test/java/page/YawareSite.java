package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class YawareSite {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private WebElement link;

    @FindBy(id = "email")
    WebElement searchInputEmail;

    @FindBy(id = "password]")
    WebElement searchInputPass;

    public YawareSite(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
    }

    public void switchLanguage(String siteLanguage){
        System.out.println("Step : Swinch language to:" + siteLanguage);
        WebElement lengLink = webDriver.findElement(By.cssSelector("a[data-lang='"+siteLanguage+"']"));
        lengLink.click();

        System.out.println("Step : Wait For Page Load");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("logo")));

    }

    public void checkLanguege(String text){
        link = webDriver.findElement(By.id("logo")).findElement(By.tagName("span"));
        Assert.assertTrue(link.getText().contains(text));
    }

    public void fillLoginForm(String email, String pass){
        link = webDriver.findElement(By.id("email"));
        link.clear();
        link.sendKeys(email);
        link = webDriver.findElement(By.id("password"));
        link.clear();
        link.sendKeys(pass);
    }

    public void loginBtnClick(){
        link = webDriver.findElement(By.id("login-submit"));
        link.click();

    }

    public void registrationFormClick(){
        link = webDriver.findElement(By.cssSelector("a[href='#register']"));
        link.click();
    }


    public void forgotPasswordClick() {
        link = webDriver.findElement(By.cssSelector("a[href='#forgot-password']"));
        link.click();
    }
}
