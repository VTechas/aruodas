package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Flat {
    public WebDriver driver;
    public String region;
    public String district;
    public String quartal;
    public String street;
    public String objNum;
    public String apartNum;
    public String rcNum;
    public String areaSize;
    public int roomCount;
    public int floor;
    public int houseHeight;
    public boolean cbElevator;
    public String years;
    public boolean renovated;
    public String renovatedYears;
    public int houseType;
    public int houseState;
    public int[] warmSystem;
    public int apartmentType;
    public int apartmentIntendance;
    public int[] windowsDirection;
    public int[] specials;
    public int houseEfficiency;
    public boolean interestedChange;
    public boolean auction;
    public String notes_lt;
    public String notes_en;
    public String notes_ru;
    public String[] photos;
    public String video;
    public String tour3d;
    public String price;
    public String phoneNum;
    public String email;
    public boolean cbDontShowInAds;
    public boolean cbDontWantChat;
    public int accountType;
    public boolean cbAgreeToRules;


    public Flat(WebDriver driver, String region, String district, String quartal, String street, String objNum, String apartNum, String rcNum, String areaSize, int roomCount, int floor, int houseHeight, boolean cbElevator, String years, boolean renovated, String renovatedYears, int houseType, int houseState, int[] warmSystem, int apartmentType, int apartmentIntendance, int[] windowsDirection, int[] specials, int houseEfficiency, boolean interestedChange, boolean auction, String notes_lt, String notes_en, String notes_ru, String[] photos, String video, String tour3d, String price, String phoneNum, String email, boolean cbDontShowInAds, boolean cbDontWantChat, int accountType, boolean cbAgreeToRules) {
        this.driver = driver;
        this.region = region;
        this.district = district;
        this.quartal = quartal;
        this.street = street;
        this.objNum = objNum;
        this.apartNum = apartNum;
        this.rcNum = rcNum;
        this.areaSize = areaSize;
        this.roomCount = roomCount;
        this.floor = floor;
        this.houseHeight = houseHeight;
        this.cbElevator = cbElevator;
        this.years = years;
        this.renovated = renovated;
        this.renovatedYears = renovatedYears;
        this.houseType = houseType;
        this.houseState = houseState;
        this.warmSystem = warmSystem;
        this.apartmentType = apartmentType;
        this.apartmentIntendance = apartmentIntendance;
        this.windowsDirection = windowsDirection;
        this.specials = specials;
        this.houseEfficiency = houseEfficiency;
        this.interestedChange = interestedChange;
        this.auction = auction;
        this.notes_lt = notes_lt;
        this.notes_en = notes_en;
        this.notes_ru = notes_ru;
        this.photos = photos;
        this.video = video;
        this.tour3d = tour3d;
        this.price = price;
        this.phoneNum = phoneNum;
        this.email = email;
        this.cbDontShowInAds = cbDontShowInAds;
        this.cbDontWantChat = cbDontWantChat;
        this.accountType = accountType;
        this.cbAgreeToRules = cbAgreeToRules;
    }

    public void fill(){
        fillRegion();
        fillDistrict();
        fillQuartal();
        fillStreet();
        fillObjNum();

        fillApartNum();
        
        fillRcNum();
        fillAreaSize();
        
        fillRoomCount();
        fillFloor();
        fillHouseHeight();
        fillCbElevator();
        fillYears();
        fillRenovated();
        fillHouseType();
        fillHouseState();
        fillWarmSystem();
        fillApartmentType();
        fillWindowsDirections();
        fillSpecials();

        fillNotesLt();
        fillNotesEn();
        fillNotesRu();
        fillPhotos();
        fillVideo();
        fillTour3d();
        fillPrice();
        fillPhoneNum();
        fillEmail();
        fillCbDontShowInAds();
        fillCbDontWantChat();
        fillAccountType();
        fillAgreeToRules();
    }

    private void fillAgreeToRules() {
        if (this.cbAgreeToRules) {
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[57]/span[1]/div/div/label/span")).click();
        }
    }

    private void fillAccountType() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[55]/div[1]/div[" + this.accountType + "]")).click();

    }

    private void fillCbDontWantChat() {
        if (this.cbDontWantChat) {
            driver.findElement(By.xpath("//label[starts-with(@for, 'cbdont_want_chat')]")).click();
        }
    }

    private void fillCbDontShowInAds() {
        if (this.cbDontShowInAds) {
            driver.findElement(By.xpath("//label[starts-with(@for, 'cbdont_show_in_ads')]")).click();
        }
    }

    private void fillEmail() {
        driver.findElement(By.name("email")).sendKeys(this.email);
    }

    private void fillPhoneNum() {
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(this.phoneNum);
    }

    private void fillPrice() {
        driver.findElement(By.id("priceField")).sendKeys(this.price);
    }

    private void fillTour3d() {
        driver.findElement(By.name("tour_3d")).sendKeys(this.tour3d);
    }

    private void fillVideo() {
        driver.findElement(By.name("Video")).sendKeys(this.video);
    }

    private void fillPhotos() {
        StringBuilder filePaths = new StringBuilder();

        for (String photo : this.photos) {
            filePaths.append(photo).append("\n");
        }

        String filePathsToSend = filePaths.toString().trim();
        WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input"));
        fileInput.sendKeys(filePathsToSend);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Wait for up to 20 seconds
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("upload-loader")));
    }


    private void fillNotesRu() {
        driver.findElement(By.className("lang-ru-label")).click();
        wait(500);
        driver.findElement(By.name("notes_ru")).sendKeys(this.notes_ru);
    }

    private void fillNotesEn() {
        driver.findElement(By.className("lang-en-label")).click();
        wait(500);
        driver.findElement(By.name("notes_en")).sendKeys(this.notes_en);
    }

    private void fillNotesLt() {
        driver.findElement(By.name("notes_lt")).sendKeys(this.notes_lt);
    }

    private void fillSpecials() {
        driver.findElements(By.className("input-style-change-object")).get(1).click();
        List<WebElement> specialLabels = driver.findElements(By.xpath("//label[starts-with(@for, 'cb_SpecialFlat')]"));
        for (int i = 0; i < this.specials.length; i++) {
            int index = this.specials[i];
            int adjustedIndex = index - 1;
            try {
                WebElement checkbox = specialLabels.get(adjustedIndex);
                checkbox.click();
            } catch (Exception e) {
            }
        }
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[37]/div/div[" + this.houseEfficiency + "]")).click();
        if (interestedChange) {
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[38]/div/div/div/label/span")).click();
        }
        if (auction) {
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[39]/div/div/div/label/span")).click();
        }
    }

    private void fillWindowsDirections() {
        for (int i = 0; i < this.windowsDirection.length; i++) {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[25]/div/div/div[1]/div[" + this.windowsDirection[i] + "]/label")).click();
        }
    }

    private void fillApartmentType() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[22]/div/div[" + this.apartmentType + "]")).click();
        if (this.apartmentType == 2) {
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[23]/div/div[" + this.apartmentIntendance + "]")).click();
        }
    }

    private void fillWarmSystem() {
        for (int i = 0; i < this.warmSystem.length; i++) {
            int index = this.warmSystem[i];
            try {
                driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[21]/div/div[" + index + "]/label")).click();
            } catch (Exception e) {
            }
        }
    }

    private void fillHouseState() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[19]/div/div[" + this.houseState + "]"));
    }

    private void fillHouseType() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[18]/div/div[" + this.houseType + "]"));
    }

    private void fillRenovated() {
        if (this.renovated) {
            driver.findElement(By.className("cbrenovated_label")).click();
            driver.findElement(By.id("FRenovatedYear")).sendKeys(this.renovatedYears);
        }
    }

    private void fillYears() {
        driver.findElement(By.name("FBuildYear")).sendKeys(this.years);
    }

    private void fillCbElevator() {
        if (this.cbElevator) {
            driver.findElement(By.className("cbelevator_label")).click();
        }
    }

    private void fillHouseHeight() {
        driver.findElement(By.name("FHouseHeight")).sendKeys(String.valueOf(this.houseHeight));
    }


    private void fillFloor() {
        driver.findElement(By.name("FFloor")).sendKeys(String.valueOf(this.floor));
//        if (this.floor > 4) {
//            driver.findElement(By.name("FFloor")).sendKeys(String.valueOf(this.floor));
//        } else {
//            driver.findElements(By.className("input-right-dropdown")).get(4).click();
//            driver.findElements(By.className("dropdown-input-values")).get(1).click();
//            wait(500);
//            driver.findElement(By.xpath("//*[@id=\"fieldRow_FFloor\"]/div[1]/span[2]/ul/li[" + this.floor + "]")).click();
//        }
    }

    private void fillRoomCount() {
        if (this.roomCount > 4) {
            WebElement input = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[15]/div/span/input"));
            input.sendKeys(String.valueOf(this.roomCount));
        } else {
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[15]/div/div[" + this.roomCount + "]")).click();

        }
    }

    private void fillAreaSize() {
        driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.areaSize);
    }

    private void fillRcNum() {
        driver.findElement(By.name("RCNumber")).sendKeys(this.rcNum);
    }

    private void fillApartNum() {
        driver.findElement(By.name("FApartNum")).sendKeys(this.apartNum);
    }

    private void fillObjNum() {
        driver.findElement(By.name("FHouseNum")).sendKeys(this.objNum);
    }

    private void fillStreet() {
        driver.findElements(By.className("dropdown-input-value-title")).get(3).click();
        wait(500);
        driver.findElements(By.className("dropdown-input-search-value")).get(5).sendKeys(this.street);  //keitesi get is 4 i 5
        wait(1000);
        driver.findElements(By.className("dropdown-input-search-value")).get(5).sendKeys(Keys.ENTER);   //keitesi get is 4 i 5
    }

    private void fillQuartal() {
        driver.findElements(By.className("dropdown-input-value-title")).get(2).click();
        wait(700);
        driver.findElements(By.className("dropdown-input-search-value")).get(2).sendKeys(this.quartal); //keitesi get is 1 i 2
        wait(700);
        driver.findElements(By.className("dropdown-input-search-value")).get(2).sendKeys(Keys.ENTER);   //keitesi get is 1 i 2
    }

    private void fillDistrict() {
    }

    private void fillRegion() {
        driver.findElements(By.className("dropdown-input-value-title")).get(0).click();
        wait(1000);
        driver.findElements(By.className("dropdown-input-search-value")).get(0).sendKeys(this.region);
        wait(1000);
        driver.findElements(By.className("dropdown-input-search-value")).get(0).sendKeys(Keys.ENTER);
    }

    public void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }

}
