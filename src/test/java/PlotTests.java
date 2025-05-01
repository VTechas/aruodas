import org.example.Helper;
import org.example.models.Plot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PlotTests {
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
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
    }

    @Test
    public void positiveTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankRegionTest() {
        Plot p = new Plot("", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite savivaldybę";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankQuartalTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankStreetTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void hideHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", false, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void hideRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", false, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void notInterestedChangeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, false,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void auctionAgreeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                true, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankNotesLtTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankNotesEnTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankNotesRuTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankPhotoUploadTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{""},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankVideoTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankTour3dTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisinga kaina";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Nurodykite el. pašto adresą, kad vėliau galėtumėte redaguoti arba pašalinti skelbimą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void showInAdsTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", false, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void wantChatTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, true,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankAccountTypeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false, 0 , true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Prašome pasirinkti paskyros tipą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankAgreeToRulesTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false, 0 , false, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//span[@class='error-arrow' and text()='Prašome sutikti su portalo taisyklėmis']"));
        String expected = "Prašome sutikti su portalo taisyklėmis";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankSpecialsTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{""},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false, 1 , true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Įveskite bendrą plotą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankIntendencesTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false, 1 , true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{""});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite paskirtį";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersRegionTest() {
        Plot p = new Plot("!@#$%^", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite savivaldybę";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersQuartalTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "!@#$%^", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersStreetTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "!@#$%^",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "!@#$%^", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='FHouseNum']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']"));
        String expected = "Neteisingai įvesta reikšmė";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "!@#$%^", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersNotesLtTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "!@#$%^", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersNotesEnTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "!@#$%^", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersNotesRuTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "!@#$%^",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersVideoTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "!@#$%^", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Blogas embed kodas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersTour3dTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "!@#$#%^", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Bloga nuoroda";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "!@#$%^",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisinga kaina";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "!@#$%^", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='phone']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "!@#$%^&", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Blogas el. pašto adresas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "!@#$%^",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Įveskite bendrą plotą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolRegionTest() {
        Plot p = new Plot(" ", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite savivaldybę";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolQuartalTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", " ", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolStreetTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", " ",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                " ", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='FHouseNum']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']"));
        String expected = "Neteisingai įvesta reikšmė";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, " ", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolNotesLtTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, " ", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolNotesEnTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", " ", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolNotesRuTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", " ",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolVideoTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                " ", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Blogas embed kodas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolTour3dTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", " ", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Bloga nuoroda";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", " ",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisinga kaina";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                " ", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='phone']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", " ", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Blogas el. pašto adresas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceSymbolAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                " ",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Įveskite bendrą plotą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void negativeNumberHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "-321", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='FHouseNum']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']"));
        String expected = "Neteisingai įvesta reikšmė";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void negativeNumberRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "-300", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='RCNumber']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']"));
        String expected = "Neteisingas numerio formatas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }


}
