import org.example.models.House;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HouseTests {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }

    private void acceptCookies() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=2");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test
    public void positiveTest() {
        House p = new House(driver, "Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5", "15", true ,
                "1234-1234-1234", false, "255", 3, "300", false, "1999", true, "2005",
                3, 4, 1, 4, new int[]{1,2,3,4,5,6,7,8,9,10}, 1, "200",new int[]{1,3,5},
                new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31},2,true,false,
                "Belekas butas silainiuose","No speak london","Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk","https://www.google.com/maps","92000","+37064610102","shelby@gmail.com",
                true,true,1,true);
        p.fill();

    }


}
