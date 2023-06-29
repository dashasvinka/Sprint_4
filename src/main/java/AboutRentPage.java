import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutRentPage {
    private WebDriver driver;

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    //тут все нужные мне элементы на странице Про аренду
    private By dateDeliveryField = By.cssSelector("input[placeholder='* Когда привезти самокат']"); // Дата когда привезти самокат

    public void sendDateDeliveryField(String date) {
        driver.findElement(dateDeliveryField).sendKeys(date); //метод ввода даты
    }

    private By commentOrderField = By.cssSelector("input[placeholder='Комментарий для курьера']"); // поле комментарий для курьера

    public void sendCommentOrderField(String comment) {
        driver.findElement(commentOrderField).sendKeys(comment); //метод ввода комментария
    }

    private By optionBlackColor = By.cssSelector("input[id='black']"); // цвет самоката черный жемчуг

    public void clickOptionBlackColor() {
        driver.findElement(optionBlackColor).click(); //клик по опции самоката черного цвета
    }

    private By getOptionColor(String value) {
        String selector = String.format("input[id='%s']", value);
        return By.cssSelector(selector);
    }  // цвет самоката

    public void clickOptionColor(String color) {
        driver.findElement(getOptionColor(color)).click(); //клик по опции выбора цвета самоката
    }

    private By rentalPeriodField = By.className("Dropdown-arrow"); // выпадающий список срок аренды

    public void clickRentalPeriodField() {
        driver.findElement(rentalPeriodField).click(); //клик по выпадающему списку срок аренды
    }

    private By getOptionTimeRent(String value) {
        String selector = String.format(".//div[text()='%s']", value);
        return By.xpath(selector);
    }  // опция аренды времени самоката

    public void clickOptionTimeRent(String param) {
        driver.findElement(getOptionTimeRent(param)).click(); //клик по опции времени аренды
    }

    private By optionTwoDays = By.xpath(".//div[text()='двое суток']"); // опция аренды двое суток

    public void clickOptionTwoDays() {
        driver.findElement(optionTwoDays).click(); //клик по опции аренды двое суток
    }

    private By checkOutOrderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]"); // кнопка Заказать

    public void clickCheckOutOrderButton() {
        driver.findElement(checkOutOrderButton).click(); //клик по кнопке Заказать
    }

    private By confirmOrderButton = By.xpath(".//button[text()='Да']"); // ДА в поле Хотите оформить заказ?

    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click(); //клик по кнопке ДА в поле Хотите оформить заказ
    }

    private By successfullyCompletedWindow = By.xpath(".//div[text()='Заказ оформлен']"); // всплывающее окно заказ оформлен

    public WebElement findSuccessfullyCompletedWindow() {
        return driver.findElement(successfullyCompletedWindow); // найти подтверждение заказа
    }
}