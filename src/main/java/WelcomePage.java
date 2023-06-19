import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
        private WebDriver driver;
        //тут все нужные мне элементы на приветственной странице
        private By orderStartButton = By.className("Button_Button__ra12g"); //кнопка Заказать
        private By priceInfoPoint = By.id("accordion__heading-0"); //кнопка выпадающего списка Сколько это стоит?
        private By priceInfoAnswer = By.id("accordion__panel-0"); //ответ выпадающего списка Сколько это стоит?
        private By severalScootersInfoPoint = By.id("accordion__heading-25"); //кнопка выпадающего списка Хочу сразу несколько самокатов!
        private By severalScootersInfoAnswer = By.id("accordion__panel-25"); //ответ выпадающего списка Хочу сразу несколько самокатов!
        private By timingInfoPoint = By.id("accordion__heading-26"); //кнопка выпадающего списка Как рассчитать время аренды?
        private By timingInfoAnswer = By.id("accordion__panel-26"); //ответ выпадающего списка Как рассчитать время аренды?
        private By todayOrderInfoPoint = By.id("accordion__heading-27"); //кнопка выпадающего списка Можно ли заказать самокат прямо сегодня?
        private By todayOrderInfoAnswer = By.id("accordion__panel-27"); //ответ выпадающего списка Можно ли заказать самокат прямо сегодня?
        private By extendReturnInfoPoint = By.id("accordion__heading-28"); //кнопка выпадающего списка Можно ли продлить заказ или вернуть самокат раньше?
        private By extendReturnInfoAnswer = By.id("accordion__panel-28"); //ответ выпадающего списка Можно ли продлить заказ или вернуть самокат раньше?
        private By chargerForScooterInfoPoint = By.id("accordion__heading-29"); //кнопка выпадающего списка Вы привозите зарядку вместе с самокатом?
        private By chargerForScooterInfoAnswer = By.id("accordion__panel-29"); //ответ выпадающего списка Вы привозите зарядку вместе с самокатом?
        private By cancelTheOrderInfoPoint = By.id("accordion__heading-30"); //кнопка выпадающего списка Можно ли отменить заказ?
        private By cancelTheOrderInfoAnswer = By.id("accordion__panel-30"); //ответ выпадающего списка Можно ли отменить заказ?
        private By liveOutMskInfoPoint = By.id("accordion__heading-31"); //кнопка выпадающего списка Я живу за МКАДом, привезете?
        private By liveOutMskInfoAnswer = By.id("accordion__panel-31"); //ответ выпадающего списка Я живу за МКАДом, привезете?
        // конструктор класса page object
        public WelcomePage(WebDriver driver){
            this.driver = driver; // инициализировали в нём поле driver
        }
        // методы для взаимодействия с кнопками
        public void clickOrderStartButton() {
            driver.findElement(orderStartButton).click(); //клик по кнопке Заказать
        }
        public void clickPriceInfoPoint() {
                driver.findElement(priceInfoPoint).click(); //клик по кнопке выпадающего списка Сколько это стоит?
        }
        public void clickSeveralScootersInfoPoint() {
                driver.findElement(severalScootersInfoPoint).click(); //клик по кнопке выпадающего списка Хочу сразу несколько самокатов!
        }
        public void clickTimingInfoPoint() {
                driver.findElement(timingInfoPoint).click(); //клик по кнопке выпадающего списка Как рассчитать время аренды?
        }
        public void clickTodayOrderInfoPoint() {
                driver.findElement(todayOrderInfoPoint).click(); //клик по кнопке выпадающего списка Можно ли заказать самокат прямо сегодня?
        }
        public void clickExtendReturnInfoPoint() {
                driver.findElement(extendReturnInfoPoint).click(); //клик по кнопке выпадающего списка Можно ли продлить заказ или вернуть самокат раньше?
        }
        public void clickChargerForScooterInfoPoint() {
                driver.findElement(chargerForScooterInfoPoint).click(); //клик по кнопке выпадающего списка Вы привозите зарядку вместе с самокатом?
        }
        public void clickCancelTheOrderInfoPoint() {
                driver.findElement(cancelTheOrderInfoPoint).click(); //клик по кнопке выпадающего списка выпадающего списка Можно ли отменить заказ?
        }
        public void clickLiveOutMskInfoPoint() {
                driver.findElement(liveOutMskInfoPoint).click(); //клик по кнопке выпадающего списка Я живу за МКАДом, привезете?
        }
        public boolean elementPriceInfoAnswerIsNotPresent(){
                return driver.findElements(priceInfoAnswer).isEmpty();//поиск ответа выпадающего списка Сколько это стоит?

        }
}