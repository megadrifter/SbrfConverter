package com.github.megadrifter.pages;

import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ConverterPage {

    private By fieldAmountLocator = By.xpath("//div[contains(@class, " +
            "'rates-aside__filter-block-line-right')]//input");
//    private By fieldAmountLocator = By.ByCssSelector("div.rates-aside__filter-block-line-right input");


    private WebDriver driver;
    private static String homeURL="http://www.sberbank.ru/ru/quotes/converter";
//    private WebElement fieldAmount;

    public ConverterPage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
    }

    @Step("задание количества валюты")
    public void setAmount(String amount){
        driver.findElement(fieldAmountLocator).sendKeys(amount);
    }

    @Step("чтение установленного количества валюты")
    public String getAmount(){
        return driver.findElement(fieldAmountLocator).getText();
    }

    @Step("Проверка установленного по умолчанию количества валюты")
    public void assertAmount(String expected){
        String amount;
        amount = driver.findElement(fieldAmountLocator).getText();
        Assert.assertEquals(expected, amount);
    }

    @Step("Открытие {ConverterPage.homeURL}")
    public void openNewHomePage(){
        //driver.manage().window().maximize();
        driver.get(homeURL);
    }

    @Step("Получение заголовка")
    public WebElement getHeader(){
        return driver.findElement(By.className("header_widget"));
    }

    @Step("Закрытие браузера.")
    public void close() {
        driver.quit();
    }
}
