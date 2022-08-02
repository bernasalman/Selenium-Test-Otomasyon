package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

//web sayfasından dosya imdirme işlemi ve indiğini kontrol etme
public class Test9 {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        String path = "C:\\Users\\Berna\\Downloads"; //dosyanın indirildiği yerin yolu
        String fileName = "sampleFile.jpeg"; //indirilen dosyanın adı
        Thread.sleep(5000); //kod indirme işlemine yetişsin diye 5 sn bekletiyoruz
        boolean isDownloaded = isFileDownLoaded(path, fileName);
        System.out.println(isDownloaded);
    }

    //dosyanın indirilme durumuna göre true/false döndüren fonk.
    public static boolean isFileDownLoaded(String downloadPath, String fileName){
        File file = new File(downloadPath);
        File[] files = file.listFiles(); //dosya yolundaki dosyaları dizide tutar

        for (int i=0; i<files.length; i++){   //sırasıyla doysa dizisindeki elemanşarın adına bakar
            if (files[i].getName().equals(fileName)){ // dosya adı indirilen dosya ile aynıysa true döndürür.
               files[i].delete();  //kontrol ettikten sonra dosyayı siler
                return true;
            }
        }
        return false;

    }}