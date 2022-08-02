package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

//frames, sayfa içindeki küçük sayfalar
public class Test13 {


        public static void main(String[] args) throws IOException, InterruptedException {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://demoqa.com/frames");
            driver.manage().window().maximize();


        driver.switchTo().frame(0); //0. indise sahip  frame geçiş yaptık
        //driver.switchTo().frame("frame1"); //idisi ile frame erişme

        WebElement heading = driver.findElement(By.id("sampleHeading"));
        String text = heading.getText(); //geçiş yapılan frame textini ekrana yazdık
        System.out.println(text);

}
}
