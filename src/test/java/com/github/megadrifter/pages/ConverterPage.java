package com.github.megadrifter.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ConverterPage {

    By fieldAmountLocator = By.xpath("//*[@id=\"kit-collapse226\"]/div/div[1]/div[2]/div/form/input");

    private WebDriver driver;
    private static String homeURL="http://www.sberbank.ru/ru/quotes/converter";
    private WebElement fieldAmount;

    public ConverterPage(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(30, SECONDS);
    }
    public void locateFieldAmount(){
        fieldAmount = ;
    }

    public void setAmount(String amount){
        driver.findElement(fieldAmountLocator).sendKeys(amount);
    }

    public String getAmount(){
        return driver.findElement(fieldAmountLocator).getText();

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
