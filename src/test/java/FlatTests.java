import org.example.Helper;
import org.example.models.Flat;
import org.example.models.RealEstate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FlatTests {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        Helper.setUp();
        driver = Helper.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        Helper.acceptCookies();
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=1");
    }

    @Test
    public void positiveTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankRegionTest() {
        Flat f = new Flat("", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite savivaldybę";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankQuartalTest() {
        Flat f = new Flat("Kaunas", "Kauno", "", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite mikrorajoną";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankStreetTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite gatvę";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankHouseNumTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void dontShowHouseNumTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                false, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankRcNumTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void hideRcNumTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", false, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void notInterestedChangeTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, false, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void noAuctionTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, false, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankNotesLtTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankNotesEnTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankNotesRuTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankPhotosTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{""},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankVideoTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankTour3dTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankPriceTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisinga kaina";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankPhoneNumTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankEmailTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Nurodykite el. pašto adresą, kad vėliau galėtumėte redaguoti arba pašalinti skelbimą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void showInAdsTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", false, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void wantChatTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, false, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankAccountTypeTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 0, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Prašome pasirinkti paskyros tipą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankAgreeToRulesTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, false,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17", true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//span[@class='error-arrow' and text()='Prašome sutikti su portalo taisyklėmis']"));
        String expected = "Prašome sutikti su portalo taisyklėmis";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankSpecialsTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{""},
                "17",true,"92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio",new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankApartNumTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "",true,"92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio",new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void dontShowApartNumTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",false, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankAreaSizeTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Įveskite bendrą plotą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankRoomCountTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 0, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Įveskite kambarių sk.";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankFloorTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 0, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("#fieldRow_FFloor .col.has-error span.error-arrow"));
        String expected = "Įveskite aukštą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankHouseHeightTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 0, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.cssSelector("#fieldRow_FHouseHeight span.error-arrow"), "Įveskite aukštų sk."));

        WebElement errorSpan = driver.findElement(By.cssSelector("#fieldRow_FHouseHeight span.error-arrow"));
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, "Įveskite aukštų sk.");
    }

    @Test
    public void noElevatorTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, false, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankYearsTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//span[contains(@class, 'error-arrow') and contains(text(), 'Įveskite statybos metus')]"));
        String expected = "Įveskite statybos metus";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void notRenovatedTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                false, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankRenovatedYearsTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1999",
                true, "", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//span[contains(@class, 'error-arrow') and contains(text(), 'Klaida. Netinkami metai')]"));
        String expected = "Klaida. Netinkami metai";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankHouseTypeTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite pastato tipą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankHouseStateTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite įrengimą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankWarmSystemTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{""},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Privalomas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankApartmentTypeTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Klaida: Neįvestas buto tipas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankApartmentIntendanceTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Privalomas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankWindowsDirectionsTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{""}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankHouseEfficiencyTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersRegionTest() {
        Flat f = new Flat(RealEstate.generateRandomSpecialChars(6), "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite savivaldybę";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersQuartalTest() {
        Flat f = new Flat("Kaunas", "Kauno", RealEstate.generateRandomSpecialChars(6), "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite mikrorajoną";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersStreetTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", RealEstate.generateRandomSpecialChars(6), "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite gatvę";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersHouseNumTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", RealEstate.generateRandomSpecialChars(6),
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='FHouseNum']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']"));
        String expected = "Neteisingai įvesta reikšmė";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersRcNumTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, RealEstate.generateRandomSpecialChars(6), true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersNotesLtTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, RealEstate.generateRandomSpecialChars(6),
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersNotesEnTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                RealEstate.generateRandomSpecialChars(6), "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersNotesRuTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", RealEstate.generateRandomSpecialChars(6),
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersVideoTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                RealEstate.generateRandomSpecialChars(6), "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Blogas embed kodas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersTour3dTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", RealEstate.generateRandomSpecialChars(6), "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Bloga nuoroda";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersPriceTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", RealEstate.generateRandomSpecialChars(6),
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17", true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisinga kaina";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersPhoneNumTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                RealEstate.generateRandomSpecialChars(6), "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='phone']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersEmailTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", RealEstate.generateRandomSpecialChars(6), true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                "17",true, "92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio", new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Blogas el. pašto adresas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersApartNumTest() {
        Flat f = new Flat("Kaunas", "Kauno", "Silainiai", "Aleksoto", "22",
                true, "1234-1234-1234", true, true, true, "Belekas butas silainiuose",
                "For sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "92000",
                "+37064610102", "shelby@gmail.com", true, true, 1, true,
                new String[]{"atskiras iejimas", "butas palepeje", "sandeliukas", "sildomos grindys", "Vonia", "Kodine laiptines spyna"},
                RealEstate.generateRandomSpecialChars(6),true,"92", 2, 1, 10, true, "1990",
                true, "1999", "timber", "full", new String[]{"Centrinis", "Elektra", "Kita", "saules energija"},
                "Patalpa", "Poilsio",new String[]{"siaurė", "Vakarai", "Pietus", "Rytai"}, "A++");
        f.fill();
        driver.findElement(By.id("submitFormButton")).click();
        String expected = "Neteisingai įvesta reikšmė";
        String actual = driver.findElement(By.xpath("//input[@name='FApartNum']/following::span[text()='Neteisingai įvesta reikšmė']")).getText().trim();
        Assert.assertEquals(actual, expected);
    }



}
