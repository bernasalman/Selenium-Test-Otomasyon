package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//farklı dinamik elementlere erişme
public class Test6 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();

        //sayfanın başındaki dinamik idli texte erişme
        WebElement textElement = driver.findElement(By.xpath("//div/p"));
        String text = textElement.getText();
        System.out.println(text);

        //5sn sonra aktif tıklanmaya aktif olan elemente erişme
        WebElement firstButton = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, 5); //5sn beklemesi için fonk. çağrıldı
        wait.until(ExpectedConditions.elementToBeClickable(firstButton));
        firstButton.click();

        //rengi değişen elemente erişme
        WebElement colorChangeButton = driver.findElement(By.id("colorChange"));
        String className = colorChangeButton.getAttribute("class");
        System.out.println("Before change:" +className); //renk değişmeden önceki class adı

        WebDriverWait cwait = new WebDriverWait(driver, 5);
        cwait.until(ExpectedConditions.attributeToBe(colorChangeButton, "class", "mt-4 text-danger btn btn-primary"));
        className =  colorChangeButton.getAttribute("class");
        System.out.println("After change:" +className); //renk değiştikten sonraki class adı

        //5sn sonra ekrana gelen elemente erişme
        WebDriverWait lWait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));  //daha sonra ortaya çıkan elementlerde kullanılan metotla çağırdık
        driver.findElement(By.id("visibleAfter")).click();

}
}
