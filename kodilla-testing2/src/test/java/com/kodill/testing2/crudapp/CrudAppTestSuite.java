package com.kodill.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CrudAppTestSuite {

    private WebDriver driver;
    private final static String BASE_URL = "https://zlyczerw.github.io/";
    private Random generator;

    @Before
    public void initTests(){
        driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(BASE_URL);
        generator = new Random();
    }
    @After
    public void cleanAfterTest(){
        driver.close();
    }


    public String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]//input[1]";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]//textarea[1]";
        final String XPATH_ADD_TASK_BUTTON = "//form[contains(@action, \"createTask\")]//button[1]";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement button = driver.findElement(By.xpath(XPATH_ADD_TASK_BUTTON));
        button.click();
        Thread.sleep(2000);

        return taskName;
    }


    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath("//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
    }


    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        checkTaskExistsInTrello(taskName);
        shouldDeleteTrelloCard(taskName);
    }

    private boolean checkTaskExistsInTrello (String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("wiktorm3");
        driverTrello.findElement(By.id("password")).sendKeys("Mondeo11");
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size()>0)
                .forEach(aHref -> aHref.click());

        Thread.sleep(2000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size()>0;
        driverTrello.close();
        System.out.println(result);
        return result;

    }
    public void shouldDeleteTrelloCard(String taskName){
        WebDriverWait wait = new WebDriverWait(driver,2,100);
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

//        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
//                .filter(anyForm -> anyForm.findElement(By.xpath("//p[@class=\"datatable__field-value\"]"))
//                        .getText().equals(taskName))
//                .forEach(theForm -> {
//                    WebElement buttonDeleteCard = theForm.findElement(By.xpath(".//div/fieldset/button[4]"));
//                    wait.until(ExpectedConditions.elementToBeClickable(buttonDeleteCard)).click();
//                });
//
//
//        List<WebElement> elementsList = driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
//                .filter(anyForm -> anyForm.findElement(By.xpath("//p[@class=\"datatable__field-value\"]"))
//                        .getText().equals(taskName)).collect(Collectors.toList());
//
//        for(WebElement element: elementsList) {
//            WebElement buttonDeleteCard = element.findElement(By.xpath(".//div/fieldset/button[4]"));
//            wait.until(ExpectedConditions.elementToBeClickable(buttonDeleteCard));
//            buttonDeleteCard.click();
//        }

        System.out.println("TEN TEKST MA BYC WIDOCZNY");
        List<WebElement> elementsList = driver.findElements(By.xpath("//div/form[@class=\"datatable__row\"]")).stream()
                .map(form -> {
                    System.out.println(form.findElement(By.xpath("//section/div/form/fieldset/p")).getText());
                    return form;
                })
                .filter(anyForm -> anyForm.findElement(By.xpath("//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName)).collect(Collectors.toList());

        for(WebElement element: elementsList) {
            WebElement buttonDeleteCard = element.findElement(By.xpath(".//div/fieldset/button[4]"));
            wait.until(ExpectedConditions.elementToBeClickable(buttonDeleteCard));
            buttonDeleteCard.click();
        }


        System.out.println("TEN TEKST KONCZY METODE");

    }
}
