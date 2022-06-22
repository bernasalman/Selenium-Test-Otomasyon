package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

//Örnek-5 çift tıklama, sağ tıklama
public class Test5 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
///Double Click
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        //double click diye bir fonksiyon olmadığı için başka sınıftan erişicez
        Actions action = new Actions(driver);
        action.doubleClick(doubleClickButton).perform();
        //butona double click yapınca verilen mesajı göstermek için
        WebElement message =driver.findElement(By.id("doubleClickMessage"));
        String messageText = message.getText();
        System.out.println(messageText);


///Right Click
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        //right click diye bir fonksiyon olmadığı için başka sınıftan erişicez.yukarıdaki actions'dan
        action.contextClick(rightClickButton).perform();
        //butona right click yapınca verilen mesajı göstermek için
        WebElement rightClickMessage =driver.findElement(By.id("rightClickMessage"));
        String message2 = rightClickMessage.getText();
        System.out.println(message2);


    }
}
