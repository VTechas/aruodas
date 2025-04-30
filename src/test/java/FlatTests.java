import org.example.Helper;
import org.example.models.Flat;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlatTests {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        Helper.setUp();
        driver = Helper.driver;
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=1");
    }

    @Test
    public void positiveTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "No speak london", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17","92", 2, 6, 11, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                2, 2,new int[]{1,2,3,4}, "A++");
        f.fill();
    }
}
