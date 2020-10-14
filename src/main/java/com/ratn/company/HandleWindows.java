package com.ratn.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleWindows {
    public static void main(String[] args) {
        String pwd = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", pwd + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://www.naukri.com/");

        String parent = driver.getWindowHandle();
        System.out.println("Parent window: " + parent);
        Set<String> childWindows = driver.getWindowHandles();

        Iterator<String> itr = childWindows.iterator();
        while (itr.hasNext()) {
            String childWindow = itr.next();
            if (!childWindow.equals(parent)) {
                System.out.println("Child Window: " + childWindow);
                driver.switchTo().window(childWindow).close();
            }
        }
        driver.switchTo().window(parent).quit();
    }
}
