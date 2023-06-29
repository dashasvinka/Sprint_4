import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForWhoPage {
    private WebDriver driver;

    public ForWhoPage(WebDriver driver) {
        this.driver = driver;
    }

    //тут все нужные мне элементы на странице Для кого самокат
    private By nameField = By.cssSelector("input[placeholder='* Имя']"); // поле Имя

    public void sendNameField(String name) {
        driver.findElement(nameField).sendKeys(name); //метод ввода имени
    }

    private By surnameField = By.cssSelector("input[placeholder='* Фамилия']"); // поле Фамилия

    public void sendSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname); //метод ввода Фамилии
    }

    private By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']"); // поле Адрес

    public void sendAddressField(String address) {
        driver.findElement(addressField).sendKeys(address); //метод ввода Адреса
    }

    private By phoneNumberField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']"); // поле Телефон

    public void sendPhoneNumberField(String number) {
        driver.findElement(phoneNumberField).sendKeys(number); //метод ввода Телефона
    }

    private By metroStationField = By.cssSelector("input[placeholder='* Станция метро']"); // поле Станция метро

    public void clickMetroStationField() {
        driver.findElement(metroStationField).click(); //клик по полю Станция метро
    }

    private By getOptionMetroField(String value) {
        String selector = String.format("li[data-value='%s']", value);
        return By.cssSelector(selector);
    } // опция выбора станции метро

    public void clickOptionMetroField(String param) {
        driver.findElement(getOptionMetroField(param)).click(); //клик по опции выбора станции
    }
    // private By optionPreobrazhenskayaSquareField = By.cssSelector("li[data-value='3']"); // опция станция метро Преображенская Площадь
    // private By optionPreobrazhenskayaSquareField = By.cssSelector("li[data-value='3']"); // опция станция метро Преображенская Площадь

    /*  public void clickOptionPreobrazhenskayaSquareField() {
          driver.findElement(optionPreobrazhenskayaSquareField).click(); //клик по станция метро Преображенская Площадь
      }*/
    private By nextPageButton = By.xpath(".//button[text()='Далее']"); // кнопка Далее

    public void clickNextPageButton() {
        driver.findElement(nextPageButton).click(); //клик по кнопке Далее на странице Для кого заказ
    }

}
