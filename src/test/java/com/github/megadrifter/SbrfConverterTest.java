package com.github.megadrifter;

import com.github.megadrifter.pages.ConverterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Parameter;

import static org.junit.Assert.assertEquals;

public class SbrfConverterTest {

    private ConverterPage sbconverter;

    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\prog\\chromedriver.exe");
        sbconverter = new ConverterPage();
        sbconverter.openNewHomePage();
        Thread.sleep(10000);
    }

    @Parameter
    private String headerExpectedText = "Калькулятfр иностранных валют"; // Ошибка сделана намеренно
    private String strAmount = "123.00"; // можно параметрировать

    @Test
    @DisplayName("Открытие стрвницы веб-приложения \"Конвертер валют\"")
    public void testConverterPageOpen()  {
        WebElement header = sbconverter.getHeader();
        assertEquals(header.getText(), headerExpectedText);
        System.out.println(header.getText());
    }

    @Test
    public void testSetAmount() throws InterruptedException {
        String readedAmound;

        sbconverter.locateFieldAmount();
        sbconverter.setAmount(strAmount);
        Thread.sleep(5000);
        readedAmound = sbconverter.getAmount();
        assertEquals(strAmount, readedAmound );
        System.out.println(readedAmound);
    }

    @After
    public void finish() {
        sbconverter.close();
    }
}
