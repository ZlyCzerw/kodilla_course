package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String DIV = "//div[contains(@class, \"birthday-wrapper\")] ";
    public static final String DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String YEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";

    public static void main(String[]args){

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        WebElement day = driver.findElement(By.xpath(DAY));
        WebElement month = driver.findElement(By.xpath(MONTH));
        WebElement year = driver.findElement(By.xpath(YEAR));

        Select selectDay = new Select(day);
        Select selectMonth = new Select(month);
        Select selectYear = new Select(year);

        selectDay.selectByValue("29");
        selectMonth.selectByVisibleText("lut");
        selectYear.selectByVisibleText("1905");
    }
}
