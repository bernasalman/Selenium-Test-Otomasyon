package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Örnek-3 checkboxa tıklamayı kontrol etme
    public class Test3 {
        public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            driver.get("https://demoqa.com/automation-practice-form");
            driver.manage().window().maximize();

        WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
        boolean isEnabled = sportCheckbox.isEnabled(); //tıklanabilir olup olmadığını kontroledip true/false döndürüyo;
            System.out.println(isEnabled);

        WebElement sportCheckboxLabel = driver.findElement(new By.ByCssSelector("label[for='hobbies-checkbox-1']"));

        //checkboxa tıklamada hata alırsa eğer checkbox lebele tıklayarak istenilen yeri seçmesi beklenir.
            if(isEnabled) { // eğer tıklanabilirse
            try {
                sportCheckbox.click();

            } catch (ElementClickInterceptedException e) {
                sportCheckboxLabel.click();
                System.out.println("Entered catch block!");
            }
        }

        boolean isSelected = sportCheckbox.isSelected(); //seçilip seçilmediğini kontrol edip true/false döndürür
            System.out.println(isSelected);
    }
    }

