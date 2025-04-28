import org.example.models.Plot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PlotTests {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }

    private void acceptCookies() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test
    public void positiveTest() {
        Plot p = new Plot(driver, "Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"}, "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
    }


}
