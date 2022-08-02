package tests;

import org.apache.http.util.Asserts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

//Alerts yani bir butona tıklayınca veya sayfayı açınca karşımıza çıkan popupa erişme
public class Test12 {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        //butona tıklanınca gelen popupı kabul etme
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        driver.switchTo().alert().accept(); //kabul fonk.


        //butona tıklanınca 5sn sonra gelen popupı kabul etme
        WebElement timerAlertButton =driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept(); //kabul fonk.


        //buttona tıklanınca onay sorma popupı red etmek
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();
        System.out.println(driver.switchTo().alert().getText()); //popup içindeki mesajı gösterir
        driver.switchTo().alert().dismiss(); //red fonk.


        //buttona basınca açılan popuptan veri alıp onaylama
        WebElement promtButton = driver.findElement(By.id("promtButton"));
        promtButton.click();
        String text = "berna";
                driver.switchTo().alert().sendKeys(text); //veri alma fonk
        driver.switchTo().alert().accept();

        WebElement promptResult= driver.findElement(By.xpath("promptResult/text()[2]"));
        //String text2 =promptResult.getText();
        String text1 = promptResult.getAttribute("value");
////*[@id="promptResult"]/text()[2]
        //"//promptResult/text-success[1]"

        if (text1==text){
            System.out.println("aynı");
        }else {
            System.out.println("farklı");
        }

        /* bi alert değişen üzerinden de yapılabilir
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("berna");
        alert.accept();
        */
    }
}