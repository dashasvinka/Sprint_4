import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WelcomePage {
    private WebDriver driver;
    //тут все нужные мне элементы на приветственной странице
    private By orderStartButton = By.className("Button_Button__ra12g"); //кнопка Заказать
    private By blockImportantQuestions = By.cssSelector("div[data-accordion-component='Accordion']"); // блок Вопросов о важном
    private By allQuestions = By.cssSelector("div[data-accordion-component='AccordionItem']"); // весь массив Вопросов о важном
    private By contentAnswers = By.cssSelector("div[data-accordion-component='AccordionItemPanel']"); // ответы на Вопросы о важном
    private By questionButton = By.cssSelector("div[data-accordion-component='AccordionItemButton']");

    public List<WebElement> getQuestions() {
        List<WebElement> questions = driver.findElement(allQuestions).findElements(blockImportantQuestions);
        return questions;
    }

    public WebElement getQuestion(String questionText) {
        List<WebElement> questions = driver.findElement(blockImportantQuestions).findElements(allQuestions);
        for (WebElement question : questions) {
            if (question.findElement(questionButton).getText().equals(questionText)) {
                return question;
            }
        }
        return null;
    }

    public String getTextAnswer(WebElement element) {
        return element.findElement(contentAnswers).findElement(By.cssSelector("p")).getText();
    }

    public void scrollToQuestions() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(blockImportantQuestions));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(blockImportantQuestions));
    }

    // конструктор класса page object
    public WelcomePage(WebDriver driver) {
        this.driver = driver; // инициализировали в нём поле driver
    }

    // методы для взаимодействия с кнопками
    public void clickOrderStartButton() {
        driver.findElement(orderStartButton).click(); //клик по кнопке Заказать
    }
}