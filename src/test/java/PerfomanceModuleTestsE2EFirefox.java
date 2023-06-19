import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public class PerfomanceModuleTestsE2EFirefox {
    private WebDriver driver;
    @Before
    public void startUp() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("capability.policy.default.Window.frameElement", "allAccess");
        System.setProperty("webdriver.gecko.driver", "src/test/lib/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void clickOrderStartButton() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
        driver.findElement((By.cssSelector("input[placeholder='* Имя']"))).sendKeys("Даша");
        driver.findElement((By.cssSelector("input[placeholder='* Фамилия']"))).sendKeys("Хмелькова");
        driver.findElement((By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']"))).sendKeys("Кантемировска 23");
        driver.findElement((By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']"))).sendKeys("89670354058");
        driver.findElement((By.cssSelector("input[placeholder='* Станция метро']"))).click();
        driver.findElement((By.cssSelector("li[data-value='1']"))).click();
        driver.findElement(By.xpath(".//button[text()='Далее']")).click();
        driver.findElement((By.cssSelector("input[placeholder='* Когда привезти самокат']"))).sendKeys("18.07.2023");
        driver.findElement((By.cssSelector("input[placeholder='Комментарий для курьера']"))).sendKeys("Не звонить");
        driver.findElement((By.cssSelector("input[id='black']"))).click();
        driver.findElement(By.className("Dropdown-arrow")).click();
        driver.findElement(By.xpath(".//div[text()='сутки']")).click();
        driver.findElement(By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]")).click();
        driver.findElement(By.xpath(".//button[text()='Да']")).click();
        var orderCheckField = driver.findElement(By.xpath(".//div[text()='Заказ оформлен']"));
        Assert.assertTrue(orderCheckField.isDisplayed());
}

    @Test
    public void clickOrderStartButtonOtherValue() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
        driver.findElement((By.cssSelector("input[placeholder='* Имя']"))).sendKeys("Даня");
        driver.findElement((By.cssSelector("input[placeholder='* Фамилия']"))).sendKeys("Козин");
        driver.findElement((By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']"))).sendKeys("2-ой Покровский 14");
        driver.findElement((By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']"))).sendKeys("+79629850067");
        driver.findElement((By.cssSelector("input[placeholder='* Станция метро']"))).click();
        driver.findElement((By.cssSelector("li[data-value='3']"))).click();
        driver.findElement(By.xpath(".//button[text()='Далее']")).click();
        driver.findElement((By.cssSelector("input[placeholder='* Когда привезти самокат']"))).sendKeys("28.06.2023");
        driver.findElement((By.cssSelector("input[placeholder='Комментарий для курьера']"))).sendKeys("У вас класный сервис");
        driver.findElement((By.cssSelector("input[id='grey']"))).click();
        driver.findElement(By.className("Dropdown-arrow")).click();
        driver.findElement(By.xpath(".//div[text()='двое суток']")).click();
        driver.findElement(By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]")).click();
        driver.findElement(By.xpath(".//button[text()='Да']")).click();
        var orderCheckField = driver.findElement(By.xpath(".//div[text()='Заказ оформлен']"));
        Assert.assertTrue(orderCheckField.isDisplayed());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}