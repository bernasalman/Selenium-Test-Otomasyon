package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

//dosya yükleme işlemi
public class Test10 {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        WebElement uploadButton = driver.findElement(By.id("uploadFile"));
        uploadButton.sendKeys("C:\\Users\\Berna\\Desktop\\atatürk.png"); //sendkeys ile butona dosya yolu atar
    }
}
