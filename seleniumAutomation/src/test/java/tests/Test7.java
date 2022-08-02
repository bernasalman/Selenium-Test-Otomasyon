package tests;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


//kırık link elementine erişme (kırık:Bozuk bağlantı, boş veya var olmayan)
public class Test7 {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://the-internet.herokuapp.com/status_codes/500/"); //gidilmesi istenen url çağrılıyor
        HttpResponse response= client.execute(request); //requestten gelen yanıtı tutmak için
        int statusCode = response.getStatusLine().getStatusCode(); //gelen yanıt kod şeklinde sayı onu görebilmek için
        System.out.println(statusCode); //gelen sayıyı konsola gösterir. 200-başarılı, 500-başarısız


    }
}
