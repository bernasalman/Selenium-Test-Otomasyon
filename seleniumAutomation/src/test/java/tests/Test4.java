    package tests;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;

    //Örnek-4 radio-button seçme
    public class Test4 {
        public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://demoqa.com/radio-button");
            driver.manage().window().maximize();

            //tıklanabilirlik kontrolü
            WebElement yesRadioButtonLabel = driver.findElement(new By.ByCssSelector("label[for='yesRadio']"));
            boolean isEnabled = yesRadioButtonLabel.isEnabled();
            if(isEnabled){
                yesRadioButtonLabel.click();
                System.out.println("Cliked yesRadio button");
            }

            //seçilmişse uyarı verir
            WebElement yesRadioButton= driver.findElement(By.id("yesRadio"));
            boolean isSelected = yesRadioButton.isSelected();
            if(isSelected){
                System.out.println("yes radio button is selected");
            }

            //radio buttona tıklanınca çıkan çıktıyı gösterir
            WebElement output = driver.findElement(new By.ByCssSelector("p.mt-3"));
            System.out.println(output.getText());

        //tıklanamayan(isEnabled=false iken) radio button olduğunun gösterir
            WebElement noRadioButton = driver.findElement(By.id("noRadio"));
            System.out.println(noRadioButton.isEnabled());
    }
    }

