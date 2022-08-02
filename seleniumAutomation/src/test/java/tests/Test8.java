package tests;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

//kırık resim elementine erişme
public class Test8 {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();

        WebElement brokenImage = driver.findElement(By.xpath("//div/img[2]"));
        String brokenImageUrl = brokenImage.getAttribute("src");
        System.out.println(brokenImageUrl);

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(brokenImageUrl); //gidilmesi istenen url çağrılıyor
        HttpResponse response= client.execute(request); //requestten gelen yanıtı tutmak için
        int statusCode = response.getStatusLine().getStatusCode(); //gelen yanıt kod şeklinde sayı onu görebilmek için
        System.out.println(statusCode); //gelen sayıyı konsola gösterir. 200-başarılı, 500-başarısız
        if (statusCode==200){
            System.out.println("valid image!");
        } else if (statusCode ==500) {
            System.out.println("broken image!");

        }
    }
}
