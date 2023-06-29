import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@RunWith(Parameterized.class)
public class PerfomanceModule {
    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String number;
    private final String metroStation;
    private final String date;
    private final String comment;
    private final String color;
    private final String timeRent;
    private final DriverType driverType;

    public PerfomanceModule(String name, String surname, String address, String number, String metroStation, String date, String comment, String color, String timeRent, DriverType driverType) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.metroStation = metroStation;
        this.date = date;
        this.comment = comment;
        this.color = color;
        this.timeRent = timeRent; // создали конструктор тестового класса
        this.driverType = driverType;
    }


    @Before
    public void startUp() throws IOException {
        FileInputStream propFile =
                new FileInputStream("test.properties");
        Properties p =
                new Properties(System.getProperties());
        p.load(propFile);
        System.setProperties(p);
        driver = ConfigurationWebDriver.getDriverByDriverType(driverType);
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {"Даша", "Хмелькова", "Кантемировская 18", "89670354058", "1", "28.06.2023", "Не звонить", "black", "сутки", DriverType.Firefox},
                {"Даня", "Евганин", "Покровка 14", "89629850052", "3", "29.06.2023", "Полностью заряженный плес", "grey", "двое суток", DriverType.Firefox},// передали тестовые данные
                {"Даша", "Хмелькова", "Кантемировская 18", "89670354058", "1", "28.06.2023", "Не звонить", "black", "сутки", DriverType.Chrome},
                {"Даня", "Евганин", "Покровка 14", "89629850052", "3", "29.06.2023", "Полностью заряженный плес", "grey", "двое суток", DriverType.Chrome}
        };
    }

    @Test
    public void clickOrderStartButton() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //Start
        WelcomePage objLoginPage = new WelcomePage(driver);
        objLoginPage.clickOrderStartButton();

        //заполняем страницу для кого
        ForWhoPage objWhoPage = new ForWhoPage(driver);
        objWhoPage.sendNameField(name);
        objWhoPage.sendSurnameField(surname);
        objWhoPage.sendAddressField(address);
        objWhoPage.sendPhoneNumberField(number);
        objWhoPage.clickMetroStationField();
        objWhoPage.clickOptionMetroField(metroStation);
        objWhoPage.clickNextPageButton();

        //Заполняем страницу об аренде
        AboutRentPage objAboutPage = new AboutRentPage(driver);
        objAboutPage.sendDateDeliveryField(date);
        objAboutPage.sendCommentOrderField(comment);
        objAboutPage.clickOptionColor(color);
        objAboutPage.clickRentalPeriodField();
        objAboutPage.clickOptionTimeRent(timeRent);
        objAboutPage.clickCheckOutOrderButton();
        objAboutPage.clickConfirmOrderButton();

        //Проверяем окно подтверждение заказа
        WebElement orderCheckField = objAboutPage.findSuccessfullyCompletedWindow();
        Assert.assertTrue(orderCheckField.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
