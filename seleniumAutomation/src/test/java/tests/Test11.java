package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// window/tabına erişme, etkileşim kurma
public class Test11 {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        WebElement tabButton = driver.findElement(By.id("tabButton"));
        tabButton.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles()); //kaç tane tabın açık olduğunu bulmak için liste yarattık

        System.out.println(tabs.size()); //ekrana açık olan tab sayısını gösterir

        driver.switchTo().window(tabs.get(1)); //swithTo geçiş yapmak için kullanılır. İçinde yazılan 1ise liste index 0dan başladığı için

        System.out.println(driver.getCurrentUrl()); //driverın bulunduğu tabın url'ini almak için

        Thread.sleep(5000); //bekleme
        driver.close(); //açık olan tabı kapatır
        //driver.quit(); driverı komple kapatıyor
}
}
