package com.ratn.company;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        String pwd = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", pwd + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        System.out.println(((ChromeDriver) driver).getSessionId());
        try{
            Alert alert = driver.switchTo().alert();
        } catch (Exception e){
        }

        List<WebElement> itemsBefClick = driver.findElements(By.xpath("//tr//td[1]"));
        List<String> sortedExpItems = itemsBefClick.stream().map(item->
                item.getText()).sorted().collect(Collectors.toList());

        driver.findElement(By.xpath("//th[1]")).click();
        List<WebElement> itemsAftClick = driver.findElements(By.xpath("//tr//td[1]"));
        List<String> sortedAppItems = itemsAftClick.stream().map(item->
                item.getText()).sorted().collect(Collectors.toList());

        if (sortedAppItems.size() != sortedExpItems.size()) {
            System.out.println("Fail");
        }

        System.out.println(sortedAppItems);
        System.out.println(sortedExpItems);

        /*for (int i = 0; i < sortedAppItems.size(); i++) {
            if (sortedAppItems.get(i) != sortedExpItems.get(i)) {
                System.out.println("Fail");
            } else {
                System.out.println(sortedAppItems.get(i) + "==> " + sortedExpItems.get(i));
            }
        }*/

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement> priceVals = driver.findElements(By.xpath("//tr//td[2]"));

        /*driver.get("https://www.facebook.com");
        Select select = new Select(driver.findElement(By.id("day")));
        List<WebElement> allOptions = select.getOptions();*/

        List<Integer> allOptInt = priceVals.stream().map(op ->
                Integer.parseInt(op.getText())).collect(Collectors.toList());

        System.out.println(allOptInt);


//        Actions builder = new Actions(driver);
//                builder
//                .keyDown(Keys.CONTROL)
//                .sendKeys("t").keyUp(Keys.CONTROL).perform();
        //New Tab Open:

        /*    Robot r = new Robot();
            r.setAutoDelay(3000);
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_T);
            r.keyRelease(KeyEvent.VK_T);
            r.keyRelease(KeyEvent.VK_CONTROL);

            Set<String> set = driver.getWindowHandles();
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            Iterator<String> itr = set.iterator();
            itr.next();
            driver.switchTo().window(itr.next());
            driver.get("https://spicejet.com");

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");*/


    }
}
