package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Örnek-1 textbox içine veri yazma ve içindeki veriyi alma
public class Test1 {
    public static void main(String[] args) {

        //proje içine eklenen driverı çağırıyoruz
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //driver objesi oluşturuyoruz
        WebDriver driver = new ChromeDriver();

        //get ile bir url'ye gidebilirsin
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize(); //açılan sayfayı tam ekran yapar

        //element objesi oluşturma
        WebElement nameElement = driver.findElement(By.id("userName"));
        nameElement.click(); //ilgili elemente tıklamak için
        nameElement.sendKeys("Berna"); // ilgili elemente anahtar değer atamak için


        WebElement email = driver.findElement(By.id("userEmail"));
        email.click();
        email.sendKeys("berna@gmail.com");

        //css kodundan belirli özellikleri vererek element çekme
        //WebElement cAdress = driver.findElement(new By.ByCssSelector(".form-control[placeHolder='Current Address']"));
        WebElement cAdress = driver.findElement(By.id("currentAddress"));
        cAdress.click();
        cAdress.sendKeys("Edirne, Türkiye");

        WebElement pAdress = driver.findElement(By.id("permanentAddress"));
        pAdress.click();
        pAdress.sendKeys("İstanbul, Türkiye");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();


        //ekrandaki textten metni alıp konsola gösterecek
        WebElement emailText = driver.findElement(By.xpath("//div/p[@id='email']"));
        String eMail = emailText.getText();
        System.out.printf(eMail);


    }
}