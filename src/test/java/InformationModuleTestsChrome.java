import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InformationModuleTestsChrome {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    private WebDriver driver;
    @Test
    public void checkOrderStart() {
        WelcomePage objLoginPage = new WelcomePage(driver);
        var res = driver.findElement(By.cssSelector("div[data-accordion-component='Accordion']"));
        var elms = res.findElements(By.cssSelector("div[data-accordion-component='AccordionItem']"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(elms.get(0)));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,800)");
        jse.executeScript("window.scrollBy(0,1000)");
        jse.executeScript("window.scrollBy(0,1200)");

        for (WebElement element : elms) {
            var selectedContentAccordion = element.findElement(By.cssSelector("div[data-accordion-component='AccordionItemPanel']"));
            Assert.assertFalse(selectedContentAccordion.isDisplayed());
        }


        for (WebElement element : elms) {
            element.click();
            var selectedContentAccordion = element.findElement(By.cssSelector("div[data-accordion-component='AccordionItemPanel']"));
            Assert.assertTrue(selectedContentAccordion.isDisplayed());
        }
}

    @After
    public void tearDown() {
        driver.quit();
    }
}
