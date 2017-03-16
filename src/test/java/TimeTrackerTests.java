import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.YawareSite;

public class TimeTrackerTests {
    private WebDriver webDriver;
    private YawareSite webSite;
    private WebDriverWait wait;


    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 30, 500);

        webSite = new YawareSite(webDriver);
        webDriver.get("http://app.yaware.com/");
        webSite.switchLanguage("en_US");
    }

    @Test
    public void testSearchUrl() {
        System.out.println("Check url");
        Assert.assertTrue(webDriver.getCurrentUrl().contains("http://app.yaware.com/"));
        webSite.registrationFormClick();
        Assert.assertTrue(webDriver.findElement(By.id("register")).isDisplayed());
        webSite.forgotPasswordClick();
        Assert.assertTrue(webDriver.findElement(By.id("forgot-password")).isDisplayed());
    }

    @Test
    public void testLanguageSwitch(){

        webSite.switchLanguage("en_US");
        webSite.checkLanguege("automated time and productivity tracking");

        webSite.switchLanguage("ru_RU");
        webSite.checkLanguege("автоматический учет времени и продуктивности");

        webSite.switchLanguage("uk_UA");
        webSite.checkLanguege("автоматизований облік часу та продуктивності");

        webSite.switchLanguage("zh_CN");
        webSite.checkLanguege("自动的时间和生产率跟踪");

        webSite.switchLanguage("fr_FR");
        webSite.checkLanguege("suivi automatisé du temps et de la productivité");
    }

    @Test
    public void testFailLogin() throws InterruptedException {
        webSite.fillLoginForm("rbromansky@gmail.com",  "1234");


        webSite.loginBtnClick();
        Thread.sleep(1000);
        Assert.assertTrue(webDriver.findElement(By.className("tooltip-inner")).isDisplayed());
    }

    @After
    public void tearDown(){
        if(webDriver != null)
            webDriver.quit();
    }
}
