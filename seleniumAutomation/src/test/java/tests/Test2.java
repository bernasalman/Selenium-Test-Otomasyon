package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Örnek-2 checkBoxa tıklama
public class Test2 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize();

        //checkBoxa tıklamak için
        String homeCheckBoxCssValue = "label[for='tree-node-home'] span.rct-checkbox svg";
        WebElement homeCheckBox = driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));
        homeCheckBox.click();


        //checkboxa tıklayınca htmle değiştiği için tekrar element bulmak gerekti
        homeCheckBox = driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));
        //checkBoxın sınıf ismini çekmek için
        String homeCheckboxClassName = homeCheckBox.getAttribute("class");
        if (homeCheckboxClassName.equals("rct-icon rct-icon-check")) { //checkbox ismini olması gerekenle kıyaslıyor
            System.out.printf("Checkbox is checked");
        } else {
            System.out.printf("Checkbox is unchecked");
        }
    }
}
