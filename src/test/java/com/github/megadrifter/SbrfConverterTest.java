package com.github.megadrifter;

import com.github.megadrifter.pages.ConverterPage;
import io.qameta.allure.Description;
import org.junit.*;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Title;

import static org.junit.Assert.assertEquals;

public class SbrfConverterTest {

    private ConverterPage sbconverter;

    @Before
    public void setup() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "D:\\prog\\chromedriver.exe"); // set in PATH
        sbconverter = new ConverterPage();
        sbconverter.openNewHomePage();
        Thread.sleep(10000);
    }


    private String headerExpectedText = "Калькулятор иностранны[ валют"; // Ошибка сделана намеренно
    private String strAmount = "-123.00"; // можно параметрировать

    @Title("Открытие стрвницы веб-приложения \"Конвертер валют\"")
    @Description("Описание")
    @Test
    public void testConverterPageOpen()  {
        WebElement header = sbconverter.getHeader();
        assertEquals(header.getText(), headerExpectedText);
        System.out.println(header.getText());
        sbconverter.assertAmount("100");
    }

    @Title("установка суммы валюты")
    @Description("Описание")
    @Test
    public void testSetAmount() throws InterruptedException {
        String readedAmound;
        Thread.sleep(5000);
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
