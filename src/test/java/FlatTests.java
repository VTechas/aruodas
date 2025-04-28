import org.example.models.Flat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FlatTests {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }

    private void acceptCookies() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=1");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test
    public void positiveTest() {
        Flat f = new Flat(driver, "Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "No speak london", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17","92", 2, 3, 4, true, "1990",
                true, "1999", 6, 1, new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                2, 2,new int[]{1,2,3,4}, "A++");
        f.fill();
    }


}
